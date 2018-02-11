/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * Information about a monitor owned by a thread.
 *
 * @author Swamy Venkataramanappa
 * @since  1.6
 */

public interface MonitorInfo extends Mirror {

    /**
     * Returns the {@link ObjectReference} object for the monitor.
     * @return the {@link ObjectReference} object for the monitor.
     * @throws InvalidStackFrameException if the associated stack
     * frame has become invalid. Once the frame's thread is resumed,
     * the stack frame is no longer valid.
     * @see ThreadReference#ownedMonitorsAndFrames
     * @since 1.6
     */
    public ObjectReference monitor();

    /**
     * Returns the stack depth at which this monitor was
     * acquired by the owning thread. Returns -1 if the
     * implementation cannot determine the stack depth
     * (e.g., for monitors acquired by JNI MonitorEnter).
     * @return the stack depth at which this monitor was
     * acquired by the owning thread.
     * @throws InvalidStackFrameException if the associated stack
     * frame has become invalid. Once the frame's thread is resumed,
     * the stack frame is no longer valid.
     * @see ThreadReference#ownedMonitorsAndFrames
     */
    public int stackDepth();

    /**
     * Returns a {@link ThreadReference} object for the thread that
     * owns the monitor.
     * @return a {@link ThreadReference} object for the thread that
     * owns the monitor.
     * @throws InvalidStackFrameException if the associated stack
     * frame has become invalid. Once the frame's thread is resumed,
     * the stack frame is no longer valid.
     * @see ThreadReference#frame
     */
    ThreadReference thread();
}
