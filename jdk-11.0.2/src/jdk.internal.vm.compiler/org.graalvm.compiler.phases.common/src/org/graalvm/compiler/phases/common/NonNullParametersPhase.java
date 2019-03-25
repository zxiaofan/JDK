/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.common;

import org.graalvm.compiler.core.common.type.ObjectStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.Phase;

/**
 * Modifies the stamp of all object {@linkplain ParameterNode parameters} in a graph to denote they
 * are non-null. This can be used for graphs where the caller null checks all arguments.
 */
public class NonNullParametersPhase extends Phase {

    @Override
    protected void run(StructuredGraph graph) {
        Stamp nonNull = StampFactory.objectNonNull();
        for (ParameterNode param : graph.getNodes(ParameterNode.TYPE)) {
            if (param.stamp(NodeView.DEFAULT) instanceof ObjectStamp) {
                ObjectStamp paramStamp = (ObjectStamp) param.stamp(NodeView.DEFAULT);
                param.setStamp(paramStamp.join(nonNull));
            }
        }
    }
}
