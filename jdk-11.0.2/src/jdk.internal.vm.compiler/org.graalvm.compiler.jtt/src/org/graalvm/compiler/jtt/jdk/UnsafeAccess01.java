/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.jdk;

import java.lang.reflect.Field;

import org.graalvm.compiler.jtt.JTTTest;
import org.junit.Test;

/*
 */
public class UnsafeAccess01 extends JTTTest {

    private static int randomValue = 100;
    private static final long offset;
    private static Object staticObject = new TestClass();

    static {
        Field field = null;
        try {
            field = TestClass.class.getDeclaredField("field");
        } catch (NoSuchFieldException e) {
        } catch (SecurityException e) {
        }
        offset = UNSAFE.objectFieldOffset(field);
    }

    private static class TestClass {
        private int field = 42;
    }

    public static int test() {
        final TestClass object = new TestClass();
        final int value = UNSAFE.getInt(object, offset);
        return value;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

    @Test
    public void runDiamond() throws Throwable {
        runTest("testDiamond");
    }

    public static int testDiamond() {

        final Object object = staticObject;
        final int oldValue = ((TestClass) object).field;

        if (randomValue == 100) {
            UNSAFE.putInt(object, offset, 41);
        } else {
            UNSAFE.putInt(object, offset, 40);
        }
        UNSAFE.putInt(object, offset, 42);
        return oldValue;
    }
}
