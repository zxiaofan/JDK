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


import java.util.Collection;


/**
 * Represents the declaration of an annotation type.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is included in {@link
 * javax.lang.model.element.TypeElement}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface AnnotationTypeDeclaration extends InterfaceDeclaration {

    /**
     * Returns the annotation type elements of this annotation type.
     * These are the methods that are directly declared in the type's
     * declaration.
     *
     * @return the annotation type elements of this annotation type,
     * or an empty collection if there are none
     */
    Collection<AnnotationTypeElementDeclaration> getMethods();
}
