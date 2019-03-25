/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.virtual.nodes;

import java.util.List;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.NodeInputList;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.virtual.EscapeObjectState;
import org.graalvm.compiler.nodes.virtual.VirtualObjectNode;

/**
 * This class encapsulated the virtual state of an escape analyzed object.
 */
@NodeInfo
public final class VirtualObjectState extends EscapeObjectState implements Node.ValueNumberable {

    public static final NodeClass<VirtualObjectState> TYPE = NodeClass.create(VirtualObjectState.class);
    @OptionalInput NodeInputList<ValueNode> values;

    public NodeInputList<ValueNode> values() {
        return values;
    }

    public VirtualObjectState(VirtualObjectNode object, ValueNode[] values) {
        super(TYPE, object);
        assert object.entryCount() == values.length;
        this.values = new NodeInputList<>(this, values);
    }

    public VirtualObjectState(VirtualObjectNode object, List<ValueNode> values) {
        super(TYPE, object);
        assert object.entryCount() == values.size();
        this.values = new NodeInputList<>(this, values);
    }

    @Override
    public VirtualObjectState duplicateWithVirtualState() {
        return graph().addWithoutUnique(new VirtualObjectState(object(), values));
    }

    @Override
    public void applyToNonVirtual(NodeClosure<? super ValueNode> closure) {
        for (ValueNode value : values) {
            if (value != null) {
                closure.apply(this, value);
            }
        }
    }
}
