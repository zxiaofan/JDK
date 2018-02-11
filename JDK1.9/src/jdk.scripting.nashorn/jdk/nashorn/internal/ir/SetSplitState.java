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
import jdk.nashorn.internal.ir.visitor.NodeVisitor;
import jdk.nashorn.internal.runtime.Scope;

/**
 * Synthetic AST node that represents loading of the scope object and invocation of the {@link Scope#setSplitState(int)}
 * method on it. It has no JavaScript source representation and only occurs in synthetic functions created by
 * the split-into-functions transformation.
 */
public final class SetSplitState extends Statement {
    private static final long serialVersionUID = 1L;

    private final int state;

    /**
     * Creates a new split state setter
     * @param state the state to set
     * @param lineNumber the line number where it is inserted
     */
    public SetSplitState(final int state, final int lineNumber) {
        super(lineNumber, NO_TOKEN, NO_FINISH);
        this.state = state;
    }

    /**
     * Returns the state this setter sets.
     * @return the state this setter sets.
     */
    public int getState() {
        return state;
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        return visitor.enterSetSplitState(this) ? visitor.leaveSetSplitState(this) : this;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        sb.append(CompilerConstants.SCOPE.symbolName()).append('.').append(Scope.SET_SPLIT_STATE.name())
        .append('(').append(state).append(");");
    }
}
