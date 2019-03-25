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

public final class Class_newInstance07 extends JTTTest {

    public static final class Class_newInstance {

        private Class_newInstance() throws Exception {
            throw new Exception();
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
