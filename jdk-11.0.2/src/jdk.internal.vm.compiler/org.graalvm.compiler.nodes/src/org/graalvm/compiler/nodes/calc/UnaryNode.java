/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.calc;

import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_1;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;

/**
 * The {@code UnaryNode} class is the base of arithmetic and bit logic operations with exactly one
 * input.
 */
@NodeInfo(size = SIZE_1)
public abstract class UnaryNode extends FloatingNode implements Canonicalizable.Unary<ValueNode> {

    public static final NodeClass<UnaryNode> TYPE = NodeClass.create(UnaryNode.class);
    @Input protected ValueNode value;

    @Override
    public ValueNode getValue() {
        return value;
    }

    public void setValue(ValueNode value) {
        updateUsages(this.value, value);
        this.value = value;
    }

    /**
     * Creates a new UnaryNode instance.
     *
     * @param stamp the result type of this instruction
     * @param value the input instruction
     */
    protected UnaryNode(NodeClass<? extends UnaryNode> c, Stamp stamp, ValueNode value) {
        super(c, stamp);
        this.value = value;
    }

    @Override
    public boolean inferStamp() {
        return updateStamp(foldStamp(value.stamp(NodeView.DEFAULT)));
    }

    /**
     * Compute an improved for this node using the passed in stamp. The stamp must be compatible
     * with the current value of {@link #value}. This code is used to provide the default
     * implementation of {@link #inferStamp()} and may be used by external optimizations.
     *
     * @param newStamp
     */
    public Stamp foldStamp(Stamp newStamp) {
        return stamp(NodeView.DEFAULT);
    }
}
