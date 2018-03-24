/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

import javafx.event.Event;
import javafx.stage.Window;

import com.sun.javafx.tk.FocusCause;
import com.sun.javafx.tk.TKStageListener;
import javafx.stage.WindowEvent;

/**
 * Listener for the Stage Peer to pass updates and events back to the stage.
 *
 */
public class WindowPeerListener implements TKStageListener {

    private final Window window;

    public WindowPeerListener(Window window) {
        this.window = window;
    }

    @Override
    public void changedLocation(float x, float y) {
        WindowHelper.notifyLocationChanged(window, x, y);
    }

    @Override
    public void changedSize(float width, float height) {
        WindowHelper.notifySizeChanged(window, width, height);
    }

    @Override
    public void changedScale(float xScale, float yScale) {
        WindowHelper.notifyScaleChanged(window, xScale, yScale);
    }

    public void changedFocused(boolean focused, FocusCause cause) {
        // Also overridden in subclasses
        WindowHelper.setFocused(window, focused);
    }

    public void changedIconified(boolean iconified) {
        // Overridden in subclasses
    }

    public void changedMaximized(boolean maximized) {
        // Overridden in subclasses
    }

    public void changedResizable(boolean resizable) {
        // Overridden in subclasses
    }

    public void changedFullscreen(boolean fs) {
        // Overridden in subclasses
    }

    public void changedAlwaysOnTop(boolean aot) {
        // Overridden in subclasses
    }

    public void changedScreen(Object from, Object to) {
        WindowHelper.getWindowAccessor().notifyScreenChanged(window, from, to);
    }

    @Override
    public void closing() {
        Event.fireEvent(window,
                        new WindowEvent(window,
                                        WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @Override
    public void closed() {
        if (window.isShowing()) {
            // This is a notification to an owned window, which is being
            // closed as a result of closing its owner. The owned window
            // can be a modal dialog, so we call hide() to exit its nested
            // event loop and unblock other windows.
            window.hide();
        }
    }

    @Override public void focusUngrab() {
        Event.fireEvent(window, new FocusUngrabEvent());
    }
}
