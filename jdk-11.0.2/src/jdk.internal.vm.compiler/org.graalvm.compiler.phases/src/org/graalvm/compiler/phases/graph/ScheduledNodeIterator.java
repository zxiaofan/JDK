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


package org.graalvm.compiler.phases.graph;

import java.util.ListIterator;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.StructuredGraph.ScheduleResult;
import org.graalvm.compiler.nodes.cfg.Block;

/**
 * Iterates over a list of nodes, which usually comes from
 * {@link ScheduleResult#getBlockToNodesMap()}.
 *
 * While iterating, it is possible to {@link #insert(FixedNode, FixedWithNextNode) insert} and
 * {@link #replaceCurrent(FixedWithNextNode) replace} nodes.
 */
public abstract class ScheduledNodeIterator {

    private FixedWithNextNode lastFixed;
    private FixedWithNextNode reconnect;
    private ListIterator<Node> iterator;

    public void processNodes(Block block, ScheduleResult schedule) {
        lastFixed = block.getBeginNode();
        assert lastFixed != null;
        reconnect = null;
        iterator = schedule.nodesFor(block).listIterator();

        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (!node.isAlive()) {
                continue;
            }
            if (reconnect != null && node instanceof FixedNode) {
                reconnect.setNext((FixedNode) node);
                reconnect = null;
            }
            if (node instanceof FixedWithNextNode) {
                lastFixed = (FixedWithNextNode) node;
            }
            processNode(node);
        }
        if (reconnect != null) {
            assert block.getSuccessorCount() == 1;
            reconnect.setNext(block.getFirstSuccessor().getBeginNode());
        }
    }

    protected void insert(FixedNode start, FixedWithNextNode end) {
        this.lastFixed.setNext(start);
        this.lastFixed = end;
        this.reconnect = end;
    }

    protected void replaceCurrent(FixedWithNextNode newNode) {
        Node current = iterator.previous();
        iterator.next(); // needed because of the previous() call
        current.replaceAndDelete(newNode);
        insert(newNode, newNode);
        iterator.set(newNode);
    }

    protected abstract void processNode(Node node);
}
