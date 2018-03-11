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
 * Represents a type variable.
 * A type variable is declared by a
 * {@linkplain TypeParameterDeclaration type parameter} of a
 * type, method, or constructor.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.type.TypeVariable}.
 *
 * @author Joe Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface TypeVariable extends ReferenceType {

    /**
     * Returns the type parameter that declared this type variable.
     *
     * @return the type parameter that declared this type variable
     */
    TypeParameterDeclaration getDeclaration();
}
