/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public final class Class_forName05 extends JTTTest {

    public static String test(int i) throws ClassNotFoundException {
        final URLClassLoader classLoader = new URLClassLoader(new URL[0], String.class.getClassLoader());
        if (i == 0) {
            return Class.forName("java.lang.String", false, classLoader).toString();
        } else if (i == 1) {
            return Class.forName("[Ljava.lang.String;", false, classLoader).toString();
        }
        return null;
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
        runTest("test", 5);
    }

}
