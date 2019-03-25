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
 */
public class HP_field04 extends JTTTest {

    private static class TestClass {
        public byte b;
        public char c;
        public short s;
        public int i;
        public long l;
        public float f;
        public double d;

        public int run(int count) {
            for (int x = 0; x <= count; x++) {
                b += x;
                c += x;
                s += x;
                i += x;
                l += x;
                f += x;
                d += x;
            }
            return (int) (b + c + s + i + l + f + d);
        }
    }

    public static int test(int count) {
        return new TestClass().run(count);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 40);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1000);
    }

}
