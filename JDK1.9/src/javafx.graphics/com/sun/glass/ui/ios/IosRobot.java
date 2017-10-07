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

package com.sun.glass.ui.ios;

import com.sun.glass.ui.*;
import java.nio.IntBuffer;

/**
 * iOS platform implementation class of test automation Robot.
 */
final class IosRobot extends Robot {

    private long ptr = 0;

    // init and create native robot object
    private native long _init();
    @Override protected void _create() {
        ptr = _init();
    }

    // release native robot object
    private native void _destroy(long ptr);
    @Override protected void _destroy() {
        _destroy(ptr);
        ptr = 0;
    }

    // synthesize key press
    private native void _keyPress(long ptr, int code);
    @Override protected void _keyPress(int code) {
        if (ptr == 0) {
            return;
        }
        _keyPress(ptr, code);
    }

    // synthesize key release
    private native void _keyRelease(long ptr, int code);
    @Override protected void _keyRelease(int code) {
        if (ptr == 0) {
            return;
        }
        _keyRelease(ptr, code);
    }

    // synthesize mouse motion
    private native void _mouseMove(long ptr, int x, int y);
    @Override protected void _mouseMove(int x, int y) {
        if (ptr == 0) {
            return;
        }
        _mouseMove(ptr, x, y);
    }

    // synthesize mouse press of buttons
    private native void _mousePress(long ptr, int buttons);
    @Override protected void _mousePress(int buttons) {
        if (ptr == 0) {
            return;
        }
        _mousePress(ptr, buttons);
    }

    // synthesize mouse release of buttons
    private native void _mouseRelease(long ptr, int buttons);
    @Override protected void _mouseRelease(int buttons) {
        if (ptr == 0) {
            return;
        }
        _mouseRelease(ptr, buttons);
    }

    private native void _mouseWheel(long ptr, int wheelAmt);
    @Override protected void _mouseWheel(int wheelAmt) {
        if (ptr == 0) {
            return;
        }
        _mouseWheel(ptr, wheelAmt);
    }

    // get x-coordinate of mouse location
    private native int _getMouseX(long ptr);
    @Override protected int _getMouseX() {
        if (ptr == 0) {
            return 0;
        }
        return _getMouseX(ptr);
    }

    // get x-coordinate of mouse location
    private native int _getMouseY(long ptr);
    @Override protected int _getMouseY() {
        if (ptr == 0) {
            return 0;
        }
        return _getMouseY(ptr);
    }

    private native int _getPixelColor(long ptr, int x, int y);
    @Override protected int _getPixelColor(int x, int y) {
        if (ptr == 0) {
            return 0;
        }
        return _getPixelColor(ptr, x, y);
    }

    // capture bitmap image of (x, y, x + width, y + height) area
    native private void _getScreenCapture(long ptr, int x, int y, int width, int height, int[] data);
    @Override protected Pixels _getScreenCapture(int x, int y, int width, int height, boolean isHiDPI) {
        if (ptr == 0) {
            return null;
        }
        int data[] = new int[width * height];
        _getScreenCapture(ptr, x, y, width, height, data);
        return Application.GetApplication().createPixels(width, height, IntBuffer.wrap(data));
    }
}

