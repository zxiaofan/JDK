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

import jdk.nashorn.internal.ir.EmptyNode;

final class EmptyStatementTreeImpl extends StatementTreeImpl implements EmptyStatementTree {
    EmptyStatementTreeImpl(final EmptyNode node) {
        super(node);
    }

    @Override
    public Kind getKind() {
        return Kind.EMPTY_STATEMENT;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitEmptyStatement(this, data);
    }
}
