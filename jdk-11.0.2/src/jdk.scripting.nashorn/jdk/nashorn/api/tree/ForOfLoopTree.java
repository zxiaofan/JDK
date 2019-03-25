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

/**
 * A tree node for <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-for-in-and-for-of-statements">for..of statement</a>.
 *
 * For example:
 * <pre>
 *   for ( <em>variable</em> of <em>expression</em> )
 *       <em>statement</em>
 * </pre>
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface ForOfLoopTree extends LoopTree {
    /**
     * The for..of left hand side expression.
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
     * The statement contained in this for..of statement.
     *
     * @return the statement
     */
    @Override
    StatementTree getStatement();
}

