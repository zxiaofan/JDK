/*
 * Copyright (c) 2009, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.java;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_2;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_1;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.ArrayLengthProvider;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.nodes.spi.Virtualizable;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import org.graalvm.compiler.nodes.util.GraphUtil;
import org.graalvm.compiler.nodes.virtual.VirtualArrayNode;

import jdk.vm.ci.meta.ConstantReflectionProvider;

/**
 * The {@code ArrayLength} instruction gets the length of an array.
 */
@NodeInfo(cycles = CYCLES_2, size = SIZE_1)
public final class ArrayLengthNode extends FixedWithNextNode implements Canonicalizable.Unary<ValueNode>, Lowerable, Virtualizable {

    public static final NodeClass<ArrayLengthNode> TYPE = NodeClass.create(ArrayLengthNode.class);
    @Input ValueNode array;

    public ValueNode array() {
        return array;
    }

    @Override
    public ValueNode getValue() {
        return array;
    }

    public ArrayLengthNode(ValueNode array) {
        super(TYPE, StampFactory.positiveInt());
        this.array = array;
    }

    public static ValueNode create(ValueNode forValue, ConstantReflectionProvider constantReflection) {
        if (forValue instanceof NewArrayNode) {
            NewArrayNode newArray = (NewArrayNode) forValue;
            return newArray.length();
        }

        ValueNode length = readArrayLength(forValue, constantReflection);
        if (length != null) {
            return length;
        }
        return new ArrayLengthNode(forValue);
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forValue) {
        ValueNode length = readArrayLength(forValue, tool.getConstantReflection());
        if (length != null) {
            return length;
        }
        return this;
    }

    /**
     * Gets the length of an array if possible.
     *
     * @return a node representing the length of {@code array} or null if it is not available
     */
    public static ValueNode readArrayLength(ValueNode originalArray, ConstantReflectionProvider constantReflection) {
        return GraphUtil.arrayLength(originalArray, ArrayLengthProvider.FindLengthMode.CANONICALIZE_READ, constantReflection);
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    @NodeIntrinsic
    public static native int arrayLength(Object array);

    @Override
    public void virtualize(VirtualizerTool tool) {
        ValueNode alias = tool.getAlias(array());
        if (alias instanceof VirtualArrayNode) {
            VirtualArrayNode virtualArray = (VirtualArrayNode) alias;
            tool.replaceWithValue(ConstantNode.forInt(virtualArray.entryCount(), graph()));
        }
    }
}
