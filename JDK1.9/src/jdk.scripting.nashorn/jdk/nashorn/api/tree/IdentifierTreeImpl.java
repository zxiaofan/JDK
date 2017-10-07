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

import jdk.nashorn.internal.ir.IdentNode;
import jdk.nashorn.internal.ir.Module;

final class IdentifierTreeImpl extends ExpressionTreeImpl implements IdentifierTree {
    private final String name;

    IdentifierTreeImpl(final IdentNode node) {
        super(node);
        this.name = node.getName();
    }

    @Override
    public Kind getKind() {
        return Kind.IDENTIFIER;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isRestParameter() {
        return ((IdentNode)node).isRestParameter();
    }

    @Override
    public boolean isSuper() {
        final IdentNode ident = (IdentNode)node;
        return ident.isDirectSuper() || "super".equals(ident.getName());
    }

    @Override
    public boolean isThis() {
        return "this".equals(((IdentNode)node).getName());
    }

    @Override
    public boolean isStar() {
        return Module.STAR_NAME.equals(((IdentNode)node).getName());
    }

    @Override
    public boolean isDefault() {
        return Module.DEFAULT_NAME.equals(((IdentNode)node).getName());
    }

    @Override
    public boolean isStarDefaultStar() {
        return Module.DEFAULT_EXPORT_BINDING_NAME.equals(((IdentNode)node).getName());
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitIdentifier(this, data);
    }
}
