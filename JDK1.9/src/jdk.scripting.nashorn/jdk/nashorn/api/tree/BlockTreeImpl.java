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
import jdk.nashorn.internal.ir.Block;
import jdk.nashorn.internal.ir.BlockStatement;

final class BlockTreeImpl extends StatementTreeImpl implements BlockTree {
    private final List<? extends StatementTree> statements;

    BlockTreeImpl(final BlockStatement node, final List<? extends StatementTree> statements) {
        super(node);
        this.statements = statements;
    }

    BlockTreeImpl(final Block node, final List<? extends StatementTree> statements) {
        super(node);
        this.statements = statements;
    }

    @Override
    public Kind getKind() {
        return Kind.BLOCK;
    }

    @Override
    public List<? extends StatementTree> getStatements() {
        return statements;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitBlock(this, data);
    }
}
