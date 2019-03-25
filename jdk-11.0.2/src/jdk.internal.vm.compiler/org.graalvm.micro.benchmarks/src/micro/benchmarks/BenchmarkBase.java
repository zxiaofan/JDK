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


package micro.benchmarks;

import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Base class for JMH benchmarks.
 */
@Warmup(iterations = BenchmarkBase.Defaults.WARMUP_ITERATIONS)
@Measurement(iterations = BenchmarkBase.Defaults.MEASUREMENT_ITERATIONS)
@Fork(BenchmarkBase.Defaults.FORKS)
public class BenchmarkBase {

    public static class Defaults {
        public static final int MEASUREMENT_ITERATIONS = 5;
        public static final int WARMUP_ITERATIONS = 5;
        public static final int FORKS = 1;
    }
}
