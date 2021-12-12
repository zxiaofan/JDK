/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

import javax.lang.model.element.Name;

/**
 * A tree node for a variable declaration.
 *
 * For example:
 * <pre>
 *   <em>modifiers</em> <em>type</em> <em>name</em> <em>initializer</em> ;
 *   <em>modifiers</em> <em>type</em> <em>qualified-name</em>.this
 * </pre>
 *
 * @jls 8.3 Field Declarations
 * @jls 14.4 Local Variable Declaration Statements
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface VariableTree extends StatementTree {
    /**
     * Returns the modifiers, including any annotations, on the declaration.
     * @return the modifiers
     */
    ModifiersTree getModifiers();

    /**
     * Returns the name of the variable being declared.
     * @return the name
     */
    Name getName();

    /**
     * Returns the qualified identifier for the name being "declared".
     * This is only used in certain cases for the receiver of a
     * method declaration. Returns {@code null} in all other cases.
     * @return the qualified identifier of a receiver declaration
     */
    ExpressionTree getNameExpression();

    /**
     * Returns the type of the variable being declared.
     * @return the type
     */
    Tree getType();

    /**
     * Returns the initializer for the variable, or {@code null} if none.
     * @return the initializer
     */
    ExpressionTree getInitializer();
}
