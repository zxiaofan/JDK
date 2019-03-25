/*
 * Copyright (c) 2003, 2015, Oracle and/or its affiliates. All rights reserved.
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


package sun.awt.X11;

import java.awt.Component;
import java.awt.Graphics;

import sun.awt.AWTAccessor;
import sun.awt.RepaintArea;

/**
 * The {@code RepaintArea} is a geometric construct created for the
 * purpose of holding the geometry of several coalesced paint events.
 * This geometry is accessed synchronously, although it is written such
 * that painting may still be executed asynchronously.
 *
 * @author      Eric Hawkes
 */
final class XRepaintArea extends RepaintArea {

    /**
     * Calls {@code Component.update(Graphics)} with given Graphics.
     */
    protected void updateComponent(Component comp, Graphics g) {
        if (comp != null) {
            // We don't call peer.paintPeer() here, because we shouldn't paint
            // native component when processing UPDATE events.
            super.updateComponent(comp, g);
        }
    }

    /**
     * Calls {@code Component.paint(Graphics)} with given Graphics.
     */
    protected void paintComponent(Component comp, Graphics g) {
        if (comp != null) {
            final XComponentPeer peer = AWTAccessor.getComponentAccessor()
                                                   .getPeer(comp);
            if (peer != null) {
                peer.paintPeer(g);
            }
            super.paintComponent(comp, g);
        }
    }
}
