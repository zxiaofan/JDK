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
 * A tree node for a parenthesized expression.  Note: parentheses
 * not be preserved by the parser.
 *
 * For example:
 * <pre>
 *   ( <em>expression</em> )
 * </pre>
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface ParenthesizedTree extends ExpressionTree {
    /**
     * Returns the expression within the parenthesis.
     *
     * @return the expression within the parenthesis
     */
    ExpressionTree getExpression();
}
