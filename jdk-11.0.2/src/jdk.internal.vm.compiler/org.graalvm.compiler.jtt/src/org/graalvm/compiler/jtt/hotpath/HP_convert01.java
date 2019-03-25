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
public class HP_convert01 extends JTTTest {

    public static int test(int count) {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum = (int) sum + i;
        }
        return (int) sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 100);
    }

}
