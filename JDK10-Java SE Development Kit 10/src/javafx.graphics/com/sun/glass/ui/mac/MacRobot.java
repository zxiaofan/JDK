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
package com.sun.glass.ui.mac;

import com.sun.glass.ui.*;

/**
 * MacOSX platform implementation class for Robot.
 */
final class MacRobot extends Robot {

    // TODO: get rid of native Robot object
    private long ptr;

    private native long _init();
    @Override protected void _create() {
        ptr = _init();
    }

    private native void _destroy(long ptr);
    @Override protected void _destroy() {
        if (ptr == 0) {
            return;
        }
        _destroy(ptr);
    }

    @Override native protected void _keyPress(int code);
    @Override native protected void _keyRelease(int code);

    private native void _mouseMove(long ptr, int x, int y);
    @Override protected void _mouseMove(int x, int y) {
        if (ptr == 0) {
            return;
        }
        _mouseMove(ptr, x, y);
    }

    private native void _mousePress(long ptr, int buttons);
    @Override protected void _mousePress(int buttons) {
        if (ptr == 0) {
            return;
        }
        _mousePress(ptr, buttons);
    }

    private native void _mouseRelease(long ptr, int buttons);
    @Override protected void _mouseRelease(int buttons) {
        if (ptr == 0) {
            return;
        }
        _mouseRelease(ptr, buttons);
    }

    @Override native protected void _mouseWheel(int wheelAmt);

    private native int _getMouseX(long ptr);
    @Override protected int _getMouseX() {
        if (ptr == 0) {
            return 0;
        }
        return _getMouseX(ptr);
    }

    private native int _getMouseY(long ptr);
    @Override protected int _getMouseY() {
        if (ptr == 0) {
            return 0;
        }
        return _getMouseY(ptr);
    }

    @Override native protected int _getPixelColor(int x, int y);
    @Override native protected Pixels _getScreenCapture(int x, int y, int width, int height, boolean isHiDPI);
}

