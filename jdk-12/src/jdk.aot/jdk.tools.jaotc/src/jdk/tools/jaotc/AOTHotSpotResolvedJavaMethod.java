/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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



package jdk.tools.jaotc;

import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.core.target.Backend;
import org.graalvm.compiler.hotspot.HotSpotCompiledCodeBuilder;
import org.graalvm.compiler.options.OptionValues;

import jdk.vm.ci.hotspot.HotSpotCompiledCode;
import jdk.vm.ci.hotspot.HotSpotResolvedJavaMethod;

final class AOTHotSpotResolvedJavaMethod implements JavaMethodInfo {

    private final HotSpotResolvedJavaMethod method;
    private final Backend backend;
    private final OptionValues options;

    AOTHotSpotResolvedJavaMethod(HotSpotResolvedJavaMethod method, Backend backend, OptionValues options) {
        this.method = method;
        this.backend = backend;
        this.options = options;
    }

    @Override
    public String getSymbolName() {
        return JavaMethodInfo.uniqueMethodName(method);
    }

    @Override
    public String getNameAndSignature() {
        String className = method.getDeclaringClass().getName();
        return className + "." + method.getName() + method.getSignature().toMethodDescriptor();
    }

    @Override
    public HotSpotCompiledCode compiledCode(CompilationResult result) {
        return HotSpotCompiledCodeBuilder.createCompiledCode(backend.getCodeCache(), method, null, result, options);
    }

}
