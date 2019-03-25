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
public class HP_allocate03 extends JTTTest {

    public static int test(int count) {
        @SuppressWarnings("unused")
        final int sum = 0;
        String text = "";
        for (int i = 0; i < count; i++) {
            text += '.';
        }
        return text.length();
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 100);
    }

}
