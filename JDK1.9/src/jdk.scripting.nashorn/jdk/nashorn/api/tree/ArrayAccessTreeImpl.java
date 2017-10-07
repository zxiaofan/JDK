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

import jdk.nashorn.internal.ir.Expression;

final class ArrayAccessTreeImpl extends ExpressionTreeImpl implements ArrayAccessTree {

    private final ExpressionTree base, index;

    ArrayAccessTreeImpl(final Expression node, final ExpressionTree base, final ExpressionTree index) {
        super(node);
        this.base = base;
        this.index = index;
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.ARRAY_ACCESS;
    }

    @Override
    public ExpressionTree getExpression() {
        return base;
    }

    @Override
    public ExpressionTree getIndex() {
        return index;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitArrayAccess(this, data);
    }
}
