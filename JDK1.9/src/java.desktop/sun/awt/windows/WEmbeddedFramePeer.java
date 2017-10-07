/*
 * Copyright (c) 1996, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Rectangle;

import sun.awt.EmbeddedFrame;
import sun.awt.Win32GraphicsEnvironment;

public class WEmbeddedFramePeer extends WFramePeer {

    public WEmbeddedFramePeer(EmbeddedFrame target) {
        super(target);
    }

    @Override
    native void create(WComponentPeer parent);

    // suppress printing of an embedded frame.
    @Override
    public void print(Graphics g) {}

    // supress calling native setMinSize()
    @Override
    public void updateMinimumSize() {}

    @Override
    public void modalDisable(Dialog blocker, long blockerHWnd)
    {
        super.modalDisable(blocker, blockerHWnd);
        ((EmbeddedFrame)target).notifyModalBlocked(blocker, true);
    }
    @Override
    public void modalEnable(Dialog blocker)
    {
        super.modalEnable(blocker);
        ((EmbeddedFrame)target).notifyModalBlocked(blocker, false);
    }

    @Override
    public void setBoundsPrivate(int x, int y, int width, int height) {
        setBounds(x, y, width, height, SET_BOUNDS | NO_EMBEDDED_CHECK);
    }

    @Override
    public native Rectangle getBoundsPrivate();

    @Override
    public boolean isAccelCapable() {
        // REMIND: Temp workaround for issues with using HW acceleration
        // in the browser on Vista when DWM is enabled
        // Note: isDWMCompositionEnabled is only relevant on Vista, returns
        // false on other systems.
        return !Win32GraphicsEnvironment.isDWMCompositionEnabled();
    }

}
