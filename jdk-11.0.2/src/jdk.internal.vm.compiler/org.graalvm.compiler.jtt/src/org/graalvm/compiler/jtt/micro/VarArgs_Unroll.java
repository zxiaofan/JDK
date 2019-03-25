/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.micro;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class VarArgs_Unroll extends JTTTest {

    public static boolean test(String a, String b) {
        return check(a, b);
    }

    private static boolean check(String... args) {
        if (args.length == 0) {
            return true;
        }
        String s = args[0];
        for (String t : args) {
            if (!t.equals(s)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", "ab", "ab");
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", "ab", "abc");
    }
}
