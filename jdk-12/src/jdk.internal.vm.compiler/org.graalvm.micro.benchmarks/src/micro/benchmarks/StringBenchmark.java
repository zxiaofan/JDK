/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
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
        String ch1string = "Q";
        char ch2 = 'X';
        String s1 = "Qu";
        String s2 = "ne";

        String longString;

        public BenchState() {
            String str = "ab";
            for (int i = 0; i < 15; i++) {
                str = str + str;
            }
            longString = str + "xx";
        }

        // Checkstyle: stop
        String lorem = "Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String loremLastChar = "Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum?";
        // Checkstyle: resume

        String smallLorem = lorem.substring(0, 13);
        String largeLorem = lorem.concat(lorem);

        char[] smallCharArray = lorem.substring(0, 13).toCharArray();
        char[] largeCharArray = lorem.concat(lorem).toCharArray();
    }

    @Benchmark
    @Warmup(iterations = 5)
    public int indexOfChar(BenchState state) {
        return state.lorem.indexOf(state.ch1);
    }

    @Benchmark
    @Warmup(iterations = 5)
    public int indexOfSingleCharString(BenchState state) {
        return state.lorem.indexOf(state.ch1string);
    }

    @Benchmark
    @Warmup(iterations = 5)
    public int indexOfSingleCharStringLong(BenchState state) {
        return state.longString.indexOf('x');
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

    @Benchmark
    @Warmup(iterations = 5)
    public String compressSmallString(BenchState state) {
        return new String(state.smallCharArray);
    }

    @Benchmark
    @Warmup(iterations = 5)
    public String compressLargeString(BenchState state) {
        return new String(state.largeCharArray);
    }

    @Benchmark
    @Warmup(iterations = 5)
    public char[] inflateSmallString(BenchState state) {
        return state.smallLorem.toCharArray();
    }

    @Benchmark
    @Warmup(iterations = 5)
    public char[] inflateLargeString(BenchState state) {
        return state.largeLorem.toCharArray();
    }
}
