/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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
public class String_format02 extends JTTTest {

    public static String test(int val) {
        return String.format("Hello %d", val);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -11);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -2147483648);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 2147483647);
    }

}
