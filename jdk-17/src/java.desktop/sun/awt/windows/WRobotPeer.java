/*
 * Copyright (c) 1998, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.peer.RobotPeer;

import static sun.java2d.SunGraphicsEnvironment.toDeviceSpaceAbs;

final class WRobotPeer implements RobotPeer {

    public native void mouseMoveImpl(int x, int y);
    @Override
    public void mouseMove(int x, int y) {
        Point point = toDeviceSpaceAbs(x, y);
        mouseMoveImpl(point.x, point.y);
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
        int[] pixelArray = new int[bounds.width*bounds.height];
        getRGBPixels(bounds.x, bounds.y, bounds.width, bounds.height, pixelArray);
        return pixelArray;
    }

    @Override
    public boolean useAbsoluteCoordinates() {
        return true;
    }

    private native void getRGBPixels(int x, int y, int width, int height, int[] pixelArray);
}
