/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.graphio;

import java.util.Collection;

/**
 * Special support for dealing with blocks.
 *
 * @param <G> the type that represents the graph
 * @param <B> the type that represents the block
 * @param <N> the type of the node
 */
public interface GraphBlocks<G, B, N> {
    /**
     * All blocks in the graph.
     *
     * @param graph the graph
     * @return collection of blocks in the graph
     */
    Collection<? extends B> blocks(G graph);

    /**
     * Unique id of a block.
     *
     * @param block the block
     * @return the id of the block
     */
    int blockId(B block);

    Collection<? extends N> blockNodes(G info, B block);

    Collection<? extends B> blockSuccessors(B block);
}
