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
public class HP_inline01 extends JTTTest {

    public static int test(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += foo(i);
        }
        return sum;
    }

    public static int foo(int x) {
        if (x < 15) {
            return bar(x);
        }
        return bar(x + 1);
    }

    public static int bar(int x) {
        return x + 1;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 20);
    }

}
