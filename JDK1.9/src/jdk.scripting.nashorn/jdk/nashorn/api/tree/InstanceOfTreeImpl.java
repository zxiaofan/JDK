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

import jdk.nashorn.internal.ir.BinaryNode;
import jdk.nashorn.internal.parser.TokenType;

final class InstanceOfTreeImpl extends BinaryTreeImpl implements InstanceOfTree {
    InstanceOfTreeImpl(final BinaryNode node,
            final ExpressionTree expr,
            final ExpressionTree type) {
        super(node, expr, type);
        assert node.isTokenType(TokenType.INSTANCEOF) : "instanceof expected";
    }

    @Override
    public Kind getKind() {
        return Kind.INSTANCE_OF;
    }

    @Override
    public ExpressionTree getExpression() {
        return getLeftOperand();
    }

    @Override
    public Tree getType() {
        return getRightOperand();
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitInstanceOf(this, data);
    }
}
