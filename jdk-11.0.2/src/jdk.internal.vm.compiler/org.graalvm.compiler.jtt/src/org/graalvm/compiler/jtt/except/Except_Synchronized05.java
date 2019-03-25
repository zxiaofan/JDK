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
/*
 */


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class Except_Synchronized05 extends JTTTest {

    static class Foo {

        Object field;

        public synchronized Object bar(int arg) {
            try {
                String f = foo1(arg);
                if (f == null) {
                    field = new Object();
                }
            } catch (NullPointerException e) {
                // do nothing
            }
            return field;
        }

        public Object baz(int arg) {
            synchronized (this) {
                try {
                    String f = foo1(arg);
                    if (f == null) {
                        field = new Object();
                    }
                } catch (NullPointerException e) {
                    // do nothing
                }
                return field;
            }
        }

        @SuppressWarnings("static-method")
        private String foo1(int arg) {
            if (arg == 0) {
                throw null;
            }
            return null;
        }

    }

    public static int test(int arg) {
        Foo obj = new Foo();
        int a = obj.bar(arg) != null ? 1 : 0;
        int b = obj.baz(arg) != null ? 1 : 0;
        return a + b;
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
