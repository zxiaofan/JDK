/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.microbenchmarks.lir.trace;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Warmup;

import org.graalvm.compiler.core.common.alloc.BiDirectionalTraceBuilder;
import org.graalvm.compiler.core.common.alloc.TraceBuilderResult;
import org.graalvm.compiler.core.common.alloc.UniDirectionalTraceBuilder;
import org.graalvm.compiler.lir.alloc.trace.TraceBuilderPhase;
import org.graalvm.compiler.microbenchmarks.graal.GraalBenchmark;

@Warmup(iterations = 15)
public class TraceBuilderBenchmark extends GraalBenchmark {

    public static class State extends ControlFlowGraphState {
        @MethodDescString @Param({
                        "java.lang.String#equals",
                        "java.util.HashMap#computeIfAbsent"
        }) public String method;
    }

    @Benchmark
    public TraceBuilderResult uniDirectionalTraceBuilder(State s) {
        return UniDirectionalTraceBuilder.computeTraces(s.getLIR().getDebug(), s.cfg.getStartBlock(), s.cfg.getBlocks(), TraceBuilderPhase.getTrivialTracePredicate(s.getLIR()));
    }

    @Benchmark
    public TraceBuilderResult biDirectionalTraceBuilder(State s) {
        return BiDirectionalTraceBuilder.computeTraces(s.getLIR().getDebug(), s.cfg.getStartBlock(), s.cfg.getBlocks(), TraceBuilderPhase.getTrivialTracePredicate(s.getLIR()));
    }

}
