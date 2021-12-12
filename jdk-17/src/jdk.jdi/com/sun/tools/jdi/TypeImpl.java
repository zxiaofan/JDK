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

import com.sun.jdi.Type;
import com.sun.jdi.VirtualMachine;

public abstract class TypeImpl extends MirrorImpl implements Type {
    private String myName = null;

    TypeImpl(VirtualMachine vm) {
        super(vm);
    }

    public abstract String signature();

    public String name() {
        if (myName == null) {
            JNITypeParser parser = new JNITypeParser(signature());
            myName = parser.typeName();
        }
        return myName;
    }

    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof Type)) {
            Type other = (Type)obj;
            return signature().equals(other.signature()) && super.equals(obj);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return signature().hashCode();
    }
}
