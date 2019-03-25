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

import java.util.List;

/**
 * A tree node for <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-function-defining-expressions">function expressions</a> including <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-arrow-function-definitions">arrow functions</a>.
 *
 * For example:
 * <pre>
 *   <em>var</em> func = <em>function</em>
 *      ( <em>parameters</em> )
 *      <em>body</em>
 * </pre>
 *
 * <pre>
 *   <em>var</em> func = <em>(x) =&gt; x+1</em>
 * </pre>
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface FunctionExpressionTree extends ExpressionTree {
    /**
     * Returns the name of the function being declared.
     *
     * @return name the function declared
     */
    IdentifierTree getName();

    /**
     * Returns the parameters of this function.
     *
     * @return the list of parameters
     */
    List<? extends ExpressionTree> getParameters();

    /**
     * Returns the body of this function. This may be a {@link BlockTree} when this
     * function has a block body. This is an {@link ExpressionTree} when the function body
     * is a concise expression as in an expression arrow, or in an expression closure.
     *
     * @return the body of this function
     */
    Tree getBody();

    /**
     * Is this a strict function?
     *
     * @return true if this function is strict
     */
    boolean isStrict();

    /**
     * Is this a arrow function?
     *
     * @return true if this is a arrow function
     */
    boolean isArrow();

    /**
     * Is this a generator function?
     *
     * @return true if this is a generator function
     */
    boolean isGenerator();
}
