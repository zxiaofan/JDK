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

package com.sun.mirror.declaration;


import com.sun.mirror.type.TypeMirror;
import com.sun.mirror.type.VoidType;


/**
 * Represents a method of a class or interface.
 * Note that an
 * {@linkplain AnnotationTypeElementDeclaration annotation type element}
 * is a kind of method.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is included in {@link
 * javax.lang.model.element.ExecutableElement}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface MethodDeclaration extends ExecutableDeclaration {

    /**
     * Returns the formal return type of this method.
     * Returns {@link VoidType} if this method does not return a value.
     *
     * @return the formal return type of this method
     */
    TypeMirror getReturnType();
}
