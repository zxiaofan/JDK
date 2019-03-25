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


package org.graalvm.compiler.nodes.spi;

import org.graalvm.compiler.lir.gen.ArithmeticLIRGeneratorTool;

public interface ArithmeticLIRLowerable extends LIRLowerable {

    @Override
    default void generate(NodeLIRBuilderTool builder) {
        generate(builder, builder.getLIRGeneratorTool().getArithmetic());
    }

    void generate(NodeLIRBuilderTool builder, ArithmeticLIRGeneratorTool gen);
}
