// *** WARNING: this file was generated by pulumi. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;
using Pulumi;

namespace Mjeffryes.Command.Remote
{
    /// <summary>
    /// A command to run on a remote host. The connection is established via ssh.
    /// 
    /// ## Example Usage
    /// 
    /// ### A Basic Example
    /// This program connects to a server and runs the `hostname` command. The output is then available via the `stdout` property.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Command = Pulumi.Command;
    /// 
    /// return await Deployment.RunAsync(() =&gt;
    /// {
    ///     var config = new Config();
    ///     var server = config.Require("server");
    ///     var userName = config.Require("userName");
    ///     var privateKey = config.Require("privateKey");
    ///     var hostnameCmd = new Command.Remote.Command("hostnameCmd", new()
    ///     {
    ///         Create = "hostname",
    ///         Connection = new Command.Remote.Inputs.ConnectionArgs
    ///         {
    ///             Host = server,
    ///             User = userName,
    ///             PrivateKey = privateKey,
    ///         },
    ///     });
    /// 
    ///     return new Dictionary&lt;string, object?&gt;
    ///     {
    ///         ["hostname"] = hostnameCmd.Stdout,
    ///     };
    /// });
    /// ```
    /// 
    /// ### Triggers
    /// This example defines several trigger values of various kinds. Changes to any of them will cause `cmd` to be re-run.
    /// 
    /// ```csharp
    /// using Pulumi;
    /// using Command = Pulumi.Command;
    /// using Random = Pulumi.Random;
    /// 
    /// return await Deployment.RunAsync(() =&gt;
    /// {
    ///     var str = "foo";
    /// 
    ///     var fileAssetVar = new FileAsset("Pulumi.yaml");
    /// 
    ///     var rand = new Random.RandomString("rand", new()
    ///     {
    ///         Length = 5,
    ///     });
    /// 
    ///     var localFile = new Command.Local.Command("localFile", new()
    ///     {
    ///         Create = "touch foo.txt",
    ///         ArchivePaths = new[]
    ///         {
    ///             "*.txt",
    ///         },
    ///     });
    /// 
    ///     var cmd = new Command.Remote.Command("cmd", new()
    ///     {
    ///         Connection = new Command.Remote.Inputs.ConnectionArgs
    ///         {
    ///             Host = "insert host here",
    ///         },
    ///         Create = "echo create &gt; op.txt",
    ///         Delete = "echo delete &gt;&gt; op.txt",
    ///         Triggers = new object[]
    ///         {
    ///             str,
    ///             rand.Result,
    ///             fileAssetVar,
    ///             localFile.Archive,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [CommandResourceType("command:remote:Command")]
    public partial class Command : global::Pulumi.CustomResource
    {
        /// <summary>
        /// If the previous command's stdout and stderr (as generated by the prior create/update) is
        /// injected into the environment of the next run as PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR.
        /// Defaults to true.
        /// </summary>
        [Output("addPreviousOutputInEnv")]
        public Output<bool?> AddPreviousOutputInEnv { get; private set; } = null!;

        /// <summary>
        /// The parameters with which to connect to the remote host.
        /// </summary>
        [Output("connection")]
        public Output<Outputs.Connection> Connection { get; private set; } = null!;

        /// <summary>
        /// The command to run on create.
        /// </summary>
        [Output("create")]
        public Output<string?> Create { get; private set; } = null!;

        /// <summary>
        /// The command to run on delete. The environment variables PULUMI_COMMAND_STDOUT
        /// and PULUMI_COMMAND_STDERR are set to the stdout and stderr properties of the
        /// Command resource from previous create or update steps.
        /// </summary>
        [Output("delete")]
        public Output<string?> Delete { get; private set; } = null!;

        /// <summary>
        /// Additional environment variables available to the command's process.
        /// Note that this only works if the SSH server is configured to accept these variables via AcceptEnv.
        /// Alternatively, if a Bash-like shell runs the command on the remote host, you could prefix the command itself
        /// with the variables in the form 'VAR=value command'.
        /// </summary>
        [Output("environment")]
        public Output<ImmutableDictionary<string, string>?> Environment { get; private set; } = null!;

        /// <summary>
        /// If the command's stdout and stderr should be logged. This doesn't affect the capturing of
        /// stdout and stderr as outputs. If there might be secrets in the output, you can disable logging here and mark the
        /// outputs as secret via 'additionalSecretOutputs'. Defaults to logging both stdout and stderr.
        /// </summary>
        [Output("logging")]
        public Output<Mjeffryes.Command.Remote.Logging?> Logging { get; private set; } = null!;

        /// <summary>
        /// The standard error of the command's process
        /// </summary>
        [Output("stderr")]
        public Output<string> Stderr { get; private set; } = null!;

