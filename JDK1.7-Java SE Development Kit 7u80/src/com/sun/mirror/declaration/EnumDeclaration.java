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
 * Represents the declaration of an enum type.
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
public interface EnumDeclaration extends ClassDeclaration {

    /**
     * Returns the enum constants defined for this enum.
     *
     * @return the enum constants defined for this enum,
     * or an empty collection if there are none
     */
    Collection<EnumConstantDeclaration> getEnumConstants();
}
