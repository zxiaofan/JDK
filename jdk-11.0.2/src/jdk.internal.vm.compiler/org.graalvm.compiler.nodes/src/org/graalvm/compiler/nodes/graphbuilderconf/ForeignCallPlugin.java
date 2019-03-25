/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.graphbuilderconf;

import org.graalvm.compiler.core.common.spi.ForeignCallDescriptor;
import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.ForeignCallNode;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * {@link InvocationPlugin} for converting a method call directly to a foreign call.
 */
public final class ForeignCallPlugin implements InvocationPlugin {
    private final ForeignCallsProvider foreignCalls;
    private final ForeignCallDescriptor descriptor;

    public ForeignCallPlugin(ForeignCallsProvider foreignCalls, ForeignCallDescriptor descriptor) {
        this.foreignCalls = foreignCalls;
        this.descriptor = descriptor;
    }

    @Override
    public boolean execute(GraphBuilderContext b, ResolvedJavaMethod targetMethod, InvocationPlugin.Receiver receiver, ValueNode[] args) {
        ForeignCallNode foreignCall = new ForeignCallNode(foreignCalls, descriptor, args);
        foreignCall.setBci(b.bci());
        b.addPush(targetMethod.getSignature().getReturnKind(), foreignCall);
        return true;
    }
}
