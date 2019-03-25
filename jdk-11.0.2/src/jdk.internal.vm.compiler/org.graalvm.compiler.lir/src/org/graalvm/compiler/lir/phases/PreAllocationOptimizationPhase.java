/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.phases;

import org.graalvm.compiler.lir.gen.LIRGeneratorTool;

public abstract class PreAllocationOptimizationPhase extends LIRPhase<PreAllocationOptimizationPhase.PreAllocationOptimizationContext> {

    public static final class PreAllocationOptimizationContext {
        public final LIRGeneratorTool lirGen;

        public PreAllocationOptimizationContext(LIRGeneratorTool lirGen) {
            this.lirGen = lirGen;
        }

    }

}
