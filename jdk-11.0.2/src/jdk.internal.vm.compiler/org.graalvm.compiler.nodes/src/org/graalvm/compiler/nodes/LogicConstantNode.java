/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.graph.Graph;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

/**
 * The {@code LogicConstantNode} represents a boolean constant.
 */
@NodeInfo(nameTemplate = "{p#value}", cycles = CYCLES_0, size = SIZE_0)
public final class LogicConstantNode extends LogicNode implements LIRLowerable {

    public static final NodeClass<LogicConstantNode> TYPE = NodeClass.create(LogicConstantNode.class);
    protected final boolean value;

    public LogicConstantNode(boolean value) {
        super(TYPE);
        this.value = value;
    }

    /**
     * Returns a node for a boolean constant.
     *
     * @param v the boolean value for which to create the instruction
     * @param graph
     * @return a node representing the boolean
     */
    public static LogicConstantNode forBoolean(boolean v, Graph graph) {
        return graph.unique(new LogicConstantNode(v));
    }

    /**
     * Returns a node for a boolean constant.
     *
     * @param v the boolean value for which to create the instruction
     * @return a node representing the boolean
     */
    public static LogicConstantNode forBoolean(boolean v) {
        return new LogicConstantNode(v);
    }

    /**
     * Gets a constant for {@code true}.
     */
    public static LogicConstantNode tautology(Graph graph) {
        return forBoolean(true, graph);
    }

    /**
     * Gets a constant for {@code false}.
     */
    public static LogicConstantNode contradiction(Graph graph) {
        return forBoolean(false, graph);
    }

    /**
     * Gets a constant for {@code true}.
     */
    public static LogicConstantNode tautology() {
        return forBoolean(true);
    }

    /**
     * Gets a constant for {@code false}.
     */
    public static LogicConstantNode contradiction() {
        return forBoolean(false);
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
        // nothing to do
    }
}
