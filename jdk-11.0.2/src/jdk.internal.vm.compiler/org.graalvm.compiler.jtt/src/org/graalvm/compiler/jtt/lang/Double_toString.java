/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public final class Double_toString extends JTTTest {

    public static String test() {
        double z1 = 0.4363485526704198;
        double z2 = -0.43536514763046896;
        double z3 = z1 + z2;
        return Double.toString(z3);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
