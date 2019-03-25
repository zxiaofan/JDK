/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.StampPair;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;

import jdk.vm.ci.code.CallingConvention;
import jdk.vm.ci.meta.JavaType;
import jdk.vm.ci.meta.ResolvedJavaMethod;

@NodeInfo
public abstract class LoweredCallTargetNode extends CallTargetNode {

    public static final NodeClass<LoweredCallTargetNode> TYPE = NodeClass.create(LoweredCallTargetNode.class);
    protected final JavaType[] signature;
    protected final CallingConvention.Type callType;

    protected LoweredCallTargetNode(NodeClass<? extends LoweredCallTargetNode> c, ValueNode[] arguments, StampPair returnStamp, JavaType[] signature,
                    ResolvedJavaMethod target,
                    CallingConvention.Type callType, InvokeKind invokeKind) {
        super(c, arguments, target, invokeKind, returnStamp);
        this.signature = signature;
        this.callType = callType;
    }

    public JavaType[] signature() {
        return signature;
    }

    public CallingConvention.Type callType() {
        return callType;
    }
}
