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
import jdk.nashorn.internal.ir.TryNode;

final class TryTreeImpl extends StatementTreeImpl implements TryTree {
    private final BlockTree block;
    private final List<? extends CatchTree> catches;
    private final BlockTree finallyBlock;
    TryTreeImpl(final TryNode node,
            final BlockTree block,
            final List<? extends CatchTree> catches,
            final BlockTree finallyBlock) {
        super(node);
        this.block = block;
        this.catches = catches;
        this.finallyBlock = finallyBlock;
    }

    @Override
    public Kind getKind() {
        return Kind.TRY;
    }

    @Override
    public BlockTree getBlock() {
        return block;
    }

    @Override
    public List<? extends CatchTree> getCatches() {
        return catches;
    }

    @Override
    public BlockTree getFinallyBlock() {
        return finallyBlock;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitTry(this, data);
    }
}
