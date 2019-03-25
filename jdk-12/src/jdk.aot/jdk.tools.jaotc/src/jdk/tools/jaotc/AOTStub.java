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
import org.graalvm.compiler.hotspot.stubs.Stub;
import org.graalvm.compiler.options.OptionValues;

import jdk.vm.ci.hotspot.HotSpotCompiledCode;

final class AOTStub implements JavaMethodInfo {

    private final Stub stub;
    private final Backend backend;
    private OptionValues options;

    AOTStub(Stub stub, Backend backend, OptionValues options) {
        this.stub = stub;
        this.backend = backend;
        this.options = options;
    }

    @Override
    public String getSymbolName() {
        return stub.toString();
    }

    @Override
    public String getNameAndSignature() {
        return stub.toString();
    }

    @Override
    public HotSpotCompiledCode compiledCode(CompilationResult result) {
        return HotSpotCompiledCodeBuilder.createCompiledCode(backend.getCodeCache(), null, null, result, options);
    }

}
