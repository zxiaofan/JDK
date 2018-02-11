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

import com.sun.javafx.event.BasicEventDispatcher;
import com.sun.javafx.event.CompositeEventDispatcher;
import com.sun.javafx.event.EventHandlerManager;

/**
 * An {@code EventDispatcher} for {@code Node}. It is formed by a chain
 * of {@code MouseEnteredExitedHandler} followed by {@code EventHandlerManager}.
 */
public class NodeEventDispatcher extends CompositeEventDispatcher {
    private final EnteredExitedHandler enteredExitedHandler;

    private final EventHandlerManager eventHandlerManager;

    public NodeEventDispatcher(final Object eventSource) {
        this(new EnteredExitedHandler(eventSource),
             new EventHandlerManager(eventSource));
    }

    public NodeEventDispatcher(
            final EnteredExitedHandler enteredExitedHandler,
            final EventHandlerManager eventHandlerManager) {
        this.enteredExitedHandler = enteredExitedHandler;
        this.eventHandlerManager = eventHandlerManager;

        enteredExitedHandler.insertNextDispatcher(eventHandlerManager);
    }

    public final EnteredExitedHandler getEnteredExitedHandler() {
        return enteredExitedHandler;
    }

    public final EventHandlerManager getEventHandlerManager() {
        return eventHandlerManager;
    }

    @Override
    public BasicEventDispatcher getFirstDispatcher() {
        return enteredExitedHandler;
    }

    @Override
    public BasicEventDispatcher getLastDispatcher() {
        return eventHandlerManager;
    }
}
