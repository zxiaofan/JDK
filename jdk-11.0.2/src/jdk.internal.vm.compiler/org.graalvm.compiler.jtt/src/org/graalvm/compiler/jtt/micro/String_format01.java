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
public class String_format01 extends JTTTest {

    public static String test(String s) {
        return String.format("Hello %s", s);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", "World");
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", "New World Order");
    }

}
