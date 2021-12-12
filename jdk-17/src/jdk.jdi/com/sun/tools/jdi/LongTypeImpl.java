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
import com.sun.jdi.LongType;
import com.sun.jdi.PrimitiveValue;
import com.sun.jdi.VirtualMachine;

public class LongTypeImpl extends PrimitiveTypeImpl implements LongType {

    LongTypeImpl(VirtualMachine vm) {
        super(vm);
    }

    public String signature() {
        return String.valueOf((char)JDWP.Tag.LONG);
    }

    PrimitiveValue convert(PrimitiveValue value) throws InvalidTypeException {
        return vm.mirrorOf(((PrimitiveValueImpl)value).checkedLongValue());
    }
}
