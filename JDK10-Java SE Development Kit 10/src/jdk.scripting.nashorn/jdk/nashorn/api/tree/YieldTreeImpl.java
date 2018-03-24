/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.nashorn.internal.ir.Expression;
import jdk.nashorn.internal.ir.UnaryNode;
import jdk.nashorn.internal.parser.TokenType;

final class YieldTreeImpl extends ExpressionTreeImpl
        implements YieldTree {

    private final ExpressionTree expr;

    YieldTreeImpl(final Expression exprNode, final ExpressionTree expr) {
        super(exprNode);
        this.expr = expr;
    }

    @Override
    public Kind getKind() {
        return Kind.YIELD;
    }

    @Override
    public ExpressionTree getExpression() {
        return expr;
    }

    @Override
    public boolean isStar() {
        return ((UnaryNode) node).isTokenType(TokenType.YIELD_STAR);
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitYield(this, data);
    }
}
