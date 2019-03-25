/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.common.inlining.info.elem;

import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.HighTierContext;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public interface Inlineable {

    static Inlineable getInlineableElement(final ResolvedJavaMethod method, Invoke invoke, HighTierContext context, CanonicalizerPhase canonicalizer, boolean trackNodeSourcePosition) {
        assert method != null;
        assert invoke != null;
        return new InlineableGraph(method, invoke, context, canonicalizer, trackNodeSourcePosition);
    }

    int getNodeCount();

    Iterable<Invoke> getInvokes();

    double getProbability(Invoke invoke);
}
