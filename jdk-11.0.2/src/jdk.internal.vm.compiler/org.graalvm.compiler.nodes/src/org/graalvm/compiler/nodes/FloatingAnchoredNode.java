/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.extended.AnchoringNode;

@NodeInfo
public abstract class FloatingAnchoredNode extends FloatingNode {
    public static final NodeClass<FloatingAnchoredNode> TYPE = NodeClass.create(FloatingAnchoredNode.class);

    @Input(InputType.Anchor) protected AnchoringNode anchor;

    public FloatingAnchoredNode(NodeClass<? extends FloatingAnchoredNode> c, Stamp stamp) {
        super(c, stamp);
    }

    public FloatingAnchoredNode(NodeClass<? extends FloatingAnchoredNode> c, Stamp stamp, AnchoringNode anchor) {
        super(c, stamp);
        this.anchor = anchor;
    }

    public AnchoringNode getAnchor() {
        return anchor;
    }

    public void setAnchor(AnchoringNode x) {
        updateUsagesInterface(this.anchor, x);
        this.anchor = x;
    }
}
