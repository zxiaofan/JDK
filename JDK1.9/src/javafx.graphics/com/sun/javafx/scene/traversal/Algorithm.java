/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package com.sun.javafx.scene.traversal;

import javafx.scene.Node;

/**
 * An algorithm to be used in a traversal engine.
 *
 * Note that in order to avoid cycles or dead-ends in traversal the algorithms should respect the following order:
 * * for NEXT: node -> node's subtree -> node siblings (first sibling then it's subtree) -> NEXT_IN_LINE for node's parent
 * * for NEXT_IN_LINE: node -> node siblings (first sibling then it's subtree) -> NEXT_IN_LINE for node's parent
 * * for PREVIOUS: node -> node siblings ( ! first subtree then the node itself ! ) -> PREVIOUS for node's parent
 *
 * Basically it ensures that next direction will traverse the same nodes as previous, in the opposite order.
 *
 */
public interface Algorithm {

    /**
     * Traverse from owner, in direction dir.
     * Return a the new target Node or null if no suitable target is found.
     *
     * Typically, the implementation of override algorithm handles only parent's direct children and looks like this:
     * 1) Find the nearest parent of the "owner" that is handled by this algorithm (i.e. it's a direct child of the root).
     * 2) select the next node within this direct child using the context.selectInSubtree() and return it
     * 2a) if no such node exists, move to the next direct child in the direction (this is where the different order of direct children is defined)
     *     or if direct children are not traversable, the select the first node in the next direct child
     */
    public Node select(Node owner, Direction dir, TraversalContext context);

    /**
     * Return the first traversable node for the specified context (root).
     * @param context the context that contains the root
     * @return the first node
     */
    public Node selectFirst(TraversalContext context);

    /**
     * Return the last traversable node for the specified context (root).
     * @param context the context that contains the root
     * @return the last node
     */
    public Node selectLast(TraversalContext context);

}
