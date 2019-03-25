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


package org.graalvm.compiler.jtt.micro;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
@SuppressWarnings("unused")
public class StrangeFrames extends JTTTest {

    public static boolean test(int arg) {
        empty();
        oneOperandStackSlot();
        twoOperandStackSlots();
        oneLocalSlot();
        return true;
    }

    static void empty() {
        // do nothing.
    }

    static void oneOperandStackSlot() {
        new DummyTestClass();
    }

    static void twoOperandStackSlots() {
        two(new DummyTestClass(), new DummyTestClass());
    }

    static void oneLocalSlot() {
        int a;
    }

    static void two(Object a, Object b) {
        Object c = b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

}
