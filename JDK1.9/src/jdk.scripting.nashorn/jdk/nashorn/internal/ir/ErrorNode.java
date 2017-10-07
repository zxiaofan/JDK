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

import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.ir.annotations.Immutable;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;

/**
 * IR representation for an error expression.
 */
@Immutable
public final class ErrorNode extends Expression {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     *
     * @param token      token
     * @param finish     finish
     */
    public ErrorNode(final long token, final int finish) {
        super(token, finish);
    }

    @Override
    public Type getType() {
        return Type.OBJECT;
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterErrorNode(this)) {
            return visitor.leaveErrorNode(this);
        }

        return this;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        sb.append("<error>");
    }
}

