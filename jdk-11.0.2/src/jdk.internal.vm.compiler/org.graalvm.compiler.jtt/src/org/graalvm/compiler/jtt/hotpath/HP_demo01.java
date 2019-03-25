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
public class HP_demo01 extends JTTTest {

    public static int test(int count) {
        int sum = 0;

        for (int i = 0; i < count; i++) {
            int[] ia = new int[count];
            long[] la = new long[count];
            float[] fa = new float[count];
            double[] da = new double[count];
            sum += ia[i] = (int) (la[i] = (long) (fa[i] = (float) (da[i] = i)));
        }

        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 80);
    }

}
