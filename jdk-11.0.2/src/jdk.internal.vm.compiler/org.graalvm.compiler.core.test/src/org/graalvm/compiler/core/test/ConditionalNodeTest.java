/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import org.junit.Test;

public class ConditionalNodeTest extends GraalCompilerTest {

    @SuppressWarnings("unused") private static int sink0;
    @SuppressWarnings("unused") private static int sink1;

    @Test
    public void test0() {
        test("conditionalTest0", 0);
        test("conditionalTest0", 1);
    }

    public static int conditionalTest0(int a) {
        int value;
        if (a == 1) {
            value = -1;
            sink1 = 0;
        } else {
            value = 6;
            sink1 = 1;
        }
        sink0 = 1;
        return Math.max(value, 6);
    }

    @Test
    public void test1() {
        test("conditionalTest1", 0);
        test("conditionalTest1", 1);
    }

    public static int conditionalTest1(int a) {
        int value;
        if (a == 1) {
            value = -1;
            sink1 = 0;
        } else {
            value = 6;
            sink1 = 1;
        }
        sink0 = 1;
        return Math.max(6, value);
    }

    @Test
    public void test2() {
        test("conditionalTest2", 0);
        test("conditionalTest2", 1);
    }

    public static int conditionalTest2(int a) {
        int value;
        if (a == 1) {
            value = -1;
            sink1 = 0;
        } else {
            value = 6;
            sink1 = 1;
        }
        sink0 = 1;
        return Math.min(value, -1);
    }

    @Test
    public void test3() {
        test("conditionalTest3", 0);
        test("conditionalTest3", 1);
    }

    public static int conditionalTest3(int a) {
        int value;
        if (a == 1) {
            value = -1;
            sink1 = 0;
        } else {
            value = 6;
            sink1 = 1;
        }
        sink0 = 1;
        return Math.min(-1, value);
    }
}
