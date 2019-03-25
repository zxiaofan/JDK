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

import org.junit.Ignore;
import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class HP_scope01 extends JTTTest {

    public static int test(int count) {
        int sum = 0;

        for (int k = 0; k < count; k++) {
            {
                int i = 1;
                sum += i;
            }
            {
                float f = 3;
                sum += f;
            }
            {
                long l = 7;
                sum += l;
            }
            {
                double d = 11;
                sum += d;
            }
        }

        for (int k = 0; k < count; k++) {
            if (k < 20) {
                int i = 1;
                sum += i;
            } else {
                float f = 3;
                sum += f;
            }
        }

        for (int k = 0; k < count; k++) {
            int i = 3;
            for (int j = 0; j < count; j++) {
                float f = 7;
                sum += i + f;
            }
        }

        for (int k = 0; k < count; k++) {
            for (int j = 0; j < count; j++) {
                float f = 7;
                sum += j + f;
            }
            int i = 3;
            sum += i;
        }

        return sum;
    }

    @Ignore
    @Test
    public void run0() throws Throwable {
        runTest("test", 40);
    }

}
