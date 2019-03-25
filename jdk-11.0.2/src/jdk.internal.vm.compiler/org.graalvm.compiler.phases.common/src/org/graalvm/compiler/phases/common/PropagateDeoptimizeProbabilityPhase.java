/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.common;

import jdk.internal.vm.compiler.collections.EconomicMap;
import jdk.internal.vm.compiler.collections.EconomicSet;
import jdk.internal.vm.compiler.collections.MapCursor;
import org.graalvm.compiler.graph.NodeStack;
import org.graalvm.compiler.nodes.AbstractBeginNode;
import org.graalvm.compiler.nodes.AbstractDeoptimizeNode;
import org.graalvm.compiler.nodes.AbstractEndNode;
import org.graalvm.compiler.nodes.AbstractMergeNode;
import org.graalvm.compiler.nodes.ControlSplitNode;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.BasePhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

/**
 * This phase will make sure that the branch leading towards this deopt has 0.0 probability.
 *
 */
public class PropagateDeoptimizeProbabilityPhase extends BasePhase<PhaseContext> {

    @Override
    @SuppressWarnings("try")
    protected void run(final StructuredGraph graph, PhaseContext context) {
        assert !graph.hasValueProxies() : "ConvertDeoptimizeToGuardPhase always creates proxies";

        if (graph.hasNode(AbstractDeoptimizeNode.TYPE)) {

            NodeStack stack = new NodeStack();
            EconomicMap<ControlSplitNode, EconomicSet<AbstractBeginNode>> reachableSplits = EconomicMap.create();

            // Mark all control flow nodes that are post-dominated by a deoptimization.
            for (AbstractDeoptimizeNode d : graph.getNodes(AbstractDeoptimizeNode.TYPE)) {
                stack.push(AbstractBeginNode.prevBegin(d));
                while (!stack.isEmpty()) {
                    AbstractBeginNode beginNode = (AbstractBeginNode) stack.pop();
                    FixedNode fixedNode = (FixedNode) beginNode.predecessor();

                    if (fixedNode == null) {
                        // Can happen for start node.
                    } else if (fixedNode instanceof AbstractMergeNode) {
                        AbstractMergeNode mergeNode = (AbstractMergeNode) fixedNode;
                        for (AbstractEndNode end : mergeNode.forwardEnds()) {
                            AbstractBeginNode newBeginNode = AbstractBeginNode.prevBegin(end);
                            stack.push(newBeginNode);
                        }
                    } else if (fixedNode instanceof ControlSplitNode) {
                        ControlSplitNode controlSplitNode = (ControlSplitNode) fixedNode;
                        EconomicSet<AbstractBeginNode> reachableSuccessors = reachableSplits.get(controlSplitNode);
                        if (reachableSuccessors == null) {
                            reachableSuccessors = EconomicSet.create();
                            reachableSplits.put(controlSplitNode, reachableSuccessors);
                        }

                        if (controlSplitNode.getSuccessorCount() == reachableSuccessors.size() - 1) {
                            // All successors of this split lead to deopt, propagate reachability
                            // further upwards.
                            reachableSplits.removeKey(controlSplitNode);
                            stack.push(AbstractBeginNode.prevBegin((FixedNode) controlSplitNode.predecessor()));
                        } else {
                            reachableSuccessors.add(beginNode);
                        }
                    } else {
                        stack.push(AbstractBeginNode.prevBegin(fixedNode));
                    }
                }
            }

            // Make sure the probability on the path towards the deoptimization is 0.0.
            MapCursor<ControlSplitNode, EconomicSet<AbstractBeginNode>> entries = reachableSplits.getEntries();
            while (entries.advance()) {
                ControlSplitNode controlSplitNode = entries.getKey();
                EconomicSet<AbstractBeginNode> value = entries.getValue();
                for (AbstractBeginNode begin : value) {
                    double probability = controlSplitNode.probability(begin);
                    if (probability != 0.0) {
                        controlSplitNode.setProbability(begin, 0.0);
                    }
                }
            }
        }
    }
}
