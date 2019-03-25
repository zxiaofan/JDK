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

import jdk.vm.ci.hotspot.HotSpotCompiledCode;
import jdk.vm.ci.meta.ResolvedJavaMethod;

interface JavaMethodInfo {

    /**
     * @return unique symbol name for this method.
     */
    String getSymbolName();

    /**
     * Name a java method with J.L.S. class name and signature.
     *
     * @return unique name for this method including class and signature
     */
    String getNameAndSignature();

    HotSpotCompiledCode compiledCode(CompilationResult result);

    /**
     * Name a java method with class and signature to make it unique.
     *
     * @param method to generate unique identifier for
     * @return Unique name for this method including class and signature
     **/
    static String uniqueMethodName(ResolvedJavaMethod method) {
        String className = method.getDeclaringClass().toClassName();
        String name = className + "." + method.getName() + method.getSignature().toMethodDescriptor();
        return name;
    }

}
