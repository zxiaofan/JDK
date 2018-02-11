/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.concurrent;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * An event which occurs whenever the state changes on a Worker. Both
 * {@link Task} and {@link Service} support listening to state events.
 * @since JavaFX 2.1
 */
public class WorkerStateEvent extends Event {
    /**
     * Common supertype for all worker state event types.
     */
    public static final EventType<WorkerStateEvent> ANY =
            new EventType<WorkerStateEvent>(Event.ANY, "WORKER_STATE");

    /**
     * This event occurs when the state of a Worker implementation has
     * transitioned to the READY state.
     */
    public static final EventType<WorkerStateEvent> WORKER_STATE_READY =
            new EventType<WorkerStateEvent>(WorkerStateEvent.ANY, "WORKER_STATE_READY");

    /**
     * This event occurs when the state of a Worker implementation has
     * transitioned to the SCHEDULED state.
     */
    public static final EventType<WorkerStateEvent> WORKER_STATE_SCHEDULED =
            new EventType<WorkerStateEvent>(WorkerStateEvent.ANY, "WORKER_STATE_SCHEDULED");

    /**
     * This event occurs when the state of a Worker implementation has
     * transitioned to the RUNNING state.
     */
    public static final EventType<WorkerStateEvent> WORKER_STATE_RUNNING =
            new EventType<WorkerStateEvent>(WorkerStateEvent.ANY, "WORKER_STATE_RUNNING");

    /**
     * This event occurs when the state of a Worker implementation has
     * transitioned to the SUCCEEDED state.
     */
    public static final EventType<WorkerStateEvent> WORKER_STATE_SUCCEEDED =
            new EventType<WorkerStateEvent>(WorkerStateEvent.ANY, "WORKER_STATE_SUCCEEDED");

    /**
     * This event occurs when the state of a Worker implementation has
     * transitioned to the CANCELLED state.
     */
    public static final EventType<WorkerStateEvent> WORKER_STATE_CANCELLED =
            new EventType<WorkerStateEvent>(WorkerStateEvent.ANY, "WORKER_STATE_CANCELLED");

    /**
     * This event occurs when the state of a Worker implementation has
     * transitioned to the FAILED state.
     */
    public static final EventType<WorkerStateEvent> WORKER_STATE_FAILED =
            new EventType<WorkerStateEvent>(WorkerStateEvent.ANY, "WORKER_STATE_FAILED");

    /**
     * Create a new WorkerStateEvent. Specify the worker and the event type.
     *
     * @param worker The Worker which is firing the event. The Worker really
     *               should be an EventTarget, otherwise the EventTarget
     *               for the event will be null.
     * @param eventType The type of event. This should not be null.
     */
    public WorkerStateEvent(@NamedArg("worker") Worker worker, @NamedArg("eventType") EventType<? extends WorkerStateEvent> eventType) {
        super(worker, worker instanceof EventTarget ? (EventTarget) worker : null, eventType);
    }

    /**
     * The Worker on which the Event initially occurred.
     *
     * @return The Worker on which the Event initially occurred.
     */
    @Override public Worker getSource() {
        return (Worker) super.getSource();
    }
}
