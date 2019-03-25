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

import org.graalvm.compiler.lir.gen.DiagnosticLIRGeneratorTool;

public abstract class PostAllocationOptimizationPhase extends LIRPhase<PostAllocationOptimizationPhase.PostAllocationOptimizationContext> {

    public static final class PostAllocationOptimizationContext {
        public final DiagnosticLIRGeneratorTool diagnosticLirGenTool;

        public PostAllocationOptimizationContext(DiagnosticLIRGeneratorTool diagnosticTool) {
            this.diagnosticLirGenTool = diagnosticTool;
        }
    }
}
