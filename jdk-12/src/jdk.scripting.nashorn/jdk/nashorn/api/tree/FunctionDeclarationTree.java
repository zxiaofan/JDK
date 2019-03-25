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
 * A tree node for a <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-function-definitions">function declaration</a>.
 *
 * For example:
 * <pre>
 *   <em>function</em> <em>name</em>
 *      ( <em>parameters</em> )
 *      <em>body</em>
 * </pre>
 *
 * <pre>
 *   <em>function*</em> <em>name</em>
 *      ( <em>parameters</em> )
 *      <em>body</em>
 * </pre>
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface FunctionDeclarationTree extends StatementTree {
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
     * Returns the body of code of this function.
     *
     * @return the body of code
     */
    BlockTree getBody();

    /**
     * Is this a strict function?
     *
     * @return true if this function is strict
     */
    boolean isStrict();

    /**
     * Is this a generator function?
     *
     * @return true if this is a generator function
     */
    boolean isGenerator();
}
