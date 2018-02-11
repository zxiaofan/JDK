/*
 * Copyright (c) 1998, 2004, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.jdi.*;

public class ByteValueImpl extends PrimitiveValueImpl
                           implements ByteValue {
    private byte value;

    ByteValueImpl(VirtualMachine aVm,byte aValue) {
        super(aVm);

        value = aValue;
    }

    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof ByteValue)) {
            return (value == ((ByteValue)obj).value())
                   && super.equals(obj);
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

    public int compareTo(ByteValue obj) {
        byte other = obj.value();
        return value() - other;
    }


    public Type type() {
        return vm.theByteType();
    }

    public byte value() {
        return value;
    }

    public boolean booleanValue() {
        return(value == 0)?false:true;
    }

    public byte byteValue() {
        return value;
    }

    public char charValue() {
        return(char)value;
    }

    public short shortValue() {
        return(short)value;
    }

    public int intValue() {
        return(int)value;
    }

    public long longValue() {
        return(long)value;
    }

    public float floatValue() {
        return(float)value;
    }

    public double doubleValue() {
        return(double)value;
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
        return JDWP.Tag.BYTE;
    }
}
