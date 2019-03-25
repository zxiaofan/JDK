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
 * Tests exiting 2 loops at the same time with escape-analysed values flowing out of loops
 */
public class Loop16 extends JTTTest {

    private static class TestClass {
        public int a;
        public int b;
        public int c;

        public int run(int count) {
            l1: for (int i = 0; i <= count; i++) {
                if (i > 5) {
                    for (int j = 0; j < i; j++) {
                        a += i;
                        if (a > 500) {
                            break l1;
                        }
                    }
                } else if (i > 7) {
                    b += i;
                } else {
                    c += i;
                }
            }
            return a + b + c;
        }
    }

    public static int test(int count) {
        return new TestClass().run(count);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 40);
    }
}
