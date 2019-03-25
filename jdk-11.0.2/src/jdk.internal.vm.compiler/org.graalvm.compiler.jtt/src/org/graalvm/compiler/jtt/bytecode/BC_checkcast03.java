/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Tests the checkcast works, when casting an array of interface.
 */
public class BC_checkcast03 extends JTTTest {

    public interface IObject {

    }

    private static class BaseClass {

    }

    private static class TestClass extends BaseClass implements IObject {
    }

    static TestClass[] a1 = {new TestClass()};

    public static BaseClass[] getBaseClassArray() {
        return a1;
    }

    public static IObject[] test() {
        return (IObject[]) getBaseClassArray();
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }
}
