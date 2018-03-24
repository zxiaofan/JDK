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

import jdk.nashorn.internal.ir.ForNode;

final class ForLoopTreeImpl extends StatementTreeImpl implements ForLoopTree {
    private final ExpressionTree init;
    private final ExpressionTree cond;
    private final ExpressionTree update;
    private final StatementTree stat;

    ForLoopTreeImpl(final ForNode node,
        final ExpressionTree init,
        final ExpressionTree cond,
        final ExpressionTree update,
        final StatementTree  stat) {
        super(node);
        assert !node.isForIn() : "for statement expected";
        this.init = init;
        this.cond = cond;
        this.update = update;
        this.stat = stat;
    }

    @Override
    public Kind getKind() {
        return Kind.FOR_LOOP;
    }

    @Override
    public ExpressionTree getInitializer() {
        return init;
    }

    @Override
    public ExpressionTree getCondition() {
        return cond;
    }

    @Override
    public ExpressionTree getUpdate() {
        return update;
    }

    @Override
    public StatementTree getStatement() {
        return stat;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitForLoop(this, data);
    }
}
