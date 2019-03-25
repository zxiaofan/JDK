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

public final class Class_isInstance06 extends JTTTest {

    private static class TestClass implements Cloneable {
    }

    static final String string = "";
    static final Object obj = new Object();
    static final String[] sarray = {};
    static final Object thisObject = new TestClass();

    public static boolean test(int i) {
        Object object = null;
        if (i == 0) {
            object = obj;
        }
        if (i == 1) {
            object = string;
        }
        if (i == 2) {
            object = sarray;
        }
        if (i == 3) {
            object = thisObject;
        }
        return Cloneable.class.isInstance(object);
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

}
