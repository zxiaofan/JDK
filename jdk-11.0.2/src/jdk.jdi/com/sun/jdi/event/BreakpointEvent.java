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
import com.sun.jdi.request.BreakpointRequest;

/**
 * Notification of a breakpoint in the target VM.
 *
 * The breakpoint event is generated before the code at its location
 * is executed. When a location is reached which satisfies a currently enabled
 * {@link BreakpointRequest breakpoint request}, an {@link EventSet event set}
 * containing an instance of this class will be added to the VM's event queue.
 *
 * @see EventQueue
 * @see VirtualMachine
 * @see BreakpointRequest
 *
 * @author Robert Field
 * @since  1.3
 */
public interface BreakpointEvent extends LocatableEvent {
}
