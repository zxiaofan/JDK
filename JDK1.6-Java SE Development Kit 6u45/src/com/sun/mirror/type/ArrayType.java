/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.type;


/**
 * Represents an array type.
 * A multidimensional array type is represented as an array type
 * whose component type is also an array type.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface ArrayType extends ReferenceType {

    /**
     * Returns the component type of this array type.
     *
     * @return the component type of this array type
     */
    TypeMirror getComponentType();
}
