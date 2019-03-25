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

final class WhileLoopTreeImpl extends StatementTreeImpl implements WhileLoopTree {
    private final ExpressionTree cond;
    private final StatementTree stat;

    WhileLoopTreeImpl(final WhileNode node, final ExpressionTree cond, final StatementTree stat) {
        super(node);
        assert !node.isDoWhile() : "while expected";
        this.cond = cond;
        this.stat = stat;
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.WHILE_LOOP;
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
        return visitor.visitWhileLoop(this, data);
    }
}
