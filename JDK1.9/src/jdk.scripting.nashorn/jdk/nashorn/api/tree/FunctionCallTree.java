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
 * A tree node for a function call expression.
 *
 * For example:
 * <pre>
 *   <em>identifier</em> ( <em>arguments</em> )
 *
 *   this . <em>identifier</em> ( <em>arguments</em> )
 * </pre>
 *
 * @since 9
 */
public interface FunctionCallTree extends ExpressionTree {
    /**
     * Returns the function being called.
     *
     * @return the function being called
     */
    ExpressionTree getFunctionSelect();

    /**
     * Returns the list of arguments being passed to this function call.
     *
     * @return the list of argument expressions
     */
    List<? extends ExpressionTree> getArguments();
}
