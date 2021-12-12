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

import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.Type;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.VoidValue;

public class VoidValueImpl extends ValueImpl implements VoidValue {

    VoidValueImpl(VirtualMachine aVm) {
        super(aVm);
    }

    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof VoidValue) && super.equals(obj);
    }

    public int hashCode() {
        /*
         * TO DO: Better hash code
         */
        return 47245;
    }

    public Type type() {
        return vm.theVoidType();
    }

    ValueImpl prepareForAssignmentTo(ValueContainer destination)
        throws InvalidTypeException
    {
        JNITypeParser sig = new JNITypeParser(destination.signature());
        if (sig.isVoid()) {
            return this;
        }
        throw new InvalidTypeException();
    }

    public String toString() {
        return "<void value>";
    }

    byte typeValueKey() {
        return JDWP.Tag.VOID;
    }
}
