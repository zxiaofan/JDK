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
 *  A tree node for <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-generator-function-definitions">yield expressions</a> used in generator functions.
 *
 * For example:
 * <pre>
 * <em>function*</em> id(){
 *     var index = 0;
 *     while(index &lt; 10)
 *         <em>yield index++;</em>
 * }
 * </pre>
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface YieldTree extends ExpressionTree {
    /**
     * Returns the expression that is yielded.
     *
     * @return The expression that is yielded.
     */
    ExpressionTree getExpression();

    /**
     * Is this a yield * expression in a generator function?
     *
     * For example:
     * <pre>
     * function* id(){
     *     yield 1;
     *     <em>yield * anotherGeneratorFunc();</em>
     *     yield 10;
     * }
     * </pre>
     *
     *
     * @return true if this is a yield * expression
     */
    boolean isStar();
}
