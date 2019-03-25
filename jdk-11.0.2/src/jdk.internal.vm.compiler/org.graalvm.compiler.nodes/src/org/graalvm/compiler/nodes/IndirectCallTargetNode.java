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
public class IndirectCallTargetNode extends LoweredCallTargetNode {
    public static final NodeClass<IndirectCallTargetNode> TYPE = NodeClass.create(IndirectCallTargetNode.class);

    @Input protected ValueNode computedAddress;

    public IndirectCallTargetNode(ValueNode computedAddress, ValueNode[] arguments, StampPair returnStamp, JavaType[] signature, ResolvedJavaMethod target,
                    CallingConvention.Type callType,
                    InvokeKind invokeKind) {
        this(TYPE, computedAddress, arguments, returnStamp, signature, target, callType, invokeKind);
    }

    protected IndirectCallTargetNode(NodeClass<? extends IndirectCallTargetNode> c, ValueNode computedAddress, ValueNode[] arguments, StampPair returnStamp,
                    JavaType[] signature,
                    ResolvedJavaMethod target, CallingConvention.Type callType, InvokeKind invokeKind) {
        super(c, arguments, returnStamp, signature, target, callType, invokeKind);
        this.computedAddress = computedAddress;
    }

    public ValueNode computedAddress() {
        return computedAddress;
    }

    @Override
    public String targetName() {
        if (targetMethod() == null) {
            return "[unknown]";
        }
        return targetMethod().format("Indirect#%h.%n");
    }
}
