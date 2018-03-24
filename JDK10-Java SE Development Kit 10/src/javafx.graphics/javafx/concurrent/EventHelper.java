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

import com.sun.javafx.event.EventHandlerManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.*;
import static javafx.concurrent.WorkerStateEvent.*;
import static javafx.concurrent.WorkerStateEvent.WORKER_STATE_CANCELLED;
import static javafx.concurrent.WorkerStateEvent.WORKER_STATE_FAILED;

/**
 * This utility class is used both to bucketize the event handler related
 * methods and state in Service and Task, but also (and more importantly)
 * to consolidate the implementation into one place.
 */
class EventHelper {
    private final EventTarget target;

    private final ObjectProperty<EventHandler<WorkerStateEvent>> onReady;
    final ObjectProperty<EventHandler<WorkerStateEvent>> onReadyProperty() { return onReady; }
    final EventHandler<WorkerStateEvent> getOnReady() { return onReady.get(); }
    final void setOnReady(EventHandler<WorkerStateEvent> value) { onReady.set(value); }

    private final ObjectProperty<EventHandler<WorkerStateEvent>> onScheduled;
    final ObjectProperty<EventHandler<WorkerStateEvent>> onScheduledProperty() { return onScheduled; }
    final EventHandler<WorkerStateEvent> getOnScheduled() { return onScheduled.get(); }
    final void setOnScheduled(EventHandler<WorkerStateEvent> value) { onScheduled.set(value); }

    private final ObjectProperty<EventHandler<WorkerStateEvent>> onRunning;
    final ObjectProperty<EventHandler<WorkerStateEvent>> onRunningProperty() { return onRunning; }
    final EventHandler<WorkerStateEvent> getOnRunning() { return onRunning.get(); }
    final void setOnRunning(EventHandler<WorkerStateEvent> value) { onRunning.set(value); }

    private final ObjectProperty<EventHandler<WorkerStateEvent>> onSucceeded;
    final ObjectProperty<EventHandler<WorkerStateEvent>> onSucceededProperty() { return onSucceeded; }
    final EventHandler<WorkerStateEvent> getOnSucceeded() { return onSucceeded.get(); }
    final void setOnSucceeded(EventHandler<WorkerStateEvent> value) { onSucceeded.set(value); }

    private final ObjectProperty<EventHandler<WorkerStateEvent>> onCancelled;
    final ObjectProperty<EventHandler<WorkerStateEvent>> onCancelledProperty() { return onCancelled; }
    final EventHandler<WorkerStateEvent> getOnCancelled() { return onCancelled.get(); }
    final void setOnCancelled(EventHandler<WorkerStateEvent> value) { onCancelled.set(value); }

    private final ObjectProperty<EventHandler<WorkerStateEvent>> onFailed;
    final ObjectProperty<EventHandler<WorkerStateEvent>> onFailedProperty() { return onFailed; }
    final EventHandler<WorkerStateEvent> getOnFailed() { return onFailed.get(); }
    final void setOnFailed(EventHandler<WorkerStateEvent> value) { onFailed.set(value); }

    private EventHandlerManager internalEventDispatcher;

    EventHelper(EventTarget bean) {
        this.target = bean;
        onReady = new SimpleObjectProperty<EventHandler<WorkerStateEvent>>(bean, "onReady") {
            @Override protected void invalidated() {
                EventHandler<WorkerStateEvent> handler = get();
                setEventHandler(WORKER_STATE_READY, handler);
            }
        };
        onScheduled = new SimpleObjectProperty<EventHandler<WorkerStateEvent>>(bean, "onScheduled") {
            @Override protected void invalidated() {
                EventHandler<WorkerStateEvent> handler = get();
                setEventHandler(WORKER_STATE_SCHEDULED, handler);
            }
        };
        onRunning = new SimpleObjectProperty<EventHandler<WorkerStateEvent>>(bean, "onRunning") {
            @Override protected void invalidated() {
                EventHandler<WorkerStateEvent> handler = get();
                setEventHandler(WORKER_STATE_RUNNING, handler);
            }
        };
        onSucceeded = new SimpleObjectProperty<EventHandler<WorkerStateEvent>>(bean, "onSucceeded") {
            @Override protected void invalidated() {
                EventHandler<WorkerStateEvent> handler = get();
                setEventHandler(WORKER_STATE_SUCCEEDED, handler);
            }
        };
        onCancelled = new SimpleObjectProperty<EventHandler<WorkerStateEvent>>(bean, "onCancelled") {
            @Override protected void invalidated() {
                EventHandler<WorkerStateEvent> handler = get();
                setEventHandler(WORKER_STATE_CANCELLED, handler);
            }
        };
        onFailed = new SimpleObjectProperty<EventHandler<WorkerStateEvent>>(bean, "onFailed") {
            @Override protected void invalidated() {
                EventHandler<WorkerStateEvent> handler = get();
                setEventHandler(WORKER_STATE_FAILED, handler);
            }
        };
    }

