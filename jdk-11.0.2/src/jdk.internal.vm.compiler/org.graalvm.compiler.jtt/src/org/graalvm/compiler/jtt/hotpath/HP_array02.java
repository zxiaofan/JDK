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
public class HP_array02 extends JTTTest {

    public static byte[] b = new byte[40];
    public static char[] c = new char[40];
    public static short[] s = new short[40];
    public static int[] iArray = new int[40];
    public static long[] l = new long[40];
    public static float[] f = new float[40];
    public static double[] d = new double[40];

    public static int test(int count) {
        int sum = 0;
        for (int x = 0; x < count; x++) {
            b[x] = (byte) x;
            c[x] = (char) x;
            s[x] = (short) x;
            iArray[x] = x;
            l[x] = x;
            f[x] = x;
            d[x] = x;
            sum += b[x] + c[x] + s[x] + iArray[x] + l[x] + f[x] + d[x];
        }
        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 40);
    }

}
