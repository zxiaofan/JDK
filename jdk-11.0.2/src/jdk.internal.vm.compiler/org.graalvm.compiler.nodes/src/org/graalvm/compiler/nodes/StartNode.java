/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes;

import static org.graalvm.compiler.nodeinfo.InputType.Memory;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint;
import jdk.internal.vm.compiler.word.LocationIdentity;

/**
 * The start node of a graph.
 */
@NodeInfo(allowedUsageTypes = {Memory}, nameTemplate = "Start", cycles = CYCLES_0, size = SIZE_0)
public class StartNode extends BeginStateSplitNode implements MemoryCheckpoint.Single {
    public static final NodeClass<StartNode> TYPE = NodeClass.create(StartNode.class);

    protected StartNode(NodeClass<? extends StartNode> c) {
        super(c);
    }

    public StartNode() {
        super(TYPE);
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return LocationIdentity.any();
    }
}
