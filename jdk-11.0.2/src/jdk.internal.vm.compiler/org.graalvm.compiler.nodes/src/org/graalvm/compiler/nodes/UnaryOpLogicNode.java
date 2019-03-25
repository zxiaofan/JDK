/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.spi.ValueProxy;

import jdk.vm.ci.meta.TriState;

@NodeInfo
public abstract class UnaryOpLogicNode extends LogicNode implements LIRLowerable, Canonicalizable.Unary<ValueNode> {

    public static final NodeClass<UnaryOpLogicNode> TYPE = NodeClass.create(UnaryOpLogicNode.class);
    @Input protected ValueNode value;

    @Override
    public ValueNode getValue() {
        return value;
    }

    public UnaryOpLogicNode(NodeClass<? extends UnaryOpLogicNode> c, ValueNode value) {
        super(c);
        assert value != null;
        this.value = value;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
    }

    /**
     * In general the input stamp cannot be trusted, this method is reserved for the cases when it's
     * "safe" to use the input stamp. To ensure safety use
     * {@link #getSucceedingStampForValue(boolean)} instead.
     */
    public Stamp getSucceedingStampForValue(boolean negated, Stamp valueStamp) {
        Stamp succStamp = getSucceedingStampForValue(negated);
        if (succStamp != null) {
            succStamp = succStamp.join(valueStamp);
        }
        return succStamp;
    }

    /**
     * The input stamp cannot be trusted, the returned stamp cannot use the input stamp to narrow
     * itself or derive any assumptions. This method does not use the input stamp and is considered
     * safe.
     *
     * It's responsibility of the caller to determine when it's "safe" to "trust" the input stamp
     * and use {@link #getSucceedingStampForValue(boolean, Stamp)} instead.
     */
    public abstract Stamp getSucceedingStampForValue(boolean negated);

    public abstract TriState tryFold(Stamp valueStamp);

    @Override
    public TriState implies(boolean thisNegated, LogicNode other) {
        if (other instanceof UnaryOpLogicNode) {
            UnaryOpLogicNode unaryY = (UnaryOpLogicNode) other;
            if (this.getValue() == unaryY.getValue() || // fast path
                            skipThroughPisAndProxies(this.getValue()) == skipThroughPisAndProxies(unaryY.getValue())) {
                Stamp succStamp = this.getSucceedingStampForValue(thisNegated);
                TriState fold = unaryY.tryFold(succStamp);
                if (fold.isKnown()) {
                    return fold;
                }
            }
        }
        return super.implies(thisNegated, other);
    }

    private static ValueNode skipThroughPisAndProxies(ValueNode node) {
        ValueNode n = node;
        while (n != null) {
            if (n instanceof PiNode) {
                n = ((PiNode) n).getOriginalNode();
            } else if (n instanceof ValueProxy) {
                n = ((ValueProxy) n).getOriginalNode();
            } else {
                break;
            }
        }
        return n;
    }
}
