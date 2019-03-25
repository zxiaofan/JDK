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
public class Field_getType01 extends JTTTest {

    public static final byte byteField = 11;
    public static final short shortField = 12;
    public static final char charField = 13;
    public static final int intField = 14;
    public static final long longField = 15;
    public static final float floatField = 16;
    public static final double doubleField = 17;
    public static final boolean booleanField = true;

    public static boolean test(int arg) throws NoSuchFieldException {
        if (arg == 0) {
            return Field_getType01.class.getField("byteField").getType() == byte.class;
        } else if (arg == 1) {
            return Field_getType01.class.getField("shortField").getType() == short.class;
        } else if (arg == 2) {
            return Field_getType01.class.getField("charField").getType() == char.class;
        } else if (arg == 3) {
            return Field_getType01.class.getField("intField").getType() == int.class;
        } else if (arg == 4) {
            return Field_getType01.class.getField("longField").getType() == long.class;
        } else if (arg == 5) {
            return Field_getType01.class.getField("floatField").getType() == float.class;
        } else if (arg == 6) {
            return Field_getType01.class.getField("doubleField").getType() == double.class;
        } else if (arg == 7) {
            return Field_getType01.class.getField("booleanField").getType() == boolean.class;
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
