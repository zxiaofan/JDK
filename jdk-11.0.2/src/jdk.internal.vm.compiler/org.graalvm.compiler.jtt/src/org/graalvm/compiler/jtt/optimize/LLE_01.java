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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Test case for local load elimination. It makes sure that the second field store is not eliminated, because
 * it is recognized that the first store changes the field "field1", so it is no longer guaranteed that it
 * has its default value 0.
 */
public class LLE_01 extends JTTTest {

    private static class TestClass {
        int field1;
    }

    public static int test() {
        TestClass o = new TestClass();
        o.field1 = 1;
        o.field1 = 0;
        return o.field1;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
