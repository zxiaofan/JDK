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


import com.sun.mirror.declaration.MethodDeclaration;


/**
 * A pseudo-type representing the type of <tt>void</tt>.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is included in {@link
 * javax.lang.model.type.NoType}.
 *
 * @see MethodDeclaration#getReturnType()
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface VoidType extends TypeMirror {
}
