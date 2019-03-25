/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.util;

import java.util.List;
import java.util.function.Function;

import org.graalvm.compiler.nodes.AbstractMergeNode;
import org.graalvm.compiler.nodes.ControlSinkNode;
import org.graalvm.compiler.nodes.EndNode;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.PhiNode;
import org.graalvm.compiler.nodes.ReturnNode;
import org.graalvm.compiler.nodes.UnwindNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.ValuePhiNode;

public class ValueMergeUtil {

    public static ValueNode mergeReturns(AbstractMergeNode merge, List<? extends ReturnNode> returnNodes) {
        return mergeValueProducers(merge, returnNodes, null, returnNode -> returnNode.result());
    }

    public static <T> ValueNode mergeValueProducers(AbstractMergeNode merge, List<? extends T> valueProducers, Function<T, FixedWithNextNode> lastInstrFunction, Function<T, ValueNode> valueFunction) {
        ValueNode singleResult = null;
        PhiNode phiResult = null;
        for (T valueProducer : valueProducers) {
            ValueNode result = valueFunction.apply(valueProducer);
            if (result != null) {
                if (phiResult == null && (singleResult == null || singleResult == result)) {
                    /* Only one result value, so no need yet for a phi node. */
                    singleResult = result;
                } else if (phiResult == null) {
                    /* Found a second result value, so create phi node. */
                    phiResult = merge.graph().addWithoutUnique(new ValuePhiNode(result.stamp(NodeView.DEFAULT).unrestricted(), merge));
                    for (int i = 0; i < merge.forwardEndCount(); i++) {
                        phiResult.addInput(singleResult);
                    }
                    phiResult.addInput(result);

                } else {
                    /* Multiple return values, just add to existing phi node. */
                    phiResult.addInput(result);
                }
            }

            // create and wire up a new EndNode
            EndNode endNode = merge.graph().add(new EndNode());
            merge.addForwardEnd(endNode);
            if (lastInstrFunction == null) {
                assert valueProducer instanceof ReturnNode || valueProducer instanceof UnwindNode;
                ((ControlSinkNode) valueProducer).replaceAndDelete(endNode);
            } else {
                FixedWithNextNode lastInstr = lastInstrFunction.apply(valueProducer);
                lastInstr.setNext(endNode);
            }
        }

        if (phiResult != null) {
            assert phiResult.verify();
            phiResult.inferStamp();
            return phiResult;
        } else {
            return singleResult;
        }
    }
}
