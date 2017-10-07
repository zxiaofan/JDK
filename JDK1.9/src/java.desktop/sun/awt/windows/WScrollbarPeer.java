/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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
import java.awt.peer.*;
import java.awt.event.AdjustmentEvent;

final class WScrollbarPeer extends WComponentPeer implements ScrollbarPeer {

    // Returns width for vertial scrollbar as SM_CXHSCROLL,
    // height for horizontal scrollbar as SM_CYVSCROLL
    static native int getScrollbarSize(int orientation);

    // ComponentPeer overrides
    public Dimension getMinimumSize() {
        if (((Scrollbar)target).getOrientation() == Scrollbar.VERTICAL) {
            return new Dimension(getScrollbarSize(Scrollbar.VERTICAL), 50);
        }
        else {
            return new Dimension(50, getScrollbarSize(Scrollbar.HORIZONTAL));
        }
    }

    // ScrollbarPeer implementation

    public native void setValues(int value, int visible,
                                 int minimum, int maximum);
    public native void setLineIncrement(int l);
    public native void setPageIncrement(int l);


    // Toolkit & peer internals

    WScrollbarPeer(Scrollbar target) {
        super(target);
    }

    native void create(WComponentPeer parent);

    void initialize() {
        Scrollbar sb = (Scrollbar)target;
        setValues(sb.getValue(), sb.getVisibleAmount(),
                  sb.getMinimum(), sb.getMaximum());
        super.initialize();
    }


    // NOTE: Callback methods are called by privileged threads.
    //       DO NOT INVOKE CLIENT CODE ON THIS THREAD!

    private void postAdjustmentEvent(final int type, final int value,
                                     final boolean isAdjusting)
    {
        final Scrollbar sb = (Scrollbar)target;
        WToolkit.executeOnEventHandlerThread(sb, new Runnable() {
            public void run() {
                sb.setValueIsAdjusting(isAdjusting);
                sb.setValue(value);
                postEvent(new AdjustmentEvent(sb,
                                AdjustmentEvent.ADJUSTMENT_VALUE_CHANGED,
                                type, value, isAdjusting));
            }
        });
    }

    void lineUp(int value) {
        postAdjustmentEvent(AdjustmentEvent.UNIT_DECREMENT, value, false);
    }

    void lineDown(int value) {
        postAdjustmentEvent(AdjustmentEvent.UNIT_INCREMENT, value, false);
    }

    void pageUp(int value) {
        postAdjustmentEvent(AdjustmentEvent.BLOCK_DECREMENT, value, false);
    }

    void pageDown(int value) {
        postAdjustmentEvent(AdjustmentEvent.BLOCK_INCREMENT, value, false);
    }

    // SB_TOP/BOTTOM are mapped to tracking
    void warp(int value) {
        postAdjustmentEvent(AdjustmentEvent.TRACK, value, false);
    }

    private boolean dragInProgress = false;

    void drag(final int value) {
        if (!dragInProgress) {
            dragInProgress = true;
        }
        postAdjustmentEvent(AdjustmentEvent.TRACK, value, true);
    }

    void dragEnd(final int value) {
        final Scrollbar sb = (Scrollbar)target;

        if (!dragInProgress) {
            return;
        }

        dragInProgress = false;
        WToolkit.executeOnEventHandlerThread(sb, new Runnable() {
            public void run() {
                // NB: notification only, no sb.setValue()
                // last TRACK event will have done it already
                sb.setValueIsAdjusting(false);
                postEvent(new AdjustmentEvent(sb,
                                AdjustmentEvent.ADJUSTMENT_VALUE_CHANGED,
                                AdjustmentEvent.TRACK, value, false));
            }
        });
    }

    public boolean shouldClearRectBeforePaint() {
        return false;
    }
}
