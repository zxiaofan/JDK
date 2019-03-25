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
public class HP_inline02 extends JTTTest {

    public static int test(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += foo(i, sum);
        }
        return sum;
    }

    public static int foo(int x, int y) {
        if (x < 18) {
            return bar(x, x - y);
        }
        return bar(x, x + y);
    }

    public static int bar(int x, int y) {
        if (x < 15) {
            return car(x, x + y);
        }
        return x - 1;
    }

    @SuppressWarnings("unused")
    public static int car(int x, int y) {
        if (x < 13) {
            return x + 1;
        }
        return x - 1;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 20);
    }

}
