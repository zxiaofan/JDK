/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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



package org.graalvm.compiler.core.sparc;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.lir.sparc.SPARCIndexedAddressValue;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.memory.address.AddressNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.meta.AllocatableValue;

/**
 * Represents an address of the form [base + index].
 */
@NodeInfo
public class SPARCIndexedAddressNode extends AddressNode implements LIRLowerable {

    public static final NodeClass<SPARCIndexedAddressNode> TYPE = NodeClass.create(SPARCIndexedAddressNode.class);

    @Input private ValueNode base;
    @Input private ValueNode index;

    public SPARCIndexedAddressNode(ValueNode base, ValueNode index) {
        super(TYPE);
        this.base = base;
        this.index = index;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        SPARCLIRGenerator tool = (SPARCLIRGenerator) gen.getLIRGeneratorTool();

        AllocatableValue baseValue = tool.asAllocatable(gen.operand(base));
        AllocatableValue indexValue = tool.asAllocatable(gen.operand(index));

        AllocatableValue baseReference = LIRKind.derivedBaseFromValue(baseValue);
        AllocatableValue indexReference = LIRKind.derivedBaseFromValue(indexValue);

        LIRKind kind = LIRKind.combineDerived(tool.getLIRKind(stamp(NodeView.DEFAULT)), baseReference, indexReference);
        gen.setResult(this, new SPARCIndexedAddressValue(kind, baseValue, indexValue));
    }

    @Override
    public ValueNode getBase() {
        return base;
    }

    public void setBase(ValueNode base) {
        updateUsages(this.base, base);
        this.base = base;
    }

    @Override
    public ValueNode getIndex() {
        return index;
    }

    public void setIndex(ValueNode index) {
        updateUsages(this.index, index);
        this.index = index;
    }

    @Override
    public long getMaxConstantDisplacement() {
        return Long.MAX_VALUE;
    }
}
