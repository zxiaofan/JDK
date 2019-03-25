/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot;

import org.graalvm.compiler.core.match.MatchableNode;
import org.graalvm.compiler.lir.gen.LIRGenerator;
import org.graalvm.compiler.nodes.CompressionNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

/**
 * This interface defines the contract a HotSpot backend LIR generator needs to fulfill in addition
 * to abstract methods from {@link LIRGenerator} and {@link NodeLIRBuilderTool}.
 */
@MatchableNode(nodeClass = CompressionNode.class, inputs = {"value"})
public interface HotSpotNodeLIRBuilder {

    void emitPatchReturnAddress(ValueNode address);

    default void emitJumpToExceptionHandler(ValueNode address) {
        emitPatchReturnAddress(address);
    }

    void emitJumpToExceptionHandlerInCaller(ValueNode handlerInCallerPc, ValueNode exception, ValueNode exceptionPc);
}
