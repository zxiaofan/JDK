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

package com.sun.javafx.stage;

import com.sun.javafx.event.BasicEventDispatcher;
import com.sun.javafx.event.CompositeEventDispatcher;
import com.sun.javafx.event.EventHandlerManager;
import com.sun.javafx.event.EventRedirector;

import javafx.stage.Window;

/**
 * An {@code EventDispatcher} for {@code Window}. It is formed by a chain
 * in which a received event is first passed through {@code EventRedirector}
 * and then through {@code EventHandlerManager}.
 */
public class WindowEventDispatcher extends CompositeEventDispatcher {
    private final EventRedirector eventRedirector;

    private final WindowCloseRequestHandler windowCloseRequestHandler;

    private final EventHandlerManager eventHandlerManager;

    public WindowEventDispatcher(final Window window) {
        this(new EventRedirector(window),
             new WindowCloseRequestHandler(window),
             new EventHandlerManager(window));

    }

    public WindowEventDispatcher(
            final EventRedirector eventRedirector,
            final WindowCloseRequestHandler windowCloseRequestHandler,
            final EventHandlerManager eventHandlerManager) {
        this.eventRedirector = eventRedirector;
        this.windowCloseRequestHandler = windowCloseRequestHandler;
        this.eventHandlerManager = eventHandlerManager;

        eventRedirector.insertNextDispatcher(windowCloseRequestHandler);
        windowCloseRequestHandler.insertNextDispatcher(eventHandlerManager);
    }

    public final EventRedirector getEventRedirector() {
        return eventRedirector;
    }

    public final WindowCloseRequestHandler getWindowCloseRequestHandler() {
        return windowCloseRequestHandler;
    }

    public final EventHandlerManager getEventHandlerManager() {
        return eventHandlerManager;
    }

    @Override
    public BasicEventDispatcher getFirstDispatcher() {
        return eventRedirector;
    }

    @Override
    public BasicEventDispatcher getLastDispatcher() {
        return eventHandlerManager;
    }
}
