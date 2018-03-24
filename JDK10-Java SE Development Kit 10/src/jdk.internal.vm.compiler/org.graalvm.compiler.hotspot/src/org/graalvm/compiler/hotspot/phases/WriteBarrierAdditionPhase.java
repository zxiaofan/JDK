/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot.phases;

import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.nodes.G1ArrayRangePostWriteBarrier;
import org.graalvm.compiler.hotspot.nodes.G1ArrayRangePreWriteBarrier;
import org.graalvm.compiler.hotspot.nodes.G1PostWriteBarrier;
import org.graalvm.compiler.hotspot.nodes.G1PreWriteBarrier;
import org.graalvm.compiler.hotspot.nodes.G1ReferentFieldReadBarrier;
import org.graalvm.compiler.hotspot.nodes.SerialArrayRangeWriteBarrier;
import org.graalvm.compiler.hotspot.nodes.SerialWriteBarrier;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.ArrayRangeWriteNode;
import org.graalvm.compiler.nodes.java.AbstractCompareAndSwapNode;
import org.graalvm.compiler.nodes.java.LoweredAtomicReadAndWriteNode;
import org.graalvm.compiler.nodes.memory.FixedAccessNode;
import org.graalvm.compiler.nodes.memory.HeapAccess.BarrierType;
import org.graalvm.compiler.nodes.memory.ReadNode;
import org.graalvm.compiler.nodes.memory.WriteNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;
import org.graalvm.compiler.nodes.type.StampTool;
import org.graalvm.compiler.phases.Phase;

public class WriteBarrierAdditionPhase extends Phase {

    private GraalHotSpotVMConfig config;

    public WriteBarrierAdditionPhase(GraalHotSpotVMConfig config) {
        this.config = config;
    }

    @Override
    protected void run(StructuredGraph graph) {
        for (Node n : graph.getNodes()) {
            if (n instanceof ReadNode) {
                addReadNodeBarriers((ReadNode) n, graph);
            } else if (n instanceof WriteNode) {
                addWriteNodeBarriers((WriteNode) n, graph);
            } else if (n instanceof LoweredAtomicReadAndWriteNode) {
                LoweredAtomicReadAndWriteNode loweredAtomicReadAndWriteNode = (LoweredAtomicReadAndWriteNode) n;
                addAtomicReadWriteNodeBarriers(loweredAtomicReadAndWriteNode, graph);
            } else if (n instanceof AbstractCompareAndSwapNode) {
                addCASBarriers((AbstractCompareAndSwapNode) n, graph);
            } else if (n instanceof ArrayRangeWriteNode) {
                ArrayRangeWriteNode node = (ArrayRangeWriteNode) n;
                if (node.isObjectArray()) {
                    addArrayRangeBarriers(node, graph);
                }
            }
        }
    }

    private void addReadNodeBarriers(ReadNode node, StructuredGraph graph) {
        if (node.getBarrierType() == BarrierType.PRECISE) {
            assert config.useG1GC;
            G1ReferentFieldReadBarrier barrier = graph.add(new G1ReferentFieldReadBarrier(node.getAddress(), node, false));
            graph.addAfterFixed(node, barrier);
        } else {
            assert node.getBarrierType() == BarrierType.NONE : "Non precise read barrier has been attached to read node.";
        }
    }

    protected static void addG1PreWriteBarrier(FixedAccessNode node, AddressNode address, ValueNode value, boolean doLoad, boolean nullCheck, StructuredGraph graph) {
        G1PreWriteBarrier preBarrier = graph.add(new G1PreWriteBarrier(address, value, doLoad, nullCheck));
        preBarrier.setStateBefore(node.stateBefore());
        node.setNullCheck(false);
        node.setStateBefore(null);
        graph.addBeforeFixed(node, preBarrier);
    }

    protected void addG1PostWriteBarrier(FixedAccessNode node, AddressNode address, ValueNode value, boolean precise, StructuredGraph graph) {
        final boolean alwaysNull = StampTool.isPointerAlwaysNull(value);
        graph.addAfterFixed(node, graph.add(new G1PostWriteBarrier(address, value, precise, alwaysNull)));
    }

