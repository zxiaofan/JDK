/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

public class OnStackReplacementTest extends GraalCompilerTest {

    @Test
    public void test1() {
        test("test1Snippet");
    }

    static int limit = 10000;

    public static void test1Snippet() {
        for (int i = 0; !Thread.currentThread().isInterrupted() && i < limit; i++) {
            for (int j = 0; !Thread.currentThread().isInterrupted() && j < limit; j++) {
            }
        }

    }

}
