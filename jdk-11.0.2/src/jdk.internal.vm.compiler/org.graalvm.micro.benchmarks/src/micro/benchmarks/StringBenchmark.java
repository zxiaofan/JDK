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

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Benchmarks cost of {@link String#indexOf(int)} and {@link String#indexOf(String)}.
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringBenchmark extends BenchmarkBase {

    @State(Scope.Benchmark)
    public static class BenchState {
        char ch1 = 'Q';
        char ch2 = 'X';
        String s1 = "Qu";
        String s2 = "ne";

        // Checkstyle: stop
        String lorem = "Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String loremLastChar = "Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum?";
        // Checkstyle: resume
    }

    @Benchmark
    @Warmup(iterations = 5)
    public int indexOfChar(BenchState state) {
        return state.lorem.indexOf(state.ch1);
    }

    @Benchmark
    @Warmup(iterations = 5)
    public int indexOfCharNotFound(BenchState state) {
        return state.lorem.indexOf(state.ch2);
    }

    @Benchmark
    @Warmup(iterations = 5)
    public int indexOfString(BenchState state) {
        return state.lorem.indexOf(state.s1);
    }

    @Benchmark
    @Warmup(iterations = 5)
    public int indexOfStringNotFound(BenchState state) {
        return state.lorem.indexOf(state.s2);
    }

    @Benchmark
    @Warmup(iterations = 5)
    public int compareTo(BenchState state) {
        return state.lorem.compareTo(state.loremLastChar);
    }
}
