/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.code.RegisterValue;
import jdk.vm.ci.code.StackSlot;
import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.ValueKind;

/**
 * Represents a value that is yet to be bound to a machine location (such as a {@link RegisterValue}
 * or {@link StackSlot}) by a register allocator.
 */
public final class Variable extends AllocatableValue {

    /**
     * The identifier of the variable. This is a non-zero index in a contiguous 0-based name space.
     */
    public final int index;

    private String name;

    /**
     * Creates a new variable.
     *
     * @param kind
     * @param index
     */
    public Variable(ValueKind<?> kind, int index) {
        super(kind);
        assert index >= 0;
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (name != null) {
            return name;
        } else {
            return "v" + index + getKindSuffix();
        }
    }

    @Override
    public int hashCode() {
        return 71 * super.hashCode() + index;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Variable) {
            Variable other = (Variable) obj;
            return super.equals(other) && index == other.index;
        }
        return false;
    }
}
