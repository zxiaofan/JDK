/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.util;

import org.graalvm.compiler.phases.LazyName;

import jdk.vm.ci.meta.JavaMethod;

/**
 * Lazily computed debug value name composed of a prefix and a {@linkplain JavaMethod#getName()
 * method name}.
 */
public class MethodDebugValueName extends LazyName {
    final String prefix;
    final JavaMethod method;

    public MethodDebugValueName(String prefix, JavaMethod method) {
        this.prefix = prefix;
        this.method = method;
    }

    @Override
    public String createString() {
        return prefix + "[" + method.getName() + "]";
    }
}
