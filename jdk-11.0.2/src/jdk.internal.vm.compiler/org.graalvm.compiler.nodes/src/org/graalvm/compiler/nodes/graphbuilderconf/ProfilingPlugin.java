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
import org.graalvm.compiler.nodes.LogicNode;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public interface ProfilingPlugin extends GraphBuilderPlugin {
    boolean shouldProfile(GraphBuilderContext builder, ResolvedJavaMethod method);

    void profileInvoke(GraphBuilderContext builder, ResolvedJavaMethod method, FrameState frameState);

    void profileGoto(GraphBuilderContext builder, ResolvedJavaMethod method, int bci, int targetBci, FrameState frameState);

    void profileIf(GraphBuilderContext builder, ResolvedJavaMethod method, int bci, LogicNode condition, int trueBranchBci, int falseBranchBci, FrameState frameState);

}
