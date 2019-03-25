/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.nodes.profiling;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.iterators.NodeIterable;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.StructuredGraph;

import jdk.vm.ci.meta.ResolvedJavaMethod;

@NodeInfo
public class ProfileInvokeNode extends ProfileWithNotificationNode {
    public static final NodeClass<ProfileInvokeNode> TYPE = NodeClass.create(ProfileInvokeNode.class);

    public ProfileInvokeNode(ResolvedJavaMethod method, int freqLog, int probabilityLog) {
        super(TYPE, method, freqLog, probabilityLog);
    }

    @Override
    protected boolean canBeMergedWith(ProfileNode p) {
        if (p instanceof ProfileInvokeNode) {
            ProfileInvokeNode that = (ProfileInvokeNode) p;
            return this.method.equals(that.method);
        }
        return false;
    }

    /**
     * Gathers all the {@link ProfileInvokeNode}s that are inputs to the
     * {@linkplain StructuredGraph#getNodes() live nodes} in a given graph.
     */
    public static NodeIterable<ProfileInvokeNode> getProfileInvokeNodes(StructuredGraph graph) {
        return graph.getNodes().filter(ProfileInvokeNode.class);
    }
}
