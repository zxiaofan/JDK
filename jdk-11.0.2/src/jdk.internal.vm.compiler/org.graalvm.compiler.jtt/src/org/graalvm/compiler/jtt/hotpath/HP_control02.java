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
public class HP_control02 extends JTTTest {

    public static int test(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            switch (i) {
                case 30:
                    sum += 30;
                    break;
                case 31:
                    sum += 31;
                    break;
                case 32:
                    sum += 32;
                    break;
                case 33:
                    sum += 33;
                    break;
                case 34:
                    sum += 34;
                    break;
                case 35:
                    sum += 35;
                    break;
                case 36:
                    sum += 36;
                    break;
                case 37:
                    sum += 37;
                    break;
                case 38:
                    sum += 38;
                    break;
                case 39:
                    sum += 39;
                    break;
                case 40:
                    sum += 40;
                    break;
                case 41:
                    sum += 41;
                    break;
                case 42:
                    sum += 42;
                    break;
                default:
                    sum += 1;
                    break;
            }
        }
        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 60);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 100);
    }

}
