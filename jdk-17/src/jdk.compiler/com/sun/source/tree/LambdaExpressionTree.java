/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * A tree node for a lambda expression.
 *
 * For example:
 * <pre>{@code
 *   ()->{}
 *   (List<String> ls)->ls.size()
 *   (x,y)-> { return x + y; }
 * }</pre>
 */
public interface LambdaExpressionTree extends ExpressionTree {

    /**
     * Lambda expressions come in two forms:
     * <ul>
     * <li> expression lambdas, whose body is an expression, and
     * <li> statement lambdas, whose body is a block
     * </ul>
     */
    public enum BodyKind {
        /** enum constant for expression lambdas */
        EXPRESSION,
        /** enum constant for statement lambdas */
        STATEMENT
    }

    /**
     * Returns the parameters of this lambda expression.
     * @return the parameters
     */
    List<? extends VariableTree> getParameters();

    /**
     * Returns the body of the lambda expression.
     * @return the body
     */
    Tree getBody();

    /**
     * Returns the kind of the body of the lambda expression.
     * @return the kind of the body
     */
    BodyKind getBodyKind();
}
