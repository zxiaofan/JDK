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

import com.sun.jdi.Method;
import com.sun.jdi.ObjectCollectedException;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

/**
 * Notification of a method return in the target VM. This event
 * is generated after all code in the method has executed, but the
 * location of this event is the last executed location in the method.
 * Method exit events are generated for both native and non-native
 * methods. Method exit events are not generated if the method terminates
 * with a thrown exception.
 *
 * @see EventQueue
 *
 * @author Robert Field
 * @since  1.3
 */
public interface MethodExitEvent extends LocatableEvent {

    /**
     * Returns the method that was exited.
     *
     * @return a {@link Method} which mirrors the method that was exited.
     * @throws ObjectCollectedException may be thrown if class
     * has been garbage collected.
     */
    public Method method();

    /**
     * Returns the value that the method will return.
     *
     * Not all target virtual machines support this operation.
     * Use
     * {@link VirtualMachine#canGetMethodReturnValues() canGetMethodReturnValues()}
     * to determine if this operation is supported.
     *
     * @return a {@link Value} which mirrors the value to be returned.
     *
     * @throws java.lang.UnsupportedOperationException if
     * the target virtual machine does not support this
     * operation - see
     * {@link VirtualMachine#canGetMethodReturnValues() canGetMethodReturnValues()}
     *
     * @since 1.6
     */
    public Value returnValue();
}
