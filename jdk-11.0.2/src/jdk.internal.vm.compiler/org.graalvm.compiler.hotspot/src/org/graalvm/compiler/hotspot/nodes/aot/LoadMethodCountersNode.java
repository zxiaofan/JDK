/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.nodes.aot;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_4;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_4;

import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.iterators.NodeIterable;
import org.graalvm.compiler.hotspot.nodes.type.MethodCountersPointerStamp;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.meta.ResolvedJavaMethod;

@NodeInfo(cycles = CYCLES_4, size = SIZE_4)
public class LoadMethodCountersNode extends FloatingNode implements LIRLowerable {
    public static final NodeClass<LoadMethodCountersNode> TYPE = NodeClass.create(LoadMethodCountersNode.class);

    ResolvedJavaMethod method;

    public LoadMethodCountersNode(ResolvedJavaMethod method) {
        super(TYPE, MethodCountersPointerStamp.methodCountersNonNull());
        this.method = method;
    }

    public ResolvedJavaMethod getMethod() {
        return method;
    }

    public static NodeIterable<LoadMethodCountersNode> getLoadMethodCountersNodes(StructuredGraph graph) {
        return graph.getNodes().filter(LoadMethodCountersNode.class);
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
        // TODO: With AOT we don't need this, as this node will be replaced.
        // Implement later when profiling is needed in the JIT mode.
        throw GraalError.unimplemented();
    }
}
