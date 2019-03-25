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
public class HP_trees01 extends JTTTest {

    public static int test(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            if (i < 100) {
                sum += 1;
            } else if (i < 200) {
                sum += 3;
            } else if (i < 300) {
                sum += 5;
            } else if (i < 400) {
                sum += 7;
            } else if (i < 500) {
                sum += 11;
            }

            if (i % 5 == 0) {
                sum += 1;
            } else if (i % 5 == 1) {
                sum += 3;
            } else if (i % 5 == 2) {
                sum += 5;
            } else if (i % 5 == 3) {
                sum += 7;
            } else if (i % 5 == 4) {
                sum += 11;
            }
        }
        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1000);
    }

}
