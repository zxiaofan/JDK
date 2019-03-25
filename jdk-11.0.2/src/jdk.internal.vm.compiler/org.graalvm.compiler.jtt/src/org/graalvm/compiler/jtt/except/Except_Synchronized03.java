/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Except_Synchronized03 extends JTTTest {

    private static class TestClass {
        int x = 1;

        @SuppressWarnings("all")
        public synchronized int test2(int i) throws Exception {
            while (true) {
                try {
                    synchronized (this) {
                        TestClass object = null;
                        return object.x;
                    }
                } catch (NullPointerException e) {
                    return 2;
                }
            }
        }
    }

    static final TestClass object = new TestClass();

    public static int test(int i) throws Exception {
        if (i == 0) {
            return 0;
        }
        return object.test2(i);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

}
