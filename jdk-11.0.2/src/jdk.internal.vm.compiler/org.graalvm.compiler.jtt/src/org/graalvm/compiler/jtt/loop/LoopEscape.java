/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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
// Checkstyle: stop


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Test around an object that escapes directly from inside a loop (no virtual phi on the loop)
 */
public class LoopEscape extends JTTTest {

    public static L ll = new L(0, 1, 2);

    private static class L {

        public int a;
        public int b;
        public int c;

        public L(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static int test0(int count) {
        L l = new L(5, 5, 5);
        for (int i = 0; i < count; i++) {
            l.a++;
            l.b--;
            l.c = 4;
        }

        return l.a + l.b * 10 + l.c * 100;
    }

    public static int test1(int count) {
        L l = new L(5, 5, 5);
        for (int i = 0; i < count; i++) {
            if (l.a % 2 == 0) {
                l.a++;
                l.b--;
                l.c = 4;
            } else {
                l.a++;
            }
        }

        return l.a + l.b * 10 + l.c * 100;
    }

    @Test
    public void run10() throws Throwable {
        runTest("test1", 0);
    }

    @Test
    public void run11() throws Throwable {
        runTest("test1", 1);
    }

    @Test
    public void run12() throws Throwable {
        runTest("test1", 2);
    }

    @Test
    public void run00() throws Throwable {
        runTest("test0", 0);
    }

    @Test
    public void run01() throws Throwable {
        runTest("test0", 1);
    }

    @Test
    public void run02() throws Throwable {
        runTest("test0", 2);
    }

    @Test
    public void run05() throws Throwable {
        runTest("test0", 5);
    }
}
