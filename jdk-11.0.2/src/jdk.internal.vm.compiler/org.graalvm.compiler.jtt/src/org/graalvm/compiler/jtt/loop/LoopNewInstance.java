/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.loop;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class LoopNewInstance extends JTTTest {

    public static Blop initBlop = new Blop();

    @SuppressWarnings("unused")
    public static int test(int arg) {
        for (int i = 0; i < arg; i++) {
            new Blop();
        }
        return count;
    }

    private static int count;

    private static class Blop {

        private boolean exists;

        Blop() {
            if (!exists) {
                count++;
            }
            exists = true;
        }
    }

    @Override
    protected void before(ResolvedJavaMethod m) {
        count = 0;
    }

    @Test
    public void run0() throws Throwable {
        count = 0;
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        count = 0;
        runTest("test", 5);
    }

}
