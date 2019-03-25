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


package org.graalvm.compiler.core.test.ea;

import org.junit.Test;

public class NestedBoxingTest extends EATestBase {

    @Test
    public void testSimpleMerge() {
        testEscapeAnalysis("testSnippet", null, false);
    }

    public static int testSnippet(int n) {
        Integer cur = 1;
        Integer prev = 1;

        for (int i = 0; i < n; i++) {
            Integer next = prev + cur;
            prev = cur;
            cur = next;
        }
        return cur;
    }
}
