/*
 * Copyright (c) 1998, 1999, Oracle and/or its affiliates. All rights reserved.
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

public class CharTypeImpl extends PrimitiveTypeImpl implements CharType {
    CharTypeImpl(VirtualMachine vm) {
        super(vm);
    }


    public String signature() {
        return String.valueOf((char)JDWP.Tag.CHAR);
    }

    PrimitiveValue convert(PrimitiveValue value) throws InvalidTypeException {
        return vm.mirrorOf(((PrimitiveValueImpl)value).checkedCharValue());
    }

}
