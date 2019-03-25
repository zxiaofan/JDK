/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.tiers;

import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.phases.PhaseSuite;

/**
 * Main interface providing access to suites used for compilation.
 */

public interface SuitesProvider {

    /**
     * Get the default phase suites of this compiler. This will take {@code options} into account,
     * returning an appropriately constructed suite. The returned suite is immutable by default but
     * {@link Suites#copy} can be used to create a customized version.
     */
    Suites getDefaultSuites(OptionValues values);

    /**
     * Get the default phase suite for creating new graphs.
     */
    PhaseSuite<HighTierContext> getDefaultGraphBuilderSuite();

    /**
     * Get the default LIR phase suites of this compiler. This will take in account any options
     * enabled at the time of call, returning an appropriately constructed suite. The returned suite
     * is immutable by default but {@link LIRSuites#copy} can be used to create a customized
     * version.
     */
    LIRSuites getDefaultLIRSuites(OptionValues options);
}
