/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.type;


import com.sun.mirror.declaration.AnnotationTypeDeclaration;


/**
 * Represents an annotation type.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface AnnotationType extends InterfaceType {

    /**
     * {@inheritDoc}
     */
    AnnotationTypeDeclaration getDeclaration();
}
