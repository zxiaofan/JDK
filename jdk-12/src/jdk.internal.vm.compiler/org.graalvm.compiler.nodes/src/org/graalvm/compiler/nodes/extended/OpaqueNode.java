/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

@NodeInfo(cycles = CYCLES_0, size = SIZE_0)
public final class OpaqueNode extends FloatingNode implements LIRLowerable {
    public static final NodeClass<OpaqueNode> TYPE = NodeClass.create(OpaqueNode.class);

    @Input protected ValueNode value;
    protected Object noGVN = new Object();

    public OpaqueNode(ValueNode value) {
        super(TYPE, value.stamp(NodeView.DEFAULT).unrestricted());
        this.value = value;
    }

    public ValueNode getValue() {
        return value;
    }

    public void setValue(ValueNode value) {
        this.updateUsages(this.value, value);
        this.value = value;
    }

    public void remove() {
        replaceAndDelete(getValue());
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        gen.setResult(this, gen.operand(value));
    }
}
