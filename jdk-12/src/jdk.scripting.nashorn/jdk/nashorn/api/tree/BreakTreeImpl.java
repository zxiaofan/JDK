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

import jdk.nashorn.internal.ir.BreakNode;

final class BreakTreeImpl extends StatementTreeImpl implements BreakTree {
    private final String label;

    BreakTreeImpl(final BreakNode node) {
        super(node);
        this.label = node.getLabelName();
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.BREAK;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitBreak(this, data);
    }
}
