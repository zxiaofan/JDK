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
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
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
