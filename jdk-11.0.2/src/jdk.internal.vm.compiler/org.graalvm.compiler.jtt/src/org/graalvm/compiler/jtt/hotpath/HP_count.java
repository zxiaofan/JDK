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
 * Runs: 10 = 55; 20 = 210; 30 = 465; 40 = 820;
 */
@SuppressWarnings("unused")
public class HP_count extends JTTTest {

    public static int test(int count) {
        float unusedFloat = 0;
        double dub = 0;
        int sum = 0;
        double unusedDouble = 0;
        for (int i = 0; i <= count; i++) {
            if (i > 20) {
                sum += i;
            } else {
                sum += i;
            }
            dub += sum;
        }
        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 40);
    }

}
