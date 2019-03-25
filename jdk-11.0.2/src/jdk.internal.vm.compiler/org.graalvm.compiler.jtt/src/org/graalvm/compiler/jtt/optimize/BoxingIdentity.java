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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class BoxingIdentity extends JTTTest {
    interface ArrayMirror {
        Object get(int i);
    }

    static class IntArray implements ArrayMirror {
        final int[] array;

        IntArray() {
            this.array = new int[8];
        }

        @Override
        public Object get(int i) {
            return array[i];
        }
    }

    public int testIntArray(Object m) {
        ArrayMirror a = new IntArray();
        if (a.get(0) != m) {
            return 42;
        }
        return 41;
    }

    @Test
    public void runIntArray() {
        runTest("testIntArray", 0);
        runTest("testIntArray", 1);
    }

    public boolean isTrue(Object obj) {
        return obj == Boolean.valueOf(true);
    }

    @Test
    public void runIsTrue() {
        runTest("isTrue", true);
        runTest("isTrue", false);
    }
}
