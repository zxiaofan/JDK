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

/**
 * A tree node for an array type.
 *
 * For example:
 * <pre>
 *   <em>type</em> []
 * </pre>
 *
 * @jls 10.1 Array Types
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface ArrayTypeTree extends Tree {
    /**
     * Returns the element type of this array type.
     * @return the element type
     */
    Tree getType();
}
