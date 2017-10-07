/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

import java.util.List;
import java.util.ArrayList;

/**
 * Represents methods which have changed when the class was redefined.
 */
public class ObsoleteMethodImpl extends NonConcreteMethodImpl {

    private Location location = null;

    ObsoleteMethodImpl(VirtualMachine vm,
                          ReferenceTypeImpl declaringType) {
        super(vm, declaringType, 0, "<obsolete>", "", null, 0);
    }

    public boolean isObsolete() {
        return true;
    }

    public String returnTypeName() {
        return "<unknown>";
    }

    public Type returnType() throws ClassNotLoadedException {
        throw new ClassNotLoadedException("type unknown");
    }

    public List<String> argumentTypeNames() {
        return new ArrayList<String>();
    }

    public List<String> argumentSignatures() {
        return new ArrayList<String>();
    }

    Type argumentType(int index) throws ClassNotLoadedException {
        throw new ClassNotLoadedException("type unknown");
    }

    public List<Type> argumentTypes() throws ClassNotLoadedException {
        return new ArrayList<Type>();
    }

}
