/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes;

import static org.graalvm.compiler.nodeinfo.InputType.Extension;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.core.common.type.StampPair;
import org.graalvm.compiler.core.common.type.TypeReference;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.NodeInputList;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.meta.Assumptions;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.JavaType;
import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.ResolvedJavaType;

@NodeInfo(allowedUsageTypes = Extension, cycles = CYCLES_0, size = SIZE_0)
public abstract class CallTargetNode extends ValueNode implements LIRLowerable {
    public static final NodeClass<CallTargetNode> TYPE = NodeClass.create(CallTargetNode.class);

    public enum InvokeKind {
        Interface(false),
        Special(true),
        Static(true),
        Virtual(false);

        InvokeKind(boolean direct) {
            this.direct = direct;
        }

        private final boolean direct;

        public boolean hasReceiver() {
            return this != Static;
        }

        public boolean isDirect() {
            return direct;
        }

        public boolean isIndirect() {
            return !direct;
        }

        public boolean isInterface() {
            return this == InvokeKind.Interface;
        }
    }

    @Input protected NodeInputList<ValueNode> arguments;
    protected ResolvedJavaMethod targetMethod;
    protected InvokeKind invokeKind;
    protected final StampPair returnStamp;

    protected CallTargetNode(NodeClass<? extends CallTargetNode> c, ValueNode[] arguments, ResolvedJavaMethod targetMethod, InvokeKind invokeKind, StampPair returnStamp) {
        super(c, StampFactory.forVoid());
        this.targetMethod = targetMethod;
        this.invokeKind = invokeKind;
        this.arguments = new NodeInputList<>(this, arguments);
        this.returnStamp = returnStamp;
    }

    public NodeInputList<ValueNode> arguments() {
        return arguments;
    }

    public static Stamp createReturnStamp(Assumptions assumptions, JavaType returnType) {
        JavaKind kind = returnType.getJavaKind();
        if (kind == JavaKind.Object && returnType instanceof ResolvedJavaType) {
            return StampFactory.object(TypeReference.create(assumptions, (ResolvedJavaType) returnType));
        } else {
            return StampFactory.forKind(kind);
        }
    }

    public StampPair returnStamp() {
        return this.returnStamp;
    }

    /**
     * A human-readable representation of the target, used for debug printing only.
     */
    public abstract String targetName();

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        // nop
    }

    public void setTargetMethod(ResolvedJavaMethod method) {
        targetMethod = method;
    }

    /**
     * Gets the target method for this invocation instruction.
     *
     * @return the target method
     */
    public ResolvedJavaMethod targetMethod() {
        return targetMethod;
    }

    public InvokeKind invokeKind() {
        return invokeKind;
    }

    public void setInvokeKind(InvokeKind kind) {
        this.invokeKind = kind;
    }
}
