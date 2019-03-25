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


package org.graalvm.compiler.core.test.ea;

import org.junit.Test;

import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.PhiNode;
import org.graalvm.compiler.nodes.ValuePhiNode;

public class EAMergingTest extends EATestBase {

    @Test
    public void testSimpleMerge() {
        testEscapeAnalysis("simpleMergeSnippet", null, false);
        assertDeepEquals(1, returnNodes.size());
        assertTrue(returnNodes.get(0).result() instanceof ValuePhiNode);
        PhiNode phi = (PhiNode) returnNodes.get(0).result();
        assertTrue(phi.valueAt(0) instanceof ParameterNode);
        assertTrue(phi.valueAt(1) instanceof ParameterNode);
    }

    public static int simpleMergeSnippet(boolean b, int u, int v) {
        TestClassInt obj;
        if (b) {
            obj = new TestClassInt(u, 0);
            notInlineable();
        } else {
            obj = new TestClassInt(v, 0);
            notInlineable();
        }
        return obj.x;
    }
}
