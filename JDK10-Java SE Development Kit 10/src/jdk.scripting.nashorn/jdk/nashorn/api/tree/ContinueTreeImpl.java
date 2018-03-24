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

import jdk.nashorn.internal.ir.ContinueNode;

final class ContinueTreeImpl extends StatementTreeImpl implements ContinueTree {
    private final String label;

    ContinueTreeImpl(final ContinueNode node) {
        super(node);
        this.label = node.getLabelName();
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.CONTINUE;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitContinue(this, data);
    }
}
