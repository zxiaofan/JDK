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
 * A tree node for a <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-variable-statement">variable declaration statement</a>.
 *
 * For example:
 * <pre>
 *   <em>var</em> <em>name</em> [ <em>initializer</em> ] ;
 *   <em>var</em> <em>binding_pattern</em> [ <em>initializer</em> ];
 * </pre>
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface VariableTree extends StatementTree {
    /**
     * Returns the binding of this declaration. This is an {@link IdentifierTree}
     * for a binding identifier case (simple variable declaration).
     * This is an {@link ObjectLiteralTree} or a {@link ArrayLiteralTree} for a
     * destructuring declaration.
     *
     * @return the binding expression of this declaration
     */
    ExpressionTree getBinding();

    /**
     * Returns the initial value expression for this variable. This is
     * null if no initial value for this variable.
     *
     * @return the initial value expression
     */
    ExpressionTree getInitializer();

    /**
     * Is this a const declaration?
     *
     * @return true if this is a const declaration
     */
    boolean isConst();

    /**
     * Is this a let declaration?
     *
     * @return true if this is a let declaration
     */
    boolean isLet();
}
