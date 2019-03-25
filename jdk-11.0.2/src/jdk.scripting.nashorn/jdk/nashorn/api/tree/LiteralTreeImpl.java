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

import jdk.nashorn.internal.ir.LiteralNode;

final class LiteralTreeImpl extends ExpressionTreeImpl implements LiteralTree {
    private final Object value;
    private final Kind kind;
    LiteralTreeImpl(final LiteralNode<?> node) {
        super(node);
        this.kind = literalKind(node);
        this.value = node.getValue();
    }

    @Override
    public Kind getKind() {
        return kind;
    }

    @Override
    public Object getValue() {
        return value;
    }

    private static Kind literalKind(final LiteralNode<?> node) {
        if (node.isBoolean()) {
            return Kind.BOOLEAN_LITERAL;
        } else if (node.isNumeric()) {
            return Kind.NUMBER_LITERAL;
        } else if (node.isString()) {
            return Kind.STRING_LITERAL;
        } else if (node.isNull()) {
            return Kind.NULL_LITERAL;
        } else {
            throw new AssertionError("should not reach here: " + node.getValue());
        }
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitLiteral(this, data);
    }
}
