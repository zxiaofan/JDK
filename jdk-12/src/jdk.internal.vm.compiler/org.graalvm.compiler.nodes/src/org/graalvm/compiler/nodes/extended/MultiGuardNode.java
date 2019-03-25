/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.extended;

import static org.graalvm.compiler.nodeinfo.InputType.Guard;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.NodeInputList;
import org.graalvm.compiler.graph.spi.Simplifiable;
import org.graalvm.compiler.graph.spi.SimplifierTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.util.GraphUtil;

@NodeInfo(allowedUsageTypes = Guard, cycles = CYCLES_0, size = SIZE_0)
public final class MultiGuardNode extends FloatingNode implements GuardingNode, LIRLowerable, Simplifiable, Node.ValueNumberable {
    public static final NodeClass<MultiGuardNode> TYPE = NodeClass.create(MultiGuardNode.class);

    @OptionalInput(Guard) NodeInputList<ValueNode> guards;

    public MultiGuardNode(ValueNode... guards) {
        super(TYPE, StampFactory.forVoid());
        this.guards = new NodeInputList<>(this, guards);
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
    }

    @Override
    public void simplify(SimplifierTool tool) {
        if (usages().filter(node -> node instanceof ValueAnchorNode).isNotEmpty()) {
            /*
             * For ValueAnchorNode usages, we can optimize MultiGuardNodes away if they depend on
             * zero or one floating nodes (as opposed to fixed nodes).
             */
            Node singleFloatingGuard = null;
            for (ValueNode guard : guards) {
                if (GraphUtil.isFloatingNode(guard)) {
                    if (singleFloatingGuard == null) {
                        singleFloatingGuard = guard;
                    } else if (singleFloatingGuard != guard) {
                        return;
                    }
                }
            }
            for (Node usage : usages().snapshot()) {
                if (usage instanceof ValueAnchorNode) {
                    usage.replaceFirstInput(this, singleFloatingGuard);
                    tool.addToWorkList(usage);
                }
            }
            if (usages().isEmpty()) {
                GraphUtil.killWithUnusedFloatingInputs(this);
            }
        }
    }

    public void addGuard(GuardingNode g) {
        this.guards.add(g.asNode());
    }

    public static GuardingNode combine(GuardingNode first, GuardingNode second) {
        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        } else {
            StructuredGraph graph = first.asNode().graph();
            return graph.unique(new MultiGuardNode(first.asNode(), second.asNode()));
        }
    }

    public static GuardingNode addGuard(GuardingNode first, GuardingNode second) {
        if (first instanceof MultiGuardNode && second != null) {
            MultiGuardNode multi = (MultiGuardNode) first;
            multi.addGuard(second);
            return multi;
        } else {
            return combine(first, second);
        }
    }
}
