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


package org.graalvm.compiler.hotspot.meta;

import static jdk.vm.ci.hotspot.HotSpotJVMCIRuntime.runtime;

import org.graalvm.compiler.api.replacements.SnippetReflectionProvider;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.HotSpotGraalRuntimeProvider;
import org.graalvm.compiler.word.WordTypes;

import jdk.vm.ci.hotspot.HotSpotConstantReflectionProvider;
import jdk.vm.ci.hotspot.HotSpotObjectConstant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaType;

public class HotSpotSnippetReflectionProvider implements SnippetReflectionProvider {

    private final HotSpotGraalRuntimeProvider runtime;
    private final HotSpotConstantReflectionProvider constantReflection;
    private final WordTypes wordTypes;

    public HotSpotSnippetReflectionProvider(HotSpotGraalRuntimeProvider runtime, HotSpotConstantReflectionProvider constantReflection, WordTypes wordTypes) {
        this.runtime = runtime;
        this.constantReflection = constantReflection;
        this.wordTypes = wordTypes;
    }

    @Override
    public JavaConstant forObject(Object object) {
        return constantReflection.forObject(object);
    }

    @Override
    public Object asObject(ResolvedJavaType type, JavaConstant constant) {
        if (constant.isNull()) {
            return null;
        }
        HotSpotObjectConstant hsConstant = (HotSpotObjectConstant) constant;
        return hsConstant.asObject(type);
    }

    @Override
    public <T> T asObject(Class<T> type, JavaConstant constant) {
        if (constant.isNull()) {
            return null;
        }
        HotSpotObjectConstant hsConstant = (HotSpotObjectConstant) constant;
        return hsConstant.asObject(type);
    }

    @Override
    public JavaConstant forBoxed(JavaKind kind, Object value) {
        if (kind == JavaKind.Object) {
            return forObject(value);
        } else {
            return JavaConstant.forBoxedPrimitive(value);
        }
    }

    // Lazily initialized
    private Class<?> wordTypesType;
    private Class<?> runtimeType;
    private Class<?> configType;

    @Override
    public <T> T getInjectedNodeIntrinsicParameter(Class<T> type) {
        // Need to test all fields since there no guarantee under the JMM
        // about the order in which these fields are written.
        GraalHotSpotVMConfig config = runtime.getVMConfig();
        if (configType == null || wordTypesType == null || runtimeType == null) {
            wordTypesType = wordTypes.getClass();
            runtimeType = runtime.getClass();
            configType = config.getClass();
        }

        if (type.isAssignableFrom(wordTypesType)) {
            return type.cast(wordTypes);
        }
        if (type.isAssignableFrom(runtimeType)) {
            return type.cast(runtime);
        }
        if (type.isAssignableFrom(configType)) {
            return type.cast(config);
        }
        return null;
    }

    @Override
    public Class<?> originalClass(ResolvedJavaType type) {
        return runtime().getMirror(type);
    }
}
