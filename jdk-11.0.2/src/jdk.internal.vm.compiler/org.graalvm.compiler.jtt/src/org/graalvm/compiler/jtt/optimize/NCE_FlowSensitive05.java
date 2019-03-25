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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class NCE_FlowSensitive05 extends JTTTest {

    private static PrintStream ps = new PrintStream(new ByteArrayOutputStream());

    public static String test(Object arg) {

        // An artificial loop to trigger iterative NCE.
        while (arg != null) {
            ps.println(arg);
        }

        // The upcast must still include the null check.
        return (String) arg;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", (Object) null);
    }

}
