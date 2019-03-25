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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_castore extends JTTTest {

    static char[] array = {0, 0, 0, 0};

    public static char test(int arg, char val) {
        array[arg] = val;
        return array[arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, ((char) 97));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, ((char) 65));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2, ((char) 42));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, ((char) 120));
    }

}
