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

/**
 * Notification of a method invocation in the target VM. This event
 * occurs after entry into the invoked method and before any
 * code has executed.
 * Method entry events are generated for both native and non-native
 * methods.
 * <P>
 * In some VMs method entry events can occur for a particular thread
 * before its {@link ThreadStartEvent} occurs if methods are called
 * as part of the thread's initialization.
 *
 * @see EventQueue
 *
 * @author Robert Field
 * @since  1.3
 */
public interface MethodEntryEvent extends LocatableEvent {

    /**
     * Returns the method that was entered.
     *
     * @return a {@link Method} which mirrors the method that was entered.
     */
    public Method method();
}
