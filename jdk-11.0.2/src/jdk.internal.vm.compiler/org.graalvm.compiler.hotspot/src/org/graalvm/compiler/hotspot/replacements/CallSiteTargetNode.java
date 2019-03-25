/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.replacements;

import org.graalvm.compiler.core.common.type.StampPair;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.CallTargetNode.InvokeKind;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.InvokeNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.replacements.nodes.MacroStateSplitNode;

import jdk.vm.ci.hotspot.HotSpotObjectConstant;
import jdk.vm.ci.meta.Assumptions;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.MetaAccessProvider;
import jdk.vm.ci.meta.ResolvedJavaMethod;

@NodeInfo
public final class CallSiteTargetNode extends MacroStateSplitNode implements Canonicalizable, Lowerable {

    public static final NodeClass<CallSiteTargetNode> TYPE = NodeClass.create(CallSiteTargetNode.class);

    public CallSiteTargetNode(InvokeKind invokeKind, ResolvedJavaMethod targetMethod, int bci, StampPair returnStamp, ValueNode receiver) {
        super(TYPE, invokeKind, targetMethod, bci, returnStamp, receiver);
    }

    private ValueNode getCallSite() {
        return arguments.get(0);
    }

    public static ConstantNode tryFold(ValueNode callSite, MetaAccessProvider metaAccess, Assumptions assumptions) {
        if (callSite != null && callSite.isConstant() && !callSite.isNullConstant()) {
            HotSpotObjectConstant c = (HotSpotObjectConstant) callSite.asConstant();
            JavaConstant target = c.getCallSiteTarget(assumptions);
            if (target != null) {
                return ConstantNode.forConstant(target, metaAccess);
            }
        }
        return null;
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        ConstantNode target = tryFold(getCallSite(), tool.getMetaAccess(), graph().getAssumptions());
        if (target != null) {
            return target;
        }

        return this;
    }

    @Override
    public void lower(LoweringTool tool) {
        ConstantNode target = tryFold(getCallSite(), tool.getMetaAccess(), graph().getAssumptions());

        if (target != null) {
            graph().replaceFixedWithFloating(this, target);
        } else {
            InvokeNode invoke = createInvoke();
            graph().replaceFixedWithFixed(this, invoke);
            invoke.lower(tool);
        }
    }
}
