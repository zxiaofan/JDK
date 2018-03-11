/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.declaration;


import com.sun.mirror.type.TypeMirror;


/**
 * Represents a formal parameter of a method or constructor.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface ParameterDeclaration extends Declaration {

    /**
     * Returns the type of this parameter.
     *
     * @return the type of this parameter
     */
    TypeMirror getType();
}
