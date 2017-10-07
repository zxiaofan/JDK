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

/**
 * This TouchFilter stabilizes touch points, eliminating moves below a certain
 * threshold.
 */
final class SmallMoveTouchFilter implements TouchFilter {

    private final TouchState oldState = new TouchState();
    private final int radius = TouchInput.getInstance()
            .getTouchRadius();

    SmallMoveTouchFilter() {
        TouchInput.getInstance().getState(oldState);
    }

    @Override
    public int getPriority() {
        return PRIORITY_POST_ID;
    }

    @Override
    public boolean filter(TouchState state) {
        for (int i = 0; i < oldState.getPointCount(); i++) {
            TouchState.Point oldPoint = oldState.getPoint(i);
            TouchState.Point newPoint = state.getPointForID(oldPoint.id);
            if (newPoint != null) {
                int dx = newPoint.x - oldPoint.x;
                int dy = newPoint.y - oldPoint.y;
                int dist2 = dx * dx + dy * dy;
                if (dist2 < radius * radius) {
                    // if this is a move, rewrite it as a stationary event
                    newPoint.x = oldPoint.x;
                    newPoint.y = oldPoint.y;
                }
            }
        }
        state.copyTo(oldState);
        return false;
    }

    @Override
    public boolean flush(TouchState state) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SmallMoveTouchFilter;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "SmallMove";
    }

}
