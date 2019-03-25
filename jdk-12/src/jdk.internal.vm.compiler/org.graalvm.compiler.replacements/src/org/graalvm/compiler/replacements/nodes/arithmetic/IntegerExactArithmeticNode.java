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


package org.graalvm.compiler.replacements.nodes.arithmetic;

import org.graalvm.compiler.nodes.AbstractBeginNode;
import org.graalvm.compiler.nodes.extended.AnchoringNode;
import org.graalvm.compiler.nodes.spi.Lowerable;

import jdk.vm.ci.meta.SpeculationLog.SpeculationReason;

public interface IntegerExactArithmeticNode extends Lowerable {

    IntegerExactArithmeticSplitNode createSplit(AbstractBeginNode next, AbstractBeginNode deopt);

    SpeculationReason getSpeculation();

    AnchoringNode getAnchor();

    void setAnchor(AnchoringNode x);

}
