/*
 * Copyright (c) 2010, 2012, Oracle and/or its affiliates. All rights reserved.
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
public class Double_01 extends JTTTest {

    public static boolean test() {
        return Double.doubleToLongBits(Double.longBitsToDouble(0x7ff8000000000088L)) == 0x7ff8000000000000L;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
