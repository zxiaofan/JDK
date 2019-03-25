/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.java;

import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.tiers.HighTierContext;
import org.graalvm.compiler.phases.tiers.Suites;
import org.graalvm.compiler.phases.tiers.SuitesCreator;

public abstract class SuitesProviderBase implements SuitesCreator {

    protected PhaseSuite<HighTierContext> defaultGraphBuilderSuite;

    @Override
    public final Suites getDefaultSuites(OptionValues options) {
        return createSuites(options);
    }

    @Override
    public PhaseSuite<HighTierContext> getDefaultGraphBuilderSuite() {
        return defaultGraphBuilderSuite;
    }

    @Override
    public final LIRSuites getDefaultLIRSuites(OptionValues options) {
        return createLIRSuites(options);
    }

    @Override
    public abstract LIRSuites createLIRSuites(OptionValues options);

    @Override
    public abstract Suites createSuites(OptionValues options);
}
