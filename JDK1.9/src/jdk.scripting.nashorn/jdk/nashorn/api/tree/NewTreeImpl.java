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
 *
 *
 */
package jdk.nashorn.api.tree;

import jdk.nashorn.internal.ir.UnaryNode;
import jdk.nashorn.internal.parser.TokenType;

final class NewTreeImpl extends ExpressionTreeImpl implements NewTree {
    private final ExpressionTree constrExpr;

    NewTreeImpl(final UnaryNode node, final ExpressionTree constrExpr) {
        super(node);
        assert (node.isTokenType(TokenType.NEW)) : "new expected";
        this.constrExpr = constrExpr;
    }

    @Override
    public Kind getKind() {
        return Kind.NEW;
    }

    @Override
    public ExpressionTree getConstructorExpression() {
        return constrExpr;
    }

    @Override
    public <R, D> R accept(final TreeVisitor<R, D> visitor, final D data) {
        return visitor.visitNew(this, data);
    }
}
