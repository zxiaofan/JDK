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

import java.time.DayOfWeek;
import java.util.HashMap;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Object_hashCode02 extends JTTTest {

    public static final Object obj1 = new Object();
    public static final Object obj2 = DayOfWeek.FRIDAY;
    public static final Object obj3 = new HashMap<>();

    public static int test(int a) {
        if (a == 1) {
            return obj1.hashCode();
        }
        if (a == 2) {
            return obj2.hashCode();
        }
        return obj3.hashCode();
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 3);
    }
}