    /**
     * Registers an event handler to this task. Any event filters are first
     * processed, then the specified onFoo event handlers, and finally any
     * event handlers registered by this method. As with other events
     * in the scene graph, if an event is consumed, it will not continue
     * dispatching.
     *
     * @param <T> the specific event class of the handler
     * @param eventType the type of the events to receive by the handler
     * @param eventHandler the handler to register
     */
    final <T extends Event> void addEventHandler(
            final EventType<T> eventType,
            final EventHandler<? super T> eventHandler) {
        getInternalEventDispatcher()
                .addEventHandler(eventType, eventHandler);
    }

    /**
     * Unregisters a previously registered event handler from this task. One
     * handler might have been registered for different event types, so the
     * caller needs to specify the particular event type from which to
     * unregister the handler.
     *
     * @param <T> the specific event class of the handler
     * @param eventType the event type from which to unregister
     * @param eventHandler the handler to unregister
     */
    final <T extends Event> void removeEventHandler(
            final EventType<T> eventType,
            final EventHandler<? super T> eventHandler) {
        getInternalEventDispatcher()
                .removeEventHandler(eventType, eventHandler);
    }

    /**
     * Registers an event filter to this task. Registered event filters get
     * an event before any associated event handlers.
     *
     * @param <T> the specific event class of the filter
     * @param eventType the type of the events to receive by the filter
     * @param eventFilter the filter to register
     */
    final <T extends Event> void addEventFilter(
            final EventType<T> eventType,
            final EventHandler<? super T> eventFilter) {
        getInternalEventDispatcher()
                .addEventFilter(eventType, eventFilter);
    }

    /**
     * Unregisters a previously registered event filter from this task. One
     * filter might have been registered for different event types, so the
     * caller needs to specify the particular event type from which to
     * unregister the filter.
     *
     * @param <T> the specific event class of the filter
     * @param eventType the event type from which to unregister
     * @param eventFilter the filter to unregister
     */
    final <T extends Event> void removeEventFilter(
            final EventType<T> eventType,
            final EventHandler<? super T> eventFilter) {
        getInternalEventDispatcher()
                .removeEventFilter(eventType, eventFilter);
    }

    /**
     * Sets the handler to use for this event type. There can only be one such
     * handler specified at a time. This handler is guaranteed to be called
     * first. This is used for registering the user-defined onFoo event
     * handlers.
     *
     * @param <T> the specific event class of the handler
     * @param eventType the event type to associate with the given eventHandler
     * @param eventHandler the handler to register, or null to unregister
     */
    final <T extends Event> void setEventHandler(
            final EventType<T> eventType,
            final EventHandler<? super T> eventHandler) {
        getInternalEventDispatcher()
                .setEventHandler(eventType, eventHandler);
    }

    private EventHandlerManager getInternalEventDispatcher() {
        if (internalEventDispatcher == null) {
            internalEventDispatcher = new EventHandlerManager(target);
        }
        return internalEventDispatcher;
    }

    /**
     * Fires the specified event. Any event filter encountered will
     * be notified and can consume the event. If not consumed by the filters,
     * the event handlers on this task are notified. If these don't consume the
     * event either, then all event handlers are called and can consume the
     * event.
     * <p>
     * This method must be called on the FX user thread.
     *
     * @param event the event to fire
     */
    final void fireEvent(Event event) {
        Event.fireEvent(target, event);
    }

    EventDispatchChain buildEventDispatchChain(EventDispatchChain tail) {
        return internalEventDispatcher == null ? tail : tail.append(getInternalEventDispatcher());
    }
}
