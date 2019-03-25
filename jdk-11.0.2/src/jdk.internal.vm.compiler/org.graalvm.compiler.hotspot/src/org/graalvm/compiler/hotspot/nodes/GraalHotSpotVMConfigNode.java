/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.nodes;

import static org.graalvm.compiler.core.common.GraalOptions.GeneratePIC;
import static org.graalvm.compiler.hotspot.GraalHotSpotVMConfig.INJECTED_VMCONFIG;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_1;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_1;

import org.graalvm.compiler.api.replacements.Fold;
import org.graalvm.compiler.api.replacements.Fold.InjectedParameter;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.HotSpotLIRGenerator;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.Value;

/**
 * Represents {@link GraalHotSpotVMConfig} values that may change after compilation.
 */
@NodeInfo(cycles = CYCLES_1, size = SIZE_1)
public class GraalHotSpotVMConfigNode extends FloatingNode implements LIRLowerable, Canonicalizable {
    public static final NodeClass<GraalHotSpotVMConfigNode> TYPE = NodeClass.create(GraalHotSpotVMConfigNode.class);

    private final GraalHotSpotVMConfig config;
    protected final int markId;

    /**
     * Constructor for {@link #areConfigValuesConstant()}.
     *
     * @param config
     */
    public GraalHotSpotVMConfigNode(@InjectedNodeParameter GraalHotSpotVMConfig config) {
        super(TYPE, StampFactory.forKind(JavaKind.Boolean));
        this.config = config;
        this.markId = 0;
    }

    /**
     * Constructor for node intrinsics below.
     *
     * @param config
     * @param markId id of the config value
     */
    public GraalHotSpotVMConfigNode(@InjectedNodeParameter Stamp stamp, @InjectedNodeParameter GraalHotSpotVMConfig config, int markId) {
        super(TYPE, stamp);
        this.config = config;
        this.markId = markId;
    }

    /**
     * Constructor with explicit type specification.
     *
     * @param config
     * @param markId id of the config value
     * @param kind explicit type of the node
     */
    public GraalHotSpotVMConfigNode(GraalHotSpotVMConfig config, int markId, JavaKind kind) {
        super(TYPE, StampFactory.forKind(kind));
        this.config = config;
        this.markId = markId;
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
        Value res = ((HotSpotLIRGenerator) generator.getLIRGeneratorTool()).emitLoadConfigValue(markId, generator.getLIRGeneratorTool().getLIRKind(stamp));
        generator.setResult(this, res);
    }

    @NodeIntrinsic
    private static native boolean areConfigValuesConstant();

    @NodeIntrinsic
    private static native long loadLongConfigValue(@ConstantNodeParameter int markId);

    @NodeIntrinsic
    private static native int loadIntConfigValue(@ConstantNodeParameter int markId);

    @NodeIntrinsic
    private static native byte loadByteConfigValue(@ConstantNodeParameter int markId);

    public static long cardTableAddress() {
        return loadLongConfigValue(cardTableAddressMark(INJECTED_VMCONFIG));
    }

    public static boolean isCardTableAddressConstant() {
        return areConfigValuesConstant();
    }

    public static long heapTopAddress() {
        return loadLongConfigValue(heapTopAddressMark(INJECTED_VMCONFIG));
    }

    public static long heapEndAddress() {
        return loadLongConfigValue(heapEndAddressMark(INJECTED_VMCONFIG));
    }

    public static long crcTableAddress() {
        return loadLongConfigValue(crcTableAddressMark(INJECTED_VMCONFIG));
    }

    public static int logOfHeapRegionGrainBytes() {
        return loadIntConfigValue(logOfHeapRegionGrainBytesMark(INJECTED_VMCONFIG));
    }

    public static boolean inlineContiguousAllocationSupported() {
        return loadByteConfigValue(inlineContiguousAllocationSupportedMark(INJECTED_VMCONFIG)) != 0;
    }

    @Fold
    public static int cardTableAddressMark(@InjectedParameter GraalHotSpotVMConfig config) {
        return config.MARKID_CARD_TABLE_ADDRESS;
    }

    @Fold
    public static int heapTopAddressMark(@InjectedParameter GraalHotSpotVMConfig config) {
        return config.MARKID_HEAP_TOP_ADDRESS;
    }

    @Fold
    public static int heapEndAddressMark(@InjectedParameter GraalHotSpotVMConfig config) {
        return config.MARKID_HEAP_END_ADDRESS;
    }

    @Fold
    public static int crcTableAddressMark(@InjectedParameter GraalHotSpotVMConfig config) {
        return config.MARKID_CRC_TABLE_ADDRESS;
    }

    @Fold
    public static int logOfHeapRegionGrainBytesMark(@InjectedParameter GraalHotSpotVMConfig config) {
        return config.MARKID_LOG_OF_HEAP_REGION_GRAIN_BYTES;
    }

    @Fold
    public static int inlineContiguousAllocationSupportedMark(@InjectedParameter GraalHotSpotVMConfig config) {
        return config.MARKID_INLINE_CONTIGUOUS_ALLOCATION_SUPPORTED;
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (markId == 0) {
            return ConstantNode.forBoolean(!GeneratePIC.getValue(tool.getOptions()));
        }
        if (!GeneratePIC.getValue(tool.getOptions())) {
            if (markId == config.MARKID_CARD_TABLE_ADDRESS) {
                return ConstantNode.forLong(config.cardtableStartAddress);
            } else if (markId == config.MARKID_HEAP_TOP_ADDRESS) {
                return ConstantNode.forLong(config.heapTopAddress);
            } else if (markId == config.MARKID_HEAP_END_ADDRESS) {
                return ConstantNode.forLong(config.heapEndAddress);
            } else if (markId == config.MARKID_CRC_TABLE_ADDRESS) {
                return ConstantNode.forLong(config.crcTableAddress);
            } else if (markId == config.MARKID_LOG_OF_HEAP_REGION_GRAIN_BYTES) {
                return ConstantNode.forInt(config.logOfHRGrainBytes);
            } else if (markId == config.MARKID_INLINE_CONTIGUOUS_ALLOCATION_SUPPORTED) {
                return ConstantNode.forBoolean(config.inlineContiguousAllocationSupported);
            } else {
                assert false;
            }
        }
        return this;
    }
}
