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

import jdk.nashorn.internal.ir.PropertyNode;

final class PropertyTreeImpl extends TreeImpl implements PropertyTree  {
    private final ExpressionTree key;
    private final ExpressionTree value;
    private final FunctionExpressionTree getter;
    private final FunctionExpressionTree setter;
    private final boolean isStatic, isComputed;

    PropertyTreeImpl(final PropertyNode node,
            final ExpressionTree key,
            final ExpressionTree value,
            final FunctionExpressionTree getter,
            final FunctionExpressionTree setter) {
        super(node);
        this.key    = key;
        this.value  = value;
        this.getter = getter;
        this.setter = setter;
        this.isStatic = node.isStatic();
        this.isComputed = node.isComputed();
    }

    @Override
    public Kind getKind() {
        return Kind.PROPERTY;
    }

    @Override
    public ExpressionTree getKey() {
        return key;
    }

    @Override
    public ExpressionTree getValue() {
        return value;
    }

    @Override
    public FunctionExpressionTree getGetter() {
        return getter;
    }

    @Override
    public FunctionExpressionTree getSetter() {
        return setter;
    }

    @Override
    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public boolean isComputed() {
        return isComputed;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitProperty(this, data);
    }
}
