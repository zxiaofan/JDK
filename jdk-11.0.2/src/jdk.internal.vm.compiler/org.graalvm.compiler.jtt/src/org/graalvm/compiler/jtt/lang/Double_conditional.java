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
/*
 */


package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.bytecode.BC_double_base;

public final class Double_conditional extends BC_double_base {

    public static double test(double x, double y) {
        if (x == y) {
            return y;
        }
        return x;
    }

    public static double conditional(double x, double y) {
        return x == y ? x : y;
    }

    @Test
    public void runEquals() throws Throwable {
        runTest("test", x, y);
    }

    @Test
    public void runConditional() throws Throwable {
        runTest("conditional", x, y);
    }
}
