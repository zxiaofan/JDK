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


package org.graalvm.compiler.lir.profiling;

import static jdk.vm.ci.code.ValueUtil.isRegister;
import static jdk.vm.ci.code.ValueUtil.isStackSlot;

import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.StandardOp.LoadConstantOp;
import org.graalvm.compiler.lir.StandardOp.MoveOp;
import org.graalvm.compiler.lir.StandardOp.ValueMoveOp;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Value;

enum MoveType {
    REG2REG("Reg", "Reg"),
    STACK2REG("Reg", "Stack"),
    CONST2REG("Reg", "Const"),
    REG2STACK("Stack", "Reg"),
    CONST2STACK("Stack", "Const"),
    STACK2STACK("Stack", "Stack");

    private final String name;

    MoveType(String dst, String src) {
        this.name = src + '2' + dst;
    }

    @Override
    public String toString() {
        return name;
    }

    public static MoveType get(LIRInstruction inst) {
        assert MoveOp.isMoveOp(inst);
        AllocatableValue dst = MoveOp.asMoveOp(inst).getResult();
        Value src = null;
        if (LoadConstantOp.isLoadConstantOp(inst)) {
            if (isRegister(dst)) {
                return CONST2REG;
            } else if (isStackSlot(dst)) {
                return CONST2STACK;
            }
        } else if (ValueMoveOp.isValueMoveOp(inst)) {
            src = ValueMoveOp.asValueMoveOp(inst).getInput();
            if (isRegister(dst)) {
                if (isRegister(src)) {
                    return REG2REG;
                } else if (isStackSlot(src)) {
                    return STACK2REG;
                }
            } else if (isStackSlot(dst)) {
                if (isRegister(src)) {
                    return REG2STACK;
                } else if (isStackSlot(src)) {
                    return STACK2STACK;
                }
            }
        }
        throw GraalError.shouldNotReachHere(String.format("Unrecognized Move: %s dst=%s, src=%s", inst, dst, src));
    }
}
