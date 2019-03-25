/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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

public class BoxingTest extends GraalCompilerTest {

    public static Object boxSnippet(int arg) {
        return arg;
    }

    @Test
    public void test0() {
        test("boxSnippet", 0);
    }

    @Test
    public void test5() {
        test("boxSnippet", 5);
    }

    @Test
    public void testMinus5() {
        test("boxSnippet", -5);
    }

    @Test
    public void test300() {
        test("boxSnippet", 300);
    }

    @Test
    public void testMinus300() {
        test("boxSnippet", -300);
    }
}
