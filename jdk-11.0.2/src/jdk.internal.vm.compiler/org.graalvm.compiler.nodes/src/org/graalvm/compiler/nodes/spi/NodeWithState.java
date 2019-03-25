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


package org.graalvm.compiler.nodes.spi;

import org.graalvm.compiler.graph.iterators.NodeIterable;
import org.graalvm.compiler.nodes.FixedNodeInterface;
import org.graalvm.compiler.nodes.FrameState;

/**
 * Interface for nodes which have {@link FrameState} nodes as input.
 */
public interface NodeWithState extends FixedNodeInterface {

    default NodeIterable<FrameState> states() {
        return asNode().inputs().filter(FrameState.class);
    }
}