    protected void addSerialPostWriteBarrier(FixedAccessNode node, AddressNode address, ValueNode value, boolean precise, StructuredGraph graph) {
        final boolean alwaysNull = StampTool.isPointerAlwaysNull(value);
        if (alwaysNull) {
            // Serial barrier isn't needed for null value
            return;
        }
        graph.addAfterFixed(node, graph.add(new SerialWriteBarrier(address, precise)));
    }

    private void addWriteNodeBarriers(WriteNode node, StructuredGraph graph) {
        BarrierType barrierType = node.getBarrierType();
        switch (barrierType) {
            case NONE:
                // nothing to do
                break;
            case IMPRECISE:
            case PRECISE:
                boolean precise = barrierType == BarrierType.PRECISE;
                if (config.useG1GC) {
                    if (!node.getLocationIdentity().isInit()) {
                        addG1PreWriteBarrier(node, node.getAddress(), null, true, node.getNullCheck(), graph);
                    }
                    addG1PostWriteBarrier(node, node.getAddress(), node.value(), precise, graph);
                } else {
                    addSerialPostWriteBarrier(node, node.getAddress(), node.value(), precise, graph);
                }
                break;
            default:
                throw new GraalError("unexpected barrier type: " + barrierType);
        }
    }

    private void addAtomicReadWriteNodeBarriers(LoweredAtomicReadAndWriteNode node, StructuredGraph graph) {
        BarrierType barrierType = node.getBarrierType();
        switch (barrierType) {
            case NONE:
                // nothing to do
                break;
            case IMPRECISE:
            case PRECISE:
                boolean precise = barrierType == BarrierType.PRECISE;
                if (config.useG1GC) {
                    addG1PreWriteBarrier(node, node.getAddress(), null, true, node.getNullCheck(), graph);
                    addG1PostWriteBarrier(node, node.getAddress(), node.getNewValue(), precise, graph);
                } else {
                    addSerialPostWriteBarrier(node, node.getAddress(), node.getNewValue(), precise, graph);
                }
                break;
            default:
                throw new GraalError("unexpected barrier type: " + barrierType);
        }
    }

    private void addCASBarriers(AbstractCompareAndSwapNode node, StructuredGraph graph) {
        BarrierType barrierType = node.getBarrierType();
        switch (barrierType) {
            case NONE:
                // nothing to do
                break;
            case IMPRECISE:
            case PRECISE:
                boolean precise = barrierType == BarrierType.PRECISE;
                if (config.useG1GC) {
                    addG1PreWriteBarrier(node, node.getAddress(), node.getExpectedValue(), false, false, graph);
                    addG1PostWriteBarrier(node, node.getAddress(), node.getNewValue(), precise, graph);
                } else {
                    addSerialPostWriteBarrier(node, node.getAddress(), node.getNewValue(), precise, graph);
                }
                break;
            default:
                throw new GraalError("unexpected barrier type: " + barrierType);
        }
    }

    private void addArrayRangeBarriers(ArrayRangeWriteNode node, StructuredGraph graph) {
        if (config.useG1GC) {
            if (!node.isInitialization()) {
                G1ArrayRangePreWriteBarrier g1ArrayRangePreWriteBarrier = graph.add(new G1ArrayRangePreWriteBarrier(node.getArray(), node.getIndex(), node.getLength()));
                graph.addBeforeFixed(node, g1ArrayRangePreWriteBarrier);
            }
            G1ArrayRangePostWriteBarrier g1ArrayRangePostWriteBarrier = graph.add(new G1ArrayRangePostWriteBarrier(node.getArray(), node.getIndex(), node.getLength()));
            graph.addAfterFixed(node, g1ArrayRangePostWriteBarrier);
        } else {
            SerialArrayRangeWriteBarrier serialArrayRangeWriteBarrier = graph.add(new SerialArrayRangeWriteBarrier(node.getArray(), node.getIndex(), node.getLength()));
            graph.addAfterFixed(node, serialArrayRangeWriteBarrier);
        }
    }

    @Override
    public boolean checkContract() {
        return false;
    }
}
