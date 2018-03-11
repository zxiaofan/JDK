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


import com.sun.mirror.declaration.*;


/**
 * Represents an interface type.
 * Note that an {@linkplain AnnotationType annotation type} is
 * a kind of interface.
 *
 * <p> While an {@link InterfaceDeclaration} represents the
 * <i>declaration</i> of an interface, an <tt>InterfaceType</tt>
 * represents an interface <i>type</i>.
 * See {@link TypeDeclaration} for more on this distinction.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is included in {@link
 * javax.lang.model.type.DeclaredType}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface InterfaceType extends DeclaredType {

    /**
     * {@inheritDoc}
     */
    InterfaceDeclaration getDeclaration();
}
