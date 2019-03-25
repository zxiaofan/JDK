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


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Loop13 extends JTTTest {

    public static class Loop {

        private int index;
        private Object[] nodes = new Object[]{null, null, new Object(), null, null, new Object(), null};
        private int size = nodes.length;

        public Loop(int start) {
            index = start;
        }

        public void test0() {
            if (index < size) {
                do {
                    index++;
                } while (index < size && nodes[index] == null);
            }
        }

        public int getIndex() {
            return index;
        }

    }

    public static int test(int arg) {
        Loop loop = new Loop(arg);
        loop.test0();
        return loop.getIndex();
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
        runTest("test", 3);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 6);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 7);
    }

}
