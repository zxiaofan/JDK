/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2017, Red Hat Inc. All rights reserved.
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



package org.graalvm.compiler.core.aarch64;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.calc.SignExtendNode;
import org.graalvm.compiler.nodes.calc.ZeroExtendNode;
import org.graalvm.compiler.nodes.memory.ReadNode;
import org.graalvm.compiler.phases.Phase;

/**
 * AArch64-specific phase which substitutes certain read nodes with arch-specific variants in order
 * to allow merging of zero and sign extension into the read operation.
 */

public class AArch64ReadReplacementPhase extends Phase {
    @Override
    protected void run(StructuredGraph graph) {
        for (Node node : graph.getNodes()) {
            // don't process nodes we just added
            if (node instanceof AArch64ReadNode) {
                continue;
            }
            if (node instanceof ReadNode) {
                ReadNode readNode = (ReadNode) node;
                if (readNode.hasExactlyOneUsage()) {
                    Node usage = readNode.getUsageAt(0);
                    if (usage instanceof ZeroExtendNode || usage instanceof SignExtendNode) {
                        AArch64ReadNode.replace(readNode);
                    }
                }
            }
        }
    }
}
