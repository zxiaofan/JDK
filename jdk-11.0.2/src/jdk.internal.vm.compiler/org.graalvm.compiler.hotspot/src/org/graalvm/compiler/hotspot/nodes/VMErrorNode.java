/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.hotspot.HotSpotBackend.VM_ERROR;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_UNKNOWN;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_UNKNOWN;

import org.graalvm.compiler.bytecode.Bytecode;
import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.common.spi.ForeignCallLinkage;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.replacements.Log;
import org.graalvm.compiler.replacements.nodes.CStringConstant;

import jdk.vm.ci.code.CodeUtil;
import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.Value;

/**
 * Causes the VM to exit with a description of the current Java location and an optional
 * {@linkplain Log#printf(String, long) formatted} error message specified.
 */
@NodeInfo(cycles = CYCLES_UNKNOWN, size = SIZE_UNKNOWN)
public final class VMErrorNode extends DeoptimizingStubCall implements LIRLowerable {

    public static final NodeClass<VMErrorNode> TYPE = NodeClass.create(VMErrorNode.class);
    protected final String format;
    @Input ValueNode value;

    public VMErrorNode(String format, ValueNode value) {
        super(TYPE, StampFactory.forVoid());
        this.format = format;
        this.value = value;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        String whereString;
        if (stateBefore() != null) {
            String nl = CodeUtil.NEW_LINE;
            StringBuilder sb = new StringBuilder("in compiled code associated with frame state:");
            FrameState fs = stateBefore();
            while (fs != null) {
                Bytecode.appendLocation(sb.append(nl).append("\t"), fs.getCode(), fs.bci);
                fs = fs.outerFrameState();
            }
            whereString = sb.toString();
        } else {
            ResolvedJavaMethod method = graph().method();
            whereString = "in compiled code for " + (method == null ? graph().toString() : method.format("%H.%n(%p)"));
        }

        LIRKind wordKind = gen.getLIRGeneratorTool().getLIRKind(StampFactory.pointer());
        Value whereArg = gen.getLIRGeneratorTool().emitConstant(wordKind, new CStringConstant(whereString));
        Value formatArg = gen.getLIRGeneratorTool().emitConstant(wordKind, new CStringConstant(format));

        ForeignCallLinkage linkage = gen.getLIRGeneratorTool().getForeignCalls().lookupForeignCall(VM_ERROR);
        gen.getLIRGeneratorTool().emitForeignCall(linkage, null, whereArg, formatArg, gen.operand(value));
    }

    @NodeIntrinsic
    public static native void vmError(@ConstantNodeParameter String format, long value);
}
