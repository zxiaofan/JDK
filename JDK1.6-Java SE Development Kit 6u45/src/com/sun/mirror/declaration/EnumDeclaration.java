/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.declaration;


import java.util.Collection;


/**
 * Represents the declaration of an enum type.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface EnumDeclaration extends ClassDeclaration {

    /**
     * Returns the enum constants defined for this enum.
     *
     * @return the enum constants defined for this enum,
     * or an empty collection if there are none
     */
    Collection<EnumConstantDeclaration> getEnumConstants();
}
