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

public final class Class_cast01 extends JTTTest {

    static final String string = "";
    static final Object object = new Object();
    static final DummyTestClass thisObject = new DummyTestClass();

    public static int test(int i) {
        if (i == 0) {
            if (Object.class.cast(string) == null) {
                return -1;
            }
        }
        if (i == 1) {
            if (String.class.cast(object) == null) {
                return -1;
            }
        }
        if (i == 2) {
            if (Object.class.cast(thisObject) == null) {
                return -1;
            }
        }
        if (i == 3) {
            if (DummyTestClass.class.cast(object) == null) {
                return -1;
            }
        }
        return i;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 3);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

}
