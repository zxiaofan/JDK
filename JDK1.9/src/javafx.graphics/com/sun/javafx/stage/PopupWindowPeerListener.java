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

import javafx.stage.PopupWindow;

import com.sun.javafx.tk.FocusCause;


public class PopupWindowPeerListener extends WindowPeerListener {

    private final PopupWindow popupWindow;

    public PopupWindowPeerListener(PopupWindow popupWindow) {
        super(popupWindow);
        this.popupWindow = popupWindow;
    }

    public void changedFocused(boolean cf, FocusCause cause) {
        // TODO: at the native level popup windows are unfocusable, so we
        // don't get any focus notifications from the platform. Temporary
        // workaround is to emulate them from the peers (see PopupStage
        // for details), but the real fix would be to forward the focus
        // events from the owner window
        WindowHelper.setFocused(popupWindow, cf);
    }

    public void closing() {
    }

    public void changedLocation(float x, float y) {
    }

    public void changedIconified(boolean iconified) {
        // Not applicable for popups
    }

    public void changedMaximized(boolean maximized) {
        // Not applicable for popups
    }

    public void changedResizable(boolean resizable) {
        // Not applicable for popups
    }

    public void changedFullscreen(boolean fs) {
        //  Not applicable for popups
    }

    @Override public void focusUngrab() {
        // Not applicable for popups
    }

}
