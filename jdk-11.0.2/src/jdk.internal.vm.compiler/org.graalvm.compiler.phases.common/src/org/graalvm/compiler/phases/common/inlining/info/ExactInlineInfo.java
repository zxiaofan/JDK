/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.common.inlining.info;

import jdk.internal.vm.compiler.collections.EconomicSet;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.phases.common.inlining.info.elem.Inlineable;
import org.graalvm.compiler.phases.util.Providers;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Represents an inlining opportunity where the compiler can statically determine a monomorphic
 * target method and therefore is able to determine the called method exactly.
 */
public class ExactInlineInfo extends AbstractInlineInfo {

    protected final ResolvedJavaMethod concrete;
    private Inlineable inlineableElement;
    private boolean suppressNullCheck;

    public ExactInlineInfo(Invoke invoke, ResolvedJavaMethod concrete) {
        super(invoke);
        this.concrete = concrete;
        assert concrete != null;
    }

    public void suppressNullCheck() {
        suppressNullCheck = true;
    }

    @Override
    public EconomicSet<Node> inline(Providers providers, String reason) {
        return inline(invoke, concrete, inlineableElement, !suppressNullCheck, reason);
    }

    @Override
    public void tryToDevirtualizeInvoke(Providers providers) {
        // nothing todo, can already be bound statically
    }

    @Override
    public int numberOfMethods() {
        return 1;
    }

    @Override
    public ResolvedJavaMethod methodAt(int index) {
        assert index == 0;
        return concrete;
    }

    @Override
    public double probabilityAt(int index) {
        assert index == 0;
        return 1.0;
    }

    @Override
    public double relevanceAt(int index) {
        assert index == 0;
        return 1.0;
    }

    @Override
    public String toString() {
        return "exact " + concrete.format("%H.%n(%p):%r");
    }

    @Override
    public Inlineable inlineableElementAt(int index) {
        assert index == 0;
        return inlineableElement;
    }

    @Override
    public void setInlinableElement(int index, Inlineable inlineableElement) {
        assert index == 0;
        this.inlineableElement = inlineableElement;
    }

    @Override
    public boolean shouldInline() {
        return concrete.shouldBeInlined();
    }
}
