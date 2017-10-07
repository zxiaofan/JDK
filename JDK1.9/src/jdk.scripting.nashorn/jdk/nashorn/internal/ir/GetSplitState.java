/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package jdk.nashorn.internal.ir;

import jdk.nashorn.internal.codegen.CompilerConstants;
import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;
import jdk.nashorn.internal.runtime.Scope;

/**
 * Synthetic AST node that represents loading of the scope object and invocation of the {@link Scope#getSplitState()}
 * method on it. It has no JavaScript source representation and only occurs in synthetic functions created by
 * the split-into-functions transformation.
 */
public final class GetSplitState extends Expression {
    private static final long serialVersionUID = 1L;

    /** The sole instance of this AST node. */
    public final static GetSplitState INSTANCE = new GetSplitState();

    private GetSplitState() {
        super(NO_TOKEN, NO_FINISH);
    }

    @Override
    public Type getType() {
        return Type.INT;
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        return visitor.enterGetSplitState(this) ? visitor.leaveGetSplitState(this) : this;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        if (printType) {
            sb.append("{I}");
        }
        sb.append(CompilerConstants.SCOPE.symbolName()).append('.').append(Scope.GET_SPLIT_STATE.name()).append("()");
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
