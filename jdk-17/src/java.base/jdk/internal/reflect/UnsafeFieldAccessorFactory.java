/*
 * Copyright (c) 2001, 2011, Oracle and/or its affiliates. All rights reserved.
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

class UnsafeFieldAccessorFactory {
    static FieldAccessor newFieldAccessor(Field field, boolean isReadOnly) {
        Class<?> type = field.getType();
        boolean isStatic = Modifier.isStatic(field.getModifiers());
        boolean isFinal = Modifier.isFinal(field.getModifiers());
        boolean isVolatile = Modifier.isVolatile(field.getModifiers());
        boolean isQualified = isFinal || isVolatile;
        if (isStatic) {
            // This code path does not guarantee that the field's
            // declaring class has been initialized, but it must be
            // before performing reflective operations.
            UnsafeFieldAccessorImpl.unsafe.ensureClassInitialized(field.getDeclaringClass());

            if (!isQualified) {
                if (type == Boolean.TYPE) {
                    return new UnsafeStaticBooleanFieldAccessorImpl(field);
                } else if (type == Byte.TYPE) {
                    return new UnsafeStaticByteFieldAccessorImpl(field);
                } else if (type == Short.TYPE) {
                    return new UnsafeStaticShortFieldAccessorImpl(field);
                } else if (type == Character.TYPE) {
                    return new UnsafeStaticCharacterFieldAccessorImpl(field);
                } else if (type == Integer.TYPE) {
                    return new UnsafeStaticIntegerFieldAccessorImpl(field);
                } else if (type == Long.TYPE) {
                    return new UnsafeStaticLongFieldAccessorImpl(field);
                } else if (type == Float.TYPE) {
                    return new UnsafeStaticFloatFieldAccessorImpl(field);
                } else if (type == Double.TYPE) {
                    return new UnsafeStaticDoubleFieldAccessorImpl(field);
                } else {
                    return new UnsafeStaticObjectFieldAccessorImpl(field);
                }
            } else {
                if (type == Boolean.TYPE) {
                    return new UnsafeQualifiedStaticBooleanFieldAccessorImpl(field, isReadOnly);
                } else if (type == Byte.TYPE) {
                    return new UnsafeQualifiedStaticByteFieldAccessorImpl(field, isReadOnly);
                } else if (type == Short.TYPE) {
                    return new UnsafeQualifiedStaticShortFieldAccessorImpl(field, isReadOnly);
                } else if (type == Character.TYPE) {
                    return new UnsafeQualifiedStaticCharacterFieldAccessorImpl(field, isReadOnly);
                } else if (type == Integer.TYPE) {
                    return new UnsafeQualifiedStaticIntegerFieldAccessorImpl(field, isReadOnly);
                } else if (type == Long.TYPE) {
                    return new UnsafeQualifiedStaticLongFieldAccessorImpl(field, isReadOnly);
                } else if (type == Float.TYPE) {
                    return new UnsafeQualifiedStaticFloatFieldAccessorImpl(field, isReadOnly);
                } else if (type == Double.TYPE) {
                    return new UnsafeQualifiedStaticDoubleFieldAccessorImpl(field, isReadOnly);
                } else {
                    return new UnsafeQualifiedStaticObjectFieldAccessorImpl(field, isReadOnly);
                }
            }
        } else {
            if (!isQualified) {
                if (type == Boolean.TYPE) {
                    return new UnsafeBooleanFieldAccessorImpl(field);
                } else if (type == Byte.TYPE) {
                    return new UnsafeByteFieldAccessorImpl(field);
                } else if (type == Short.TYPE) {
                    return new UnsafeShortFieldAccessorImpl(field);
                } else if (type == Character.TYPE) {
                    return new UnsafeCharacterFieldAccessorImpl(field);
                } else if (type == Integer.TYPE) {
                    return new UnsafeIntegerFieldAccessorImpl(field);
                } else if (type == Long.TYPE) {
                    return new UnsafeLongFieldAccessorImpl(field);
                } else if (type == Float.TYPE) {
                    return new UnsafeFloatFieldAccessorImpl(field);
                } else if (type == Double.TYPE) {
                    return new UnsafeDoubleFieldAccessorImpl(field);
                } else {
                    return new UnsafeObjectFieldAccessorImpl(field);
                }
            } else {
                if (type == Boolean.TYPE) {
                    return new UnsafeQualifiedBooleanFieldAccessorImpl(field, isReadOnly);
                } else if (type == Byte.TYPE) {
                    return new UnsafeQualifiedByteFieldAccessorImpl(field, isReadOnly);
                } else if (type == Short.TYPE) {
                    return new UnsafeQualifiedShortFieldAccessorImpl(field, isReadOnly);
                } else if (type == Character.TYPE) {
                    return new UnsafeQualifiedCharacterFieldAccessorImpl(field, isReadOnly);
                } else if (type == Integer.TYPE) {
                    return new UnsafeQualifiedIntegerFieldAccessorImpl(field, isReadOnly);
                } else if (type == Long.TYPE) {
                    return new UnsafeQualifiedLongFieldAccessorImpl(field, isReadOnly);
                } else if (type == Float.TYPE) {
                    return new UnsafeQualifiedFloatFieldAccessorImpl(field, isReadOnly);
                } else if (type == Double.TYPE) {
                    return new UnsafeQualifiedDoubleFieldAccessorImpl(field, isReadOnly);
                } else {
                    return new UnsafeQualifiedObjectFieldAccessorImpl(field, isReadOnly);
                }
            }
        }
    }
}
