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


package org.graalvm.compiler.graph.test;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_UNKNOWN;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_UNKNOWN;

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.graph.Graph;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;

public class NodeValidationChecksTest extends GraphTest {

    @NodeInfo(cycles = CYCLES_UNKNOWN, size = SIZE_UNKNOWN)
    static final class TestNode extends Node {
        public static final NodeClass<TestNode> TYPE = NodeClass.create(TestNode.class);

        @Input TestNode input;
        @Successor TestNode successor;

        protected TestNode(TestNode input, TestNode successor) {
            super(TYPE);
            this.input = input;
            this.successor = successor;
        }
    }

    @Test
    public void testInputNotAlive() {
        Graph graph = new Graph(getOptions(), getDebug());
        TestNode node = new TestNode(null, null);
        try {
            graph.add(new TestNode(node, null));
            Assert.fail("Exception expected.");
        } catch (AssertionError e) {
            Assert.assertTrue(e.getMessage().contains("Input"));
            Assert.assertTrue(e.getMessage().contains("not alive"));
        }
    }

    @Test
    public void testSuccessorNotAlive() {
        Graph graph = new Graph(getOptions(), getDebug());
        TestNode node = new TestNode(null, null);
        try {
            graph.add(new TestNode(null, node));
            Assert.fail("Exception expected.");
        } catch (AssertionError e) {
            Assert.assertTrue(e.getMessage().contains("Successor"));
            Assert.assertTrue(e.getMessage().contains("not alive"));
        }
    }
}
