import * as pulumi from "@pulumi/pulumi";
import * as command from "@pulumi/command";

type PulumiSdksArgs = {
  pluginBinary: string;
  workingDir: string;
}

class PulumiSdks extends pulumi.ComponentResource {
  public readonly npmOutput: pulumi.Output<string>;
  public readonly pyPiOutput: pulumi.Output<string>;

  constructor(name: string, args: PulumiSdksArgs, opts?: pulumi.ComponentResourceOptions) {
    super("pkg:index:PulumiSdks", name, {}, opts);

    // Generate the package when the plugin binary changes
    const generatePackage = new command.local.Command("generatePackage", {
      create: `pulumi package gen-sdk "${args.pluginBinary}"`,
      dir: args.workingDir,
      triggers: [new pulumi.asset.FileAsset(args.pluginBinary)], // Trigger the command when the plugin binary changes
      archivePaths: [`sdk/**`],
    }, { parent: this, });


    // When the package is generated, publish it to NPM
    const publishToNpm = new command.local.Command("publishToNpm", {
      create: "echo '//registry.npmjs.org/:_authToken=${NPM_TOKEN}' > .npmrc; npm publish --tag foo ",
      dir: `${args.workingDir}/sdk/nodejs`,
      triggers: [generatePackage.archive], // Trigger the command when the package is generated
      environment: {
        "NPM_TOKEN": process.env.NPM_TOKEN || "", // Ensure you have your NPM token set in the environment
      },
    }, { parent: this, });

    // When the package is generated, publish it to PyPi
    const publishToPyPi = new command.local.Command("publishToPyPi", {
      create: "python3 -m pip install build twine && python3 -m build && python3 -m twine upload dist/* --u __token__ -p ${PYPI_TOKEN}",
      dir: `${args.workingDir}/sdk/python`,
      triggers: [generatePackage.archive], // Trigger the command when the package is generated
      environment: {
        "PYPI_TOKEN": process.env.PYPI_TOKEN || "", // Ensure you have your PyPI token set in the environment
      },
    }, { parent: this, });


    this.npmOutput = publishToNpm.stdout;
    this.pyPiOutput = publishToPyPi.stdout;
    this.registerOutputs(undefined);
  }
}



// Fetch plugin binary so it's available for the PulumiSdks component
const _ = await command.local.run({
  command: `make provider PROVIDER_VERSION="0.0.1-alpha.6"`,
  dir: `${process.env.PWD}/../`,
});

const pulumiSdks = new PulumiSdks("pulumiSdks", {
  pluginBinary: `${process.env.PWD}/../bin/pulumi-resource-command`,
  workingDir: "./pkg",
});

// Export the output of the command
export const npmOutput = pulumiSdks.npmOutput;
export const pyPiOutput = pulumiSdks.pyPiOutput;
