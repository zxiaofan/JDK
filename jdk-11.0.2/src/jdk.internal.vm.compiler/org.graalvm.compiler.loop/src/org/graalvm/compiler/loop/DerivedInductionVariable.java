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


package org.graalvm.compiler.loop;

import org.graalvm.compiler.nodes.StructuredGraph;

/**
 * Base class of the derived induction variables.
 */
public abstract class DerivedInductionVariable extends InductionVariable {

    protected final InductionVariable base;

    public DerivedInductionVariable(LoopEx loop, InductionVariable base) {
        super(loop);
        this.base = base;
    }

    @Override
    public StructuredGraph graph() {
        return base.graph();
    }

    public InductionVariable getBase() {
        return base;
    }
}
