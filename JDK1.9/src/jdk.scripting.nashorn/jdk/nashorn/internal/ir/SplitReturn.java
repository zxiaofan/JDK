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

import jdk.nashorn.internal.ir.visitor.NodeVisitor;

/**
 * Synthetic AST node that represents return from a split fragment of a split function for control flow reasons (break
 * or continue into a target outside the current fragment). It has no JavaScript source representation and only occurs
 * in synthetic functions created by the split-into-functions transformation. It is different from a return node in
 * that the return value is irrelevant, and doesn't affect the function's return type calculation.
 */
public final class SplitReturn extends Statement {
    private static final long serialVersionUID = 1L;

    /** The sole instance of this AST node. */
    public static final SplitReturn INSTANCE = new SplitReturn();

    private SplitReturn() {
        super(NO_LINE_NUMBER, NO_TOKEN, NO_FINISH);
    }

    @Override
    public boolean isTerminal() {
        return true;
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        return visitor.enterSplitReturn(this) ? visitor.leaveSplitReturn(this) : this;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        sb.append(":splitreturn;");
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
