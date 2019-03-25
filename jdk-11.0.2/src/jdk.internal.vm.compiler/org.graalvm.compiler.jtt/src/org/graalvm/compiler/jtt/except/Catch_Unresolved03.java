/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Catch_Unresolved03 extends JTTTest {

    public static boolean executed;
    public static int value;

    public static int test(int arg) {
        executed = false;
        int result = 0;
        try {
            result = value + helper1(arg) + helper2(arg);
        } catch (Catch_Unresolved03_Exception1 e) {
            if (arg == 1) {
                return 1;
            }
            return new Catch_Unresolved03_UnresolvedClass().value();
        }
        return result;
    }

    private static int helper1(int arg) {
        if (executed) {
            throw new IllegalStateException("helper1 may only be called once");
        }
        executed = true;
        if (arg == 1 || arg == 2) {
            throw new Catch_Unresolved03_Exception1();
        }
        return 0;
    }

    private static int helper2(int arg) {
        if (arg != 0) {
            throw new IllegalStateException("helper2 can only be called if arg==0");
        }
        return 0;
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

}

@SuppressWarnings("serial")
class Catch_Unresolved03_Exception1 extends RuntimeException {
}

class Catch_Unresolved03_UnresolvedClass {

    public int value() {
        return 2;
    }
}
