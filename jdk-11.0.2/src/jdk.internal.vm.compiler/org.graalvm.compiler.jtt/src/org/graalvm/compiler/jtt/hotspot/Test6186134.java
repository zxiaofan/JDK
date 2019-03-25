/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.hotspot;

import java.util.ArrayList;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

// @formatter:off
public class Test6186134 extends JTTTest {

    @SuppressWarnings("serial")
    public static final class MyArrayList<E> extends ArrayList<E> {

    }

    public static class TestClass {

        int num = 0;

        public TestClass(int n) {
            num = n;
        }

        public boolean more() {
            return num-- > 0;
        }

        public MyArrayList<?> test1() {
            MyArrayList<Object> res = new MyArrayList<>();
            int maxResults = Integer.MAX_VALUE;
            int n = 0;
            boolean more = more();
            while ((n++ < maxResults) && more) {
                res.add(new Object());
                more = more();
            }
            return res;
        }

    }

    public static int test(int n) {
        for (int i = 0; i < n; i++) {
            TestClass t = new TestClass(10);
            int size = t.test1().size();
            if (size != 10) {
                return 97;
            }
        }
        return 0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 100);
    }

}
