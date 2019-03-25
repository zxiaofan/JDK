/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.amd64;

import static org.graalvm.compiler.nodeinfo.InputType.Memory;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_UNKNOWN;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_512;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedWithNextNode;
import org.graalvm.compiler.nodes.NamedLocationIdentity;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.ValueNodeUtil;
import org.graalvm.compiler.nodes.memory.MemoryAccess;
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint;
import org.graalvm.compiler.nodes.memory.MemoryNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import jdk.internal.vm.compiler.word.LocationIdentity;
import jdk.internal.vm.compiler.word.Pointer;

import jdk.vm.ci.meta.JavaKind;

@NodeInfo(allowedUsageTypes = Memory, size = SIZE_512, cycles = CYCLES_UNKNOWN)

public final class AMD64StringLatin1InflateNode extends FixedWithNextNode
                implements LIRLowerable, MemoryCheckpoint.Multi, MemoryAccess {

    public static final NodeClass<AMD64StringLatin1InflateNode> TYPE = NodeClass.create(AMD64StringLatin1InflateNode.class);

    @Input private ValueNode src;
    @Input private ValueNode dst;
    @Input private ValueNode len;

    private final JavaKind writeKind;

    @OptionalInput(Memory) private MemoryNode lla; // Last access location registered.

    // java.lang.StringLatin1.inflate([BI[CII)V
    //
    // void inflate(byte[] src, int src_indx, char[] dst, int dst_indx, int len)
    //
    // Represented as a graph node by:

    public AMD64StringLatin1InflateNode(ValueNode src, ValueNode dst, ValueNode len, JavaKind writeKind) {
        super(TYPE, StampFactory.forVoid());
        this.src = src;
        this.dst = dst;
        this.len = len;
        this.writeKind = writeKind;
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        // Model read access via 'src' using:
        return NamedLocationIdentity.getArrayLocation(JavaKind.Byte);
    }

    @Override
    public LocationIdentity[] getLocationIdentities() {
        // Model write access via 'dst' using:
        return new LocationIdentity[]{NamedLocationIdentity.getArrayLocation(writeKind)};
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        LIRGeneratorTool lgt = gen.getLIRGeneratorTool();
        lgt.emitStringLatin1Inflate(gen.operand(src), gen.operand(dst), gen.operand(len));
    }

    @Override
    public MemoryNode getLastLocationAccess() {
        return lla;
    }

    @Override
    public void setLastLocationAccess(MemoryNode newlla) {
        updateUsages(ValueNodeUtil.asNode(lla), ValueNodeUtil.asNode(newlla));
        lla = newlla;
    }

    @NodeIntrinsic
    public static native void inflate(Pointer src, Pointer dst, int len, @ConstantNodeParameter JavaKind writeKind);
}
