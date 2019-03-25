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


package org.graalvm.compiler.lir;

import jdk.vm.ci.code.StackSlot;
import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.ValueKind;

/**
 * {@link VirtualStackSlot}s are stack slots that are not yet fixed to specific frame offset. They
 * are replaced by real {@link StackSlot}s with a fixed position in the frame before code emission.
 */
public abstract class VirtualStackSlot extends AllocatableValue {

    private final int id;

    public VirtualStackSlot(int id, ValueKind<?> kind) {
        super(kind);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "vstack:" + id + getKindSuffix();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        VirtualStackSlot other = (VirtualStackSlot) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

}
