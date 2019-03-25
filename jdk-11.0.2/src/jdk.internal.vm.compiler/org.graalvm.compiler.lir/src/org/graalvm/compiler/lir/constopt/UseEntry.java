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


package org.graalvm.compiler.lir.constopt;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.ValueProcedure;

import jdk.vm.ci.meta.Value;

/**
 * Represents a usage of a constant.
 */
class UseEntry {

    private final AbstractBlockBase<?> block;
    private final LIRInstruction instruction;
    private final Value value;

    UseEntry(AbstractBlockBase<?> block, LIRInstruction instruction, Value value) {
        this.block = block;
        this.instruction = instruction;
        this.value = value;
    }

    public LIRInstruction getInstruction() {
        return instruction;
    }

    public AbstractBlockBase<?> getBlock() {
        return block;
    }

    public void setValue(Value newValue) {
        replaceValue(instruction, value, newValue);
    }

    private static void replaceValue(LIRInstruction op, Value oldValue, Value newValue) {
        ValueProcedure proc = (value, mode, flags) -> value.identityEquals(oldValue) ? newValue : value;
        op.forEachAlive(proc);
        op.forEachInput(proc);
        op.forEachOutput(proc);
        op.forEachTemp(proc);
        op.forEachState(proc);
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Use[" + getValue() + ":" + instruction + ":" + block + "]";
    }

}
