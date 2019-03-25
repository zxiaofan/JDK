/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.GuardingNode;
import org.graalvm.compiler.nodes.java.LoadIndexedNode;

import jdk.vm.ci.meta.JavaKind;

@NodeInfo
public final class LoadIndexedPointerNode extends LoadIndexedNode {

    public static final NodeClass<LoadIndexedPointerNode> TYPE = NodeClass.create(LoadIndexedPointerNode.class);

    public LoadIndexedPointerNode(Stamp stamp, ValueNode array, ValueNode index, GuardingNode boundsCheck) {
        super(TYPE, stamp, array, index, boundsCheck, JavaKind.Illegal);
    }

    @Override
    public boolean inferStamp() {
        return false;
    }
}
