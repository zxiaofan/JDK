/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_IGNORED;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_IGNORED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.graph.Graph;
import org.graalvm.compiler.graph.IterableNodeType;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;

public class TypedNodeIteratorTest2 extends GraphTest {

    @NodeInfo(cycles = CYCLES_IGNORED, size = SIZE_IGNORED)
    static class NodeA extends Node implements TestNodeInterface {

        public static final NodeClass<NodeA> TYPE = NodeClass.create(NodeA.class);
        protected final String name;

        protected NodeA(String name) {
            this(TYPE, name);
        }

        protected NodeA(NodeClass<? extends NodeA> c, String name) {
            super(c);
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @NodeInfo(cycles = CYCLES_IGNORED, size = SIZE_IGNORED)
    static class NodeB extends NodeA implements IterableNodeType {
        public static final NodeClass<NodeB> TYPE = NodeClass.create(NodeB.class);

        protected NodeB(String name) {
            this(TYPE, name);
        }

        protected NodeB(NodeClass<? extends NodeB> c, String name) {
            super(c, name);
        }

    }

    @NodeInfo(cycles = CYCLES_IGNORED, size = SIZE_IGNORED)
    static class NodeC extends NodeB {
        public static final NodeClass<NodeC> TYPE = NodeClass.create(NodeC.class);

        protected NodeC(String name) {
            this(TYPE, name);
        }

        protected NodeC(NodeClass<? extends NodeC> c, String name) {
            super(c, name);
        }

    }

    @NodeInfo(cycles = CYCLES_IGNORED, size = SIZE_IGNORED)
    static final class NodeD extends NodeC {
        public static final NodeClass<NodeD> TYPE = NodeClass.create(NodeD.class);

        protected NodeD(String name) {
            super(TYPE, name);
        }

    }

    @Test
    public void simpleSubclassTest() {
        Graph graph = new Graph(getOptions(), getDebug());
        graph.add(new NodeB("b"));
        graph.add(new NodeD("d"));

        Assert.assertEquals("bd", TypedNodeIteratorTest.toString(graph.getNodes(NodeB.TYPE)));
        Assert.assertEquals("d", TypedNodeIteratorTest.toString(graph.getNodes(NodeD.TYPE)));
    }

    @Test
    public void addingNodeDuringIterationTest() {
        Graph graph = new Graph(getOptions(), getDebug());
        graph.add(new NodeB("b1"));
        NodeD d1 = graph.add(new NodeD("d1"));
        StringBuilder sb = new StringBuilder();
        for (NodeB tn : graph.getNodes(NodeB.TYPE)) {
            if (tn == d1) {
                graph.add(new NodeB("b2"));
            }
            sb.append(tn.getName());
        }
        assertEquals("b1d1b2", sb.toString());
        for (NodeB tn : graph.getNodes(NodeB.TYPE)) {
            if (tn == d1) {
                graph.add(new NodeB("b3"));
            }
            assertNotNull(tn);
        }
        assertEquals(4, graph.getNodes(NodeB.TYPE).count());
        assertEquals(1, graph.getNodes(NodeD.TYPE).count());
    }

}
