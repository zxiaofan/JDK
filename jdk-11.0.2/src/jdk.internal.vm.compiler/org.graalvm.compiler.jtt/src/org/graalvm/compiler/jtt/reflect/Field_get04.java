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


package org.graalvm.compiler.jtt.reflect;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Field_get04 extends JTTTest {

    private static class TestClass {
        public final byte byteField = 11;
        public final short shortField = 12;
        public final char charField = 13;
        public final int intField = 14;
        public final long longField = 15;
        public final float floatField = 16;
        public final double doubleField = 17;
        public final boolean booleanField = true;
    }

    private static final TestClass object = new TestClass();

    public static boolean test(int arg) throws NoSuchFieldException, IllegalAccessException {
        if (arg == 0) {
            return TestClass.class.getField("byteField").getByte(object) == object.byteField;
        } else if (arg == 1) {
            return TestClass.class.getField("shortField").getShort(object) == object.shortField;
        } else if (arg == 2) {
            return TestClass.class.getField("charField").getChar(object) == object.charField;
        } else if (arg == 3) {
            return TestClass.class.getField("intField").getInt(object) == object.intField;
        } else if (arg == 4) {
            return TestClass.class.getField("longField").getLong(object) == object.longField;
        } else if (arg == 5) {
            return TestClass.class.getField("floatField").getFloat(object) == object.floatField;
        } else if (arg == 6) {
            return TestClass.class.getField("doubleField").getDouble(object) == object.doubleField;
        } else if (arg == 7) {
            return TestClass.class.getField("booleanField").getBoolean(object) == object.booleanField;
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

    @Test
    public void run5() throws Throwable {
        runTest("test", 5);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 6);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 7);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", 8);
    }

}
