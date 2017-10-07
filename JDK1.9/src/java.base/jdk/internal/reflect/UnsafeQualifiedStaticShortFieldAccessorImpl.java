/*
 * Copyright (c) 2004, 2005, Oracle and/or its affiliates. All rights reserved.
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

class UnsafeQualifiedStaticShortFieldAccessorImpl
    extends UnsafeQualifiedStaticFieldAccessorImpl
{
    UnsafeQualifiedStaticShortFieldAccessorImpl(Field field, boolean isReadOnly) {
        super(field, isReadOnly);
    }

    public Object get(Object obj) throws IllegalArgumentException {
        return Short.valueOf(getShort(obj));
    }

    public boolean getBoolean(Object obj) throws IllegalArgumentException {
        throw newGetBooleanIllegalArgumentException();
    }

    public byte getByte(Object obj) throws IllegalArgumentException {
        throw newGetByteIllegalArgumentException();
    }

    public char getChar(Object obj) throws IllegalArgumentException {
        throw newGetCharIllegalArgumentException();
    }

    public short getShort(Object obj) throws IllegalArgumentException {
        return unsafe.getShortVolatile(base, fieldOffset);
    }

    public int getInt(Object obj) throws IllegalArgumentException {
        return getShort(obj);
    }

    public long getLong(Object obj) throws IllegalArgumentException {
        return getShort(obj);
    }

    public float getFloat(Object obj) throws IllegalArgumentException {
        return getShort(obj);
    }

    public double getDouble(Object obj) throws IllegalArgumentException {
        return getShort(obj);
    }

    public void set(Object obj, Object value)
        throws IllegalArgumentException, IllegalAccessException
    {
        if (isReadOnly) {
            throwFinalFieldIllegalAccessException(value);
        }
        if (value == null) {
            throwSetIllegalArgumentException(value);
        }
        if (value instanceof Byte) {
            unsafe.putShortVolatile(base, fieldOffset, ((Byte) value).byteValue());
            return;
        }
        if (value instanceof Short) {
            unsafe.putShortVolatile(base, fieldOffset, ((Short) value).shortValue());
            return;
        }
        throwSetIllegalArgumentException(value);
    }

    public void setBoolean(Object obj, boolean z)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(z);
    }

    public void setByte(Object obj, byte b)
        throws IllegalArgumentException, IllegalAccessException
    {
        setShort(obj, b);
    }

    public void setChar(Object obj, char c)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(c);
    }

    public void setShort(Object obj, short s)
        throws IllegalArgumentException, IllegalAccessException
    {
        if (isReadOnly) {
            throwFinalFieldIllegalAccessException(s);
        }
        unsafe.putShortVolatile(base, fieldOffset, s);
    }

    public void setInt(Object obj, int i)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(i);
    }

    public void setLong(Object obj, long l)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(l);
    }

    public void setFloat(Object obj, float f)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(f);
    }

    public void setDouble(Object obj, double d)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(d);
    }
}
