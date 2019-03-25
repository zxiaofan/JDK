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
public final class ClassLoader_loadClass01 extends JTTTest {

    public static String test(int i) throws ClassNotFoundException {
        final URLClassLoader classLoader = new URLClassLoader(new URL[0], String.class.getClassLoader());
        if (i == 0) {
            return classLoader.loadClass("java.lang.String").toString();
        } else if (i == 1) {
            return classLoader.loadClass("[Ljava.lang.String;").toString();
        } else if (i == 2) {
            return classLoader.loadClass("java.lang.String[]").toString();
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
        runTest("test", 2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 5);
    }

}
