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


package org.graalvm.compiler.nodes;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_IGNORED;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_IGNORED;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.NodeInputList;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

/**
 * A node that results in a platform dependent breakpoint instruction being emitted. A number of
 * arguments can be associated with such a node for placing values of interest in the Java ABI
 * specified parameter locations corresponding to the kinds of the values. That is, the arguments
 * are set up as if the breakpoint instruction was a call to a compiled Java method.
 * <p>
 * A breakpoint is usually place by defining a node intrinsic method as follows:
 *
 * <pre>
 *     {@literal @}NodeIntrinsic(BreakpointNode.class)
 *     static void breakpoint(Object object, Word mark, Word value) {
 *          throw new GraalError("");
 *     }
 * </pre>
 *
 * Note that the signature is arbitrary. It's sole purpose is to capture values you may want to
 * inspect in the native debugger when the breakpoint is hit.
 */
@NodeInfo(cycles = CYCLES_IGNORED, size = SIZE_IGNORED)
public final class BreakpointNode extends FixedWithNextNode implements LIRLowerable {

    public static final NodeClass<BreakpointNode> TYPE = NodeClass.create(BreakpointNode.class);
    @Input NodeInputList<ValueNode> arguments;

    public BreakpointNode(ValueNode... arguments) {
        super(TYPE, StampFactory.forVoid());
        this.arguments = new NodeInputList<>(this, arguments);
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        gen.visitBreakpointNode(this);
    }

    public NodeInputList<ValueNode> arguments() {
        return arguments;
    }

    @NodeIntrinsic
    public static native void breakpoint();
}
