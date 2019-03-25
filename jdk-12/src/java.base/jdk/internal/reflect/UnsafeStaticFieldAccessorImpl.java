/*
 * Copyright (c) 2001, 2018, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Set;

import jdk.internal.misc.Unsafe;

/** Base class for jdk.internal.misc.Unsafe-based FieldAccessors for static
    fields. The observation is that there are only nine types of
    fields from the standpoint of reflection code: the eight primitive
    types and Object. Using class Unsafe instead of generated
    bytecodes saves memory and loading time for the
    dynamically-generated FieldAccessors. */

abstract class UnsafeStaticFieldAccessorImpl extends UnsafeFieldAccessorImpl {
    static {
        Reflection.registerFieldsToFilter(UnsafeStaticFieldAccessorImpl.class,
                                          Set.of("base"));
    }

    protected final Object base; // base

    UnsafeStaticFieldAccessorImpl(Field field) {
        super(field);
        base = unsafe.staticFieldBase(field);
    }
}
