/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.type;


import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.util.Types;
import com.sun.mirror.util.TypeVisitor;


/**
 * Represents a type in the Java programming language.
 * Types include primitive types, class and interface types, array
 * types, and type variables.  Wildcard type arguments, and the
 * pseudo-type representing the type of <tt>void</tt>, are represented
 * by type mirrors as well.
 *
 * <p> Types may be compared using the utility methods in
 * {@link Types}.
 * There is no guarantee that any particular type will
 * always be represented by the same object.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 *
 * @see Declaration
 * @see Types
 * @since 1.5
 */

public interface TypeMirror {

    /**
     * Returns a string representation of this type.
     * Any names embedded in the expression are qualified.
     *
     * @return a string representation of this type
     */
    String toString();

    /**
     * Tests whether two types represent the same type.
     *
     * @param obj the object to be compared with this type
     * @return <tt>true</tt> if the specified object represents the same
     *		type as this.
     */
    boolean equals(Object obj);

    /**
     * Applies a visitor to this type.
     *
     * @param v the visitor operating on this type
     */
    void accept(TypeVisitor v);
}
