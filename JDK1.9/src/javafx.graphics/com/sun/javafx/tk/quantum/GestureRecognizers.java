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

package com.sun.javafx.tk.quantum;

import java.util.Vector;
import java.util.Collection;

class GestureRecognizers implements GestureRecognizer {

    private Collection<GestureRecognizer> recognizers = new Vector<GestureRecognizer>();
    private GestureRecognizer workList[];

    void add(GestureRecognizer r) {
        if (!contains(r)) {
            recognizers.add(r);
            workList = null;
        }
    }

    void remove(GestureRecognizer r) {
        if (contains(r)) {
            recognizers.remove(r);
            workList = null;
        }
    }

    boolean contains(GestureRecognizer r) {
        return recognizers.contains(r);
    }

    private GestureRecognizer[] synchWorkList() {
        if (workList == null) {
            workList = recognizers.toArray(new GestureRecognizer[0]);
        }
        return workList;
    }

    public void notifyBeginTouchEvent(long time, int modifiers, boolean isDirect, int touchEventCount) {
        final GestureRecognizer[] wl = synchWorkList();
        for (int idx = 0; idx != wl.length; ++idx) {
            wl[idx].notifyBeginTouchEvent(time, modifiers, isDirect, touchEventCount);
        }
    }

    public void notifyNextTouchEvent(long time, int type, long touchId,
                                     int x, int y, int xAbs, int yAbs)
    {
        final GestureRecognizer[] wl = synchWorkList();
        for (int idx = 0; idx != wl.length; ++idx) {
            wl[idx].notifyNextTouchEvent(time, type, touchId, x, y, xAbs, yAbs);
        }
    }

    public void notifyEndTouchEvent(long time) {
        final GestureRecognizer[] wl = synchWorkList();
        for (int idx = 0; idx != wl.length; ++idx) {
            wl[idx].notifyEndTouchEvent(time);
        }
    }
}
