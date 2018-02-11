/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui.gtk;

import com.sun.glass.ui.Pixels;

final class GtkChildWindow extends GtkWindow {

    public GtkChildWindow(long parent) {
        super(parent);
    }

    @Override
    protected void _enterModal(long ptr) {
    }

    @Override
    protected void _enterModalWithWindow(long dialog, long window) {
    }

    @Override
    protected void _exitModal(long ptr) {
    }

    @Override
    protected boolean _maximize(long ptr, boolean maximize, boolean wasMaximized) {
        return true;
    }

    @Override
    protected boolean _minimize(long ptr, boolean minimize) {
        return true;
    }

    @Override
    protected void _setEnabled(long ptr, boolean enabled) {
    }

    @Override
    protected void _setFocusable(long ptr, boolean isFocusable) {
    }

    @Override
    protected void _setIcon(long ptr, Pixels pixels) {
    }

    @Override
    protected void _setLevel(long ptr, int level) {
    }

    @Override
    protected void _setAlpha(long ptr, float alpha) {
    }

    @Override
    protected boolean _setMaximumSize(long ptr, int width, int height) {
        return true;
    }

    @Override
    protected boolean _setMinimumSize(long ptr, int width, int height) {
        return true;
    }

    @Override
    protected boolean _setResizable(long ptr, boolean resizable) {
        return true;
    }

    @Override
    protected boolean _setMenubar(long ptr, long menubarPtr) {
        return true;
    }

    @Override
    protected boolean _setTitle(long ptr, String title) {
        return true;
    }
}
