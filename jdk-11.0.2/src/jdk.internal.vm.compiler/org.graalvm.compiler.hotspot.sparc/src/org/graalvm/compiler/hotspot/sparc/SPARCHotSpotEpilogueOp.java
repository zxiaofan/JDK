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


package org.graalvm.compiler.hotspot.sparc;

import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.sparc.SPARCBlockEndOp;

/**
 * Superclass for operations that leave a method's frame.
 */
abstract class SPARCHotSpotEpilogueOp extends SPARCBlockEndOp {
    public static final LIRInstructionClass<SPARCHotSpotEpilogueOp> TYPE = LIRInstructionClass.create(SPARCHotSpotEpilogueOp.class);

    protected SPARCHotSpotEpilogueOp(LIRInstructionClass<? extends SPARCHotSpotEpilogueOp> c, SizeEstimate size) {
        super(c, size);
    }

    protected void leaveFrame(CompilationResultBuilder crb) {
        crb.frameContext.leave(crb);
    }
}
