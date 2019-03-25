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


package org.graalvm.compiler.nodes.spi;

/**
 * This interface allows a node to convey information about what its effect would be if some of its
 * inputs were virtualized. The {@link #virtualize(VirtualizerTool)} method will only be called for
 * nodes that have some interaction with virtualized nodes. However, the virtualized nodes might
 * have been re-materialized in the meantime.
 */
public interface Virtualizable {

    /**
     * A node class can implement this method to convey information about what its effect would be
     * if some of its inputs were virtualized. All modifications must be made through the supplied
     * tool, and not directly on the node, because by the time this method is called the
     * virtualized/non-virtualized state is still speculative and might not hold because of loops,
     * etc.
     *
     * @param tool the tool used to describe the effects of this node
     */
    void virtualize(VirtualizerTool tool);
}
