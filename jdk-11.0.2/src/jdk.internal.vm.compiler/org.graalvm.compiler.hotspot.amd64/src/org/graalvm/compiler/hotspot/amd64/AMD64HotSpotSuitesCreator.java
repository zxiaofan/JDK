/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.amd64;

import org.graalvm.compiler.core.amd64.AMD64SuitesCreator;
import org.graalvm.compiler.debug.Assertions;
import org.graalvm.compiler.hotspot.lir.HotSpotZapRegistersPhase;
import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration.Plugins;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;

public class AMD64HotSpotSuitesCreator extends AMD64SuitesCreator {

    public AMD64HotSpotSuitesCreator(CompilerConfiguration compilerConfiguration, Plugins plugins) {
        super(compilerConfiguration, plugins);
    }

    @Override
    public LIRSuites createLIRSuites(OptionValues options) {
        LIRSuites lirSuites = super.createLIRSuites(options);
        if (Assertions.detailedAssertionsEnabled(options)) {
            lirSuites.getPostAllocationOptimizationStage().appendPhase(new HotSpotZapRegistersPhase());
        }
        return lirSuites;
    }
}
