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


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class DegeneratedLoop extends JTTTest {

    public static String test(int a) {
        int arg = a;
        for (;;) {
            try {
                arg++;
                break;
            } catch (Unresolved iioe) {
            }
        }
        return "ok-" + arg;
    }

    @SuppressWarnings("serial")
    public static class Unresolved extends RuntimeException {

    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

}
