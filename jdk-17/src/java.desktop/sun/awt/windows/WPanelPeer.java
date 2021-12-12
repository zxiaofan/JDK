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
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.peer.PanelPeer;

import sun.awt.SunGraphicsCallback;

class WPanelPeer extends WCanvasPeer implements PanelPeer {

    // ComponentPeer overrides

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        SunGraphicsCallback.PaintHeavyweightComponentsCallback.getInstance().
            runComponents(((Container)target).getComponents(), g,
                          SunGraphicsCallback.LIGHTWEIGHTS |
                          SunGraphicsCallback.HEAVYWEIGHTS);
    }
    @Override
    public void print(Graphics g) {
        super.print(g);
        SunGraphicsCallback.PrintHeavyweightComponentsCallback.getInstance().
            runComponents(((Container)target).getComponents(), g,
                          SunGraphicsCallback.LIGHTWEIGHTS |
                          SunGraphicsCallback.HEAVYWEIGHTS);
    }

    // ContainerPeer (via PanelPeer) implementation

    @Override
    public Insets getInsets() {
        return insets_;
    }

    // Toolkit & peer internals

    Insets insets_;

    static {
        initIDs();
    }

    /**
     * Initialize JNI field IDs
     */
    private static native void initIDs();

    WPanelPeer(Component target) {
        super(target);
    }

    @Override
    void initialize() {
        super.initialize();
        insets_ = new Insets(0,0,0,0);

        Color c = ((Component)target).getBackground();
        if (c == null) {
            c = SystemColor.window;
            ((Component)target).setBackground(c);
            setBackground(c);
        }
        c = ((Component)target).getForeground();
        if (c == null) {
            c = SystemColor.windowText;
            ((Component)target).setForeground(c);
            setForeground(c);
        }
    }
}
