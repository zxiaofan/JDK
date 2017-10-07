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

import jdk.nashorn.internal.ir.WithNode;

final class WithTreeImpl extends StatementTreeImpl implements WithTree {
    private final ExpressionTree scope;
    private final StatementTree stat;
    WithTreeImpl(final WithNode node, final ExpressionTree scope,
            final StatementTree stat) {
        super(node);
        this.scope = scope;
        this.stat = stat;
    }

    @Override
    public Kind getKind() {
        return Kind.WITH;
    }

    @Override
    public ExpressionTree getScope() {
        return scope;
    }

    @Override
    public StatementTree getStatement() {
        return stat;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitWith(this, data);
    }
}
