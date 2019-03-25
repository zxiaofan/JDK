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


package org.graalvm.compiler.nodes.extended;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_2;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_1;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

@NodeInfo(cycles = CYCLES_2, size = SIZE_1)
public final class StoreHubNode extends FixedWithNextNode implements Lowerable {

    public static final NodeClass<StoreHubNode> TYPE = NodeClass.create(StoreHubNode.class);
    @Input ValueNode value;
    @Input ValueNode object;

    public ValueNode getValue() {
        return value;
    }

    public ValueNode getObject() {
        return object;
    }

    public StoreHubNode(ValueNode object, ValueNode value) {
        super(TYPE, StampFactory.forVoid());
        this.value = value;
        this.object = object;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    @NodeIntrinsic
    public static native void write(Object object, Object value);
}
