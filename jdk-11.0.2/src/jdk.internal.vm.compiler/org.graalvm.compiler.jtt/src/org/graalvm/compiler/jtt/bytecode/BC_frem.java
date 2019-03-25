/*
 * Copyright (c) 2007, 2016, Oracle and/or its affiliates. All rights reserved.
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



package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

public class BC_frem extends BC_float_base {

    public static float test(float a, float b) {
        return a % b;
    }

    @Test
    public void frem() {
        runTest("test", x, y);
    }
}
