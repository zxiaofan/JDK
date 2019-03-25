/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Tests calls to the array copy method.
 */
public class ArrayCopyGeneric extends JTTTest {

    public Object[] arraysFrom;
    public Object[] arraysTo;

    public void init() {
        arraysFrom = new Object[]{new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new short[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                        new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new float[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
        arraysTo = new Object[]{new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new short[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                        new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new float[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
    }

    public Object test() {
        init();

        for (int i = 0; i < arraysFrom.length; i++) {
            Object from = arraysFrom[i];
            Object to = arraysTo[i];
            System.arraycopy(from, 1, to, 2, 2);
            System.arraycopy(from, 8, to, 7, 2);
        }
        return arraysTo;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }
}
