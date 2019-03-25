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

public class Class_newInstance03 extends JTTTest {

    public abstract static class AbstractClass {
    }

    public static boolean test(int i) throws IllegalAccessException, InstantiationException {
        if (i == 0) {
            return AbstractClass.class.newInstance() != null;
        } else if (i == 1) {
            return Cloneable.class.newInstance() != null;
        } else if (i == 2) {
            return int[].class.newInstance() != null;
        } else if (i == 3) {
            return int.class.newInstance() != null;
        }
        return false;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

}
