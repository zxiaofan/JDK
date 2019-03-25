/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.StandardOp.LoadConstantOp;
import org.graalvm.compiler.lir.Variable;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.Value;

/**
 * Represents def-use tree of a constant.
 */
class DefUseTree {
    private final LoadConstantOp instruction;
    private final AbstractBlockBase<?> block;
    private final List<UseEntry> uses;

    DefUseTree(LIRInstruction instruction, AbstractBlockBase<?> block) {
        assert LoadConstantOp.isLoadConstantOp(instruction) : "Not a LoadConstantOp: " + instruction;
        this.instruction = LoadConstantOp.asLoadConstantOp(instruction);
        this.block = block;
        this.uses = new ArrayList<>();
    }

    public Variable getVariable() {
        return (Variable) instruction.getResult();
    }

    public Constant getConstant() {
        return instruction.getConstant();
    }

    public LIRInstruction getInstruction() {
        return (LIRInstruction) instruction;
    }

    public AbstractBlockBase<?> getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return "DefUseTree [" + instruction + "|" + block + "," + uses + "]";
    }

    public void addUsage(AbstractBlockBase<?> b, LIRInstruction inst, Value value) {
        uses.add(new UseEntry(b, inst, value));
    }

    public int usageCount() {
        return uses.size();
    }

    public void forEach(Consumer<? super UseEntry> action) {
        uses.forEach(action);
    }

}
