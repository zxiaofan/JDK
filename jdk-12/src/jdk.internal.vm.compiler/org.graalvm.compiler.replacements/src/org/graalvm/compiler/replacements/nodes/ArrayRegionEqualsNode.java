/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.nodes;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.Value;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeCycles;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodeinfo.NodeSize;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.NamedLocationIdentity;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.ValueNodeUtil;
import org.graalvm.compiler.nodes.memory.MemoryAccess;
import org.graalvm.compiler.nodes.memory.MemoryNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import jdk.internal.vm.compiler.word.LocationIdentity;
import jdk.internal.vm.compiler.word.Pointer;

import static org.graalvm.compiler.nodeinfo.InputType.Memory;

// JaCoCo Exclude

/**
 * Compares two array regions with a given length.
 */
@NodeInfo(cycles = NodeCycles.CYCLES_UNKNOWN, size = NodeSize.SIZE_128)
public final class ArrayRegionEqualsNode extends FixedWithNextNode implements LIRLowerable, MemoryAccess {

    public static final NodeClass<ArrayRegionEqualsNode> TYPE = NodeClass.create(ArrayRegionEqualsNode.class);

    /** {@link JavaKind} of the arrays to compare. */
    private final JavaKind kind;

    /** Pointer to first array region to be tested for equality. */
    @Input private ValueNode array1;

    /** Pointer to second array region to be tested for equality. */
    @Input private ValueNode array2;

    /** Length of the array region. */
    @Input private ValueNode length;

    @OptionalInput(Memory) private MemoryNode lastLocationAccess;

    public ArrayRegionEqualsNode(ValueNode array1, ValueNode array2, ValueNode length, @ConstantNodeParameter JavaKind kind) {
        super(TYPE, StampFactory.forKind(JavaKind.Boolean));
        this.kind = kind;
        this.array1 = array1;
        this.array2 = array2;
        this.length = length;
    }

    @NodeIntrinsic
    public static native boolean regionEquals(Pointer array1, Pointer array2, int length, @ConstantNodeParameter JavaKind kind);

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        int constantLength = -1;
        if (length.isConstant()) {
            constantLength = length.asJavaConstant().asInt();
        }
        Value result = gen.getLIRGeneratorTool().emitArrayEquals(kind, gen.operand(array1), gen.operand(array2), gen.operand(length), constantLength, true);
        gen.setResult(this, result);
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return NamedLocationIdentity.getArrayLocation(kind);
    }

    @Override
    public MemoryNode getLastLocationAccess() {
        return lastLocationAccess;
    }

    @Override
    public void setLastLocationAccess(MemoryNode lla) {
        updateUsages(ValueNodeUtil.asNode(lastLocationAccess), ValueNodeUtil.asNode(lla));
        lastLocationAccess = lla;
    }
}
