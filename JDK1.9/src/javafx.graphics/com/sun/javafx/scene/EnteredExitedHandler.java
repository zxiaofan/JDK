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

package com.sun.javafx.scene;

import javafx.event.Event;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

import com.sun.javafx.event.BasicEventDispatcher;
import javafx.event.EventType;
import javafx.scene.input.MouseDragEvent;

/**
 * {@code EventDispatcher} which translates event types for events which have
 * normal event types with target specific sub-types.
 */
public class EnteredExitedHandler extends BasicEventDispatcher {
    private final Object eventSource;
    private boolean eventTypeModified;

    public EnteredExitedHandler(final Object eventSource) {
        this.eventSource = eventSource;
    }

    @Override
    public final Event dispatchCapturingEvent(Event event) {
        if (eventSource == event.getTarget()) {
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED_TARGET) {
                eventTypeModified = true;
                return((MouseEvent)event).copyFor(eventSource, event.getTarget(),
                        MouseEvent.MOUSE_ENTERED);
            }

            if (event.getEventType() == MouseEvent.MOUSE_EXITED_TARGET) {
                eventTypeModified = true;
                return ((MouseEvent)event).copyFor(eventSource, event.getTarget(),
                        MouseEvent.MOUSE_EXITED);
            }

            if (event.getEventType() == MouseDragEvent.MOUSE_DRAG_ENTERED_TARGET) {
                eventTypeModified = true;
                return ((MouseDragEvent) event).copyFor(eventSource,
                        event.getTarget(), MouseDragEvent.MOUSE_DRAG_ENTERED);
            }

            if (event.getEventType() == MouseDragEvent.MOUSE_DRAG_EXITED_TARGET) {
                eventTypeModified = true;
                return ((MouseDragEvent) event).copyFor(eventSource,
                        event.getTarget(), MouseDragEvent.MOUSE_DRAG_EXITED);
            }

            if (event.getEventType() == DragEvent.DRAG_ENTERED_TARGET) {
                eventTypeModified = true;
                return ((DragEvent) event).copyFor(eventSource, event.getTarget(),
                                           DragEvent.DRAG_ENTERED);
            }

            if (event.getEventType() == DragEvent.DRAG_EXITED_TARGET) {
                eventTypeModified = true;
                return ((DragEvent) event).copyFor(eventSource, event.getTarget(),
                                           DragEvent.DRAG_EXITED);
            }
        }

        eventTypeModified = false;
        return event;
    }

    @Override
    public final Event dispatchBubblingEvent(Event event) {
        if (eventTypeModified && (eventSource == event.getTarget())) {
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                return ((MouseEvent)event).copyFor(eventSource, event.getTarget(),
                                            MouseEvent.MOUSE_ENTERED_TARGET);
            }

            if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                return ((MouseEvent)event).copyFor(eventSource, event.getTarget(),
                                            MouseEvent.MOUSE_EXITED_TARGET);
            }

            if (event.getEventType() == MouseDragEvent.MOUSE_DRAG_ENTERED) {
                eventTypeModified = true;
                return ((MouseDragEvent) event).copyFor(eventSource,
                        event.getTarget(), MouseDragEvent.MOUSE_DRAG_ENTERED_TARGET);
            }

            if (event.getEventType() == MouseDragEvent.MOUSE_DRAG_EXITED) {
                eventTypeModified = true;
                return ((MouseDragEvent) event).copyFor(eventSource,
                        event.getTarget(), MouseDragEvent.MOUSE_DRAG_EXITED_TARGET);
            }

            if (event.getEventType() == DragEvent.DRAG_ENTERED) {
                return ((DragEvent) event).copyFor(eventSource, event.getTarget(),
                                           DragEvent.DRAG_ENTERED_TARGET);
            }

            if (event.getEventType() == DragEvent.DRAG_EXITED) {
                return ((DragEvent) event).copyFor(eventSource, event.getTarget(),
                                           DragEvent.DRAG_EXITED_TARGET);
            }
        }

        return event;
    }
}


