/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.hotspot;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.VMConstant;
import jdk.vm.ci.meta.Value;
import jdk.vm.ci.meta.ValueKind;

public final class HotSpotSentinelConstant extends Value implements JavaConstant, VMConstant {

    private final JavaKind javaKind;

    public HotSpotSentinelConstant(ValueKind<?> valueKind, JavaKind javaKind) {
        super(valueKind);
        this.javaKind = javaKind;
    }

    @Override
    public JavaKind getJavaKind() {
        return javaKind;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public boolean isDefaultForKind() {
        return true;
    }

    @Override
    public Object asBoxedPrimitive() {
        throw new IllegalArgumentException();
    }

    @Override
    public int asInt() {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean asBoolean() {
        throw new IllegalArgumentException();
    }

    @Override
    public long asLong() {
        throw new IllegalArgumentException();
    }

    @Override
    public float asFloat() {
        throw new IllegalArgumentException();
    }

    @Override
    public double asDouble() {
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return JavaConstant.toString(this);
    }

    @Override
    public String toValueString() {
        return "sentinel";
    }

    @Override
    public int hashCode() {
        return 13;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof HotSpotSentinelConstant;
    }
}
