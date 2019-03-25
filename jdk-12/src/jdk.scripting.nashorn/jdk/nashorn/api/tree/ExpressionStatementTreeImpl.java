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

import jdk.nashorn.internal.ir.ExpressionStatement;

final class ExpressionStatementTreeImpl extends StatementTreeImpl implements ExpressionStatementTree {
    private final ExpressionTree expr;

    ExpressionStatementTreeImpl(final ExpressionStatement es, final ExpressionTree expr) {
        super(es);
        this.expr = expr;
    }

    @Override
    public Kind getKind() {
        return Kind.EXPRESSION_STATEMENT;
    }

    @Override
    public ExpressionTree getExpression() {
        return expr;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitExpressionStatement(this, data);
    }
}
