/*
 * Copyright (c) 1996, 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.peer.CanvasPeer;

import sun.awt.PaintEventDispatcher;
import sun.awt.SunToolkit;

class WCanvasPeer extends WComponentPeer implements CanvasPeer {

    private boolean eraseBackground;

    // Toolkit & peer internals

    WCanvasPeer(Component target) {
        super(target);
    }

    @Override
    native void create(WComponentPeer parent);

    @Override
    void initialize() {
        eraseBackground = !SunToolkit.getSunAwtNoerasebackground();
        boolean eraseBackgroundOnResize = SunToolkit.getSunAwtErasebackgroundonresize();
        // Optimization: the default value in the native code is true, so we
        // call setNativeBackgroundErase only when the value changes to false
        if (!PaintEventDispatcher.getPaintEventDispatcher().
                shouldDoNativeBackgroundErase((Component)target)) {
            eraseBackground = false;
        }
        setNativeBackgroundErase(eraseBackground, eraseBackgroundOnResize);
        super.initialize();
        Color bg = ((Component)target).getBackground();
        if (bg != null) {
            setBackground(bg);
        }
    }

    @Override
    public void paint(Graphics g) {
        Dimension d = ((Component)target).getSize();
        if (g instanceof Graphics2D) {
            // background color is setup correctly, so just use clearRect
            g.clearRect(0, 0, d.width, d.height);
        } else {
            // emulate clearRect
            g.setColor(((Component)target).getBackground());
            g.fillRect(0, 0, d.width, d.height);
            g.setColor(((Component)target).getForeground());
        }
        super.paint(g);
    }

    @Override
    public boolean shouldClearRectBeforePaint() {
        return eraseBackground;
    }

    /*
     * Disables background erasing for this canvas, both for resizing
     * and not-resizing repaints.
     */
    void disableBackgroundErase() {
        eraseBackground = false;
        setNativeBackgroundErase(false, false);
    }

    /*
     * Sets background erasing flags at the native level. If {@code
     * doErase} is set to {@code true}, canvas background is erased on
     * every repaint. If {@code doErase} is {@code false} and {@code
     * doEraseOnResize} is {@code true}, then background is only erased
     * on resizing repaints. If both {@code doErase} and {@code
     * doEraseOnResize} are false, then background is never erased.
     */
    private native void setNativeBackgroundErase(boolean doErase,
                                                 boolean doEraseOnResize);

    @Override
    public GraphicsConfiguration getAppropriateGraphicsConfiguration(
            GraphicsConfiguration gc)
    {
        return gc;
    }
}
