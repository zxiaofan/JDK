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

public class Object_toString01 extends JTTTest {

    private static class TestClass {
        @Override
        public String toString() {
            return string;
        }
    }

    static final String string = "Object_toString01";
    static final Object object = new Object();

    public static boolean test(int i) {
        if (i == 0) {
            return object.toString() != null;
        }
        if (i == 1) {
            return new TestClass().toString() == string;
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

}
