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
package com.sun.glass.ui.win;

import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.Screen;
import com.sun.glass.ui.View;
import com.sun.glass.ui.Window;

/**
 * MS Windows platform implementation class for child Window.
 */
final class WinChildWindow extends WinWindow {
    protected WinChildWindow(long parent) {
        super(parent);
    }

    // Prohibit operations applicable to top-level windows only
    @Override protected long _createWindow(long ownerPtr, long screenPtr, int mask) { return 0L; }
    @Override protected boolean _setMenubar(long ptr, long menubarPtr) { return false; }
    @Override protected boolean _minimize(long ptr, boolean minimize) { return false; }
    @Override protected boolean _maximize(long ptr, boolean maximize, boolean wasMaximized) { return false; }
    @Override protected boolean _setResizable(long ptr, boolean resizable) { return false; }
    @Override protected boolean _setTitle(long ptr, String title) { return false; }
    @Override protected void _setLevel(long ptr, int level) {}
    @Override protected void _setAlpha(long ptr, float alpha) {}
    @Override protected boolean _setMinimumSize(long ptr, int width, int height) { return false; }
    @Override protected boolean _setMaximumSize(long ptr, int width, int height) { return false; }
    @Override protected void _setIcon(long ptr, Pixels pixels) {}
    @Override protected void _enterModal(long ptr) {}
    @Override protected void _enterModalWithWindow(long dialog, long window) {}
    @Override protected void _exitModal(long ptr) {}
}

