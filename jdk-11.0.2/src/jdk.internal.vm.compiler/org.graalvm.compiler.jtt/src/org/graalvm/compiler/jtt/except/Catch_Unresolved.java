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
public class Catch_Unresolved extends JTTTest {

    public static boolean executed;

    public static int test(int arg) {
        executed = false;
        try {
            helper1(arg);
            helper2(arg);
        } catch (Catch_Unresolved_Exception1 e) {
            return 1;
        } catch (Catch_Unresolved_Exception2 e) {
            return 2;
        }
        return 0;
    }

    private static void helper1(int arg) {
        if (executed) {
            throw new IllegalStateException("helper1 may only be called once");
        }
        executed = true;
        if (arg == 1) {
            throw new Catch_Unresolved_Exception1();
        } else if (arg == 2) {
            throw new Catch_Unresolved_Exception2();
        }
    }

    private static void helper2(int arg) {
        if (arg != 0) {
            throw new IllegalStateException("helper2 can only be called if arg==0");
        }
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
class Catch_Unresolved_Exception1 extends RuntimeException {
}

@SuppressWarnings("serial")
class Catch_Unresolved_Exception2 extends RuntimeException {
}
