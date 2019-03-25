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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Phi01 extends JTTTest {

    public static class Phi {

        int f;

        Phi(int f) {
            this.f = f;
        }
    }

    public static int test(int arg) {
        return test2(new Phi(arg), arg);
    }

    private static int test2(Phi p, int a) {
        int arg = a;
        if (arg > 2) {
            p.f += 1;
            arg += 1;
        } else {
            p.f += 2;
            arg += 2;
            if (arg > 3) {
                p.f += 1;
                arg += 1;
                if (arg > 4) {
                    p.f += 1;
                    arg += 1;
                } else {
                    p.f += 2;
                    arg += 2;
                }
            } else {
                p.f += 2;
                arg += 2;
            }
        }
        return arg + p.f;
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
        runTest("test", 6);
    }

}
