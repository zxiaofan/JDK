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


package org.graalvm.compiler.jtt.hotpath;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class HP_array01 extends JTTTest {

    public static int[] array = new int[40];

    public static int test(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            array[i] = i;
            sum += array[i];
        }
        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 40);
    }

}
