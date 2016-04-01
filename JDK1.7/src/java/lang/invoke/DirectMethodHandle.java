/*
 * Copyright (c) 2008, 2011, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.invoke;

import static java.lang.invoke.MethodHandleNatives.Constants.*;

/**
 * The flavor of method handle which emulates invokespecial or invokestatic.
 * @author jrose
 */
class DirectMethodHandle extends MethodHandle {
    //inherited oop    vmtarget;    // methodOop or virtual class/interface oop
    private final int  vmindex;     // method index within class or interface
    { vmindex = VM_INDEX_UNINITIALIZED; }  // JVM may change this

    // Constructors in this class *must* be package scoped or private.
    DirectMethodHandle(MethodType mtype, MemberName m, boolean doDispatch, Class<?> lookupClass) {
        super(mtype);

        assert(m.isMethod() || !doDispatch && m.isConstructor());
        if (!m.isResolved())
            throw new InternalError();

        if (m.getDeclaringClass().isInterface() && !m.isAbstract()) {
            // Check for corner case: invokeinterface of Object method.
            MemberName m2 = new MemberName(Object.class, m.getName(), m.getMethodType(), m.getModifiers());
            m2 = MemberName.getFactory().resolveOrNull(m2, false, null);
            if (m2 != null && m2.isPublic()) {
                m = m2;
            }
        }

        MethodHandleNatives.init(this, (Object) m, doDispatch, lookupClass);
    }

    boolean isValid() {
        return (vmindex != VM_INDEX_UNINITIALIZED);
    }
}
