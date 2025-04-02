import * as pulumi from "@pulumi/pulumi";
import * as command from "@pulumi/command";

const config = {
  pluginBinary: `${process.env.PWD}/../bin/pulumi-resource-command`,
  workingDir: "./pkg",
  version: "0.0.1-alpha.1",
};

// Generate the package when the plugin binary changes
const generatePackage = new command.local.Command("generatePackage", {
  create: `pulumi package gen-sdk "${config.pluginBinary}" --version ${config.version}`,
  dir: config.workingDir,
  triggers: [new pulumi.asset.FileAsset(config.pluginBinary)], // Trigger the command when the plugin binary changes
  archivePaths: [`${config.workingDir}/sdk`],
});


// When the package is generated, publish it to NPM
const publishToNpm = new command.local.Command("publishToNpm", {
  create: "echo '//registry.npmjs.org/:_authToken=${NPM_TOKEN}' > .npmrc; npm publish --tag foo ",
  dir: `${config.workingDir}/sdk/nodejs`,
  triggers: [generatePackage.archive], // Trigger the command when the package is generated
  environment: {
    "NPM_TOKEN": process.env.NPM_TOKEN || "", // Ensure you have your NPM token set in the environment
  },
});

// When the package is generated, publish it to PyPi
const publishToPyPi = new command.local.Command("publishToPyPi", {
  create: "python3 -m pip install build twine && python3 -m build && python3 -m twine upload dist/* --u __token__ -p ${PYPI_TOKEN}",
  dir: `${config.workingDir}/sdk/python`,
  triggers: [generatePackage.archive], // Trigger the command when the package is generated
  environment: {
    "PYPI_TOKEN": process.env.PYPI_TOKEN || "", // Ensure you have your PyPI token set in the environment
  },
});

// Export the output of the command
export const npmOutput = publishToNpm.stdout;
export const pyPiOutput = publishToPyPi.stdout;
