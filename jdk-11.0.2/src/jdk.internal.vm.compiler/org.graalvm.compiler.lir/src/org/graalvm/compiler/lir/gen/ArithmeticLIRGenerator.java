/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.gen;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.Variable;
import org.graalvm.compiler.options.OptionValues;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.PlatformKind;
import jdk.vm.ci.meta.Value;

/**
 * This class traverses the HIR instructions and generates LIR instructions from them.
 */
public abstract class ArithmeticLIRGenerator implements ArithmeticLIRGeneratorTool {

    LIRGenerator lirGen;

    public LIRGenerator getLIRGen() {
        return lirGen;
    }

    protected final AllocatableValue asAllocatable(Value value) {
        return lirGen.asAllocatable(value);
    }

    public OptionValues getOptions() {
        return getLIRGen().getResult().getLIR().getOptions();
    }
    // automatic derived reference handling

    protected abstract boolean isNumericInteger(PlatformKind kind);

    protected abstract Variable emitAdd(LIRKind resultKind, Value a, Value b, boolean setFlags);

    protected abstract Variable emitSub(LIRKind resultKind, Value a, Value b, boolean setFlags);

    @Override
    public final Variable emitAdd(Value aVal, Value bVal, boolean setFlags) {
        return emitAddOrSub(aVal, bVal, setFlags, true);
    }

    @Override
    public final Variable emitSub(Value aVal, Value bVal, boolean setFlags) {
        return emitAddOrSub(aVal, bVal, setFlags, false);
    }

    private Variable emitAddOrSub(Value aVal, Value bVal, boolean setFlags, boolean isAdd) {
        LIRKind resultKind;
        Value a = aVal;
        Value b = bVal;

        if (isNumericInteger(a.getPlatformKind())) {
            LIRKind aKind = a.getValueKind(LIRKind.class);
            LIRKind bKind = b.getValueKind(LIRKind.class);
            assert a.getPlatformKind() == b.getPlatformKind() : a.getPlatformKind() + " vs. " + b.getPlatformKind();

            if (aKind.isUnknownReference()) {
                resultKind = aKind;
            } else if (bKind.isUnknownReference()) {
                resultKind = bKind;
            } else if (aKind.isValue() && bKind.isValue()) {
                resultKind = aKind;
            } else if (aKind.isValue()) {
                if (bKind.isDerivedReference()) {
                    resultKind = bKind;
                } else {
                    AllocatableValue allocatable = asAllocatable(b);
                    resultKind = bKind.makeDerivedReference(allocatable);
                    b = allocatable;
                }
            } else if (bKind.isValue()) {
                if (aKind.isDerivedReference()) {
                    resultKind = aKind;
                } else {
                    AllocatableValue allocatable = asAllocatable(a);
                    resultKind = aKind.makeDerivedReference(allocatable);
                    a = allocatable;
                }
            } else {
                resultKind = aKind.makeUnknownReference();
            }
        } else {
            resultKind = LIRKind.combine(a, b);
        }

        return isAdd ? emitAdd(resultKind, a, b, setFlags) : emitSub(resultKind, a, b, setFlags);
    }

}
