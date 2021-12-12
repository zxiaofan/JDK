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
 * Callback interface to monitor Flight Recorder's life cycle.
 *
 * @since 9
 */
public interface FlightRecorderListener {

    /**
     * Receives notification when Flight Recorder is initialized.
     * <p>
     * This method is also be invoked when a listener is added to an already
     * initialized Flight Recorder.
     * <p>
     * This method allows clients to implement their own initialization mechanism
     * that is executed before a {@code FlightRecorder} instance is returned by
     * {@link FlightRecorder#getFlightRecorder()}.
     *
     * @implNote This method should return as soon as possible, to avoid blocking
     *           initialization of Flight Recorder. To avoid deadlocks or unexpected
     *           behavior, this method should not call
     *           {@code FlightRecorder.getFlightRecorder()} or start new recordings.
     *
     * @implSpec The default implementation of this method is empty.
     *
     * @param recorder Flight Recorder instance, not {@code null}
     *
     * @see FlightRecorder#addListener(FlightRecorderListener)
     */
    default void recorderInitialized(FlightRecorder recorder) {
    }

    /**
     * Receives notification when the state of a recording changes.
     * <p>
     * Callback is invoked when a recording reaches the {@code RUNNING},
     * {@code STOPPED} and {@code CLOSED} state.
     *
     * @implNote The implementation of this method should return as soon as possible
     *           to avoid blocking normal operation of Flight Recorder.
     *
     * @implSpec The default implementation of this method is empty.
     *
     * @param recording the recording where the state change occurred, not
     *        {@code null}
     *
     * @see FlightRecorder#addListener(FlightRecorderListener)
     * @see RecordingState
     *
     */
    default void recordingStateChanged(Recording recording) {
    }
}
