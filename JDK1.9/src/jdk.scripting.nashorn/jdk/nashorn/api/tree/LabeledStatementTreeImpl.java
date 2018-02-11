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

import jdk.nashorn.internal.ir.LabelNode;

final class LabeledStatementTreeImpl extends StatementTreeImpl
    implements LabeledStatementTree {
    private final String name;
    private final StatementTree stat;

    LabeledStatementTreeImpl(final LabelNode node, final StatementTree stat) {
        super(node);
        this.name = node.getLabelName();
        this.stat = stat;
    }

    @Override
    public Kind getKind() {
        return Kind.LABELED_STATEMENT;
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public StatementTree getStatement() {
        return stat;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitLabeledStatement(this, data);
    }
}
