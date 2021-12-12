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
 * A tree node to declare a new instance of a class.
 *
 * For example:
 * <pre>
 *   new <em>identifier</em> ( )
 *
 *   new <em>identifier</em> ( <em>arguments</em> )
 *
 *   new <em>typeArguments</em> <em>identifier</em> ( <em>arguments</em> )
 *       <em>classBody</em>
 *
 *   <em>enclosingExpression</em>.new <em>identifier</em> ( <em>arguments</em> )
 * </pre>
 *
 * @jls 15.9 Class Instance Creation Expressions
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface NewClassTree extends ExpressionTree {
    /**
     * Returns the enclosing expression, or {@code null} if none.
     * @return the enclosing expression
     */
    ExpressionTree getEnclosingExpression();

    /**
     * Returns the type arguments for the object being created.
     * @return the type arguments
     */
    List<? extends Tree> getTypeArguments();

    /**
     * Returns the name of the class being instantiated.
     * @return the name
     */
    ExpressionTree getIdentifier();

    /**
     * Returns the arguments for the constructor to be invoked.
     * @return the arguments
     */
    List<? extends ExpressionTree> getArguments();

    /**
     * Returns the class body if an anonymous class is being
     * instantiated, and {@code null} otherwise.
     * @return the class body
     */
    ClassTree getClassBody();
}
