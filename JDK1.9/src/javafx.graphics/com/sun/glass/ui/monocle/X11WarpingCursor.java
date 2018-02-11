/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

/** Native cursor for use with X11 when we are NOT using x11 input
 *
 */
public class X11WarpingCursor extends X11Cursor {

    private int nextX, nextY;
    private static X xLib = X.getX();

    /** Update the next coordinates for the cursor.  The actual move will occur
     * on the next buffer swap
     * @param x the new X location on the screen
     * @param y the new Y location on the screen
     */
    @Override
    void setLocation(int x, int y) {
        if (x != nextX || y != nextY) {
            nextX = x;
            nextY = y;
            MonocleWindowManager.getInstance().repaintAll();
        }
    }

    /** Called from the swap buffer implementation for this accelerated screen.
     *  Tells X to move the cursor by a given x/y offset from the current
     *  location.
     */
    void warp() {
        if (isVisible) {
            int[] position = new int[2];
            xLib.XQueryPointer(xdisplay, xwindow, position);
            if (position[0] != nextX || position[1] != nextY) {
                xLib.XWarpPointer(xdisplay, 0l, 0l, 0, 0, 0, 0,
                               nextX - position[0],
                               nextY - position[1]);
            }
        }
    }
}
