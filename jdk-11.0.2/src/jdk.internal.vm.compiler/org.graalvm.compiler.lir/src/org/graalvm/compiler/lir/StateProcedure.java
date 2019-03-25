/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir;

@FunctionalInterface
public interface StateProcedure extends InstructionStateProcedure {

    void doState(LIRFrameState state);

    @Override
    default void doState(LIRInstruction instruction, LIRFrameState state) {
        doState(state);
    }
}
