/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Check for incorrect elimination of 0.0 and -0.0 from computations. They can affect the sign of
 * the result of an add or substract.
 */
public class FloatOptimizationTest extends GraalCompilerTest {

    @Test
    public void test1() {
        test("test1Snippet", -0.0);
    }

    @SuppressWarnings("all")
    public static double test1Snippet(double x) {
        return x + 0.0;
    }

    @Test
    public void test2() {
        test("test2Snippet", -0.0f);
    }

    @SuppressWarnings("all")
    public static double test2Snippet(float x) {
        return x + 0.0f;
    }

    @Test
    public void test3() {
        test("test3Snippet", -0.0);
    }

    @SuppressWarnings("all")
    public static double test3Snippet(double x) {
        return x - -0.0;
    }

    @Test
    public void test4() {
        test("test4Snippet", -0.0f);
    }

    @SuppressWarnings("all")
    public static double test4Snippet(float x) {
        return x - -0.0f;
    }

    @Override
    protected void assertDeepEquals(String message, Object expected, Object actual, double delta) {
        if (expected instanceof Double && actual instanceof Double) {
            double e = (double) expected;
            double a = (double) actual;
            if (Double.doubleToRawLongBits(a) != Double.doubleToRawLongBits(e)) {
                Assert.fail((message == null ? "" : message) + "raw double bits not equal " + Double.doubleToRawLongBits(a) + " != " + Double.doubleToRawLongBits(e));
            }
        } else {
            super.assertDeepEquals(message, expected, actual, delta);
        }
    }
}
