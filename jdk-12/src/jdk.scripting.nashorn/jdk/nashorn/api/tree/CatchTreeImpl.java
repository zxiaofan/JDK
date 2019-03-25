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

import jdk.nashorn.internal.ir.CatchNode;

final class CatchTreeImpl extends TreeImpl implements CatchTree {
    private final ExpressionTree param;
    private final BlockTree block;
    private final ExpressionTree condition;

    CatchTreeImpl(final CatchNode node,
            final ExpressionTree param,
            final BlockTree block,
            final ExpressionTree condition) {
        super(node);
        this.param = param;
        this.block = block;
        this.condition = condition;
    }

    @Override
    public Kind getKind() {
        return Kind.CATCH;
    }

    @Override
    public ExpressionTree getParameter() {
        return param;
    }

    @Override
    public BlockTree getBlock() {
        return block;
    }

    @Override
    public ExpressionTree getCondition() {
        return condition;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitCatch(this, data);
    }
}
