/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
public class Bridge_method01 extends JTTTest {

    private abstract static class Wrap<T> {

        abstract T get();
    }

    private static class IWrap extends Wrap<Integer> {

        @Override
        Integer get() {
            return 1;
        }
    }

    private static Wrap<Integer> wrapped = new IWrap();

    public static int test() {
        return wrapped.get();
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
