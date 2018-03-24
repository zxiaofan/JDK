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

/**
 * A tree node for for..in statement
 *
 * For example:
 * <pre>
 *   for ( <em>variable</em> in <em>expression</em> )
 *       <em>statement</em>
 * </pre>
 *
 * @since 9
 */
public interface ForInLoopTree extends LoopTree {
    /**
     * The for..in left hand side expression.
     *
     * @return the left hand side expression
     */
    ExpressionTree getVariable();

    /**
     * The object or array being whose properties are iterated.
     *
     * @return the object or array expression being iterated
     */
    ExpressionTree getExpression();

    /**
     * The statement contained in this for..in statement.
     *
     * @return the statement
     */
    @Override
    StatementTree getStatement();

    /**
     * Returns if this is a for..each..in statement or not.
     *
     * @return true if this is a for..each..in statement
     */
    boolean isForEach();
}
