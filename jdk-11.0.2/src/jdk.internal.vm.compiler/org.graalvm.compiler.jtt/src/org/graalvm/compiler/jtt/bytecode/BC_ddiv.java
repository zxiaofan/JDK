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

public class BC_ddiv extends BC_double_base {

    public static double test(double a, double b) {
        return a / b;
    }

    @Test
    public void ddiv() {
        runTest("test", x, y);
    }

}
