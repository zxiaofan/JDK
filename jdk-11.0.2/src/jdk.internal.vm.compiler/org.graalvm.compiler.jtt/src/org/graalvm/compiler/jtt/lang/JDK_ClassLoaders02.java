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

import java.net.URLClassLoader;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class JDK_ClassLoaders02 extends JTTTest {

    public static boolean test() {
        ClassLoader classLoader = JDK_ClassLoaders02.class.getClassLoader();
        return classLoader == null || classLoader instanceof URLClassLoader;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
