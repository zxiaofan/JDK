/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.jmx;

import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * This interface serves as an algorithm to retrieve Scene-graph structure.
 */
public interface MXNodeAlgorithm {

    /**
     * Method for processing leaf nodes.
     *
     * @param node node to be processed
     * @param ctx current context
     * @return algorithm specific result for the node
     */
    Object processLeafNode(Node node, MXNodeAlgorithmContext ctx);

    /**
     * Method for processing container nodes ({@link Parent}, {@link javafx.scene.Group}, etc.).
     *
     * @param parent container node to be processed
     * @param ctx current context
     * @return algorithm specific result for the container node
     */
    Object processContainerNode(Parent parent, MXNodeAlgorithmContext ctx);

}
