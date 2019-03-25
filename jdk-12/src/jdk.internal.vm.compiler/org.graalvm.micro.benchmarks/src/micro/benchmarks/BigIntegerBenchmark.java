/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.math.BigInteger;
import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/*
 * Benchmarks cost of BigInteger intrinsics:
 *
 *      montgomeryMultiply, montgomerySquare, mulAdd, multiplyToLen, squareToLen
 */
public class BigIntegerBenchmark extends BenchmarkBase {

    @State(Scope.Benchmark)
    public static class ThreadState {
        BigInteger[] data = randomBigInteger(100);
        BigInteger[] result = new BigInteger[100];

        static BigInteger[] randomBigInteger(int len) {
            BigInteger[] data = new BigInteger[len];
            Random r = new Random(17);
            for (int i = 0; i < data.length; i++) {
                data[i] = new BigInteger(r.nextInt(16384) + 512, r);
            }
            return data;
        }
    }

    @Benchmark
    @Warmup(iterations = 5)
    public void bigIntMul(ThreadState state) {
        BigInteger[] data = state.data;
        for (int i = 1; i < data.length; i++) {
            BigInteger[] result = state.result;
            result[i] = data[i - 1].multiply(data[i]);
        }
    }

    @Benchmark
    @Warmup(iterations = 5)
    public void bigIntMulAdd(ThreadState state) {
        BigInteger[] data = state.data;
        for (int i = 0; i < data.length; i++) {
            BigInteger[] result = state.result;
            // Using BigInteger.square() when length is suitable.
            // Using BigInteger.mulAdd() when length is suitable.
            result[i] = data[i].multiply(data[i]);
        }
    }

    @Benchmark
    @Warmup(iterations = 5)
    public void bigIntMontgomeryMul(ThreadState state) {
        BigInteger[] data = state.data;
        BigInteger exp = BigInteger.valueOf(2);

        for (int i = 0; i < data.length; i++) {
            BigInteger[] result = state.result;
            int rsh = data[i].bitLength() / 2 + 3;
            // The "odd" path.
            // Using BigInteger.montgomeryMultiply().
            // Using BigInteger.montgomerySquare().
            // Using BigInteger.mulAdd() when length is suitable.
            result[i] = data[i].modPow(exp, data[i].shiftRight(rsh).setBit(0));
        }
    }

    @Benchmark
    @Warmup(iterations = 5)
    public void bigIntMontgomerySqr(ThreadState state) {
        BigInteger[] data = state.data;
        BigInteger exp = BigInteger.valueOf(2);

        for (int i = 0; i < data.length; i++) {
            BigInteger[] result = state.result;
            int rsh = data[i].bitLength() / 2 + 3;
            // The "even" path.
            // Using BigInteger.montgomeryMultiply().
            // Using BigInteger.montgomerySquare().
            // Using BigInteger.mulAdd() when length is suitable.
            result[i] = data[i].modPow(exp, data[i].shiftRight(rsh).clearBit(0));
        }
    }
}
