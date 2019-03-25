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


package org.graalvm.compiler.nodes;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampPair;
import org.graalvm.compiler.graph.IterableNodeType;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.spi.UncheckedInterfaceProvider;

/**
 * The {@code Parameter} instruction is a placeholder for an incoming argument to a function call.
 */
@NodeInfo(nameTemplate = "P({p#index})")
public final class ParameterNode extends AbstractLocalNode implements IterableNodeType, UncheckedInterfaceProvider {

    public static final NodeClass<ParameterNode> TYPE = NodeClass.create(ParameterNode.class);

    private Stamp uncheckedStamp;

    public ParameterNode(int index, StampPair stamp) {
        super(TYPE, index, stamp.getTrustedStamp());
        this.uncheckedStamp = stamp.getUncheckedStamp();
    }

    @Override
    public Stamp uncheckedStamp() {
        return uncheckedStamp;
    }
}
