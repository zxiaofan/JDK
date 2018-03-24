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
import org.graalvm.compiler.hotspot.stubs.Stub;

import jdk.vm.ci.hotspot.HotSpotCompiledCode;

final class AOTStub implements JavaMethodInfo {

    private final Stub stub;
    private final Backend backend;

    AOTStub(Stub stub, Backend backend) {
        this.stub = stub;
        this.backend = backend;
    }

    public String getSymbolName() {
        return stub.toString();
    }

    public String getNameAndSignature() {
        return stub.toString();
    }

    public HotSpotCompiledCode compiledCode(CompilationResult result) {
        return HotSpotCompiledCodeBuilder.createCompiledCode(backend.getCodeCache(), null, null, result);
    }

}
