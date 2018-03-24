/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.ir;

import jdk.nashorn.internal.codegen.types.Type;
import jdk.nashorn.internal.ir.annotations.Immutable;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;

/**
 * IR representation of a property access (period operator.)
 */
@Immutable
public final class AccessNode extends BaseNode {
    private static final long serialVersionUID = 1L;

    /** Property name. */
    private final String property;

    /**
     * Constructor
     *
     * @param token     token
     * @param finish    finish
     * @param base      base node
     * @param property  property
     */
    public AccessNode(final long token, final int finish, final Expression base, final String property) {
        super(token, finish, base, false, false);
        this.property = property;
    }

    private AccessNode(final AccessNode accessNode, final Expression base, final String property, final boolean isFunction,
                       final Type type, final int id, final boolean isSuper) {
        super(accessNode, base, isFunction, type, id, isSuper);
        this.property = property;
    }

    /**
     * Assist in IR navigation.
     * @param visitor IR navigating visitor.
     */
    @Override
    public Node accept(final NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterAccessNode(this)) {
            return visitor.leaveAccessNode(
                setBase((Expression)base.accept(visitor)));
        }
        return this;
    }

    @Override
    public void toString(final StringBuilder sb, final boolean printType) {
        final boolean needsParen = tokenType().needsParens(getBase().tokenType(), true);

        if (printType) {
            optimisticTypeToString(sb);
        }

        if (needsParen) {
            sb.append('(');
        }

        base.toString(sb, printType);

        if (needsParen) {
            sb.append(')');
        }
        sb.append('.');

        sb.append(property);
    }

    /**
     * Get the property name
     *
     * @return the property name
     */
    public String getProperty() {
        return property;
    }

    private AccessNode setBase(final Expression base) {
        if (this.base == base) {
            return this;
        }
        return new AccessNode(this, base, property, isFunction(), type, programPoint, isSuper());
    }

    @Override
    public AccessNode setType(final Type type) {
        if (this.type == type) {
            return this;
        }
        return new AccessNode(this, base, property, isFunction(), type, programPoint, isSuper());
    }

    @Override
    public AccessNode setProgramPoint(final int programPoint) {
        if (this.programPoint == programPoint) {
            return this;
        }
        return new AccessNode(this, base, property, isFunction(), type, programPoint, isSuper());
    }

    @Override
    public AccessNode setIsFunction() {
        if (isFunction()) {
            return this;
        }
        return new AccessNode(this, base, property, true, type, programPoint, isSuper());
    }

    @Override
    public AccessNode setIsSuper() {
        if (isSuper()) {
            return this;
        }
        return new AccessNode(this, base, property, isFunction(), type, programPoint, true);
    }
}
