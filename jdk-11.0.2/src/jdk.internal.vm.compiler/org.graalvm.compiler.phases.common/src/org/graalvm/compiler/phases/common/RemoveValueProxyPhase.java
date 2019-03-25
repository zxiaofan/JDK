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


package org.graalvm.compiler.phases.common;

import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.LoopExitNode;
import org.graalvm.compiler.nodes.ProxyNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.util.GraphUtil;
import org.graalvm.compiler.phases.Phase;

public class RemoveValueProxyPhase extends Phase {

    @Override
    protected void run(StructuredGraph graph) {
        for (LoopExitNode exit : graph.getNodes(LoopExitNode.TYPE)) {
            for (ProxyNode vpn : exit.proxies().snapshot()) {
                vpn.replaceAtUsagesAndDelete(vpn.value());
            }
            FrameState stateAfter = exit.stateAfter();
            if (stateAfter != null) {
                exit.setStateAfter(null);
                if (stateAfter.hasNoUsages()) {
                    GraphUtil.killWithUnusedFloatingInputs(stateAfter);
                }
            }
        }
        graph.setHasValueProxies(false);
    }
}
