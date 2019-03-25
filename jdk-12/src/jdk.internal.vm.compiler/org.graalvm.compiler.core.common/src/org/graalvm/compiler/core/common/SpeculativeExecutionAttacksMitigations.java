/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common;

import org.graalvm.compiler.options.EnumOptionKey;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionKey;
import org.graalvm.compiler.options.OptionType;

public enum SpeculativeExecutionAttacksMitigations {
    None,
    AllTargets,
    GuardTargets,
    NonDeoptGuardTargets;

    public static class Options {
        // @formatter:off
        @Option(help = "Select a strategy to mitigate speculative execution attacks (e.g., SPECTRE)", type = OptionType.User)
        public static final EnumOptionKey<SpeculativeExecutionAttacksMitigations> MitigateSpeculativeExecutionAttacks = new EnumOptionKey<>(None);
        @Option(help = "Use index masking after bounds check to mitigate speculative execution attacks", type = OptionType.User)
        public static final OptionKey<Boolean> UseIndexMasking = new OptionKey<>(false);
        // @formatter:on
    }
}
