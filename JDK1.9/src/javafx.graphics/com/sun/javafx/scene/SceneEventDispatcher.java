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
 * An {@code EventDispatcher} for {@code Scene}. It is formed by a chain
 * of {@code KeyboardShortcutsHandler} followed by {@code EventHandlerManager}.
 */
public class SceneEventDispatcher extends CompositeEventDispatcher {
    private final KeyboardShortcutsHandler keyboardShortcutsHandler;

    private final EnteredExitedHandler enteredExitedHandler;

    private final EventHandlerManager eventHandlerManager;

    public SceneEventDispatcher(final Object eventSource) {
        this(new KeyboardShortcutsHandler(),
             new EnteredExitedHandler(eventSource),
             new EventHandlerManager(eventSource));

    }

    public SceneEventDispatcher(
            final KeyboardShortcutsHandler keyboardShortcutsHandler,
            final EnteredExitedHandler enteredExitedHandler,
            final EventHandlerManager eventHandlerManager) {
        this.keyboardShortcutsHandler = keyboardShortcutsHandler;
        this.enteredExitedHandler = enteredExitedHandler;
        this.eventHandlerManager = eventHandlerManager;

        keyboardShortcutsHandler.insertNextDispatcher(enteredExitedHandler);
        enteredExitedHandler.insertNextDispatcher(eventHandlerManager);

    }

    public final KeyboardShortcutsHandler getKeyboardShortcutsHandler() {
        return keyboardShortcutsHandler;
    }

    public final EnteredExitedHandler getEnteredExitedHandler() {
        return enteredExitedHandler;
    }

    public final EventHandlerManager getEventHandlerManager() {
        return eventHandlerManager;
    }

    @Override
    public BasicEventDispatcher getFirstDispatcher() {
        return keyboardShortcutsHandler;
    }

    @Override
    public BasicEventDispatcher getLastDispatcher() {
        return eventHandlerManager;
    }
}
