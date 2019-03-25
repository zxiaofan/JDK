/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.swing.interop;

import java.awt.Cursor;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import java.util.Map;
import sun.awt.dnd.SunDragSourceContextPeer;

/**
 * This class provides a wrapper over inner DragSourceContextPeerProxy class
 * which extends jdk internal sun.awt.dnd.SunDragSourceContextPeer class
 * and provides APIs to be used by FX swing interop to access and use
 * DragSourceContextPeer APIs.
 *
 * @since 11
 */
public abstract class DragSourceContextWrapper {
    private DragSourceContextPeerProxy dsp;

    public DragSourceContextWrapper(DragGestureEvent e) {
        dsp = new DragSourceContextPeerProxy(e);
    }

    DragSourceContextPeer getPeer() {
        return dsp;
    }

    public static int convertModifiersToDropAction(int modifiers,
                                                   int supportedActions) {
        return DragSourceContextPeerProxy.
            convertModifiersToDropAction(modifiers, supportedActions);
    }

    protected abstract void setNativeCursor(Cursor c, int cType);

    protected abstract void startDrag(Transferable trans, long[] formats,
                                      Map<Long, DataFlavor> formatMap);

    public abstract void startSecondaryEventLoop();

    public abstract void quitSecondaryEventLoop();

    public void dragDropFinished(final boolean success,
                                 final int operations,
                                 final int x, final int y) {
        dsp.dragDropFinishedCall(success, operations, x, y);
    }

    public DragSourceContext getDragSourceContext() {
        return dsp.getDragSourceContextCall();
    }

    private class DragSourceContextPeerProxy extends SunDragSourceContextPeer {

        public DragSourceContextPeerProxy(DragGestureEvent e) {
            super(e);
        }

        protected void startDrag(Transferable trans, long[] formats,
                                 Map<Long, DataFlavor> formatMap) {
            DragSourceContextWrapper.this.startDrag(trans, formats, formatMap);
        }

        protected void setNativeCursor(long nativeCtxt, Cursor c, int cType) {
            DragSourceContextWrapper.this.setNativeCursor(c, cType);
        }

        public void startSecondaryEventLoop() {
            DragSourceContextWrapper.this.startSecondaryEventLoop();
        }

        public void quitSecondaryEventLoop() {
            DragSourceContextWrapper.this.quitSecondaryEventLoop();
        }

        protected void dragDropFinishedCall(final boolean success,
                                 final int operations,
                                 final int x, final int y) {
            dragDropFinished(success, operations, x, y);
        }

        protected DragSourceContext getDragSourceContextCall() {
            return getDragSourceContext();
        }
    }
}
