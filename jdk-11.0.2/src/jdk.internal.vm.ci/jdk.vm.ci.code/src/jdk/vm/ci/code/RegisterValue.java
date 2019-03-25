/*
 * Copyright (c) 2009, 2016, Oracle and/or its affiliates. All rights reserved.
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
import jdk.vm.ci.meta.ValueKind;

/**
 * Denotes a register that stores a value of a fixed kind.
 */
public final class RegisterValue extends AllocatableValue {

    private final Register reg;

    protected RegisterValue(ValueKind<?> kind, Register register) {
        super(kind);
        this.reg = register;
    }

    @Override
    public String toString() {
        return getRegister().name + getKindSuffix();
    }

    /**
     * @return the register that contains the value
     */
    public Register getRegister() {
        return reg;
    }

    @Override
    public int hashCode() {
        return 29 * super.hashCode() + reg.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RegisterValue) {
            RegisterValue other = (RegisterValue) obj;
            return super.equals(obj) && reg.equals(other.reg);
        }
        return false;
    }
}
