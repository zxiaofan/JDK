/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.declaration;


/**
 * Represents an enum constant declaration.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface EnumConstantDeclaration extends FieldDeclaration {
    /**
     * {@inheritDoc}
     */
    EnumDeclaration getDeclaringType();
}
