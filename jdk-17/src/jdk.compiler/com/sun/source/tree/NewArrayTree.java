/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

import java.util.List;

/**
 * A tree node for an expression to create a new instance of an array.
 *
 * For example:
 * <pre>
 *   new <em>type</em> <em>dimensions</em> <em>initializers</em>
 *
 *   new <em>type</em> <em>dimensions</em> [ ] <em>initializers</em>
 * </pre>
 *
 * @jls 15.10.1 Array Creation Expressions
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface NewArrayTree extends ExpressionTree {
    /**
     * Returns the base type of the expression.
     * May be {@code null} for an array initializer expression.
     * @return the base type
     */
    Tree getType();

    /**
     * Returns the dimension expressions for the type.
     *
     * @return the dimension expressions
     */
    List<? extends ExpressionTree> getDimensions();

    /**
     * Returns the initializer expressions.
     *
     * @return the initializer expressions
     */
    List<? extends ExpressionTree> getInitializers();

    /**
     * Returns the annotations on the base type.
     * @return the annotations
     */
    List<? extends AnnotationTree> getAnnotations();

    /**
     * Returns the annotations on each of the dimension
     * expressions.
     * @return the annotations on the dimensions expressions
     */
    List<? extends List<? extends AnnotationTree>> getDimAnnotations();
}
