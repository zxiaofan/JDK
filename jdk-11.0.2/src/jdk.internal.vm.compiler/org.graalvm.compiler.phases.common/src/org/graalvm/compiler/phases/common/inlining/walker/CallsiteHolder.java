/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.common.inlining.walker;

import org.graalvm.compiler.nodes.StructuredGraph;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Information about a graph that will potentially be inlined. This includes tracking the
 * invocations in graph that will subject to inlining themselves.
 */
public abstract class CallsiteHolder {

    /**
     * Gets the method associated with the {@linkplain #graph() graph} represented by this object.
     */
    public abstract ResolvedJavaMethod method();

    /**
     * The stack realized by {@link InliningData} grows upon {@link InliningData#moveForward()}
     * deciding to explore (depth-first) a callsite of the graph associated to this
     * {@link CallsiteHolder}. The list of not-yet-considered callsites is managed by
     * {@link CallsiteHolderExplorable}, and this method reports whether any such candidates remain.
     */
    public abstract boolean hasRemainingInvokes();

    /**
     * The graph about which this object contains inlining information.
     */
    public abstract StructuredGraph graph();

}
