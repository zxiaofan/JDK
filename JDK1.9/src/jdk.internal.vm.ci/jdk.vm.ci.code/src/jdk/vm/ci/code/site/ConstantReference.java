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
package jdk.vm.ci.code.site;

import java.util.Objects;

import jdk.vm.ci.meta.VMConstant;

/**
 * Represents an embedded {@link VMConstant} in the code or data section that needs to be
 * {@link DataPatch patched} by the VM (e.g. an embedded pointer to a Java object).
 */
public final class ConstantReference extends Reference {

    private final VMConstant constant;

    public ConstantReference(VMConstant constant) {
        this.constant = constant;
    }

    public VMConstant getConstant() {
        return constant;
    }

    @Override
    public String toString() {
        return constant.toString();
    }

    @Override
    public int hashCode() {
        return constant.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConstantReference) {
            ConstantReference that = (ConstantReference) obj;
            return Objects.equals(this.constant, that.constant);
        }
        return false;
    }
}
