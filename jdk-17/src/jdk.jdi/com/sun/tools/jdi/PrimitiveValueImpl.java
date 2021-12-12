/*
 * Copyright (c) 1998, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdi;

import com.sun.jdi.BooleanValue;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.InternalException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.PrimitiveValue;
import com.sun.jdi.VirtualMachine;

public abstract class PrimitiveValueImpl extends ValueImpl
                                         implements PrimitiveValue
{
    PrimitiveValueImpl(VirtualMachine aVm) {
        super(aVm);
    }

    abstract public boolean booleanValue();
    abstract public byte byteValue();
    abstract public char charValue();
    abstract public short shortValue();
    abstract public int intValue();
    abstract public long longValue();
    abstract public float floatValue();
    abstract public double doubleValue();

    /*
     * The checked versions of the value accessors throw
     * InvalidTypeException if the required conversion is
     * narrowing and would result in the loss of information
     * (either magnitude or precision).
     *
     * Default implementations here do no checking; subclasses
     * override as necessary to do the proper checking.
     */
    byte checkedByteValue() throws InvalidTypeException {
        return byteValue();
    }
    char checkedCharValue() throws InvalidTypeException {
        return charValue();
    }
    short checkedShortValue() throws InvalidTypeException {
        return shortValue();
    }
    int checkedIntValue() throws InvalidTypeException {
        return intValue();
    }
    long checkedLongValue() throws InvalidTypeException {
        return longValue();
    }
    float checkedFloatValue() throws InvalidTypeException {
        return floatValue();
    }

    final boolean checkedBooleanValue() throws InvalidTypeException {
        /*
         * Always disallow a conversion to boolean from any other
         * primitive
         */
        if (this instanceof BooleanValue) {
            return booleanValue();
        } else {
            throw new InvalidTypeException("Can't convert non-boolean value to boolean");
        }
    }

    final double checkedDoubleValue() throws InvalidTypeException {
        /*
         * Can't overflow by converting to double, so this method
         * is never overridden
         */
        return doubleValue();
    }

    ValueImpl prepareForAssignmentTo(ValueContainer destination)
        throws InvalidTypeException
    {
        return convertForAssignmentTo(destination);
    }

    ValueImpl convertForAssignmentTo(ValueContainer destination)
        throws InvalidTypeException
    {
        JNITypeParser destSig = new JNITypeParser(destination.signature());
        JNITypeParser sourceSig = new JNITypeParser(type().signature());

        if (destSig.isReference()) {
            throw new InvalidTypeException("Can't assign primitive value to object");
        }

        if (destSig.isBoolean() && !sourceSig.isBoolean()) {
            throw new InvalidTypeException("Can't assign non-boolean value to a boolean");
        }

        if (!destSig.isBoolean() && sourceSig.isBoolean()) {
            throw new InvalidTypeException("Can't assign boolean value to an non-boolean");
        }

        if (destSig.isVoid()) {
            throw new InvalidTypeException("Can't assign primitive value to a void");
        }

        try {
            PrimitiveTypeImpl primitiveType = (PrimitiveTypeImpl)destination.type();
            return (ValueImpl)(primitiveType.convert(this));
        } catch (ClassNotLoadedException e) {
            throw new InternalException("Signature and type inconsistent for: " +
                                        destination.typeName());
        }
    }
}
