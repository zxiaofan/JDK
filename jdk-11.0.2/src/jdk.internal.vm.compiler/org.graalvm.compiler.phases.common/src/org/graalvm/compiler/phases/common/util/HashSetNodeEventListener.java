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


package org.graalvm.compiler.phases.common.util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import jdk.internal.vm.compiler.collections.EconomicSet;
import jdk.internal.vm.compiler.collections.Equivalence;
import org.graalvm.compiler.graph.Graph.NodeEvent;
import org.graalvm.compiler.graph.Graph.NodeEventListener;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.Node.IndirectCanonicalization;

/**
 * A simple {@link NodeEventListener} implementation that accumulates event nodes in a
 * {@link HashSet}.
 */
public class HashSetNodeEventListener extends NodeEventListener {

    private final EconomicSet<Node> nodes;
    private final Set<NodeEvent> filter;

    /**
     * Creates a {@link NodeEventListener} that collects nodes from all events.
     */
    public HashSetNodeEventListener() {
        this.nodes = EconomicSet.create(Equivalence.IDENTITY);
        this.filter = EnumSet.allOf(NodeEvent.class);
    }

    /**
     * Creates a {@link NodeEventListener} that collects nodes from all events that match a given
     * filter.
     */
    public HashSetNodeEventListener(Set<NodeEvent> filter) {
        this.nodes = EconomicSet.create(Equivalence.IDENTITY);
        this.filter = filter;
    }

    /**
     * Excludes a given event from those for which nodes are collected.
     */
    public HashSetNodeEventListener exclude(NodeEvent e) {
        filter.remove(e);
        return this;
    }

    @Override
    public void changed(NodeEvent e, Node node) {
        if (filter.contains(e)) {
            nodes.add(node);
            if (node instanceof IndirectCanonicalization) {
                for (Node usage : node.usages()) {
                    nodes.add(usage);
                }
            }
        }
    }

    /**
     * Gets the set being used to accumulate the nodes communicated to this listener.
     */
    public EconomicSet<Node> getNodes() {
        return nodes;
    }
}
