/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

abstract class LexicalContextExpression extends Expression implements LexicalContextNode {
    private static final long serialVersionUID = 1L;

    LexicalContextExpression(final LexicalContextExpression expr) {
        super(expr);
    }

    LexicalContextExpression(final long token, final int start, final int finish) {
        super(token, start, finish);
    }

    LexicalContextExpression(final long token, final int finish) {
        super(token, finish);
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        return Acceptor.accept(this, visitor);
    }
}
