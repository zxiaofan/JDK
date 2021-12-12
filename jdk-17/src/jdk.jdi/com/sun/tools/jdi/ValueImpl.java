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

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

abstract class ValueImpl extends MirrorImpl implements Value {

    ValueImpl(VirtualMachine aVm) {
        super(aVm);
    }

    static ValueImpl prepareForAssignment(Value value,
                                          ValueContainer destination)
                  throws InvalidTypeException, ClassNotLoadedException {
        if (value == null) {
            JNITypeParser sig = new JNITypeParser(destination.signature());
            if (sig.isPrimitive()) {
                throw new InvalidTypeException("Can't set a primitive type to null");
            }
            return null;    // no further checking or conversion necessary
        } else {
            return ((ValueImpl)value).prepareForAssignmentTo(destination);
        }
    }

    static byte typeValueKey(Value val) {
        if (val == null) {
            return JDWP.Tag.OBJECT;
        } else {
            return ((ValueImpl)val).typeValueKey();
        }
    }

    abstract ValueImpl prepareForAssignmentTo(ValueContainer destination)
                 throws InvalidTypeException, ClassNotLoadedException;

    abstract byte typeValueKey();
}
