/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.jdi.ObjectReference;
import com.sun.jdi.ThreadReference;

/**
 * Notification that a thread in the target VM is about to
 * wait on a monitor object.
 *
 * @see EventQueue
 * @see MonitorWaitedEvent
 *
 * @author Swamy Venkataramanappa
 * @since  1.6
 */
public interface MonitorWaitEvent extends LocatableEvent {

    /**
     * Returns the thread in which monitor wait event has occurred.
     *
     * @return a {@link ThreadReference} which mirrors the event's thread in
     * the target VM.
     */
    public ThreadReference thread();

    /**
     * Returns the monitor object that the thread about to wait.
     *
     * @return an {@link ObjectReference} for the monitor.
     */
    public ObjectReference monitor();

    /**
     * Returns the number of millisecond the thread will wait.
     *
     * @return a {@code jlong} containing monitor wait time in milliseconds.
     */
    public long timeout();
}
