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

import org.graalvm.compiler.jtt.bytecode.BC_float_base;

public final class Float_conditional extends BC_float_base {

    public static float test(float x, float y) {
        if (x == y) {
            return y;
        }
        return x;
    }

    public static float conditional(float x, float y) {
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
