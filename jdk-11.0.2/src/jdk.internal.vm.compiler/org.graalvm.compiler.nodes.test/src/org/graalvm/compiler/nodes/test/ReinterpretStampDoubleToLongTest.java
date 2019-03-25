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
import org.graalvm.compiler.core.common.type.StampPair;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.calc.ReinterpretNode;

import jdk.vm.ci.meta.JavaKind;

@RunWith(Parameterized.class)
public class ReinterpretStampDoubleToLongTest extends ReinterpretStampTest {

    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        List<Object[]> ret = new ArrayList<>();

        for (long x : interestingLongs) {
            double lowerBound = Double.longBitsToDouble(x);
            if (Double.isNaN(lowerBound)) {
                continue;
            }

            for (long y : interestingLongs) {
                double upperBound = Double.longBitsToDouble(y);
                if (Double.isNaN(upperBound)) {
                    continue;
                }

                if (Double.compare(lowerBound, upperBound) <= 0) {
                    ret.add(new Object[]{new FloatStamp(Double.SIZE, lowerBound, upperBound, true)});
                    ret.add(new Object[]{new FloatStamp(Double.SIZE, lowerBound, upperBound, false)});
                }
            }
        }

        ret.add(new Object[]{new FloatStamp(Double.SIZE, Double.NaN, Double.NaN, false)});

        return ret;
    }

    @Parameter(value = 0) public FloatStamp inputStamp;

    @Test
    public void run() {
        ParameterNode param = new ParameterNode(0, StampPair.createSingle(inputStamp));
        ValueNode reinterpret = ReinterpretNode.create(JavaKind.Long, param, NodeView.DEFAULT);

        IntegerStamp resultStamp = (IntegerStamp) reinterpret.stamp(NodeView.DEFAULT);
        Assert.assertEquals(Long.SIZE, resultStamp.getBits());

        for (long result : interestingLongs) {
            double input = Double.longBitsToDouble(result);

            if (inputStamp.contains(input) && !resultStamp.contains(result)) {
                Assert.fail(String.format("value %f (0x%x) is in input stamp, but not in result stamp (%s)", input, result, resultStamp));
            }
        }
    }
}
