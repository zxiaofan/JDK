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

import java.util.List;
import jdk.nashorn.internal.ir.Expression;

final class TemplateLiteralTreeImpl extends ExpressionTreeImpl
        implements TemplateLiteralTree {

    private final List<? extends ExpressionTree> expressions;

    TemplateLiteralTreeImpl(final Expression node, final List<? extends ExpressionTree> expressions) {
        super(node);
        this.expressions = expressions;
    }

    @Override
    public Kind getKind() {
        return Kind.TEMPLATE_LITERAL;
    }

    @Override
    public List<? extends ExpressionTree> getExpressions() {
        return expressions;
    }


    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitTemplateLiteral(this, data);
    }
}
