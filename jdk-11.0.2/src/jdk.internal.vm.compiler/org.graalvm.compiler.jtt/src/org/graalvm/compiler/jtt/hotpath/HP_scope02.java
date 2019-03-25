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
public class HP_scope02 extends JTTTest {

    public static int test(int count) {
        int sum = 0;
        // Although sum is not explicitly read in the tree below it is implicitly read
        // by the guard bail-out.
        for (int i = 0; i < count; i++) {
            if (i > 20) {
                break; // We need to write back either the original value of sum, or the previous
                       // iteration's value.
            }
            sum = i;
        }
        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 40);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 22);
    }

}
