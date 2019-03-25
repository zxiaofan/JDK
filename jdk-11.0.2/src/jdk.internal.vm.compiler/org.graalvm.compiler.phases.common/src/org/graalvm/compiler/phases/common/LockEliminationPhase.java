/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.OSRMonitorEnterNode;
import org.graalvm.compiler.nodes.java.AccessMonitorNode;
import org.graalvm.compiler.nodes.java.MonitorEnterNode;
import org.graalvm.compiler.nodes.java.MonitorExitNode;
import org.graalvm.compiler.nodes.java.MonitorIdNode;
import org.graalvm.compiler.nodes.java.RawMonitorEnterNode;
import org.graalvm.compiler.nodes.util.GraphUtil;
import org.graalvm.compiler.phases.Phase;

public class LockEliminationPhase extends Phase {

    @Override
    protected void run(StructuredGraph graph) {
        for (MonitorExitNode monitorExitNode : graph.getNodes(MonitorExitNode.TYPE)) {
            FixedNode next = monitorExitNode.next();
            if ((next instanceof MonitorEnterNode || next instanceof RawMonitorEnterNode)) {
                // should never happen, osr monitor enters are always direct successors of the graph
                // start
                assert !(next instanceof OSRMonitorEnterNode);
                AccessMonitorNode monitorEnterNode = (AccessMonitorNode) next;
                if (isCompatibleLock(monitorEnterNode, monitorExitNode)) {
                    /*
                     * We've coarsened the lock so use the same monitor id for the whole region,
                     * otherwise the monitor operations appear to be unrelated.
                     */
                    MonitorIdNode enterId = monitorEnterNode.getMonitorId();
                    MonitorIdNode exitId = monitorExitNode.getMonitorId();
                    if (enterId != exitId) {
                        enterId.replaceAndDelete(exitId);
                    }
                    GraphUtil.removeFixedWithUnusedInputs(monitorEnterNode);
                    GraphUtil.removeFixedWithUnusedInputs(monitorExitNode);
                }
            }
        }
    }

    /**
     * Check that the paired operations operate on the same object at the same lock depth.
     */
    public static boolean isCompatibleLock(AccessMonitorNode lock1, AccessMonitorNode lock2) {
        /*
         * It is not always the case that sequential monitor operations on the same object have the
         * same lock depth: Escape analysis can have removed a lock operation that was in between,
         * leading to a mismatch in lock depth.
         */
        ValueNode object1 = GraphUtil.unproxify(lock1.object());
        ValueNode object2 = GraphUtil.unproxify(lock2.object());
        return object1 == object2 && lock1.getMonitorId().getLockDepth() == lock2.getMonitorId().getLockDepth();
    }
}
