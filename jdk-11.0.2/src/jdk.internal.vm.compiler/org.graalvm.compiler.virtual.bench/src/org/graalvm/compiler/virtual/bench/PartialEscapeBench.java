/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.virtual.bench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import org.graalvm.compiler.microbenchmarks.graal.GraalBenchmark;

public class PartialEscapeBench extends GraalBenchmark {

    private static class Thing {
        final int id;
        final String name;

        Thing(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @State(Scope.Thread)
    public static class ThingsCache {

        private Thing[] cache = new Thing[100];

        public Thing getOrAdd(Thing input) {
            if (cache[input.id] == null) {
                cache[input.id] = input;
            }
            return cache[input.id];
        }
    }

    @Benchmark
    @Warmup(iterations = 30)
    public String benchPartialEscape(ThingsCache cache) {
        Thing thing = cache.getOrAdd(new Thing(42, "the answer!"));
        return thing.name;
    }
}
