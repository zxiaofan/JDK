/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.declaration;


/**
 * Represents a declaration that may be a member or constructor of a declared
 * type.  This includes fields, constructors, methods, and (since they
 * may be nested) declared types themselves.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface MemberDeclaration extends Declaration {

    /**
     * Returns the type declaration within which this member or constructor
     * is declared.
     * If this is the declaration of a top-level type (a non-nested class
     * or interface), returns null.
     *
     * @return the type declaration within which this member or constructor
     * is declared, or null if there is none
     */
    TypeDeclaration getDeclaringType();
}
