/*
 * Copyright (c) 2009, 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.java;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;

/**
 * This the base class of all array operations.
 */
@NodeInfo
public abstract class AccessArrayNode extends FixedWithNextNode {

    public static final NodeClass<AccessArrayNode> TYPE = NodeClass.create(AccessArrayNode.class);
    @Input protected ValueNode array;

    public ValueNode array() {
        return array;
    }

    /**
     * Creates a new AccessArrayNode.
     *
     * @param array the instruction that produces the array object value
     */
    public AccessArrayNode(NodeClass<? extends AccessArrayNode> c, Stamp stamp, ValueNode array) {
        super(c, stamp);
        this.array = array;
    }

    public void setArray(ValueNode array) {
        updateUsages(this.array, array);
        this.array = array;
    }
}
