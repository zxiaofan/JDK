/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.microbenchmarks.lir;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.microbenchmarks.graal.GraalBenchmark;
import org.graalvm.compiler.nodes.StructuredGraph;

public class CompileTimeBenchmark extends GraalBenchmark {

    public static class CompileState extends GraalCompilerState.Compile {
        @MethodDescString @Param({
                        "java.lang.String#equals",
                        "java.util.HashMap#computeIfAbsent"
        }) public String method;
    }

    @Benchmark
    public CompilationResult compile(CompileState s) {
        return s.compile();
    }

    public static class FrontEndState extends GraalCompilerState.FrontEndOnly {
        @MethodDescString @Param({
                        "java.lang.String#equals",
                        "java.util.HashMap#computeIfAbsent"
        }) public String method;
    }

    @Benchmark
    public StructuredGraph frontend(FrontEndState s) {
        return s.compile();
    }

    public static class BackEndEndState extends GraalCompilerState.BackEndOnly {
        @MethodDescString @Param({
                        "java.lang.String#equals",
                        "java.util.HashMap#computeIfAbsent"
        }) public String method;
    }

    @Benchmark
    public CompilationResult backend(BackEndEndState s) {
        return s.compile();
    }
}
