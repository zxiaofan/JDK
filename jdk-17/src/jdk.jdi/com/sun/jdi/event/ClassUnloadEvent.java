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

package com.sun.jdi.event;

import com.sun.jdi.VirtualMachine;

/**
 * Notification of a class unload in the target VM.
 * <p>
 * There are severe constraints on the debugger back-end during
 * garbage collection, so unload information is greatly limited.
 *
 * @see EventQueue
 * @see VirtualMachine
 *
 * @author Robert Field
 * @since  1.3
 */
public interface ClassUnloadEvent extends Event {

    /**
     * Returns the {@linkplain com.sun.jdi.Type#name() name of the class}
     * that has been unloaded. The returned string may not be a
     * <a href="{@docRoot}/java.base/java/lang/ClassLoader.html#binary-name">binary name</a>.
     *
     * @see Class#getName()
     */
    public String className();

    /**
     * Returns the {@linkplain com.sun.jdi.Type#signature() type signature of the class}
     * that has been unloaded.  The result is of the same
     * form as the string returned by {@link Class#descriptorString()}.
     * If this class can be described nominally, the returned string is a
     * type descriptor conforming to JVMS {@jvms 4.3.2}; otherwise, the returned string
     * is not a type descriptor.
     */
    public String classSignature();
}
