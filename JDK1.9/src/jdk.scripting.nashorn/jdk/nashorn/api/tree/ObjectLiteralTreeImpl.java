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
import jdk.nashorn.internal.ir.ObjectNode;

final class ObjectLiteralTreeImpl extends ExpressionTreeImpl
    implements ObjectLiteralTree {
    private final List<? extends PropertyTree> props;
    ObjectLiteralTreeImpl(final ObjectNode node, final List<? extends PropertyTree> props) {
        super(node);
        this.props = props;
    }

    @Override
    public Kind getKind() {
        return Kind.OBJECT_LITERAL;
    }

    @Override
    public List<? extends PropertyTree> getProperties() {
        return props;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitObjectLiteral(this, data);
    }
}
