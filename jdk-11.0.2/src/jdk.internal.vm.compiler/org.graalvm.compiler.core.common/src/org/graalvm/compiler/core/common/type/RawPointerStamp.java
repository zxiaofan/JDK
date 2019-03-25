/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.type;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.common.spi.LIRKindTool;
import org.graalvm.compiler.debug.GraalError;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.MemoryAccessProvider;
import jdk.vm.ci.meta.MetaAccessProvider;
import jdk.vm.ci.meta.PrimitiveConstant;
import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * Type describing pointers to raw memory. This stamp is used for example for direct pointers to
 * fields or array elements.
 */
public class RawPointerStamp extends AbstractPointerStamp {

    protected RawPointerStamp() {
        super(false, false);
    }

    @Override
    public LIRKind getLIRKind(LIRKindTool tool) {
        return tool.getWordKind();
    }

    @Override
    protected AbstractPointerStamp copyWith(boolean newNonNull, boolean newAlwaysNull) {
        // RawPointerStamp is a singleton
        assert newNonNull == nonNull() && newAlwaysNull == alwaysNull();
        return this;
    }

    @Override
    public Stamp meet(Stamp other) {
        assert isCompatible(other);
        return this;
    }

    @Override
    public Stamp improveWith(Stamp other) {
        return this;
    }

    @Override
    public Stamp join(Stamp other) {
        assert isCompatible(other);
        return this;
    }

    @Override
    public Stamp unrestricted() {
        return this;
    }

    @Override
    public Stamp empty() {
        // there is no empty pointer stamp
        return this;
    }

    @Override
    public boolean hasValues() {
        return true;
    }

    @Override
    public ResolvedJavaType javaType(MetaAccessProvider metaAccess) {
        throw GraalError.shouldNotReachHere("pointer has no Java type");
    }

    @Override
    public Stamp constant(Constant c, MetaAccessProvider meta) {
        return this;
    }

    @Override
    public boolean isCompatible(Stamp other) {
        return other instanceof RawPointerStamp;
    }

    @Override
    public boolean isCompatible(Constant constant) {
        if (constant instanceof PrimitiveConstant) {
            return ((PrimitiveConstant) constant).getJavaKind().isNumericInteger();
        } else {
            return constant instanceof DataPointerConstant;
        }
    }

    @Override
    public Constant readConstant(MemoryAccessProvider provider, Constant base, long displacement) {
        throw GraalError.shouldNotReachHere("can't read raw pointer");
    }

    @Override
    public String toString() {
        return "void*";
    }
}
