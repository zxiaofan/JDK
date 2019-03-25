/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.nashorn.internal.ir.VarNode;

final class VariableTreeImpl extends StatementTreeImpl implements VariableTree {
    private final IdentifierTree ident;
    private final ExpressionTree init;

    VariableTreeImpl(final VarNode node, final IdentifierTree ident, final ExpressionTree init) {
        super(node);
        this.ident = ident;
        this.init = init;
    }

    @Override
    public Kind getKind() {
        return Kind.VARIABLE;
    }

    @Override
    public ExpressionTree getBinding() {
        return ident;
    }

    @Override
    public ExpressionTree getInitializer() {
        return init;
    }

    @Override
    public boolean isConst() {
        return ((VarNode)node).isConst();
    }

    @Override
    public boolean isLet() {
        return ((VarNode)node).isLet();
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitVariable(this, data);
    }
}
