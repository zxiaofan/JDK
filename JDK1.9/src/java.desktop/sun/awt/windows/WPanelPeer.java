/*
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
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
            c = WColor.getDefaultColor(WColor.WINDOW_BKGND);
            ((Component)target).setBackground(c);
            setBackground(c);
        }
        c = ((Component)target).getForeground();
        if (c == null) {
            c = WColor.getDefaultColor(WColor.WINDOW_TEXT);
            ((Component)target).setForeground(c);
            setForeground(c);
        }
    }

    /**
     * DEPRECATED:  Replaced by getInsets().
     */
    public Insets insets() {
        return getInsets();
    }
}
