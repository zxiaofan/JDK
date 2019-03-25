/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.java;

import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.SpeculationLog.SpeculationReason;

public final class IntegerExactOpSpeculation implements SpeculationReason {

    public enum IntegerExactOp {
        INTEGER_ADD_EXACT,
        INTEGER_INCREMENT_EXACT,
        INTEGER_SUBTRACT_EXACT,
        INTEGER_DECREMENT_EXACT,
        INTEGER_MULTIPLY_EXACT
    }

    protected final String methodDescriptor;
    protected final IntegerExactOp op;

    public IntegerExactOpSpeculation(ResolvedJavaMethod method, IntegerExactOp op) {
        this.methodDescriptor = method.format("%H.%n(%p)%R");
        this.op = op;
    }

    @Override
    public int hashCode() {
        return methodDescriptor.hashCode() * 31 + op.ordinal();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IntegerExactOpSpeculation) {
            IntegerExactOpSpeculation other = (IntegerExactOpSpeculation) obj;
            return op.equals(other.op) && methodDescriptor.equals(other.methodDescriptor);
        }
        return false;
    }

}
