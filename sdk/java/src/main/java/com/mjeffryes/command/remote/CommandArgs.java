// *** WARNING: this file was generated by pulumi-language-java. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.mjeffryes.command.remote;

import com.mjeffryes.command.remote.enums.Logging;
import com.mjeffryes.command.remote.inputs.ConnectionArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.core.internal.Codegen;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CommandArgs extends com.pulumi.resources.ResourceArgs {

    public static final CommandArgs Empty = new CommandArgs();

    /**
     * If the previous command&#39;s stdout and stderr (as generated by the prior create/update) is
     * injected into the environment of the next run as PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR.
     * Defaults to true.
     * 
     */
    @Import(name="addPreviousOutputInEnv")
    private @Nullable Output<Boolean> addPreviousOutputInEnv;

    /**
     * @return If the previous command&#39;s stdout and stderr (as generated by the prior create/update) is
     * injected into the environment of the next run as PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR.
     * Defaults to true.
     * 
     */
    public Optional<Output<Boolean>> addPreviousOutputInEnv() {
        return Optional.ofNullable(this.addPreviousOutputInEnv);
    }

    /**
     * The parameters with which to connect to the remote host.
     * 
     */
    @Import(name="connection", required=true)
    private Output<ConnectionArgs> connection;

    /**
     * @return The parameters with which to connect to the remote host.
     * 
     */
    public Output<ConnectionArgs> connection() {
        return this.connection;
    }

    /**
     * The command to run on create.
     * 
     */
    @Import(name="create")
    private @Nullable Output<String> create;

    /**
     * @return The command to run on create.
     * 
     */
    public Optional<Output<String>> create() {
        return Optional.ofNullable(this.create);
    }

    /**
     * The command to run on delete. The environment variables PULUMI_COMMAND_STDOUT
     * and PULUMI_COMMAND_STDERR are set to the stdout and stderr properties of the
     * Command resource from previous create or update steps.
     * 
     */
    @Import(name="delete")
    private @Nullable Output<String> delete;

    /**
     * @return The command to run on delete. The environment variables PULUMI_COMMAND_STDOUT
     * and PULUMI_COMMAND_STDERR are set to the stdout and stderr properties of the
     * Command resource from previous create or update steps.
     * 
     */
    public Optional<Output<String>> delete() {
        return Optional.ofNullable(this.delete);
    }

    /**
     * Additional environment variables available to the command&#39;s process.
     * Note that this only works if the SSH server is configured to accept these variables via AcceptEnv.
     * Alternatively, if a Bash-like shell runs the command on the remote host, you could prefix the command itself
     * with the variables in the form &#39;VAR=value command&#39;.
     * 
     */
    @Import(name="environment")
    private @Nullable Output<Map<String,String>> environment;

    /**
     * @return Additional environment variables available to the command&#39;s process.
     * Note that this only works if the SSH server is configured to accept these variables via AcceptEnv.
     * Alternatively, if a Bash-like shell runs the command on the remote host, you could prefix the command itself
     * with the variables in the form &#39;VAR=value command&#39;.
     * 
     */
    public Optional<Output<Map<String,String>>> environment() {
        return Optional.ofNullable(this.environment);
    }

    /**
     * If the command&#39;s stdout and stderr should be logged. This doesn&#39;t affect the capturing of
     * stdout and stderr as outputs. If there might be secrets in the output, you can disable logging here and mark the
     * outputs as secret via &#39;additionalSecretOutputs&#39;. Defaults to logging both stdout and stderr.
     * 
     */
    @Import(name="logging")
    private @Nullable Output<Logging> logging;

    /**
     * @return If the command&#39;s stdout and stderr should be logged. This doesn&#39;t affect the capturing of
     * stdout and stderr as outputs. If there might be secrets in the output, you can disable logging here and mark the
     * outputs as secret via &#39;additionalSecretOutputs&#39;. Defaults to logging both stdout and stderr.
     * 
     */
    public Optional<Output<Logging>> logging() {
        return Optional.ofNullable(this.logging);
    }

    /**
     * Pass a string to the command&#39;s process as standard in
     * 
     */
    @Import(name="stdin")
    private @Nullable Output<String> stdin;

    /**
     * @return Pass a string to the command&#39;s process as standard in
     * 
     */
    public Optional<Output<String>> stdin() {
        return Optional.ofNullable(this.stdin);
    }

    /**
     * Trigger a resource replacement on changes to any of these values. The
     * trigger values can be of any type. If a value is different in the current update compared to the
     * previous update, the resource will be replaced, i.e., the &#34;create&#34; command will be re-run.
     * Please see the resource documentation for examples.
     * 
     */
    @Import(name="triggers")
    private @Nullable Output<List<Object>> triggers;

    /**
     * @return Trigger a resource replacement on changes to any of these values. The
     * trigger values can be of any type. If a value is different in the current update compared to the
     * previous update, the resource will be replaced, i.e., the &#34;create&#34; command will be re-run.
     * Please see the resource documentation for examples.
     * 
     */
    public Optional<Output<List<Object>>> triggers() {
        return Optional.ofNullable(this.triggers);
    }

    /**
     * The command to run on update, if empty, create will
     * run again. The environment variables PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR
     * are set to the stdout and stderr properties of the Command resource from previous
     * create or update steps.
     * 
     */
    @Import(name="update")
    private @Nullable Output<String> update;

    /**
     * @return The command to run on update, if empty, create will
     * run again. The environment variables PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR
     * are set to the stdout and stderr properties of the Command resource from previous
     * create or update steps.
     * 
     */
    public Optional<Output<String>> update() {
        return Optional.ofNullable(this.update);
    }

    private CommandArgs() {}

    private CommandArgs(CommandArgs $) {
        this.addPreviousOutputInEnv = $.addPreviousOutputInEnv;
        this.connection = $.connection;
        this.create = $.create;
        this.delete = $.delete;
        this.environment = $.environment;
        this.logging = $.logging;
        this.stdin = $.stdin;
        this.triggers = $.triggers;
        this.update = $.update;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CommandArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CommandArgs $;

        public Builder() {
            $ = new CommandArgs();
        }

        public Builder(CommandArgs defaults) {
            $ = new CommandArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param addPreviousOutputInEnv If the previous command&#39;s stdout and stderr (as generated by the prior create/update) is
         * injected into the environment of the next run as PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR.
         * Defaults to true.
         * 
         * @return builder
         * 
         */
        public Builder addPreviousOutputInEnv(@Nullable Output<Boolean> addPreviousOutputInEnv) {
            $.addPreviousOutputInEnv = addPreviousOutputInEnv;
            return this;
        }

        /**
         * @param addPreviousOutputInEnv If the previous command&#39;s stdout and stderr (as generated by the prior create/update) is
         * injected into the environment of the next run as PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR.
         * Defaults to true.
         * 
         * @return builder
         * 
         */
        public Builder addPreviousOutputInEnv(Boolean addPreviousOutputInEnv) {
            return addPreviousOutputInEnv(Output.of(addPreviousOutputInEnv));
        }

        /**
         * @param connection The parameters with which to connect to the remote host.
         * 
         * @return builder
         * 
         */
        public Builder connection(Output<ConnectionArgs> connection) {
            $.connection = connection;
            return this;
        }

        /**
         * @param connection The parameters with which to connect to the remote host.
         * 
         * @return builder
         * 
         */
        public Builder connection(ConnectionArgs connection) {
            return connection(Output.of(connection));
        }

        /**
         * @param create The command to run on create.
         * 
         * @return builder
         * 
         */
        public Builder create(@Nullable Output<String> create) {
            $.create = create;
            return this;
        }

        /**
         * @param create The command to run on create.
         * 
         * @return builder
         * 
         */
        public Builder create(String create) {
            return create(Output.of(create));
        }

        /**
         * @param delete The command to run on delete. The environment variables PULUMI_COMMAND_STDOUT
         * and PULUMI_COMMAND_STDERR are set to the stdout and stderr properties of the
         * Command resource from previous create or update steps.
         * 
         * @return builder
         * 
         */
        public Builder delete(@Nullable Output<String> delete) {
            $.delete = delete;
            return this;
        }

        /**
         * @param delete The command to run on delete. The environment variables PULUMI_COMMAND_STDOUT
         * and PULUMI_COMMAND_STDERR are set to the stdout and stderr properties of the
         * Command resource from previous create or update steps.
         * 
         * @return builder
         * 
         */
        public Builder delete(String delete) {
            return delete(Output.of(delete));
        }

        /**
         * @param environment Additional environment variables available to the command&#39;s process.
         * Note that this only works if the SSH server is configured to accept these variables via AcceptEnv.
         * Alternatively, if a Bash-like shell runs the command on the remote host, you could prefix the command itself
         * with the variables in the form &#39;VAR=value command&#39;.
         * 
         * @return builder
         * 
         */
        public Builder environment(@Nullable Output<Map<String,String>> environment) {
            $.environment = environment;
            return this;
        }

        /**
         * @param environment Additional environment variables available to the command&#39;s process.
         * Note that this only works if the SSH server is configured to accept these variables via AcceptEnv.
         * Alternatively, if a Bash-like shell runs the command on the remote host, you could prefix the command itself
         * with the variables in the form &#39;VAR=value command&#39;.
         * 
         * @return builder
         * 
         */
        public Builder environment(Map<String,String> environment) {
            return environment(Output.of(environment));
        }

        /**
         * @param logging If the command&#39;s stdout and stderr should be logged. This doesn&#39;t affect the capturing of
         * stdout and stderr as outputs. If there might be secrets in the output, you can disable logging here and mark the
         * outputs as secret via &#39;additionalSecretOutputs&#39;. Defaults to logging both stdout and stderr.
         * 
         * @return builder
         * 
         */
        public Builder logging(@Nullable Output<Logging> logging) {
            $.logging = logging;
            return this;
        }

        /**
         * @param logging If the command&#39;s stdout and stderr should be logged. This doesn&#39;t affect the capturing of
         * stdout and stderr as outputs. If there might be secrets in the output, you can disable logging here and mark the
         * outputs as secret via &#39;additionalSecretOutputs&#39;. Defaults to logging both stdout and stderr.
         * 
         * @return builder
         * 
         */
        public Builder logging(Logging logging) {
            return logging(Output.of(logging));
        }

        /**
         * @param stdin Pass a string to the command&#39;s process as standard in
         * 
         * @return builder
         * 
         */
        public Builder stdin(@Nullable Output<String> stdin) {
            $.stdin = stdin;
            return this;
        }

        /**
         * @param stdin Pass a string to the command&#39;s process as standard in
         * 
         * @return builder
         * 
         */
        public Builder stdin(String stdin) {
            return stdin(Output.of(stdin));
        }

        /**
         * @param triggers Trigger a resource replacement on changes to any of these values. The
         * trigger values can be of any type. If a value is different in the current update compared to the
         * previous update, the resource will be replaced, i.e., the &#34;create&#34; command will be re-run.
         * Please see the resource documentation for examples.
         * 
         * @return builder
         * 
         */
        public Builder triggers(@Nullable Output<List<Object>> triggers) {
            $.triggers = triggers;
            return this;
        }

        /**
         * @param triggers Trigger a resource replacement on changes to any of these values. The
         * trigger values can be of any type. If a value is different in the current update compared to the
         * previous update, the resource will be replaced, i.e., the &#34;create&#34; command will be re-run.
         * Please see the resource documentation for examples.
         * 
         * @return builder
         * 
         */
        public Builder triggers(List<Object> triggers) {
            return triggers(Output.of(triggers));
        }

        /**
         * @param triggers Trigger a resource replacement on changes to any of these values. The
         * trigger values can be of any type. If a value is different in the current update compared to the
         * previous update, the resource will be replaced, i.e., the &#34;create&#34; command will be re-run.
         * Please see the resource documentation for examples.
         * 
         * @return builder
         * 
         */
        public Builder triggers(Object... triggers) {
            return triggers(List.of(triggers));
        }

        /**
         * @param update The command to run on update, if empty, create will
         * run again. The environment variables PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR
         * are set to the stdout and stderr properties of the Command resource from previous
         * create or update steps.
         * 
         * @return builder
         * 
         */
        public Builder update(@Nullable Output<String> update) {
            $.update = update;
            return this;
        }

        /**
         * @param update The command to run on update, if empty, create will
         * run again. The environment variables PULUMI_COMMAND_STDOUT and PULUMI_COMMAND_STDERR
         * are set to the stdout and stderr properties of the Command resource from previous
         * create or update steps.
         * 
         * @return builder
         * 
         */
        public Builder update(String update) {
            return update(Output.of(update));
        }

        public CommandArgs build() {
            $.addPreviousOutputInEnv = Codegen.booleanProp("addPreviousOutputInEnv").output().arg($.addPreviousOutputInEnv).def(true).getNullable();
            if ($.connection == null) {
                throw new MissingRequiredPropertyException("CommandArgs", "connection");
            }
            return $;
        }
    }

}
