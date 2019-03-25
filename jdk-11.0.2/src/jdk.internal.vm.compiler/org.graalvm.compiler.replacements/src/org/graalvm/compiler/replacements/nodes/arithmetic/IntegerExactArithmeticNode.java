/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.nodes.spi.Lowerable;

public interface IntegerExactArithmeticNode extends Lowerable {

    IntegerExactArithmeticSplitNode createSplit(AbstractBeginNode next, AbstractBeginNode deopt);
}
