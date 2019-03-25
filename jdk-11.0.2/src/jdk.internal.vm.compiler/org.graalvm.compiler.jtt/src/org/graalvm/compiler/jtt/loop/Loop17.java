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
// Checkstyle: stop


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Test around an object that escapes directly from inside a loop (no virtual phi on the loop)
 */
public class Loop17 extends JTTTest {

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

    public static int test(int count) {
        int i = 0;
        L l;
        do {
            l = new L(i, i + 1, i + 2);
        } while (++i < count);

        return l.a + l.b * 10 + l.c * 100;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", new L(4, 4, 4).a);
    }
}
