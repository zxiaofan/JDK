/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org.graalvm.compiler.jtt.JTTTest;

@RunWith(Parameterized.class)
public class Math_round extends JTTTest {

    @Parameter(value = 0) public double input;

    public static double rint(double arg) {
        return Math.rint(arg);
    }

    @Test
    public void runRint() throws Throwable {
        runTest("rint", input);
    }

    public static double floor(double arg) {
        return Math.floor(arg);
    }

    @Test
    public void runFloor() throws Throwable {
        runTest("floor", input);
    }

    public static double ceil(double arg) {
        return Math.ceil(arg);
    }

    @Test
    public void runCeil() throws Throwable {
        runTest("ceil", input);
    }

    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        ArrayList<Object[]> tests = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            addTest(tests, i);
            addTest(tests, i + 0.2);
            addTest(tests, i + 0.5);
            addTest(tests, i + 0.7);
        }
        addTest(tests, -0.0);
        addTest(tests, Double.NaN);
        addTest(tests, Double.NEGATIVE_INFINITY);
        addTest(tests, Double.POSITIVE_INFINITY);
        return tests;
    }

    private static void addTest(ArrayList<Object[]> tests, double input) {
        tests.add(new Object[]{input});
    }
}
