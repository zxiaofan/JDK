/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.meta;

import org.graalvm.compiler.bytecode.Bytecodes;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.hotspot.nodes.aot.ResolveDynamicConstantNode;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.InvokeDynamicPlugin;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;

import jdk.vm.ci.hotspot.HotSpotResolvedJavaMethod;
import jdk.vm.ci.hotspot.HotSpotResolvedObjectType;
import jdk.vm.ci.meta.ConstantPool;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.ResolvedJavaMethod;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class HotSpotInvokeDynamicPlugin implements InvokeDynamicPlugin {

    private static final Class<? extends ConstantPool> hscp;
    private static final MethodHandle isResolvedDynamicInvokeMH;

    static {
        MethodHandle m = null;
        Class<? extends ConstantPool> c = null;
        try {
            c = Class.forName("jdk.vm.ci.hotspot.HotSpotConstantPool").asSubclass(ConstantPool.class);
            m = MethodHandles.lookup().findVirtual(c, "isResolvedDynamicInvoke", MethodType.methodType(boolean.class, int.class, int.class));
        } catch (Exception e) {
        }
        isResolvedDynamicInvokeMH = m;
        hscp = c;
    }

    private static boolean isResolvedDynamicInvoke(ConstantPool constantPool, int index, int opcode) {
        if (isResolvedDynamicInvokeMH != null) {
            if (!hscp.isInstance(constantPool)) {
                return false;
            }
            try {
                return (boolean) isResolvedDynamicInvokeMH.invoke(constantPool, index, opcode);
            } catch (Throwable t) {
                throw GraalError.shouldNotReachHere(t);
            }
        }
        throw GraalError.shouldNotReachHere("isResolvedDynamicInvokeMH not set");
    }

    private final DynamicTypeStore dynoStore;
    private final boolean treatAppendixAsConstant;

    public HotSpotInvokeDynamicPlugin(DynamicTypeStore dynoStore, boolean treatAppendixAsConstant) {
        this.dynoStore = dynoStore;
        this.treatAppendixAsConstant = treatAppendixAsConstant;
    }

    public HotSpotInvokeDynamicPlugin(DynamicTypeStore dynoStore) {
        this(dynoStore, true);
    }

    public HotSpotInvokeDynamicPlugin() {
        this(null);
    }

    // invokehandle support
    @Override
    public boolean isResolvedDynamicInvoke(GraphBuilderContext builder, int index, int opcode) {
        ConstantPool constantPool = builder.getCode().getConstantPool();
        if (isResolvedDynamicInvokeMH == null) {
            // If older JVMCI, but HotSpotInvokeDynamicPlugin is being
            // used for testing, return true so that we continue along the
            // plugin path.
            return true;
        }
        return isResolvedDynamicInvoke(constantPool, index, opcode);
    }

    @Override
    public boolean supportsDynamicInvoke(GraphBuilderContext builder, int index, int opcode) {
        return opcode == Bytecodes.INVOKEDYNAMIC || isResolvedDynamicInvokeMH != null;
    }

    public DynamicTypeStore getDynamicTypeStore() {
        return dynoStore;
    }

    @Override
    public void recordDynamicMethod(GraphBuilderContext builder, int index, int opcode, ResolvedJavaMethod target) {
        assert supportsDynamicInvoke(builder, index, opcode);
        HotSpotResolvedJavaMethod method = (HotSpotResolvedJavaMethod) builder.getMethod();
        HotSpotResolvedObjectType methodHolder = method.getDeclaringClass();

        HotSpotResolvedJavaMethod adapter = (HotSpotResolvedJavaMethod) target;
        if (dynoStore != null) {
            dynoStore.recordAdapter(opcode, methodHolder, index, adapter);
        }
    }

    @Override
    public ValueNode genAppendixNode(GraphBuilderContext builder, int index, int opcode, JavaConstant appendixConstant, FrameState frameState) {
        JavaConstant appendix = appendixConstant;
        assert supportsDynamicInvoke(builder, index, opcode);
        HotSpotResolvedJavaMethod method = (HotSpotResolvedJavaMethod) builder.getMethod();
        HotSpotResolvedObjectType methodHolder = method.getDeclaringClass();

        if (dynoStore != null) {
            appendix = dynoStore.recordAppendix(opcode, methodHolder, index, appendix);
        }

        ConstantNode appendixNode = ConstantNode.forConstant(appendix, builder.getMetaAccess(), builder.getGraph());

        Stamp appendixStamp = appendixNode.stamp(NodeView.DEFAULT);
        Stamp resolveStamp = treatAppendixAsConstant ? appendixStamp : appendixStamp.unrestricted();
        ResolveDynamicConstantNode resolveNode = new ResolveDynamicConstantNode(resolveStamp, appendixNode);
        ResolveDynamicConstantNode added = builder.append(resolveNode);
        assert added == resolveNode;
        added.setStateBefore(frameState);
        return resolveNode;
    }

    public interface DynamicTypeStore {

        void recordAdapter(int opcode, HotSpotResolvedObjectType holder, int cpi, HotSpotResolvedJavaMethod adapter);

        JavaConstant recordAppendix(int opcode, HotSpotResolvedObjectType holder, int cpi, JavaConstant appendix);

    }

}
