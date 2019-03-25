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


package org.graalvm.compiler.nodes.extended;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.IterableNodeType;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.AbstractLocalNode;

@NodeInfo(nameTemplate = "OSRLocal({p#index})")
public final class OSRLocalNode extends AbstractLocalNode implements IterableNodeType {

    public static final NodeClass<OSRLocalNode> TYPE = NodeClass.create(OSRLocalNode.class);

    public OSRLocalNode(int index, Stamp stamp) {
        super(TYPE, index, stamp);
    }

}
