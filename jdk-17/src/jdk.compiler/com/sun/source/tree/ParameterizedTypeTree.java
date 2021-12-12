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

/**
 * A tree node for a type expression involving type parameters.
 *
 * For example:
 * <pre>
 *   <em>type</em> &lt; <em>typeArguments</em> &gt;
 * </pre>
 *
 * @jls 4.5.1 Type Arguments of Parameterized Types
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ParameterizedTypeTree extends Tree {
    /**
     * Returns the base type.
     * @return the base type
     */
    Tree getType();

    /**
     * Returns the type arguments.
     * @return the type arguments
     */
    List<? extends Tree> getTypeArguments();
}
