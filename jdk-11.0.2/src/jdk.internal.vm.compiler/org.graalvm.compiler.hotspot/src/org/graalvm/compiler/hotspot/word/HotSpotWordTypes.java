/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.word;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.hotspot.nodes.type.KlassPointerStamp;
import org.graalvm.compiler.hotspot.nodes.type.MethodCountersPointerStamp;
import org.graalvm.compiler.hotspot.nodes.type.MethodPointerStamp;
import org.graalvm.compiler.word.WordTypes;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.JavaType;
import jdk.vm.ci.meta.MetaAccessProvider;
import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * Extends {@link WordTypes} with information about HotSpot metaspace pointer types.
 */
public class HotSpotWordTypes extends WordTypes {

    /**
     * Resolved type for {@link MetaspacePointer}.
     */
    private final ResolvedJavaType metaspacePointerType;

    /**
     * Resolved type for {@link KlassPointer}.
     */
    private final ResolvedJavaType klassPointerType;

    /**
     * Resolved type for {@link MethodPointer}.
     */
    private final ResolvedJavaType methodPointerType;

    /**
     * Resolved type for {@link MethodCountersPointer}.
     */
    private final ResolvedJavaType methodCountersPointerType;

    public HotSpotWordTypes(MetaAccessProvider metaAccess, JavaKind wordKind) {
        super(metaAccess, wordKind);
        this.metaspacePointerType = metaAccess.lookupJavaType(MetaspacePointer.class);
        this.klassPointerType = metaAccess.lookupJavaType(KlassPointer.class);
        this.methodPointerType = metaAccess.lookupJavaType(MethodPointer.class);
        this.methodCountersPointerType = metaAccess.lookupJavaType(MethodCountersPointer.class);
    }

    @Override
    public boolean isWord(JavaType type) {
        if (type instanceof ResolvedJavaType && metaspacePointerType.isAssignableFrom((ResolvedJavaType) type)) {
            return true;
        }
        return super.isWord(type);
    }

    @Override
    public JavaKind asKind(JavaType type) {
        if (klassPointerType.equals(type) || methodPointerType.equals(type)) {
            return getWordKind();
        }
        return super.asKind(type);
    }

    @Override
    public Stamp getWordStamp(ResolvedJavaType type) {
        if (type.equals(klassPointerType)) {
            return KlassPointerStamp.klass();
        } else if (type.equals(methodPointerType)) {
            return MethodPointerStamp.method();
        } else if (type.equals(methodCountersPointerType)) {
            return MethodCountersPointerStamp.methodCounters();
        }
        return super.getWordStamp(type);
    }
}
