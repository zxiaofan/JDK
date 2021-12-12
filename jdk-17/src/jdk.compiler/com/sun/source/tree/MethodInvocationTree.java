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
 * A tree node for a method invocation expression.
 *
 * For example:
 * <pre>
 *   <em>identifier</em> ( <em>arguments</em> )
 *
 *   this . <em>typeArguments</em> <em>identifier</em> ( <em>arguments</em> )
 * </pre>
 *
 * @jls 15.12 Method Invocation Expressions
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface MethodInvocationTree extends ExpressionTree {
    /**
     * Returns the type arguments for this method invocation.
     * @return the type arguments
     */
    List<? extends Tree> getTypeArguments();

    /**
     * Returns the expression identifying the method to be invoked.
     * @return the method selection expression
     */
    ExpressionTree getMethodSelect();

    /**
     * Returns the arguments for the method invocation.
     * @return the arguments
     */
    List<? extends ExpressionTree> getArguments();
}
