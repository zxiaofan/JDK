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

import com.sun.mirror.type.*;


/**
 * Represents a formal type parameter of a generic type, method,
 * or constructor declaration.
 * A type parameter declares a {@link TypeVariable}.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.lang.model.element.TypeParameterElement}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface TypeParameterDeclaration extends Declaration {

    /**
     * Returns the bounds of this type parameter.
     * These are the types given by the <i>extends</i> clause.
     * If there is no explicit <i>extends</i> clause, then
     * <tt>java.lang.Object</tt> is considered to be the sole bound.
     *
     * @return the bounds of this type parameter
     */
    Collection<ReferenceType> getBounds();

    /**
     * Returns the type, method, or constructor declaration within which
     * this type parameter is declared.
     *
     * @return the declaration within which this type parameter is declared
     */
    Declaration getOwner();
}
