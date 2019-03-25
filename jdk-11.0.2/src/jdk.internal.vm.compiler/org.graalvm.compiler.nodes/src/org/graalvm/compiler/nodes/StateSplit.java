/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
 * A state split is a node that may have a frame state associated with it.
 */
public interface StateSplit extends NodeWithState {

    /**
     * Gets the {@link FrameState} corresponding to the state of the JVM after execution of this
     * node.
     */
    FrameState stateAfter();

    /**
     * Sets the {@link FrameState} corresponding to the state of the JVM after execution of this
     * node.
     */
    void setStateAfter(FrameState x);

    /**
     * Determines if this node has a side-effect. Such nodes cannot be safely re-executed because
     * they modify state which is visible to other threads or modify state beyond what is captured
     * in {@link FrameState} nodes.
     */
    boolean hasSideEffect();
}
