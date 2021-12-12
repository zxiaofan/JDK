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
package jdk.vm.ci.hotspot;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;

/**
 * The compressed representation of the {@link JavaConstant#NULL_POINTER null constant}.
 */
public final class HotSpotCompressedNullConstant implements JavaConstant, HotSpotConstant {

    public static final JavaConstant COMPRESSED_NULL = new HotSpotCompressedNullConstant();

    private HotSpotCompressedNullConstant() {
    }

    @Override
    public JavaKind getJavaKind() {
        return JavaKind.Object;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public boolean isCompressed() {
        return true;
    }

    @Override
    public Constant compress() {
        throw new IllegalArgumentException();
    }

    @Override
    public Constant uncompress() {
        return NULL_POINTER;
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
        return "null";
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof HotSpotCompressedNullConstant;
    }
}
