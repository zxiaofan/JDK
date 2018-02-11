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
package com.sun.glass.ui.mac;

import com.sun.glass.events.TouchEvent;
import com.sun.glass.ui.TouchInputSupport;
import com.sun.glass.ui.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MacTouchInputSupport extends TouchInputSupport
{
    private final Map<Long, WeakReference<View>> touchIdToView =
            new HashMap<Long, WeakReference<View>>();

    private int curModifiers;
    private boolean curIsDirect;
    private List<TouchPoint> curTouchPoints;

    static private class TouchPoint
    {
        final int state;
        final long id;
        final int x;
        final int y;
        final int xAbs;
        final int yAbs;

        TouchPoint(int state, long id, int x, int y, int xAbs,
                   int yAbs) {
            this.state = state;
            this.id = id;
            this.x = x;
            this.y = y;
            this.xAbs = xAbs;
            this.yAbs = yAbs;
        }
    };

    MacTouchInputSupport(TouchCountListener listener,
                         boolean filterTouchCoordinates) {
        super(listener, filterTouchCoordinates);
    }

    @Override
    public void notifyBeginTouchEvent(View view, int modifiers, boolean isDirect,
                                      int touchEventCount) {
        curModifiers = modifiers;
        curIsDirect = isDirect;
        curTouchPoints = new ArrayList<TouchPoint>(touchEventCount);
    }

    @Override
    public void notifyEndTouchEvent(View view) {
        if (curTouchPoints.isEmpty()) {
            return;
        }

        try {
            super.notifyBeginTouchEvent(view, curModifiers, curIsDirect,
                                        curTouchPoints.size());

            for (TouchPoint tp: curTouchPoints) {
                super.notifyNextTouchEvent(view, tp.state, tp.id, tp.x, tp.y,
                                           tp.xAbs, tp.yAbs);
            }

            super.notifyEndTouchEvent(view);

        } finally {
            curTouchPoints = null;
        }
    }

    @Override
    public void notifyNextTouchEvent(View view, int state, long id, int x, int y,
                                     int xAbs, int yAbs) {

        View storedView = null;
        if (state == TouchEvent.TOUCH_PRESSED) {
            storedView = view;
            touchIdToView.put(id, new WeakReference<View>(view));
        } else {
            storedView = touchIdToView.get(id).get();
            if (state == TouchEvent.TOUCH_RELEASED) {
                touchIdToView.remove(id);
            }
        }

        //
        // Forward touch point event to the view from which it originates.
        //

        if (storedView == view) {
            curTouchPoints.add(new TouchPoint(state, id, x, y, xAbs, yAbs));
        } else {
            if (storedView != null && storedView.isClosed()) {
                // Make sure Scenegraph never receives touch events
                // for disposed views.
                storedView = null;
            }

            super.notifyBeginTouchEvent(storedView, curModifiers,
                                        curIsDirect, 1);
            super.notifyNextTouchEvent(storedView, state, id, x, y, xAbs,
                                       yAbs);
            super.notifyEndTouchEvent(storedView);
        }
    }
}
