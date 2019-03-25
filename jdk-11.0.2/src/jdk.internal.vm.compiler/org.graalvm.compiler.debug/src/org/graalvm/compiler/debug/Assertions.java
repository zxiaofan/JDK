/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


package org.graalvm.compiler.debug;

import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionKey;
import org.graalvm.compiler.options.OptionType;
import org.graalvm.compiler.options.OptionValues;

/**
 * Utility for query whether assertions are enabled.
 */
public class Assertions {
    /**
     * Determines if assertions are enabled. Strictly speaking, this may only be true for the
     * {@link Assertions} class but we assume assertions are enabled/disabled for Graal as a whole.
     */
    public static boolean assertionsEnabled() {
        boolean enabled = false;
        assert (enabled = true) == true;
        return enabled;
    }

    /**
     * Determines if detailed assertions are enabled. This requires that the normal assertions are
     * also enabled.
     *
     * @param values the current OptionValues that might define a value for DetailAsserts.
     */
    public static boolean detailedAssertionsEnabled(OptionValues values) {
        return assertionsEnabled() && Options.DetailedAsserts.getValue(values);
    }

    // @formatter:off
    public static class Options {

        @Option(help = "Enable expensive assertions if normal assertions (i.e. -ea or -esa) are enabled.", type = OptionType.Debug)
        public static final OptionKey<Boolean> DetailedAsserts = new OptionKey<>(false);

    }
    // @formatter:on
}
