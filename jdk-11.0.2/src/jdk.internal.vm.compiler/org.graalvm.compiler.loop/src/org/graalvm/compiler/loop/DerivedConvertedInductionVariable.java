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


package org.graalvm.compiler.loop;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.IntegerConvertNode;

public class DerivedConvertedInductionVariable extends DerivedInductionVariable {

    private final Stamp stamp;
    private final ValueNode value;

    public DerivedConvertedInductionVariable(LoopEx loop, InductionVariable base, Stamp stamp, ValueNode value) {
        super(loop, base);
        this.stamp = stamp;
        this.value = value;
    }

    @Override
    public ValueNode valueNode() {
        return value;
    }

    @Override
    public Direction direction() {
        return base.direction();
    }

    @Override
    public ValueNode initNode() {
        return IntegerConvertNode.convert(base.initNode(), stamp, graph(), NodeView.DEFAULT);
    }

    @Override
    public ValueNode strideNode() {
        return IntegerConvertNode.convert(base.strideNode(), stamp, graph(), NodeView.DEFAULT);
    }

    @Override
    public boolean isConstantInit() {
        return base.isConstantInit();
    }

    @Override
    public boolean isConstantStride() {
        return base.isConstantStride();
    }

    @Override
    public long constantInit() {
        return base.constantInit();
    }

    @Override
    public long constantStride() {
        return base.constantStride();
    }

    @Override
    public ValueNode extremumNode(boolean assumePositiveTripCount, Stamp s) {
        return base.extremumNode(assumePositiveTripCount, s);
    }

    @Override
    public ValueNode exitValueNode() {
        return IntegerConvertNode.convert(base.exitValueNode(), stamp, graph(), NodeView.DEFAULT);
    }

    @Override
    public boolean isConstantExtremum() {
        return base.isConstantExtremum();
    }

    @Override
    public long constantExtremum() {
        return base.constantExtremum();
    }

    @Override
    public void deleteUnusedNodes() {
    }

    @Override
    public String toString() {
        return String.format("DerivedConvertedInductionVariable base (%s) %s %s", base, value.getNodeClass().shortName(), stamp);
    }
}
