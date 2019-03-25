/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.aarch64;

import java.util.ListIterator;

import org.graalvm.compiler.java.DefaultSuitesCreator;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.phases.BasePhase;
import org.graalvm.compiler.phases.Phase;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;
import org.graalvm.compiler.phases.tiers.LowTierContext;
import org.graalvm.compiler.phases.tiers.Suites;

public class AArch64SuitesCreator extends DefaultSuitesCreator {
    private final Class<? extends Phase> insertReadReplacementBefore;

    public AArch64SuitesCreator(CompilerConfiguration compilerConfiguration, Plugins plugins, Class<? extends Phase> insertReadReplacementBefore) {
        super(compilerConfiguration, plugins);
        this.insertReadReplacementBefore = insertReadReplacementBefore;
    }

    @Override
    public Suites createSuites(OptionValues options) {
        Suites suites = super.createSuites(options);

        ListIterator<BasePhase<? super LowTierContext>> findPhase = suites.getLowTier().findPhase(insertReadReplacementBefore);
        // Put AArch64ReadReplacementPhase right before the SchedulePhase
        while (PhaseSuite.findNextPhase(findPhase, insertReadReplacementBefore)) {
            // Search for last occurrence of SchedulePhase
        }
        findPhase.previous();
        findPhase.add(new AArch64ReadReplacementPhase());
        return suites;
    }
}
