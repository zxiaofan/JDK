/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.loop.LoopEx;
import org.graalvm.compiler.loop.LoopsData;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.nodes.LoopEndNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.cfg.Block;
import org.graalvm.compiler.nodes.extended.ForeignCallNode;
import org.graalvm.compiler.phases.BasePhase;
import org.graalvm.compiler.phases.tiers.MidTierContext;

public class LoopSafepointEliminationPhase extends BasePhase<MidTierContext> {

    @Override
    protected void run(StructuredGraph graph, MidTierContext context) {
        LoopsData loops = new LoopsData(graph);
        if (context.getOptimisticOptimizations().useLoopLimitChecks(graph.getOptions()) && graph.getGuardsStage().allowsFloatingGuards()) {
            loops.detectedCountedLoops();
            for (LoopEx loop : loops.countedLoops()) {
                if (loop.loop().getChildren().isEmpty() && loop.counted().getStamp().getBits() <= 32) {
                    boolean hasSafepoint = false;
                    for (LoopEndNode loopEnd : loop.loopBegin().loopEnds()) {
                        hasSafepoint |= loopEnd.canSafepoint();
                    }
                    if (hasSafepoint) {
                        loop.counted().createOverFlowGuard();
                        loop.loopBegin().disableSafepoint();
                    }
                }
            }
        }
        for (LoopEx loop : loops.loops()) {
            for (LoopEndNode loopEnd : loop.loopBegin().loopEnds()) {
                Block b = loops.getCFG().blockFor(loopEnd);
                blocks: while (b != loop.loop().getHeader()) {
                    assert b != null;
                    for (FixedNode node : b.getNodes()) {
                        if (node instanceof Invoke || (node instanceof ForeignCallNode && ((ForeignCallNode) node).isGuaranteedSafepoint())) {
                            loopEnd.disableSafepoint();
                            break blocks;
                        }
                    }
                    b = b.getDominator();
                }
            }
        }
        loops.deleteUnusedNodes();
    }
}
