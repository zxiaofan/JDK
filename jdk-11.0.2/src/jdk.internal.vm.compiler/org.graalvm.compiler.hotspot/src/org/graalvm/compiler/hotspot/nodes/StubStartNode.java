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


package org.graalvm.compiler.hotspot.nodes;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.hotspot.stubs.Stub;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.StartNode;

/**
 * Start node for a {@link Stub}'s graph.
 */
@NodeInfo(cycles = CYCLES_0, size = SIZE_0)
public final class StubStartNode extends StartNode {

    public static final NodeClass<StubStartNode> TYPE = NodeClass.create(StubStartNode.class);
    protected final Stub stub;

    public StubStartNode(Stub stub) {
        super(TYPE);
        this.stub = stub;
    }

    public Stub getStub() {
        return stub;
    }
}
