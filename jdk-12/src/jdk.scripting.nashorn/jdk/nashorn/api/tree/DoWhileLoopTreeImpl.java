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

import jdk.nashorn.internal.ir.WhileNode;

final class DoWhileLoopTreeImpl extends StatementTreeImpl implements DoWhileLoopTree {
    private final ExpressionTree cond;
    private final StatementTree stat;

    DoWhileLoopTreeImpl(final WhileNode node, final ExpressionTree cond, final StatementTree stat) {
        super(node);
        assert node.isDoWhile() : "do while expected";
        this.cond = cond;
        this.stat = stat;
    }

    @Override
    public Kind getKind() {
        return Kind.DO_WHILE_LOOP;
    }

    @Override
    public ExpressionTree getCondition() {
        return cond;
    }

    @Override
    public StatementTree getStatement() {
        return stat;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitDoWhileLoop(this, data);
    }
}
