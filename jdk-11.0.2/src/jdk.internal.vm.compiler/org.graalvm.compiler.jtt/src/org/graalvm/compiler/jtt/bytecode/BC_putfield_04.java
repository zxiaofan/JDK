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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_putfield_04 extends JTTTest {

    private static class TestClass {
        private volatile Object field;
    }

    private static TestClass object = new TestClass();

    public static Object test(Object arg) {
        object.field = arg;
        return object.field;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", "0");
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", (Object) null);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", "string");
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", "-4");
    }

}
