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


package org.graalvm.compiler.jtt.hotpath;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Runs: 10 = 55; 20 = 210; 30 = 465; 40 = 820;
 */
public class HP_field02 extends JTTTest {

    private static class TestClass {
        public int a;
        public int b;
        public int c;

        public int run(int count) {
            for (int i = 0; i <= count; i++) {
                if (i > 5) {
                    a += i;
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
