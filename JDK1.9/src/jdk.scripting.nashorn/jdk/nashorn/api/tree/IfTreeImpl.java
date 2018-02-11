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

import jdk.nashorn.internal.ir.IfNode;

final class IfTreeImpl extends StatementTreeImpl implements IfTree {
    private final ExpressionTree cond;
    private final StatementTree thenStat;
    private final StatementTree elseStat;
    IfTreeImpl(final IfNode node, final ExpressionTree cond,
            final StatementTree thenStat, final StatementTree elseStat) {
        super(node);
        this.cond = cond;
        this.thenStat = thenStat;
        this.elseStat = elseStat;
    }

    @Override
    public Kind getKind() {
        return Kind.IF;
    }

    @Override
    public ExpressionTree getCondition() {
        return cond;
    }

    @Override
    public StatementTree getThenStatement() {
        return thenStat;
    }

    /**
     * @return null if this if statement has no else branch.
     */
    @Override
    public StatementTree getElseStatement() {
        return elseStat;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitIf(this, data);
    }
}
