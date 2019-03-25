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


package org.graalvm.compiler.core.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IfReorderTest extends GraalCompilerTest {

    private static Object fieldA = Integer.class;
    private static Object fieldB = Double.class;

    @Test
    public void test1() {
        test("test1Snippet", new ArrayList<>());
    }

    public static Object test1Snippet(Object o) {
        /*
         * Serializable and List are not mutually exclusive, so these two IFs should never be
         * reordered.
         */
        if (branchProbability(0.1, o instanceof Serializable)) {
            return fieldA;
        }
        if (branchProbability(0.9, o instanceof List)) {
            return fieldB;
        }
        return null;
    }

}