        /// <summary>
        /// Pass a string to the command's process as standard in
        /// </summary>
        [Output("stdin")]
        public Output<string?> Stdin { get; private set; } = null!;

        /// <summary>
        /// The standard output of the command's process
        /// </summary>
        [Output("stdout")]
        public Output<string> Stdout { get; private set; } = null!;

        /// <summary>
        /// Trigger a resource replacement on changes to any of these values. The
        /// trigger values can be of any type. If a value is different in the current update compared to the
        /// previous update, the resource will be replaced, i.e., the "create" command will be re-run.
        /// Please see the resource documentation for examples.
        /// </summary>
        [Output("triggers")]
        public Output<ImmutableArray<object>> Triggers { get; private set; } = null!;

        /// <summary>
        /// The command to run on update, if empty, create will 
        /// run again. The environment variables PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR 
        /// are set to the stdout and stderr properties of the Command resource from previous 
        /// create or update steps.
        /// </summary>
        [Output("update")]
        public Output<string?> Update { get; private set; } = null!;


        /// <summary>
        /// Create a Command resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Command(string name, CommandArgs args, CustomResourceOptions? options = null)
            : base("command:remote:Command", name, args ?? new CommandArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Command(string name, Input<string> id, CustomResourceOptions? options = null)
            : base("command:remote:Command", name, null, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "connection",
                },
                ReplaceOnChanges =
                {
                    "triggers[*]",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing Command resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Command Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new Command(name, id, options);
        }
    }

    public sealed class CommandArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// If the previous command's stdout and stderr (as generated by the prior create/update) is
        /// injected into the environment of the next run as PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR.
        /// Defaults to true.
        /// </summary>
        [Input("addPreviousOutputInEnv")]
        public Input<bool>? AddPreviousOutputInEnv { get; set; }

        [Input("connection", required: true)]
        private Input<Inputs.ConnectionArgs>? _connection;

        /// <summary>
        /// The parameters with which to connect to the remote host.
        /// </summary>
        public Input<Inputs.ConnectionArgs>? Connection
        {
            get => _connection;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _connection = Output.Tuple<Input<Inputs.ConnectionArgs>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// The command to run on create.
        /// </summary>
        [Input("create")]
        public Input<string>? Create { get; set; }

        /// <summary>
        /// The command to run on delete. The environment variables PULUMI_COMMAND_STDOUT
        /// and PULUMI_COMMAND_STDERR are set to the stdout and stderr properties of the
        /// Command resource from previous create or update steps.
        /// </summary>
        [Input("delete")]
        public Input<string>? Delete { get; set; }

        [Input("environment")]
        private InputMap<string>? _environment;

        /// <summary>
        /// Additional environment variables available to the command's process.
        /// Note that this only works if the SSH server is configured to accept these variables via AcceptEnv.
        /// Alternatively, if a Bash-like shell runs the command on the remote host, you could prefix the command itself
        /// with the variables in the form 'VAR=value command'.
        /// </summary>
        public InputMap<string> Environment
        {
            get => _environment ?? (_environment = new InputMap<string>());
            set => _environment = value;
        }

        /// <summary>
        /// If the command's stdout and stderr should be logged. This doesn't affect the capturing of
        /// stdout and stderr as outputs. If there might be secrets in the output, you can disable logging here and mark the
        /// outputs as secret via 'additionalSecretOutputs'. Defaults to logging both stdout and stderr.
        /// </summary>
        [Input("logging")]
        public Input<Mjeffryes.Command.Remote.Logging>? Logging { get; set; }

        /// <summary>
        /// Pass a string to the command's process as standard in
        /// </summary>
        [Input("stdin")]
        public Input<string>? Stdin { get; set; }

        [Input("triggers")]
        private InputList<object>? _triggers;

        /// <summary>
        /// Trigger a resource replacement on changes to any of these values. The
        /// trigger values can be of any type. If a value is different in the current update compared to the
        /// previous update, the resource will be replaced, i.e., the "create" command will be re-run.
        /// Please see the resource documentation for examples.
        /// </summary>
        public InputList<object> Triggers
        {
            get => _triggers ?? (_triggers = new InputList<object>());
            set => _triggers = value;
        }

        /// <summary>
        /// The command to run on update, if empty, create will 
        /// run again. The environment variables PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR 
        /// are set to the stdout and stderr properties of the Command resource from previous 
        /// create or update steps.
        /// </summary>
        [Input("update")]
        public Input<string>? Update { get; set; }

        public CommandArgs()
        {
            AddPreviousOutputInEnv = true;
        }
        public static new CommandArgs Empty => new CommandArgs();
    }
}
