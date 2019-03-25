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
public class HP_nest02 extends JTTTest {

    public static int test(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += i;
            sum = foo(count, sum);
            sum = foo(count, sum);
        }
        return sum;
    }

    private static int foo(int count, int s) {
        int sum = s;
        for (int j = 0; j < count; j++) {
            sum += j;
        }
        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 15);
    }

}
