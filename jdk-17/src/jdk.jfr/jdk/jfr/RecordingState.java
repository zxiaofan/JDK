/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr;

/**
 * Indicates a state in the life cycle of a recording.
 *
 * @since 9
 */
public enum RecordingState {

    /**
     * The initial state when a {@code Recording} is created.
     */
    NEW,

    /**
     * The recording is scheduled to start with a start time in the future.
     * <p>
     * An invocation of the {@link Recording#start()} method will transition the
     * recording to the {@code RUNNING} state.
     */
    DELAYED,

    /**
     * The recording is recording data and an invocation of the {@link Recording#stop()}
     * method will transition the recording to the {@code STOPPED} state.
     */
    RUNNING,

    /**
     * The recording is stopped and is holding recorded data that can be dumped to
     * disk.
     * <p>
     * An invocation of the {@link Recording#close()} method will release the
     * data and transition the recording to the {@code CLOSED} state.
     */
    STOPPED,

    /**
     * The recording is closed and all resources that are associated with the
     * recording are released.
     * <p>
     * Nothing that can be done with a recording from this point, and it's
     * no longer retrievable from the {@link FlightRecorder#getRecordings()} method.
     */
    CLOSED;
}
