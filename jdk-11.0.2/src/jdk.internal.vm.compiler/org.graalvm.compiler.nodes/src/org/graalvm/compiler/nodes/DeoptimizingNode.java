/*
 * Copyright (c) 2013, 2013, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.nodes.spi.NodeWithState;

/**
 * Interface implemented by nodes which may need {@linkplain FrameState deoptimization information}.
 */
public interface DeoptimizingNode extends NodeWithState {

    /**
     * Determines if this node needs deoptimization information.
     */
    boolean canDeoptimize();

    /**
     * Interface for nodes that need a {@link FrameState} for deoptimizing to a point before their
     * execution.
     */
    public interface DeoptBefore extends DeoptimizingNode {

        /**
         * Sets the {@link FrameState} describing the program state before the execution of this
         * node.
         */
        void setStateBefore(FrameState state);

        FrameState stateBefore();
    }

    /**
     * Interface for nodes that need a {@link FrameState} for deoptimizing to a point after their
     * execution.
     */
    public interface DeoptAfter extends DeoptimizingNode, StateSplit {
    }

    /**
     * Interface for nodes that need a special {@link FrameState} for deoptimizing during their
     * execution (e.g. {@link Invoke}).
     */
    public interface DeoptDuring extends DeoptimizingNode, StateSplit {

        FrameState stateDuring();

        /**
         * Sets the {@link FrameState} describing the program state during the execution of this
         * node.
         */
        void setStateDuring(FrameState state);

        /**
         * Compute the {@link FrameState} describing the program state during the execution of this
         * node from an input {@link FrameState} describing the program state after finishing the
         * execution of this node.
         */
        void computeStateDuring(FrameState stateAfter);
    }
}
