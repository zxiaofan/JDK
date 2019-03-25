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

import java.util.concurrent.ConcurrentSkipListMap;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Benchmarks cost of ArrayList.
 */
public class ConcurrentSkipListBenchmark extends BenchmarkBase {

    private static final int N = 100;

    @State(Scope.Benchmark)
    public static class ThreadState {
        ConcurrentSkipListMap<Integer, Integer> list = new ConcurrentSkipListMap<>();
    }

    @Benchmark
    @Warmup(iterations = 20)
    public void addBoxed(ThreadState state) {
        for (int i = 0; i < N; ++i) {
            state.list.put(i, i);
        }
    }
}
