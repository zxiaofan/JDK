/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.MemoryAccessProvider;
import jdk.vm.ci.meta.ResolvedJavaType;

public class ObjectStamp extends AbstractObjectStamp {

    public ObjectStamp(ResolvedJavaType type, boolean exactType, boolean nonNull, boolean alwaysNull) {
        super(type, exactType, nonNull, alwaysNull);
    }

    @Override
    protected ObjectStamp copyWith(ResolvedJavaType type, boolean exactType, boolean nonNull, boolean alwaysNull) {
        return new ObjectStamp(type, exactType, nonNull, alwaysNull);
    }

    @Override
    public Stamp unrestricted() {
        return StampFactory.object();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append('a');
        appendString(str);
        return str.toString();
    }

    @Override
    public boolean isCompatible(Stamp other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ObjectStamp) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCompatible(Constant constant) {
        if (constant instanceof JavaConstant) {
            return ((JavaConstant) constant).getJavaKind().isObject();
        }
        return false;
    }

    @Override
    public LIRKind getLIRKind(LIRKindTool tool) {
        return tool.getObjectKind();
    }

    @Override
    public Constant readConstant(MemoryAccessProvider provider, Constant base, long displacement) {
        try {
            return provider.readObjectConstant(base, displacement);
        } catch (IllegalArgumentException e) {
            /*
             * It's possible that the base and displacement aren't valid together so simply return
             * null.
             */
            return null;
        }
    }
}
