/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph;

/**
 * An entity that depends upon {@linkplain Graph#maybeCompress() stable} node identifiers.
 */
class NodeIdAccessor {
    final Graph graph;
    final int epoch;

    NodeIdAccessor(Graph graph) {
        this.graph = graph;
        this.epoch = graph.compressions;
    }

    Graph getGraph() {
        return graph;
    }

    /**
     * Verifies that node identifiers have not changed since this object was created.
     *
     * @return true if the check succeeds
     * @throws VerificationError if the check fails
     */
    boolean verifyIdsAreStable() {
        int compressions = graph.compressions - epoch;
        if (compressions != 0) {
            throw new VerificationError("accessing node id in %s across %d graph compression%s", graph, compressions, compressions == 1 ? "" : "s");
        }
        return true;
    }

    /**
     * Gets the identifier for a node. If assertions are enabled, this method asserts that the
     * identifier is stable.
     */
    int getNodeId(Node node) {
        assert verifyIdsAreStable();
        return node.id();
    }
}
