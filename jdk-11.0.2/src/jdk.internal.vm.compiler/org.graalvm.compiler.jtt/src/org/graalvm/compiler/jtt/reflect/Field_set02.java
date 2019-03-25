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
public class Field_set02 extends JTTTest {

    private static class TestClass {
        public byte byteField;
        public short shortField;
        public char charField;
        public int intField;
        public long longField;
        public float floatField;
        public double doubleField;
        public boolean booleanField;
    }

    private static final TestClass object = new TestClass();

    public static boolean test(int arg) throws NoSuchFieldException, IllegalAccessException {
        if (arg == 0) {
            TestClass.class.getField("byteField").set(object, Byte.valueOf((byte) 11));
            return object.byteField == 11;
        } else if (arg == 1) {
            TestClass.class.getField("shortField").set(object, Short.valueOf((short) 12));
            return object.shortField == 12;
        } else if (arg == 2) {
            TestClass.class.getField("charField").set(object, Character.valueOf((char) 13));
            return object.charField == 13;
        } else if (arg == 3) {
            TestClass.class.getField("intField").set(object, Integer.valueOf(14));
            return object.intField == 14;
        } else if (arg == 4) {
            TestClass.class.getField("longField").set(object, Long.valueOf(15L));
            return object.longField == 15;
        } else if (arg == 5) {
            TestClass.class.getField("floatField").set(object, Float.valueOf(16));
            return object.floatField == 16;
        } else if (arg == 6) {
            TestClass.class.getField("doubleField").set(object, Double.valueOf(17));
            return object.doubleField == 17;
        } else if (arg == 7) {
            TestClass.class.getField("booleanField").set(object, true);
            return object.booleanField == true;
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
