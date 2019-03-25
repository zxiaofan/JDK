/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph.spi;

import org.graalvm.compiler.graph.Node;

/**
 * @see Simplifiable
 */
public interface SimplifierTool extends CanonicalizerTool {

    void deleteBranch(Node branch);

    /**
     * Adds a node to the worklist independent of whether it has already been on the worklist.
     */
    void addToWorkList(Node node);

    void addToWorkList(Iterable<? extends Node> nodes);

    void removeIfUnused(Node node);
}
