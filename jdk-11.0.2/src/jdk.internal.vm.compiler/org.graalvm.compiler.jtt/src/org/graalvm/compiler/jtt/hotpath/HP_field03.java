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
// Checkstyle: stop


package org.graalvm.compiler.jtt.hotpath;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class HP_field03 extends JTTTest {

    public static byte b;
    public static char c;
    public static short s;
    public static int i;
    public static long l;
    public static float f;
    public static double d;

    public static int test(int count) {
        for (int x = 0; x <= count; x++) {
            b += x;
            c += x;
            s += x;
            i += x;
            l += x;
            f += x;
            d += x;
        }
        return (int) (b + c + s + i + l + f + d);
    }

    @Override
    public void before(ResolvedJavaMethod m) {
        b = 0;
        c = 0;
        s = 0;
        i = 0;
        l = 0L;
        f = 0.0F;
        d = 0.0D;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1000);
    }

}
