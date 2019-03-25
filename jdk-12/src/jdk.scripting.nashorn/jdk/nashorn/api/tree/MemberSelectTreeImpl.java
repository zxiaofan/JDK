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

import jdk.nashorn.internal.ir.AccessNode;

final class MemberSelectTreeImpl extends ExpressionTreeImpl
    implements MemberSelectTree {
    private final String ident;
    private final ExpressionTree expr;
    MemberSelectTreeImpl(final AccessNode node, final ExpressionTree expr) {
        super(node);
        this.ident = node.getProperty();
        this.expr = expr;
    }

    @Override
    public Kind getKind() {
        return Kind.MEMBER_SELECT;
    }

    @Override
    public ExpressionTree getExpression() {
        return expr;
    }

    @Override
    public String getIdentifier() {
        return ident;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitMemberSelect(this, data);
    }
}
