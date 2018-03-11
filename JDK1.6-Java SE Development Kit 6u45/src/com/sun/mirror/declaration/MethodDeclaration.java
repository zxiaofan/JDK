/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.declaration;


import com.sun.mirror.type.TypeMirror;
import com.sun.mirror.type.VoidType;


/**
 * Represents a method of a class or interface.
 * Note that an
 * {@linkplain AnnotationTypeElementDeclaration annotation type element}
 * is a kind of method.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface MethodDeclaration extends ExecutableDeclaration {

    /**
     * Returns the formal return type of this method.
     * Returns {@link VoidType} if this method does not return a value.
     *
     * @return the formal return type of this method
     */
    TypeMirror getReturnType();
}
