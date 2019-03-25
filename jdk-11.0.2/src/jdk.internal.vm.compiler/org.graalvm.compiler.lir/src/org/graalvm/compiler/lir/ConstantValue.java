/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.Value;
import jdk.vm.ci.meta.ValueKind;

/**
 * Represents an inlined {@link Constant} value.
 */
public class ConstantValue extends Value {

    private final Constant constant;

    public ConstantValue(ValueKind<?> kind, Constant constant) {
        super(kind);
        this.constant = constant;
    }

    public Constant getConstant() {
        return constant;
    }

    public boolean isJavaConstant() {
        return constant instanceof JavaConstant;
    }

    public JavaConstant getJavaConstant() {
        return (JavaConstant) constant;
    }

    @Override
    public String toString() {
        return constant.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConstantValue) {
            ConstantValue other = (ConstantValue) obj;
            return super.equals(other) && this.constant.equals(other.constant);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return constant.hashCode() + super.hashCode();
    }
}
