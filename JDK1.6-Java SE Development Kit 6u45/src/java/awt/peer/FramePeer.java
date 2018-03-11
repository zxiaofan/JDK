/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt.peer;

import java.awt.*;

/**
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface FramePeer extends WindowPeer {
    void setTitle(String title);
    void setMenuBar(MenuBar mb);
    void setResizable(boolean resizeable);
    void setState(int state);
    int  getState();
    void setMaximizedBounds(Rectangle bounds); // XXX
    void setBoundsPrivate(int x, int y, int width, int height);
    Rectangle getBoundsPrivate();
}
