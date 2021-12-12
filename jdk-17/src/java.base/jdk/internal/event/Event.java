/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.event;

/**
 * Base class for events, to be subclassed in order to define events and their
 * fields.
 */
public abstract class Event {
    /**
     * Sole constructor, for invocation by subclass constructors, typically
     * implicit.
     */
    protected Event() {
    }

    /**
     * Starts the timing of this event.
     */
    public void begin() {
    }

    /**
     * Ends the timing of this event.
     *
     * The {@code end} method must be invoked after the {@code begin} method.
     */
    public void end() {
    }

    /**
     * Writes the field values, time stamp, and event duration.
     * <p>
     * If the event starts with an invocation of the {@code begin} method, but does
     * not end with an explicit invocation of the {@code end} method, then the event
     * ends when the {@code commit} method is invoked.
     */
    public void commit() {
    }

    /**
     * Returns {@code true} if the event is enabled, {@code false} otherwise
     *
     * @return {@code true} if event is enabled, {@code false} otherwise
     */
    public boolean isEnabled() {
        return false;
    }

    /**
     * Returns {@code true} if the event is enabled and if the duration is within
     * the threshold for the event, {@code false} otherwise.
     *
     * @return {@code true} if the event can be written, {@code false} otherwise
     */
    public boolean shouldCommit() {
        return false;
    }

    /**
     * Sets a field value.
     *
     * @param index the index of the field to set
     * @param value value to set, can be {@code null}
     * @throws UnsupportedOperationException if functionality is not supported
     * @throws IndexOutOfBoundsException if {@code index} is less than {@code 0} or
     *         greater than or equal to the number of fields specified for the event
     */
    public void set(int index, Object value) {
    }
}
