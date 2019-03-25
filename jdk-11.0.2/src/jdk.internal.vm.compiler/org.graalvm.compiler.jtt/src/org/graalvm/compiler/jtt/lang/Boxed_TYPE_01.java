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
public class Boxed_TYPE_01 extends JTTTest {

    public static String test(int i) {
        if (i == 0) {
            return Boolean.TYPE.getName();
        }
        if (i == 1) {
            return Byte.TYPE.getName();
        }
        if (i == 2) {
            return Character.TYPE.getName();
        }
        if (i == 3) {
            return Double.TYPE.getName();
        }
        if (i == 4) {
            return Float.TYPE.getName();
        }
        if (i == 5) {
            return Integer.TYPE.getName();
        }
        if (i == 6) {
            return Long.TYPE.getName();
        }
        if (i == 7) {
            return Short.TYPE.getName();
        }
        if (i == 8) {
            return Void.TYPE.getName();
        }
        return null;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 5);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 6);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 7);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", 8);
    }

}
