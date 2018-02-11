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
 * Represents ECMAScript array literal expression.
 *
 * @since 9
 */
public interface ArrayLiteralTree extends ExpressionTree {
    /**
     * Returns the list of Array element expressions.
     *
     * @return array element expressions
     */
    public List<? extends ExpressionTree> getElements();
}
