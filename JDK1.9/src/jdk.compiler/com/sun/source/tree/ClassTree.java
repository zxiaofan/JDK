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

import java.util.List;
import javax.lang.model.element.Name;

/**
 * A tree node for a class, interface, enum, or annotation
 * type declaration.
 *
 * For example:
 * <pre>
 *   <em>modifiers</em> class <em>simpleName</em> <em>typeParameters</em>
 *       extends <em>extendsClause</em>
 *       implements <em>implementsClause</em>
 *   {
 *       <em>members</em>
 *   }
 * </pre>
 *
 * @jls sections 8.1, 8.9, 9.1, and 9.6
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ClassTree extends StatementTree {
    /**
     * Returns the modifiers, including any annotations,
     * for this type declaration.
     * @return the modifiers
     */
    ModifiersTree getModifiers();

    /**
     * Returns the simple name of this type declaration.
     * @return the simple name
     */
    Name getSimpleName();

    /**
     * Returns any type parameters of this type declaration.
     * @return the type parameters
     */
    List<? extends TypeParameterTree> getTypeParameters();

    /**
     * Returns the supertype of this type declaration,
     * or {@code null} if none is provided.
     * @return the supertype
     */
    Tree getExtendsClause();

    /**
     * Returns the interfaces implemented by this type declaration.
     * @return the interfaces
     */
    List<? extends Tree> getImplementsClause();

    /**
     * Returns the members declared in this type declaration.
     * @return the members
     */
    List<? extends Tree> getMembers();
}
