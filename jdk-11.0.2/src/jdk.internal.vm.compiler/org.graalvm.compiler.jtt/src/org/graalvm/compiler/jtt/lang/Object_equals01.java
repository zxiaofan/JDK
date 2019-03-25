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
/*
 */


package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Object_equals01 extends JTTTest {

    public static DummyTestClass field = new DummyTestClass();

    public static boolean test(int i) {
        final Object obj1 = new Object();
        final Object obj2 = new Object();
        switch (i) {
            case 0:
                return obj1.equals(field);
            case 1:
                return obj1.equals(obj2);
            case 2:
                return obj1.equals(null);
            case 3:
                return obj1.equals(obj1);
            case 4:
                return field.equals(field);
            case 5:
                return obj2.equals(field);
            case 6:
                return obj2.equals(obj2);
            case 7:
                return obj2.equals(null);
            case 8:
                return obj2.equals(obj1);
        }
        return false;
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
