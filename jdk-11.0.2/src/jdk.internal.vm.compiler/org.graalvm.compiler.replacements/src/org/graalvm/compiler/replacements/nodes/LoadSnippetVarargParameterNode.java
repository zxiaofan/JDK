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


package org.graalvm.compiler.replacements.nodes;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.api.replacements.Snippet.VarargsParameter;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.NodeInputList;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.ValueNode;

/**
 * Implements the semantics of {@link VarargsParameter}.
 */
@NodeInfo(cycles = CYCLES_0, size = SIZE_0)
public final class LoadSnippetVarargParameterNode extends FixedWithNextNode implements Canonicalizable {

    public static final NodeClass<LoadSnippetVarargParameterNode> TYPE = NodeClass.create(LoadSnippetVarargParameterNode.class);
    @Input ValueNode index;

    @Input NodeInputList<ParameterNode> parameters;

    public LoadSnippetVarargParameterNode(ParameterNode[] locals, ValueNode index, Stamp stamp) {
        super(TYPE, stamp);
        this.index = index;
        this.parameters = new NodeInputList<>(this, locals);
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (index.isConstant()) {
            int indexValue = index.asJavaConstant().asInt();
            if (indexValue < parameters.size()) {
                return parameters.get(indexValue);
            }
        }
        return this;
    }
}
