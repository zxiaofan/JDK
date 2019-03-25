/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.extended;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.java.MonitorEnterNode;
import org.graalvm.compiler.nodes.java.MonitorIdNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;

@NodeInfo(cycles = CYCLES_0, size = SIZE_0)
public class OSRMonitorEnterNode extends MonitorEnterNode implements LIRLowerable {

    public static final NodeClass<OSRMonitorEnterNode> TYPE = NodeClass.create(OSRMonitorEnterNode.class);

    public OSRMonitorEnterNode(ValueNode object, MonitorIdNode monitorId) {
        super(TYPE, object, monitorId);
    }

    @Override
    public void virtualize(VirtualizerTool tool) {
        // OSR Entry cannot be virtualized
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
        // Nothing to do
    }

    @Override
    public void lower(LoweringTool tool) {
        /*
         * Nothing to do for OSR compilations with locks the monitor enter operation already
         * happened when we do the compilation.
         */
    }
}
