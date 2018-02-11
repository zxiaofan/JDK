/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.*;
import java.nio.IntBuffer;

/**
 * MS Windows platform implementation class for Robot.
 */
final class WinRobot extends Robot {

    @Override protected void _create() {
        // no-op
    }
    @Override protected void _destroy() {
        // no-op
    }

    @Override native protected void _keyPress(int code);
    @Override native protected void _keyRelease(int code);

    @Override native protected void _mouseMove(int x, int y);
    @Override native protected void _mousePress(int buttons);
    @Override native protected void _mouseRelease(int buttons);
    @Override native protected void _mouseWheel(int wheelAmt);

    @Override native protected int _getMouseX();
    @Override native protected int _getMouseY();

    @Override native protected int _getPixelColor(int x, int y);
    @Override native protected void _getScreenCapture(int x, int y, int width, int height, int[] data);
}
