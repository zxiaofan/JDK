/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.declaration;


import com.sun.mirror.type.InterfaceType;


/**
 * Represents the declaration of an interface.
 * Provides access to information about the interface and its members.
 * Note that an {@linkplain AnnotationTypeDeclaration annotation type} is
 * a kind of interface.
 *
 * <p> While an <tt>InterfaceDeclaration</tt> represents the
 * <i>declaration</i> of an interface, an {@link InterfaceType}
 * represents an interface <i>type</i>.
 * See {@link TypeDeclaration} for more on this distinction.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 *
 * @see InterfaceType
 * @since 1.5
 */

public interface InterfaceDeclaration extends TypeDeclaration {
}
