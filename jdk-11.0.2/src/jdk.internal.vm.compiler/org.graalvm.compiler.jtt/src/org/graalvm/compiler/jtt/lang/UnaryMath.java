/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.lang;

import org.graalvm.compiler.jtt.JTTTest;
import org.graalvm.compiler.options.OptionValues;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public abstract class UnaryMath extends JTTTest {

    private static final long STEP = Long.MAX_VALUE / 1_000_000;

    /**
     * Tests a unary {@link Math} method on a wide range of values.
     */
    void testManyValues(OptionValues options, ResolvedJavaMethod method) throws AssertionError {
        if (!Java8OrEarlier) {
            /*
             * GR-8276: Allow for variance on JVMCI > 8 until a JVMCI version that includes
             * https://github.com/graalvm/graal-jvmci-8/commit/
             * c86fb66f86b8d52a08dd2495d34879d3730f9987 or Graal has stubs that a monotonic with
             * other HotSpot implementations of these Math routines.
             */
            ulpDelta = 2D;
        } else {
            /*
             * Forces the assertion message shows the ulps by which a computed result is wrong.
             */
            ulpDelta = 0D;
        }
        Object receiver = null;
        long testIteration = 0;
        for (long l = Long.MIN_VALUE;; l += STEP) {
            double d = Double.longBitsToDouble(l);
            Result expect = executeExpected(method, receiver, d);
            try {
                testAgainstExpected(options, method, expect, EMPTY, receiver, d);
                testIteration++;
            } catch (AssertionError e) {
                throw new AssertionError(String.format("%d: While testing %g [long: %d, hex: %x]", testIteration, d, l, l), e);
            }
            if (Long.MAX_VALUE - STEP < l) {
                break;
            }
        }
    }
}
