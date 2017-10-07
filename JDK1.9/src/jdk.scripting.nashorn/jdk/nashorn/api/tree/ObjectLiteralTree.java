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

/**
 * Represents ECMAScript object literal expression.
 *
 * @since 9
 */
public interface ObjectLiteralTree extends ExpressionTree {
    /**
     * Returns the list of properties of this object literal.
     *
     * @return the list of properties of this object literal
     */
    public List<? extends PropertyTree> getProperties();
}
