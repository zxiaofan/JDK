/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;

@NodeInfo(allowedUsageTypes = {InputType.Association}, nameTemplate = "End")
public final class EndNode extends AbstractEndNode {
    public static final NodeClass<EndNode> TYPE = NodeClass.create(EndNode.class);

    public EndNode() {
        super(TYPE);
    }

}
