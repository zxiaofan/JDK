/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.lens;

import com.sun.glass.ui.*;
import com.sun.glass.events.KeyEvent;
import com.sun.glass.events.MouseEvent;
import java.nio.IntBuffer;

final class LensRobot extends Robot {

    //used for debuging only
    static private int numOfInstances = 0;

    private static final int GET_X = 1;
    private static final int GET_Y = 2;

    protected LensRobot() {
        super();
    }

    @Override protected void _create() {
        // no-op

    }
    @Override protected void _destroy() {
        // no-op
    }

    //Key events

    @Override
    protected void _keyPress(int code) {
        postKeyEvent(KeyEvent.PRESS, code);
    }
    @Override
    protected void _keyRelease(int code) {
        postKeyEvent(KeyEvent.RELEASE, code);
    }


    //Mouse events

    @Override
    protected void _mouseMove(int x, int y) {
        postMouseEvent(MouseEvent.MOVE, x, y, 0);
    }

    @Override
    protected void _mousePress(int buttons) {
        postMouseEvent(MouseEvent.DOWN, 0, 0, buttons);

    }

    @Override
    protected void _mouseRelease(int buttons) {
        postMouseEvent(MouseEvent.UP, 0, 0, buttons);
    }

    @Override
    protected void _mouseWheel(int wheelAmt) {
        postScrollEvent(wheelAmt);
    }

    @Override
    protected int _getMouseX() {
        return getMouseLocation(GET_X);
    }
    @Override
    protected int _getMouseY() {
        return getMouseLocation(GET_Y);
    }

    private native void postScrollEvent(int wheelAmt);

    private native void postKeyEvent(int keyEventType, int keyCode);

    private native void postMouseEvent(int mouseEventType, int x, int y,
                                       int buttons);

    private native int getMouseLocation(int axsis);

    @Override native protected int _getPixelColor(int x, int y);

    @Override native protected void _getScreenCapture(int x, int y, int width, int height, int[] data);
    @Override protected Pixels _getScreenCapture(int x, int y, int width, int height, boolean isHiDPI) {
        int data[] = new int[width * height];
        _getScreenCapture(x, y, width, height, data);
        return Application.GetApplication().createPixels(width, height, IntBuffer.wrap(data));
    }
}

