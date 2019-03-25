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
/*
 */


package org.graalvm.compiler.jtt.reflect;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Class_newInstance06 extends JTTTest {

    public static final class Class_newInstance {

        @SuppressWarnings("unused")
        private Class_newInstance(int i) {
            // do nothing. xx
        }
    }

    public static boolean test(int i) throws IllegalAccessException, InstantiationException {
        if (i == 0) {
            return Class_newInstance.class.newInstance() != null;
        }
        return false;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 4);
    }

}
