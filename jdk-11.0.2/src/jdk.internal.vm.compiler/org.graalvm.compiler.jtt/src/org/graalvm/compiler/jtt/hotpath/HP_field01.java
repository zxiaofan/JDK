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
public class HP_field01 extends JTTTest {

    public static int a;
    public static int b;
    public static int c;

    public static int test(int count) {
        for (int i = 0; i <= count; i++) {
            if (i > 5) {
                a += i;
            } else if (i > 7) {
                b += i;
            } else {
                c += i;
            }
        }
        return a + b + c;
    }

    @Override
    public void before(ResolvedJavaMethod m) {
        a = 0;
        b = 0;
        c = 0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 40);
    }

}
