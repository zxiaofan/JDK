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

import javax.lang.model.type.TypeKind;

/**
 * A tree node for a primitive type.
 *
 * For example:
 * <pre>
 *   <em>primitiveTypeKind</em>
 * </pre>
 *
 * @jls 4.2 Primitive Types and Values
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface PrimitiveTypeTree extends Tree {
    /**
     * Returns the kind of this primitive type.
     * @return the kind of the type
     */
    TypeKind getPrimitiveTypeKind();
}
