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

package jdk.internal.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import jdk.internal.misc.Unsafe;

/** Base class for jdk.internal.misc.Unsafe-based FieldAccessors for final or
    static volatile fields.  */

abstract class UnsafeQualifiedStaticFieldAccessorImpl
    extends UnsafeStaticFieldAccessorImpl
{
    protected final boolean isReadOnly;

    UnsafeQualifiedStaticFieldAccessorImpl(Field field, boolean isReadOnly) {
        super(field);
        this.isReadOnly = isReadOnly;
    }
}
