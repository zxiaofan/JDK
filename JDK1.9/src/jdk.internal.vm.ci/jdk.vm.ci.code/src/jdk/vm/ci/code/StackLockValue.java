/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.code;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.JavaValue;
import jdk.vm.ci.meta.Value;

/**
 * Represents lock information in the debug information.
 */
public final class StackLockValue implements JavaValue {

    private JavaValue owner;
    private AllocatableValue slot;
    private final boolean eliminated;

    public StackLockValue(JavaValue object, AllocatableValue slot, boolean eliminated) {
        this.owner = object;
        this.slot = slot;
        this.eliminated = eliminated;
    }

    public JavaValue getOwner() {
        return owner;
    }

    public void setOwner(JavaValue newOwner) {
        this.owner = newOwner;
    }

    public Value getSlot() {
        return slot;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    @Override
    public String toString() {
        return "monitor[" + owner + (slot != null ? ", " + slot : "") + (eliminated ? ", eliminated" : "") + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 43;
        int result = super.hashCode();
        result = prime * result + (eliminated ? 1231 : 1237);
        result = prime * result + owner.hashCode();
        result = prime * result + slot.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StackLockValue) {
            StackLockValue other = (StackLockValue) obj;
            return super.equals(obj) && eliminated == other.eliminated && owner.equals(other.owner) && slot.equals(other.slot);
        }
        return false;
    }

    public void setSlot(AllocatableValue stackSlot) {
        slot = stackSlot;
    }
}
