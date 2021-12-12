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
import com.sun.jdi.request.EventRequest;

/**
 * Notification of disconnection from target VM.
 * May be caused by normal termination of a VM,
 * VM termination by uncaught exception or other error,
 * debugger action ({@link VirtualMachine#dispose} or
 * {@link VirtualMachine#exit}) or by external events
 * (for example, target process termination by the
 * operating system, transport termination, etc).
 * <p>
 * If the target VM terminates before the disconnection, this event
 * will be preceded by a {@link VMDeathEvent}.
 * <p>
 * This event is always sent.
 * There is no corresponding {@link EventRequest}.
 * The enclosing singleton {@link EventSet} always has a
 * suspend policy of {@link EventRequest#SUSPEND_NONE}.
 *
 * @see VMDeathEvent
 * @see EventQueue
 * @see VirtualMachine
 *
 * @author Robert Field
 * @since  1.3
 */
public interface VMDisconnectEvent extends Event {
}
