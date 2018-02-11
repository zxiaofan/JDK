/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.util.List;

public interface TraversalContext {

    /**
     * Returns all possible targets within the context
     */
    List<Node> getAllTargetNodes();

    /**
     * Returns layout bounds of the Node in the relevant (Sub)Scene. Note that these bounds are the most important for traversal
     * as they define the final position within the scene.
     */
    Bounds getSceneLayoutBounds(Node node);

    /**
     * The root for this context, Traversal should be done only within the root
     */
    Parent getRoot();

    /**
     * If the TraversalEngine does not want to handle traversal inside some inner child (Parent), it can use this method to apply
     * default algorithm inside that Parent and return the first Node
     */
    Node selectFirstInParent(Parent parent);

    /**
     * If the TraversalEngine does not want to handle traversal inside some inner child (Parent), it can use this method to apply
     * default algorithm inside that Parent and return the last Node
     */
    Node selectLastInParent(Parent parent);

    /**
     * If the TraversalEngine does not want to handle traversal inside some inner child (Parent), it can use this method to apply
     * default algorithm inside that Parent and return the next Node within the Parent or null if there's no successor.
     * @param  subTreeRoot this will be used as a root of the traversal. Should be a Node that is still handled by the current TraversalEngine,
     *                     but it's content is not.
     */
    Node selectInSubtree(Parent subTreeRoot, Node from, Direction dir);
}
