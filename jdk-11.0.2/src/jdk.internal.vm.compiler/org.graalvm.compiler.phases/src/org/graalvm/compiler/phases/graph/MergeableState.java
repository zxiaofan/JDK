/*
 * Copyright (c) 2011, 2011, Oracle and/or its affiliates. All rights reserved.
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

import java.util.List;

import org.graalvm.compiler.nodes.AbstractBeginNode;
import org.graalvm.compiler.nodes.AbstractMergeNode;
import org.graalvm.compiler.nodes.ControlSplitNode;
import org.graalvm.compiler.nodes.LoopBeginNode;
import org.graalvm.compiler.nodes.LoopEndNode;

public abstract class MergeableState<T> {

    @Override
    public abstract T clone();

    /**
     * This method is called on merge on the state of the first branch. The {@code withStates} list
     * contains the states of the of the other branches in the order of the merge's end nodes.
     *
     * @param merge the merge node
     * @param withStates the state at the merge's end node except the first one.
     */
    public abstract boolean merge(AbstractMergeNode merge, List<T> withStates);

    /**
     * This method is called before a loop is entered (before the {@link LoopBeginNode} is visited).
     *
     * @param loopBegin the begin node of the loop
     */
    public void loopBegin(LoopBeginNode loopBegin) {
        // empty default implementation
    }

    /**
     * This method is called after all {@link LoopEndNode}s belonging to a loop have been visited.
     *
     * @param loopBegin the begin node of the loop
     * @param loopEndStates the states at the loop ends, sorted according to
     *            {@link LoopBeginNode#orderedLoopEnds()}
     */
    public void loopEnds(LoopBeginNode loopBegin, List<T> loopEndStates) {
        // empty default implementation
    }

    /**
     * This method is called before the successors of a {@link ControlSplitNode} are visited.
     *
     * @param node the successor of the control split that is about to be visited
     */
    public void afterSplit(AbstractBeginNode node) {
        // empty default implementation
    }
}
