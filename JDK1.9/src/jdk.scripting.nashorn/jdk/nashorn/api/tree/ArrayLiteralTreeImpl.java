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
import jdk.nashorn.internal.ir.LiteralNode;

final class ArrayLiteralTreeImpl extends ExpressionTreeImpl
    implements ArrayLiteralTree {
    private final List<? extends ExpressionTree> elements;
    ArrayLiteralTreeImpl(final LiteralNode<?> node, final List<? extends ExpressionTree> elements) {
        super(node);
        this.elements = elements;
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.ARRAY_LITERAL;
    }

    @Override
    public List<? extends ExpressionTree> getElements() {
        return elements;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitArrayLiteral(this, data);
    }
}
