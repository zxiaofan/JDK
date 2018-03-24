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
package org.graalvm.compiler.nodes;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.core.common.type.TypeReference;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.extended.GuardingNode;

import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * A {@link PiNode} where the type is not yet known. If the type becomes known at a later point in
 * the compilation, this can canonicalize to a regular {@link PiNode}.
 */
@NodeInfo
public final class DynamicPiNode extends PiNode {

    public static final NodeClass<DynamicPiNode> TYPE = NodeClass.create(DynamicPiNode.class);
    @Input ValueNode typeMirror;

    public DynamicPiNode(ValueNode object, GuardingNode guard, ValueNode typeMirror) {
        super(TYPE, object, StampFactory.object(), guard);
        this.typeMirror = typeMirror;
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (typeMirror.isConstant()) {
            ResolvedJavaType t = tool.getConstantReflection().asJavaType(typeMirror.asConstant());
            if (t != null) {
                Stamp staticPiStamp;
                if (t.isPrimitive()) {
                    staticPiStamp = StampFactory.alwaysNull();
                } else {
                    TypeReference type = TypeReference.createTrusted(tool.getAssumptions(), t);
                    staticPiStamp = StampFactory.object(type);
                }

                return new PiNode(object(), staticPiStamp, (ValueNode) getGuard()).canonical(tool);
            }
        }

        return this;
    }
}
