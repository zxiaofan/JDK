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

import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.ShortValue;
import com.sun.jdi.Type;
import com.sun.jdi.VirtualMachine;

public class ShortValueImpl extends PrimitiveValueImpl
                            implements ShortValue {
    private short value;

    ShortValueImpl(VirtualMachine aVm, short aValue) {
        super(aVm);
        value = aValue;
    }

    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof ShortValue)) {
            return (value == ((ShortValue)obj).value()) &&
                   super.equals(obj);
        } else {
            return false;
        }
    }

    public int hashCode() {
        /*
         * TO DO: Better hash code
         */
        return intValue();
    }

    public int compareTo(ShortValue obj) {
        short other = obj.value();
        return value() - other;
    }

    public Type type() {
        return vm.theShortType();
    }

    public short value() {
        return value;
    }

    public boolean booleanValue() {
        return (value == 0 ? false : true);
    }

    public byte byteValue() {
        return (byte)value;
    }

    public char charValue() {
        return (char)value;
    }

    public short shortValue() {
        return value;
    }

    public int intValue() {
        return value;
    }

    public long longValue() {
        return value;
    }

    public float floatValue() {
        return value;
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

    public String toString() {
        return "" + value;
    }

    byte typeValueKey() {
        return JDWP.Tag.SHORT;
    }
}
