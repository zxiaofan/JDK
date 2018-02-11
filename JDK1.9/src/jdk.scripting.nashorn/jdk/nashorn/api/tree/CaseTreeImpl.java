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

import java.util.List;
import jdk.nashorn.internal.ir.CaseNode;

final class CaseTreeImpl extends TreeImpl implements CaseTree {
    private final ExpressionTree expression;
    private final List<? extends StatementTree> statements;

    public CaseTreeImpl(final CaseNode node,
        final ExpressionTree expression,
        final List<? extends StatementTree> statements) {
        super(node);
        this.expression = expression;
        this.statements = statements;
    }

    @Override
    public Kind getKind() {
        return Kind.CASE;
    }

    @Override
    public ExpressionTree getExpression() {
        return expression;
    }

    @Override
    public List<? extends StatementTree> getStatements() {
        return statements;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitCase(this, data);
    }
}
