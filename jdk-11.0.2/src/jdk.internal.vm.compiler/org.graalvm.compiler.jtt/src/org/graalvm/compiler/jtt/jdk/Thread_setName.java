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


package org.graalvm.compiler.jtt.jdk;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Thread_setName extends JTTTest {

    public static String test(String name) {
        String oldName = Thread.currentThread().getName();
        Thread.currentThread().setName(name);
        String name2 = Thread.currentThread().getName();
        Thread.currentThread().setName(oldName);
        return name2;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", "abc");
    }

}
