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


package org.graalvm.compiler.nodes.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org.graalvm.compiler.core.common.type.FloatStamp;
import org.graalvm.compiler.core.common.type.IntegerStamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.core.common.type.StampPair;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.calc.ReinterpretNode;

import jdk.vm.ci.meta.JavaKind;

@RunWith(Parameterized.class)
public class ReinterpretStampIntToFloatTest extends ReinterpretStampTest {

    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        List<Object[]> ret = new ArrayList<>();

        for (int lowerBound : interestingInts) {
            for (int upperBound : interestingInts) {
                if (lowerBound <= upperBound) {
                    ret.add(new Object[]{StampFactory.forInteger(JavaKind.Int, lowerBound, upperBound)});
                }
                if ((lowerBound & ~upperBound) == 0) {
                    ret.add(new Object[]{IntegerStamp.stampForMask(Integer.SIZE, lowerBound & 0xFFFF_FFFFL, upperBound & 0xFFFF_FFFFL)});
                }
            }
        }

        return ret;
    }

    @Parameter(value = 0) public IntegerStamp inputStamp;

    @Test
    public void run() {
        ParameterNode param = new ParameterNode(0, StampPair.createSingle(inputStamp));
        ValueNode reinterpret = ReinterpretNode.create(JavaKind.Float, param, NodeView.DEFAULT);
        reinterpret.inferStamp();

        FloatStamp resultStamp = (FloatStamp) reinterpret.stamp(NodeView.DEFAULT);
        Assert.assertEquals(Float.SIZE, resultStamp.getBits());

        for (int input : interestingInts) {
            float result = Float.intBitsToFloat(input);

            if (inputStamp.contains(input) && !resultStamp.contains(result)) {
                Assert.fail(String.format("value 0x%x (%f) is in input stamp, but not in result stamp (%s)", input, result, resultStamp));
            }
        }
    }
}
