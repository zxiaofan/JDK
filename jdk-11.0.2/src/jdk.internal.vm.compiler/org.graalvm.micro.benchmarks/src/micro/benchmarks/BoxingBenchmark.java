/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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


package micro.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Benchmarks cost of ArrayList.
 */
public class BoxingBenchmark extends BenchmarkBase {

    @State(Scope.Benchmark)
    public static class ThreadState {
        int value = 42;
    }

    @Benchmark
    @Warmup(iterations = 20)
    public Integer addBoxed(ThreadState state) {
        return Integer.valueOf(state.value);
    }

    @SuppressWarnings("unused")
    @Benchmark
    @Warmup(iterations = 20)
    public int doNothing(ThreadState state) {
        return 42;
    }
}
