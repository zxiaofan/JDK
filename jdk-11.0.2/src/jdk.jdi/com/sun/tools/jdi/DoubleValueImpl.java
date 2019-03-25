/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.jdi.DoubleValue;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.Type;
import com.sun.jdi.VirtualMachine;

public class DoubleValueImpl extends PrimitiveValueImpl
                             implements DoubleValue {
    private double value;

    DoubleValueImpl(VirtualMachine aVm, double aValue) {
        super(aVm);
        value = aValue;
    }

    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof DoubleValue)) {
            return (value == ((DoubleValue)obj).value()) &&
                   super.equals(obj);
        } else {
            return false;
        }
    }

    public int compareTo(DoubleValue obj) {
        double other = obj.value();
        if (value() < other) {
            return -1;
        } else if (value() == other) {
            return 0;
        } else {
            return 1;
        }
    }

    public int hashCode() {
        /*
         * TO DO: Better hash code
         */
        return intValue();
    }

    public Type type() {
        return vm.theDoubleType();
    }

    public double value() {
        return value;
    }

    public boolean booleanValue() {
        return (value == 0.0 ? false : true);
    }

    public byte byteValue() {
        return (byte)value;
    }

    public char charValue() {
        return (char)value;
    }

    public short shortValue() {
        return (short)value;
    }

    public int intValue() {
        return (int)value;
    }

    public long longValue() {
        return (long)value;
    }

    public float floatValue() {
        return (float)value;
    }

    public double doubleValue() {
        return value;
    }

    byte checkedByteValue() throws InvalidTypeException {
        if ((value > Byte.MAX_VALUE) || (value < Byte.MIN_VALUE)) {
            throw new InvalidTypeException("Can't convert " + value + " to byte");
        } else {
            return super.checkedByteValue();
        }
    }

    char checkedCharValue() throws InvalidTypeException {
        if ((value > Character.MAX_VALUE) || (value < Character.MIN_VALUE)) {
            throw new InvalidTypeException("Can't convert " + value + " to char");
        } else {
            return super.checkedCharValue();
        }
    }

    short checkedShortValue() throws InvalidTypeException {
        if ((value > Short.MAX_VALUE) || (value < Short.MIN_VALUE)) {
            throw new InvalidTypeException("Can't convert " + value + " to short");
        } else {
            return super.checkedShortValue();
        }
    }

    int checkedIntValue() throws InvalidTypeException {
        if ((value > Integer.MAX_VALUE) || (value < Integer.MIN_VALUE)) {
            throw new InvalidTypeException("Can't convert " + value + " to int");
        } else {
            return super.checkedIntValue();
        }
    }

    long checkedLongValue() throws InvalidTypeException {
        long longValue = (long)value;
        if (longValue != value) {
            throw new InvalidTypeException("Can't convert " + value + " to long");
        } else {
            return super.checkedLongValue();
        }
    }

    float checkedFloatValue() throws InvalidTypeException {
        float floatValue = (float)value;
        if (floatValue != value) {
            throw new InvalidTypeException("Can't convert " + value + " to float");
        } else {
            return super.checkedFloatValue();
        }
    }

    public String toString() {
        return "" + value;
    }

    byte typeValueKey() {
        return JDWP.Tag.DOUBLE;
    }
}
