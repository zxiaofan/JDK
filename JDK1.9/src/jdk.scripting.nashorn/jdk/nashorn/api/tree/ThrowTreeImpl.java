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

import jdk.nashorn.internal.ir.ThrowNode;

final class ThrowTreeImpl extends StatementTreeImpl implements ThrowTree {
    private final ExpressionTree expr;
    ThrowTreeImpl(final ThrowNode node, final ExpressionTree expr) {
        super(node);
        this.expr = expr;
    }

    @Override
    public Kind getKind() {
        return Kind.THROW;
    }

    @Override
    public ExpressionTree getExpression() {
        return expr;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitThrow(this, data);
    }
}
