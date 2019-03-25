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


package micro.benchmarks;

import java.util.Arrays;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
public class ArrayDuplicationBenchmark extends BenchmarkBase {

    /** How large should the test-arrays be. */
    private static final int TESTSIZE = 300;

    private Object[][] testObjectArray;

    private Object[] dummy;

    @Setup
    public void setup() {
        testObjectArray = new Object[TESTSIZE][];
        for (int i = 0; i < TESTSIZE; i++) {
            testObjectArray[i] = new Object[20];
        }
    }

    @Setup(Level.Iteration)
    public void iterationSetup() {
        dummy = new Object[TESTSIZE * 3];
    }

    @TearDown(Level.Iteration)
    public void iterationTearDown() {
        dummy = null;
    }

    @Benchmark
    @OperationsPerInvocation(TESTSIZE)
    public Object[] normalArraycopy() {
        int j = 0;
        for (int i = 0; i < TESTSIZE; i++) {
            dummy[j++] = normalArraycopy(testObjectArray[i]);
        }
        return dummy;
    }

    public Object[] normalArraycopy(Object[] cache) {
        Object[] result = new Object[cache.length];
        System.arraycopy(cache, 0, result, 0, result.length);
        return result;
    }

    @Benchmark
    @OperationsPerInvocation(TESTSIZE)
    public Object[] arraysCopyOf() {
        int j = 0;
        for (int i = 0; i < TESTSIZE; i++) {
            dummy[j++] = arraysCopyOf(testObjectArray[i]);
        }
        return dummy;
    }

    public Object[] arraysCopyOf(Object[] cache) {
        return Arrays.copyOf(cache, cache.length);
    }

    @Benchmark
    @OperationsPerInvocation(TESTSIZE)
    public Object[] cloneObjectArray() {
        int j = 0;
        for (int i = 0; i < TESTSIZE; i++) {
            dummy[j++] = arraysClone(testObjectArray[i]);
        }
        return dummy;
    }

    @SuppressWarnings("cast")
    public Object[] arraysClone(Object[] cache) {
        return (Object[]) cache.clone();
    }

}
