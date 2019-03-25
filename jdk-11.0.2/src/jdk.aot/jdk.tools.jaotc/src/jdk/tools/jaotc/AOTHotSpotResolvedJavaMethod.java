/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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
import jdk.vm.ci.hotspot.HotSpotCompiledCode;
import jdk.vm.ci.hotspot.HotSpotResolvedJavaMethod;

final class AOTHotSpotResolvedJavaMethod implements JavaMethodInfo {

    private final HotSpotResolvedJavaMethod method;
    private final Backend backend;

    AOTHotSpotResolvedJavaMethod(HotSpotResolvedJavaMethod method, Backend backend) {
        this.method = method;
        this.backend = backend;
    }

    public String getSymbolName() {
        return JavaMethodInfo.uniqueMethodName(method);
    }

    public String getNameAndSignature() {
        String className = method.getDeclaringClass().getName();
        return className + "." + method.getName() + method.getSignature().toMethodDescriptor();
    }

    public HotSpotCompiledCode compiledCode(CompilationResult result) {
        return HotSpotCompiledCodeBuilder.createCompiledCode(backend.getCodeCache(), method, null, result);
    }

}
