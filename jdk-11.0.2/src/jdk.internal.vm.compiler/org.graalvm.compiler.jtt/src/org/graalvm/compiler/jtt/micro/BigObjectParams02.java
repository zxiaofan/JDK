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


package org.graalvm.compiler.jtt.micro;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BigObjectParams02 extends JTTTest {

    public static String test(String p0, String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9) {
        return p0 + p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

}
