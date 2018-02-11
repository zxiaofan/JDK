/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui;

import com.sun.glass.events.TouchEvent;

import java.util.HashMap;
import java.util.Map;

public class TouchInputSupport
{
    private int touchCount = 0;

    private boolean filterTouchCoordinates;
    private static class TouchCoord {
        private final int x, y, xAbs, yAbs;

        private TouchCoord(int x, int y, int xAbs, int yAbs) {
            this.x = x;
            this.y = y;
            this.xAbs = xAbs;
            this.yAbs = yAbs;
        }
    }
    private Map<Long, TouchCoord> touch;

    private TouchCountListener listener;

    private int curTouchCount;
    private View curView;
    private int curModifiers;
    private boolean curIsDirect;

    public static interface TouchCountListener {
        void touchCountChanged(TouchInputSupport sender, View view,
                               int modifiers, boolean isDirect);
    }

    public TouchInputSupport(TouchCountListener listener,
                             boolean filterTouchCoordinates) {
        Application.checkEventThread();
        this.listener = listener;
        this.filterTouchCoordinates = filterTouchCoordinates;
        if (filterTouchCoordinates) {
            touch = new HashMap<>();
        }
    }

    public int getTouchCount() {
        Application.checkEventThread();
        return touchCount;
    }

    public void notifyBeginTouchEvent(View view, int modifiers, boolean isDirect,
                                      int touchEventCount) {

        if (curView != null && view != curView && touchCount != 0 && touch != null) {
            if (!curView.isClosed()) {
                // Release the currently pressed touch points
                curView.notifyBeginTouchEvent(0, true, touchCount);
                for (Map.Entry<Long, TouchCoord> e : touch.entrySet()) {
                    TouchCoord coord = e.getValue();
                    curView.notifyNextTouchEvent(TouchEvent.TOUCH_RELEASED, e.getKey(), coord.x, coord.y, coord.xAbs, coord.yAbs);
                }
                curView.notifyEndTouchEvent();
            }
            touch.clear();
            touchCount = 0;
            if (listener != null ) {
                listener.touchCountChanged(this, curView, 0, true);
            }
        }

        curTouchCount = touchCount;
        curView = view;
        curModifiers = modifiers;
        curIsDirect = isDirect;
        if (view != null) {
            view.notifyBeginTouchEvent(modifiers, isDirect, touchEventCount);
        }
    }

    public void notifyEndTouchEvent(View view) {
        if (view == null) {
            return;
        }

        view.notifyEndTouchEvent();

        // RT-21288. Notify outer world when touch point count changes
        if (curTouchCount != 0 && touchCount != 0 && curTouchCount != touchCount &&
                listener != null) {
            listener.touchCountChanged(this, curView, curModifiers, curIsDirect);
        }
    }

    public void notifyNextTouchEvent(View view, int state, long id, int x, int y,
                                     int xAbs, int yAbs)
    {
        switch (state) {
            case TouchEvent.TOUCH_RELEASED:
                touchCount--;
                break;
            case TouchEvent.TOUCH_PRESSED:
                touchCount++;
                break;
            case TouchEvent.TOUCH_MOVED:
            case TouchEvent.TOUCH_STILL:
                break;
            default:
                System.err.println("Unknown touch state: " + state);
                return;
        }

        if (filterTouchCoordinates) {
            state = filterTouchInputState(state, id, x, y, xAbs, yAbs);
        }

        if (view != null) {
            view.notifyNextTouchEvent(state, id, x, y, xAbs, yAbs);
        }
    }

    private int filterTouchInputState(int state, long id, int x, int y, int xAbs, int yAbs) {
        switch (state) {
            case TouchEvent.TOUCH_RELEASED:
                touch.remove(id);
                break;
            case TouchEvent.TOUCH_MOVED:
                TouchCoord c = touch.get(id);
                if (x == c.x && y == c.y) {
                    state = TouchEvent.TOUCH_STILL;
                    break;
                }
                // fall through;
            case TouchEvent.TOUCH_PRESSED:
                touch.put(id, new TouchCoord(x, y, xAbs, yAbs));
                break;
            case TouchEvent.TOUCH_STILL:
                break;
            default:
                System.err.println("Unknown touch state: " + state);
                break;
        }
        return state;
    }
}
