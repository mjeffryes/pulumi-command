// *** WARNING: this file was generated by pulumi-language-java. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.command.remote.enums;

import com.pulumi.core.annotations.EnumType;
import java.lang.String;
import java.util.Objects;
import java.util.StringJoiner;

    @EnumType
    public enum Logging {
        /**
         * Capture stdout in logs but not stderr
         * 
         */
        Stdout("stdout"),
        /**
         * Capture stderr in logs but not stdout
         * 
         */
        Stderr("stderr"),
        /**
         * Capture stdout and stderr in logs
         * 
         */
        StdoutAndStderr("stdoutAndStderr"),
        /**
         * Capture no logs
         * 
         */
        None("none");

        private final String value;

        Logging(String value) {
            this.value = Objects.requireNonNull(value);
        }

        @EnumType.Converter
        public String getValue() {
            return this.value;
        }

        @Override
        public java.lang.String toString() {
            return new StringJoiner(", ", "Logging[", "]")
                .add("value='" + this.value + "'")
                .toString();
        }
    }
