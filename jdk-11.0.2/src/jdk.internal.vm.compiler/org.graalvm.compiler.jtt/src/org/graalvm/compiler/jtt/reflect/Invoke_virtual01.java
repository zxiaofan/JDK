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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Invoke_virtual01 extends JTTTest {

    static final HelperTest helper = new HelperTest(55);

    public static int test(int input) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (input == 1) {
            final Method m = HelperTest.class.getDeclaredMethod("getInt");
            Object o = m.invoke(helper);
            return ((Integer) o).intValue();
        }
        return 0;
    }

    public static class HelperTest {

        private int intField;

        public int getInt() {
            return intField;
        }

        public HelperTest(int i) {
            intField = i;
        }
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1);
    }

}
