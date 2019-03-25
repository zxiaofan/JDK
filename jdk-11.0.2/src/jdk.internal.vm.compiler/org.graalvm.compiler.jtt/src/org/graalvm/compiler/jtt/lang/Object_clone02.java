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


package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class Object_clone02 extends JTTTest {

    private static class TestClass implements Cloneable {
        @SuppressWarnings("unused")
        private boolean tryClone(int i) throws CloneNotSupportedException {
            return this == this.clone();
        }
    }

    static final TestClass field = new TestClass();

    public static boolean test(int i) throws CloneNotSupportedException {
        return field.tryClone(i);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

}
