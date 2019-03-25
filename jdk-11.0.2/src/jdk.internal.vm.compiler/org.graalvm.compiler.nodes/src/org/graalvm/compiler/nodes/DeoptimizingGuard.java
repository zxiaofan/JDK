/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.graph.NodeSourcePosition;
import org.graalvm.compiler.nodes.extended.GuardingNode;

/**
 * Shared interface to capture core methods of {@link AbstractFixedGuardNode} and {@link GuardNode}.
 *
 */
public interface DeoptimizingGuard extends GuardingNode, StaticDeoptimizingNode {

    LogicNode getCondition();

    void setCondition(LogicNode x, boolean negated);

    boolean isNegated();

    NodeSourcePosition getNoDeoptSuccessorPosition();

    void setNoDeoptSuccessorPosition(NodeSourcePosition noDeoptSuccessorPosition);

    default void addCallerToNoDeoptSuccessorPosition(NodeSourcePosition caller) {
        NodeSourcePosition noDeoptSuccessorPosition = getNoDeoptSuccessorPosition();
        if (noDeoptSuccessorPosition == null) {
            return;
        }
        setNoDeoptSuccessorPosition(new NodeSourcePosition(caller, noDeoptSuccessorPosition.getMethod(), noDeoptSuccessorPosition.getBCI()));
    }
}
