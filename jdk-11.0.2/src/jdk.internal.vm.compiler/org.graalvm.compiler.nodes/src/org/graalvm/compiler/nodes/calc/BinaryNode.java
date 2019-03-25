/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;

/**
 * The {@code BinaryNode} class is the base of arithmetic and logic operations with two inputs.
 */
@NodeInfo
public abstract class BinaryNode extends FloatingNode implements Canonicalizable.Binary<ValueNode> {

    public static final NodeClass<BinaryNode> TYPE = NodeClass.create(BinaryNode.class);
    @Input protected ValueNode x;
    @Input protected ValueNode y;

    @Override
    public ValueNode getX() {
        return x;
    }

    @Override
    public ValueNode getY() {
        return y;
    }

    public void setX(ValueNode x) {
        updateUsages(this.x, x);
        this.x = x;
    }

    public void setY(ValueNode y) {
        updateUsages(this.y, y);
        this.y = y;
    }

    /**
     * Creates a new BinaryNode instance.
     *
     * @param stamp the result type of this instruction
     * @param x the first input instruction
     * @param y the second input instruction
     */
    protected BinaryNode(NodeClass<? extends BinaryNode> c, Stamp stamp, ValueNode x, ValueNode y) {
        super(c, stamp);
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean inferStamp() {
        return updateStamp(foldStamp(getX().stamp(NodeView.DEFAULT), getY().stamp(NodeView.DEFAULT)));
    }

    /**
     * Compute an improved for this node using the passed in stamps. The stamps must be compatible
     * with the current values of {@link #x} and {@link #y}. This code is used to provide the
     * default implementation of {@link #inferStamp()} and may be used by external optimizations.
     *
     * @param stampX
     * @param stampY
     */
    public abstract Stamp foldStamp(Stamp stampX, Stamp stampY);
}
