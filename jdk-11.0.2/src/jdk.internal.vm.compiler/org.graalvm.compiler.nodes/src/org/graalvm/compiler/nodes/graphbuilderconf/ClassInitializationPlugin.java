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

import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.ValueNode;

import jdk.vm.ci.meta.ConstantPool;
import jdk.vm.ci.meta.ResolvedJavaType;

public interface ClassInitializationPlugin extends GraphBuilderPlugin {
    boolean shouldApply(GraphBuilderContext builder, ResolvedJavaType type);

    ValueNode apply(GraphBuilderContext builder, ResolvedJavaType type, FrameState frameState);

    boolean supportsLazyInitialization(ConstantPool cp);

    void loadReferencedType(GraphBuilderContext builder, ConstantPool cp, int cpi, int bytecode);

}
