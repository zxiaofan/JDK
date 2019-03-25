/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.nodes.ReturnNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.debug.VerifyHeapNode;
import org.graalvm.compiler.phases.Phase;

public class VerifyHeapAtReturnPhase extends Phase {

    @Override
    protected void run(StructuredGraph graph) {
        for (ReturnNode returnNode : graph.getNodes(ReturnNode.TYPE)) {
            VerifyHeapNode.addBefore(returnNode);
        }
    }
}
