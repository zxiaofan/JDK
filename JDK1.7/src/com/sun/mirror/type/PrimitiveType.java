/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.mirror.type;


/**
 * Represents a primitive type.  These include
 * <tt>boolean</tt>, <tt>byte</tt>, <tt>short</tt>, <tt>int</tt>,
 * <tt>long</tt>, <tt>char</tt>, <tt>float</tt>, and <tt>double</tt>.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.type.PrimitiveType}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface PrimitiveType extends TypeMirror {

    /**
     * Returns the kind of primitive type that this object represents.
     *
     * @return the kind of primitive type that this object represents
     */
    Kind getKind();

    /**
     * An enumeration of the different kinds of primitive types.
     *
     * @deprecated All components of this API have been superseded by
     * the standardized annotation processing API.  The replacement
     * for the functionality of this enum is {@link
     * javax.lang.model.type.TypeKind}.
     */
    @Deprecated
    enum Kind {
        /** The primitive type <tt>boolean</tt> */      BOOLEAN,
        /** The primitive type <tt>byte</tt> */         BYTE,
        /** The primitive type <tt>short</tt> */        SHORT,
        /** The primitive type <tt>int</tt> */          INT,
        /** The primitive type <tt>long</tt> */         LONG,
        /** The primitive type <tt>char</tt> */         CHAR,
        /** The primitive type <tt>float</tt> */        FLOAT,
        /** The primitive type <tt>double</tt> */       DOUBLE
    }
}
