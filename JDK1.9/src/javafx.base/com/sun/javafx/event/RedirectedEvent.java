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

package com.sun.javafx.event;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * Used as a wrapper in {@code EventRedirector} to distinquish between normal
 * "direct" events and the events "redirected" from the parent dispatcher(s).
 */
public class RedirectedEvent extends Event {

    private static final long serialVersionUID = 20121107L;

    public static final EventType<RedirectedEvent> REDIRECTED =
            new EventType<RedirectedEvent>(Event.ANY, "REDIRECTED");

    private final Event originalEvent;

    public RedirectedEvent(final Event originalEvent) {
        this(originalEvent, null, null);
    }

    public RedirectedEvent(final Event originalEvent,
                           final Object source,
                           final EventTarget target) {
        super(source, target, REDIRECTED);
        this.originalEvent = originalEvent;
    }

    public Event getOriginalEvent() {
        return originalEvent;
    }
}
