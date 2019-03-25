/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.microbenchmarks.graal;

import static org.graalvm.compiler.microbenchmarks.graal.GraalBenchmark.Defaults.FORKS;
import static org.graalvm.compiler.microbenchmarks.graal.GraalBenchmark.Defaults.MEASUREMENT_ITERATIONS;
import static org.graalvm.compiler.microbenchmarks.graal.GraalBenchmark.Defaults.WARMUP_ITERATIONS;

import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

/**
 * All classes defining Graal benchmarks must subclass this class as it defines the default value
 * for each benchmark option. Individual options can be overridden in the subclasses or by an
 * individual benchmark.
 */
@Warmup(iterations = WARMUP_ITERATIONS)
@Measurement(iterations = MEASUREMENT_ITERATIONS)
@Fork(FORKS)
public class GraalBenchmark {

    public static class Defaults {
        public static final int MEASUREMENT_ITERATIONS = 5;
        public static final int WARMUP_ITERATIONS = 5;
        public static final int FORKS = 1;
    }
}
