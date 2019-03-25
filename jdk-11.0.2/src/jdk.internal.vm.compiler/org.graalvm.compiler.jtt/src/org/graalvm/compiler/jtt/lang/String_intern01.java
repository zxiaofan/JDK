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


package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class String_intern01 extends JTTTest {

    public static boolean test() {
        // Checkstyle: stop
        return "id".intern() == "id";
        // Checkstyle: resume
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
