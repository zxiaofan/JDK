/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.loop.phases;

import java.util.Iterator;
import java.util.List;

import org.graalvm.compiler.debug.CounterKey;
import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.loop.LoopEx;
import org.graalvm.compiler.loop.LoopPolicies;
import org.graalvm.compiler.loop.LoopsData;
import org.graalvm.compiler.nodes.AbstractBeginNode;
import org.graalvm.compiler.nodes.ControlSplitNode;
import org.graalvm.compiler.nodes.StructuredGraph;

public class LoopUnswitchingPhase extends ContextlessLoopPhase<LoopPolicies> {
    private static final CounterKey UNSWITCHED = DebugContext.counter("Unswitched");
    private static final CounterKey UNSWITCH_CANDIDATES = DebugContext.counter("UnswitchCandidates");
    private static final CounterKey UNSWITCH_EARLY_REJECTS = DebugContext.counter("UnswitchEarlyRejects");

    public LoopUnswitchingPhase(LoopPolicies policies) {
        super(policies);
    }

    @Override
    protected void run(StructuredGraph graph) {
        DebugContext debug = graph.getDebug();
        if (graph.hasLoops()) {
            boolean unswitched;
            do {
                unswitched = false;
                final LoopsData dataUnswitch = new LoopsData(graph);
                for (LoopEx loop : dataUnswitch.outerFirst()) {
                    if (getPolicies().shouldTryUnswitch(loop)) {
                        List<ControlSplitNode> controlSplits = LoopTransformations.findUnswitchable(loop);
                        if (controlSplits != null) {
                            UNSWITCH_CANDIDATES.increment(debug);
                            if (getPolicies().shouldUnswitch(loop, controlSplits)) {
                                if (debug.isLogEnabled()) {
                                    logUnswitch(loop, controlSplits);
                                }
                                LoopTransformations.unswitch(loop, controlSplits);
                                debug.dump(DebugContext.DETAILED_LEVEL, graph, "After unswitch %s", controlSplits);
                                UNSWITCHED.increment(debug);
                                unswitched = true;
                                break;
                            }
                        }
                    } else {
                        UNSWITCH_EARLY_REJECTS.increment(debug);
                    }
                }
            } while (unswitched);
        }
    }

    private static void logUnswitch(LoopEx loop, List<ControlSplitNode> controlSplits) {
        StringBuilder sb = new StringBuilder("Unswitching ");
        sb.append(loop).append(" at ");
        for (ControlSplitNode controlSplit : controlSplits) {
            sb.append(controlSplit).append(" [");
            Iterator<Node> it = controlSplit.successors().iterator();
            while (it.hasNext()) {
                sb.append(controlSplit.probability((AbstractBeginNode) it.next()));
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        loop.entryPoint().getDebug().log("%s", sb);
    }

    @Override
    public float codeSizeIncrease() {
        return 10.0f;
    }
}
