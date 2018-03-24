/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Collections;
import java.util.List;

import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;

/**
 * IR for CoverParenthesizedExpressionAndArrowParameterList, used only during parsing.
 */
public final class ExpressionList extends Expression {
    private static final long serialVersionUID = 1L;

    private final List<Expression> expressions;

    /**
     * Constructor.
     *
     * @param token token
     * @param finish finish
     * @param expressions expression
     */
    public ExpressionList(final long token, final int finish, final List<Expression> expressions) {
        super(token, finish);
        this.expressions = expressions;
    }

    /**
     * Get the list of expressions.
     *
     * @return the list of expressions
     */
    public List<Expression> getExpressions() {
        return Collections.unmodifiableList(expressions);
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        sb.append("(");
        boolean first = true;
        for (final Expression expression : expressions) {
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }
            expression.toString(sb, printType);
        }
        sb.append(")");
    }
}
