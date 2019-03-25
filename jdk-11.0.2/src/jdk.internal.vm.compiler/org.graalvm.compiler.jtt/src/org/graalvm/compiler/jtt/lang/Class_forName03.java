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

import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public final class Class_forName03 extends JTTTest {

    public static String test(int i) throws ClassNotFoundException {
        String clname = null;
        Class<?> cl = null;
        if (i == 0) {
            clname = "java.lang.Object[]";
            cl = Object.class;
        } else if (i == 1) {
            clname = "[Ljava.lang.String;";
            cl = String.class;
        } else if (i == 2) {
            clname = "[Ljava/lang/String;";
            cl = String.class;
        } else if (i == 3) {
            clname = "[I";
            cl = Class_forName03.class;
        } else if (i == 4) {
            clname = "[java.lang.Object;";
            cl = Class_forName03.class;
        }
        if (clname != null) {
            return Class.forName(clname, false, new URLClassLoader(new URL[0], cl.getClassLoader())).toString();
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
        runTest("test", 3);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 5);
    }

}
