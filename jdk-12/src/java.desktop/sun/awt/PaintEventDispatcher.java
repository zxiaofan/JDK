/*
 * Copyright (c) 2005, 2011, Oracle and/or its affiliates. All rights reserved.
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
package sun.awt;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.PaintEvent;

/**
 * PaintEventDispatcher is responsible for dispatching PaintEvents.  There
 * can be only one PaintEventDispatcher active at a particular time.
 *
 */
public class PaintEventDispatcher {
    /**
     * Singleton dispatcher.
     */
    private static PaintEventDispatcher dispatcher;

    /**
     * Sets the current {@code PaintEventDispatcher}.
     *
     * @param dispatcher PaintEventDispatcher
     */
    public static void setPaintEventDispatcher(
                          PaintEventDispatcher dispatcher) {
        synchronized(PaintEventDispatcher.class) {
            PaintEventDispatcher.dispatcher = dispatcher;
        }
    }

    /**
     * Returns the currently active {@code PaintEventDispatcher}.  This
     * will never return null.
     *
     * @return PaintEventDispatcher
     */
    public static PaintEventDispatcher getPaintEventDispatcher() {
        synchronized(PaintEventDispatcher.class) {
            if (dispatcher == null) {
                dispatcher = new PaintEventDispatcher();
            }
            return dispatcher;
        }
    }

    /**
     * Creates and returns the {@code PaintEvent} that should be
     * dispatched for the specified component.  If this returns null
     * no {@code PaintEvent} is dispatched.
     * <p>
     * <b>WARNING:</b> This is invoked from the native thread, be careful
     * what methods you end up invoking here.
     */
    public PaintEvent createPaintEvent(Component target, int x, int y, int w,
                                       int h) {

        return new PaintEvent(target, PaintEvent.PAINT,
                              new Rectangle(x, y, w, h));
    }

    /**
     * Returns true if a native background erase should be done for
     * the specified Component.
     */
    public boolean shouldDoNativeBackgroundErase(Component c) {
        return true;
    }

    /**
     * This method is invoked from the toolkit thread when the surface
     * data of the component needs to be replaced. The method run() of
     * the Runnable argument performs surface data replacing, run()
     * should be invoked on the EDT of this component's AppContext.
     * Returns true if the Runnable has been enqueued to be invoked
     * on the EDT.
     * (Fix 6255371.)
     */
    public boolean queueSurfaceDataReplacing(Component c, Runnable r) {
        return false;
    }
}
