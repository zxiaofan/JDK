/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.graph.Node.ValueNumberable;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;

@NodeInfo
public abstract class FloatingNode extends ValueNode implements ValueNumberable {
    public static final NodeClass<FloatingNode> TYPE = NodeClass.create(FloatingNode.class);

    public FloatingNode(NodeClass<? extends FloatingNode> c, Stamp stamp) {
        super(c, stamp);
    }

    @Override
    public FloatingNode asNode() {
        return this;
    }
}
