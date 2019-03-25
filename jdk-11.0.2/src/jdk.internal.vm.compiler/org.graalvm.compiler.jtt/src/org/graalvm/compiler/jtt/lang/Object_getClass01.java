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

public final class Object_getClass01 extends JTTTest {

    static final Object object = new Object();
    static final Object string = new String();
    static final DummyTestClass thisObject = new DummyTestClass();

    public static String test(int i) {
        if (i == 0) {
            return object.getClass().toString();
        }
        if (i == 1) {
            return string.getClass().toString();
        }
        if (i == 2) {
            return thisObject.getClass().toString();
        }
        if (i == 3) {
            return thisObject.getClass().getClass().toString();
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

}
