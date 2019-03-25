/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.StampPair;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.IndirectCallTargetNode;
import org.graalvm.compiler.nodes.ValueNode;

import jdk.vm.ci.code.CallingConvention.Type;
import jdk.vm.ci.meta.JavaType;
import jdk.vm.ci.meta.ResolvedJavaMethod;

@NodeInfo
public final class HotSpotIndirectCallTargetNode extends IndirectCallTargetNode {
    public static final NodeClass<HotSpotIndirectCallTargetNode> TYPE = NodeClass.create(HotSpotIndirectCallTargetNode.class);

    @Input ValueNode metaspaceMethod;

    public HotSpotIndirectCallTargetNode(ValueNode metaspaceMethod, ValueNode computedAddress, ValueNode[] arguments, StampPair returnStamp, JavaType[] signature,
                    ResolvedJavaMethod target,
                    Type callType, InvokeKind invokeKind) {
        super(TYPE, computedAddress, arguments, returnStamp, signature, target, callType, invokeKind);
        this.metaspaceMethod = metaspaceMethod;
    }

    public ValueNode metaspaceMethod() {
        return metaspaceMethod;
    }
}
