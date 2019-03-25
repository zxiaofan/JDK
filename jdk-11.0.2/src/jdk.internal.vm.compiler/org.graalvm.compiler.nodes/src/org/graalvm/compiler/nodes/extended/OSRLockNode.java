/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

@NodeInfo(nameTemplate = "OSRLock({p#index})")
public class OSRLockNode extends AbstractLocalNode implements IterableNodeType {

    public static final NodeClass<OSRLockNode> TYPE = NodeClass.create(OSRLockNode.class);

    public OSRLockNode(int index, Stamp stamp) {
        super(TYPE, index, stamp);
    }
}
