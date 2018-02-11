/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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
package javafx.scene.control;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * Event related to dialog showing/hiding actions. In particular, this event is
 * used exclusively by the following methods:
 *
 * <ul>
 *   <li>{@link Dialog#onShowingProperty()}
 *   <li>{@link Dialog#onShownProperty()}
 *   <li>{@link Dialog#onHidingProperty()}
 *   <li>{@link Dialog#onCloseRequestProperty()}
 *   <li>{@link Dialog#onHiddenProperty()}
 * </ul>
 *
 * @see Dialog
 * @since JavaFX 8u40
 */
public class DialogEvent extends Event {

    private static final long serialVersionUID = 20140716L;

    /**
     * Common supertype for all dialog event types.
     */
    public static final EventType<DialogEvent> ANY =
            new EventType<DialogEvent>(Event.ANY, "DIALOG");

    /**
     * This event occurs on dialog just before it is shown.
     */
    public static final EventType<DialogEvent> DIALOG_SHOWING =
            new EventType<DialogEvent>(DialogEvent.ANY, "DIALOG_SHOWING");

    /**
     * This event occurs on dialog just after it is shown.
     */
    public static final EventType<DialogEvent> DIALOG_SHOWN =
            new EventType<DialogEvent>(DialogEvent.ANY, "DIALOG_SHOWN");

    /**
     * This event occurs on dialog just before it is hidden.
     */
    public static final EventType<DialogEvent> DIALOG_HIDING =
            new EventType<DialogEvent>(DialogEvent.ANY, "DIALOG_HIDING");

    /**
     * This event occurs on dialog just after it is hidden.
     */
    public static final EventType<DialogEvent> DIALOG_HIDDEN =
            new EventType<DialogEvent>(DialogEvent.ANY, "DIALOG_HIDDEN");

    /**
     * This event is delivered to a
     * dialog when there is an external request to close that dialog. If the
     * event is not consumed by any installed dialog event handler, the default
     * handler for this event closes the corresponding dialog.
     */
    public static final EventType<DialogEvent> DIALOG_CLOSE_REQUEST =
            new EventType<DialogEvent>(DialogEvent.ANY, "DIALOG_CLOSE_REQUEST");

    /**
     * Construct a new {@code Event} with the specified event source, target
     * and type. If the source or target is set to {@code null}, it is replaced
     * by the {@code NULL_SOURCE_TARGET} value.
     *
     * @param source    the event source which sent the event
     * @param eventType the event type
     */
    public DialogEvent(final @NamedArg("source") Dialog<?> source, final @NamedArg("eventType") EventType<? extends Event> eventType) {
        super(source, source, eventType);
    }

    /**
     * Returns a string representation of this {@code DialogEvent} object.
     * @return a string representation of this {@code DialogEvent} object.
     */
    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("DialogEvent [");

        sb.append("source = ").append(getSource());
        sb.append(", target = ").append(getTarget());
        sb.append(", eventType = ").append(getEventType());
        sb.append(", consumed = ").append(isConsumed());

        return sb.append("]").toString();
    }

    @Override public DialogEvent copyFor(Object newSource, EventTarget newTarget) {
        return (DialogEvent) super.copyFor(newSource, newTarget);
    }

    /**
     * Creates a copy of the given event with the given fields substituted.
     * @param newSource the new source of the copied event
     * @param newTarget the new target of the copied event
     * @param type the new eventType
     * @return the event copy with the fields substituted
     */
    public DialogEvent copyFor(Object newSource, EventTarget newTarget, EventType<DialogEvent> type) {
        DialogEvent e = copyFor(newSource, newTarget);
        e.eventType = type;
        return e;
    }

    @SuppressWarnings("unchecked")
    @Override public EventType<DialogEvent> getEventType() {
        return (EventType<DialogEvent>) super.getEventType();
    }
}
