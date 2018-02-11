/*
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.windows;

import java.awt.*;
import java.awt.peer.RobotPeer;

final class WRobotPeer extends WObjectPeer implements RobotPeer
{
    WRobotPeer() {
        create();
    }
    WRobotPeer(GraphicsDevice screen) {
        create();
    }

    private synchronized native void _dispose();

    @Override
    protected void disposeImpl() {
        _dispose();
    }

    public native void create();
    public native void mouseMoveImpl(int x, int y);
    @Override
    public void mouseMove(int x, int y) {
        mouseMoveImpl(x, y);
    }
    @Override
    public native void mousePress(int buttons);
    @Override
    public native void mouseRelease(int buttons);
    @Override
    public native void mouseWheel(int wheelAmt);

    @Override
    public native void keyPress( int keycode );
    @Override
    public native void keyRelease( int keycode );

    @Override
    public int getRGBPixel(int x, int y) {
         // See 7002846: that's ineffective, but works correctly with non-opaque windows
        return getRGBPixels(new Rectangle(x, y, 1, 1))[0];
    }

    @Override
    public int [] getRGBPixels(Rectangle bounds) {
        int pixelArray[] = new int[bounds.width*bounds.height];
        getRGBPixels(bounds.x, bounds.y, bounds.width, bounds.height, pixelArray);
        return pixelArray;
    }

    private native void getRGBPixels(int x, int y, int width, int height, int pixelArray[]);
}
