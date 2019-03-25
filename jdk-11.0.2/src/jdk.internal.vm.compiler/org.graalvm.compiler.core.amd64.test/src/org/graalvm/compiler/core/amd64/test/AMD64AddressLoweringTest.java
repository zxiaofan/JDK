/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.amd64.test;

import static org.junit.Assume.assumeTrue;

import org.graalvm.compiler.asm.amd64.AMD64Address.Scale;
import org.graalvm.compiler.core.amd64.AMD64AddressLowering;
import org.graalvm.compiler.core.amd64.AMD64AddressNode;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.AddNode;
import org.graalvm.compiler.nodes.calc.LeftShiftNode;
import org.graalvm.compiler.nodes.calc.NegateNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jdk.vm.ci.amd64.AMD64;

public class AMD64AddressLoweringTest extends GraalCompilerTest {

    private StructuredGraph graph;
    private AMD64AddressLowering lowering;

    @Before
    public void checkAMD64() {
        assumeTrue("skipping AMD64 specific test", getTarget().arch instanceof AMD64);
        graph = new StructuredGraph.Builder(getInitialOptions(), getDebugContext()).build();
        lowering = new AMD64AddressLowering();
    }

    @Test
    public void convertBaseAndIndexToDisplacement() {
        ValueNode base = graph.unique(const64(1000));
        ValueNode index = graph.unique(const64(10));
        AddressNode result = lowering.lower(base, index);
        assertAddress(result, null, null, Scale.Times1, 1010);
    }

    @Test
    public void convertBaseToDisplacement() {
        ValueNode constantAddress = graph.addOrUniqueWithInputs(const64(1000));
        AddressNode result = lowering.lower(constantAddress, null);
        assertAddress(result, null, null, Scale.Times1, 1000);
    }

    @Test
    public void convertBaseAndShiftedIndexToDisplacement() {
        ValueNode base = graph.addOrUniqueWithInputs(const64(1000));
        ValueNode index = graph.addOrUniqueWithInputs(new LeftShiftNode(const64(10), const32(1)));
        AddressNode result = lowering.lower(base, index);
        assertAddress(result, null, null, Scale.Times2, 1020);
    }

    @Test
    public void convertBaseAndNegatedShiftedIndexToDisplacement() {
        ValueNode base = graph.addOrUniqueWithInputs(const64(1000));
        ValueNode index = graph.addOrUniqueWithInputs(new NegateNode(new LeftShiftNode(const64(10), const32(2))));
        AddressNode result = lowering.lower(base, index);
        assertAddress(result, null, null, Scale.Times4, 960);
    }

    @Test
    public void convertNegatedBaseAndNegatedShiftedIndexToDisplacement() {
        ValueNode base = graph.addOrUniqueWithInputs(new NegateNode(const64(1000)));
        ValueNode index = graph.addOrUniqueWithInputs(new NegateNode(new LeftShiftNode(const64(10), const32(2))));
        AddressNode result = lowering.lower(base, index);
        assertAddress(result, null, null, Scale.Times4, -1040);
    }

    @Test
    public void convertNegatedShiftedBaseAndNegatedIndexToDisplacement() {
        ValueNode base = graph.addOrUniqueWithInputs(new NegateNode(new LeftShiftNode(const64(10), const32(2))));
        ValueNode index = graph.addOrUniqueWithInputs(new NegateNode(const64(1000)));
        AddressNode result = lowering.lower(base, index);
        assertAddress(result, null, null, Scale.Times4, -1040);
    }

    @Test
    public void convertTwoLevelsOfNegatedShiftedBaseAndNegatedIndexToDisplacement() {
        ValueNode base = graph.addOrUniqueWithInputs(new NegateNode(new LeftShiftNode(new NegateNode(new LeftShiftNode(const64(500), const32(1))), const32(1))));
        ValueNode index = graph.addOrUniqueWithInputs(new NegateNode(new AddNode(new NegateNode(const64(13)), const64(3))));
        AddressNode result = lowering.lower(base, index);
        assertAddress(result, null, null, Scale.Times4, 2010);
    }

    private static ConstantNode const64(long value) {
        return ConstantNode.forIntegerBits(Long.SIZE, value);
    }

    private static ConstantNode const32(long value) {
        return ConstantNode.forIntegerBits(Integer.SIZE, value);
    }

    private static void assertAddress(AddressNode actual, ValueNode expectedBase, ValueNode expectedIndex, Scale expectedScale, int expectedDisplacement) {
        AMD64AddressNode address = (AMD64AddressNode) actual;
        Assert.assertEquals(expectedBase, address.getBase());
        Assert.assertEquals(expectedIndex, address.getIndex());
        Assert.assertEquals(expectedScale, address.getScale());
        Assert.assertEquals(expectedDisplacement, address.getDisplacement());
    }
}
