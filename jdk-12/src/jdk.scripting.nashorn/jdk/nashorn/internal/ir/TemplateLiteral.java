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

import java.util.Collections;
import java.util.List;
import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;

/**
 * Represents ES6 template string expression. Note that this Node class is used
 * only in "parse only" mode. In evaluation mode, Parser directly folds template
 * literal as string concatenation. Parser API uses this node to represent ES6
 * template literals "as is" rather than as a String concatenation.
 */
public final class TemplateLiteral extends Expression {
    private static final long serialVersionUID = 1L;
    private final List<Expression> exprs;

    public TemplateLiteral(final List<Expression> exprs) {
        super(exprs.get(0).getToken(), exprs.get(exprs.size() - 1).finish);
        this.exprs = exprs;
    }

    @Override
    public Type getType() {
        return Type.STRING;
    }

    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterTemplateLiteral(this)) {
            return visitor.leaveTemplateLiteral(this);
        }

        return this;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        for (final Expression expr : exprs) {
            sb.append(expr);
        }
    }

    /**
     * The list of expressions that are part of this template literal.
     *
     * @return the list of expressions that are part of this template literal.
     */
    public List<Expression> getExpressions() {
        return Collections.unmodifiableList(exprs);
    }
}