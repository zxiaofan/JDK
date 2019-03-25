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

import org.graalvm.compiler.options.OptionValues;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/*
 */
public class Math_abs extends UnaryMath {

    @SuppressWarnings("serial")
    public static class NaN extends Throwable {
    }

    public static double test(double arg) throws NaN {
        double v = Math.abs(arg);
        if (Double.isNaN(v)) {
            // NaN can't be tested against itself
            throw new NaN();
        }
        return v;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 5.0d);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -5.0d);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0.0d);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", -0.0d);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", java.lang.Double.NEGATIVE_INFINITY);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", java.lang.Double.POSITIVE_INFINITY);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", java.lang.Double.NaN);
    }

    @Test
    public void run7() {
        OptionValues options = getInitialOptions();
        ResolvedJavaMethod method = getResolvedJavaMethod("test");
        testManyValues(options, method);
    }
}
