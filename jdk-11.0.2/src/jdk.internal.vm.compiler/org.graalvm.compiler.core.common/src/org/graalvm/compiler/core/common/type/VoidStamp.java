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


package org.graalvm.compiler.core.common.type;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.common.spi.LIRKindTool;
import org.graalvm.compiler.debug.GraalError;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.MemoryAccessProvider;
import jdk.vm.ci.meta.MetaAccessProvider;
import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * Singleton stamp representing the value of type {@code void}.
 */
public final class VoidStamp extends Stamp {

    private VoidStamp() {
    }

    @Override
    public Stamp unrestricted() {
        return this;
    }

    @Override
    public boolean isUnrestricted() {
        return true;
    }

    @Override
    public JavaKind getStackKind() {
        return JavaKind.Void;
    }

    @Override
    public Stamp improveWith(Stamp other) {
        assert other instanceof VoidStamp;
        return this;
    }

    @Override
    public LIRKind getLIRKind(LIRKindTool tool) {
        throw GraalError.shouldNotReachHere("void stamp has no value");
    }

    @Override
    public ResolvedJavaType javaType(MetaAccessProvider metaAccess) {
        return metaAccess.lookupJavaType(Void.TYPE);
    }

    @Override
    public String toString() {
        return "void";
    }

    @Override
    public boolean alwaysDistinct(Stamp other) {
        return this != other;
    }

    @Override
    public Stamp meet(Stamp other) {
        assert other instanceof VoidStamp;
        return this;
    }

    @Override
    public Stamp join(Stamp other) {
        assert other instanceof VoidStamp;
        return this;
    }

    @Override
    public boolean isCompatible(Stamp stamp) {
        return stamp instanceof VoidStamp;
    }

    @Override
    public boolean isCompatible(Constant constant) {
        return false;
    }

    @Override
    public Stamp empty() {
        // the void stamp is always empty
        return this;
    }

    @Override
    public boolean hasValues() {
        return false;
    }

    @Override
    public Constant readConstant(MemoryAccessProvider provider, Constant base, long displacement) {
        throw GraalError.shouldNotReachHere("can't read values of void stamp");
    }

    @Override
    public Stamp constant(Constant c, MetaAccessProvider meta) {
        throw GraalError.shouldNotReachHere("void stamp has no value");
    }

    private static final VoidStamp instance = new VoidStamp();

    static VoidStamp getInstance() {
        return instance;
    }
}
