/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.runtime;

import jdk.vm.ci.code.CodeCacheProvider;
import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.code.stack.StackIntrospection;
import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.MetaAccessProvider;

/**
 * A JVMCI backend encapsulates the capabilities needed by a Java based compiler for compiling and
 * installing code for a single compute unit within a JVM. In a JVM with support for heterogeneous
 * computing, more than one backend may be exposed.
 */
public class JVMCIBackend {

    private final MetaAccessProvider metaAccess;
    private final CodeCacheProvider codeCache;
    private final ConstantReflectionProvider constantReflection;
    private final StackIntrospection stackIntrospection;

    public JVMCIBackend(MetaAccessProvider metaAccess, CodeCacheProvider codeCache, ConstantReflectionProvider constantReflection, StackIntrospection stackIntrospection) {
        this.metaAccess = metaAccess;
        this.codeCache = codeCache;
        this.constantReflection = constantReflection;
        this.stackIntrospection = stackIntrospection;
    }

    public MetaAccessProvider getMetaAccess() {
        return metaAccess;
    }

    public CodeCacheProvider getCodeCache() {
        return codeCache;
    }

    public ConstantReflectionProvider getConstantReflection() {
        return constantReflection;
    }

    public TargetDescription getTarget() {
        return codeCache.getTarget();
    }

    public StackIntrospection getStackIntrospection() {
        return stackIntrospection;
    }
}
