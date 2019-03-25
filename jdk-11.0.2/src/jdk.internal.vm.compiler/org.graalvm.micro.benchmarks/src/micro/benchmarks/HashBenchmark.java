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
 * Benchmarks cost of hashing a character array.
 */
public class HashBenchmark extends BenchmarkBase {

    @State(Scope.Benchmark)
    public static class ThreadState {
        char[] characters = ("Hello world from the HashBenchmark!").toCharArray();
    }

    @Benchmark
    @Warmup(iterations = 20)
    public int hash(ThreadState state) {
        int value = 0;
        char[] array = state.characters;
        for (int i = 0; i < array.length; ++i) {
            value = value * 31 + array[i];
        }
        return value;
    }
}
