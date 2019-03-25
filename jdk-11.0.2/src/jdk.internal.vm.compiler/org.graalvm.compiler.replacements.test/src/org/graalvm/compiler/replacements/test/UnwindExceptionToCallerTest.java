/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.test;

import org.junit.Test;

import org.graalvm.compiler.core.test.GraalCompilerTest;

/**
 * Tests exception throwing from Graal compiled code.
 */
public class UnwindExceptionToCallerTest extends GraalCompilerTest {

    @Test
    public void test1() {
        NullPointerException npe = new NullPointerException();
        test("test1Snippet", "a string", npe);
        test("test1Snippet", (String) null, npe);
    }

    public static String test1Snippet(String message, NullPointerException npe) {
        if (message == null) {
            throw npe;
        }
        return message;
    }
}
