/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.declaration;


import java.util.Collection;


/**
 * Represents the declaration of an annotation type.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

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
