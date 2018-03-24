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
package org.graalvm.compiler.hotspot.nodes;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.Lowerable;

@NodeInfo
public abstract class ArrayRangeWriteBarrier extends WriteBarrier implements Lowerable {

    public static final NodeClass<ArrayRangeWriteBarrier> TYPE = NodeClass.create(ArrayRangeWriteBarrier.class);
    @Input ValueNode object;
    @Input ValueNode startIndex;
    @Input ValueNode length;

    protected ArrayRangeWriteBarrier(NodeClass<? extends ArrayRangeWriteBarrier> c, ValueNode object, ValueNode startIndex, ValueNode length) {
        super(c);
        this.object = object;
        this.startIndex = startIndex;
        this.length = length;
    }

    public ValueNode getObject() {
        return object;
    }

    public ValueNode getStartIndex() {
        return startIndex;
    }

    public ValueNode getLength() {
        return length;
    }
}
