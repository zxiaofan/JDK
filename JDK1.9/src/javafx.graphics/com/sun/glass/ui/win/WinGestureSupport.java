/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.TouchInputSupport;
import com.sun.glass.ui.GestureSupport;
import com.sun.glass.ui.Application;
import com.sun.glass.ui.View;
import java.security.AccessController;
import java.security.PrivilegedAction;

final class WinGestureSupport {

    private native static void _initIDs();
    static {
        _initIDs();
    }

    // The multiplier used to convert scroll units to pixels
    private static final double multiplier = 1.0;

    private final static GestureSupport gestures = new GestureSupport(true);
    private final static TouchInputSupport touches =
            new TouchInputSupport(gestures.createTouchCountListener(), true);
    private static int modifiers;
    private static boolean isDirect;

    public static void notifyBeginTouchEvent(View view, int modifiers,
                                             boolean isDirect,
                                             int touchEventCount) {
        touches.notifyBeginTouchEvent(view, modifiers, isDirect, touchEventCount);
    }

    public static void notifyNextTouchEvent(View view, int state, long id, int x,
                                            int y, int xAbs, int yAbs) {
        touches.notifyNextTouchEvent(view, state, id, x, y, xAbs, yAbs);
    }

    public static void notifyEndTouchEvent(View view) {
        touches.notifyEndTouchEvent(view);
        gestureFinished(view, touches.getTouchCount(), false);
    }

    private static void gestureFinished(View view, int touchCount,
                                        boolean isInertia) {
        if (gestures.isScrolling() && touchCount == 0) {
            gestures.handleScrollingEnd(view, modifiers, touchCount, isDirect,
                                        isInertia,
                                        View.GESTURE_NO_VALUE,
                                        View.GESTURE_NO_VALUE,
                                        View.GESTURE_NO_VALUE,
                                        View.GESTURE_NO_VALUE);
        }

        if (gestures.isRotating() && touchCount < 2) {
            gestures.handleRotationEnd(view, modifiers, isDirect, isInertia,
                                       View.GESTURE_NO_VALUE,
                                       View.GESTURE_NO_VALUE,
                                       View.GESTURE_NO_VALUE,
                                       View.GESTURE_NO_VALUE);
        }

        if (gestures.isZooming() && touchCount < 2) {
            gestures.handleZoomingEnd(view, modifiers, isDirect, isInertia,
                                      View.GESTURE_NO_VALUE,
                                      View.GESTURE_NO_VALUE,
                                      View.GESTURE_NO_VALUE,
                                      View.GESTURE_NO_VALUE);
        }
    }

    public static void inertiaGestureFinished(View view) {
        gestureFinished(view, 0, true);
    }

    public static void gesturePerformed(View view, int modifiers,
                                        boolean isDirect, boolean isInertia,
                                        int x, int y, int xAbs,
                                        int yAbs, float dx, float dy,
                                        float totaldx, float totaldy,
                                        float totalscale, float totalexpansion,
                                        float totalrotation) {
        WinGestureSupport.modifiers = modifiers;
        WinGestureSupport.isDirect = isDirect;

        final int touchCount = touches.getTouchCount();

        if (touchCount >= 2) {
            gestures.handleTotalZooming(view, modifiers, isDirect, isInertia, x,
                                        y, xAbs, yAbs, totalscale,
                                        totalexpansion);

            gestures.handleTotalRotation(view, modifiers, isDirect, isInertia, x,
                                         y, xAbs, yAbs, Math.toDegrees(
                    totalrotation));
        }

        gestures.handleTotalScrolling(view, modifiers, isDirect, isInertia,
                                      touchCount, x, y, xAbs, yAbs, totaldx,
                                      totaldy, multiplier, multiplier);
    }
}
