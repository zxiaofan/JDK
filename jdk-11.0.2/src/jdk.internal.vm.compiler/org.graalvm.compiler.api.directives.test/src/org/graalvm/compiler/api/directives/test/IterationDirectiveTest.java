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


package org.graalvm.compiler.api.directives.test;

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.graph.iterators.NodeIterable;
import org.graalvm.compiler.nodes.LoopBeginNode;
import org.graalvm.compiler.nodes.StructuredGraph;

public class IterationDirectiveTest extends GraalCompilerTest {

    public static int loopFrequencySnippet(int arg) {
        int x = arg;
        while (GraalDirectives.injectIterationCount(128, x > 1)) {
            GraalDirectives.controlFlowAnchor(); // prevent loop peeling or unrolling
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
        }
        return x;
    }

    @Test
    public void testLoopFrequency() {
        test("loopFrequencySnippet", 7);
    }

    @Override
    protected boolean checkLowTierGraph(StructuredGraph graph) {
        NodeIterable<LoopBeginNode> loopBeginNodes = graph.getNodes(LoopBeginNode.TYPE);
        Assert.assertEquals("LoopBeginNode count", 1, loopBeginNodes.count());

        LoopBeginNode loopBeginNode = loopBeginNodes.first();
        Assert.assertEquals("loop frequency of " + loopBeginNode, 128, loopBeginNode.loopFrequency(), 0);

        return true;
    }
}
