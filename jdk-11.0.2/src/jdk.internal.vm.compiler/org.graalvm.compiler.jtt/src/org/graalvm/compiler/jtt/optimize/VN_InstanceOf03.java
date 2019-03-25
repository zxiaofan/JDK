/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Tests value numbering of instanceof operations.
 */
public class VN_InstanceOf03 extends JTTTest {

    private static boolean cond = true;

    static final Object object = new DummyTestClass();

    public static boolean test() {
        return foo();
    }

    private static boolean foo() {
        Object obj = new DummyTestClass();
        boolean a = obj instanceof DummyTestClass;
        if (cond) {
            boolean b = obj instanceof DummyTestClass;
            return a | b;
        }
        return false;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
