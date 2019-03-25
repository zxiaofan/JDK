/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Graphics;

public interface XAbstractMenuItem {
    int getWidth(Graphics g);
    int getShortcutWidth(Graphics g);
    String getLabel();
    int getHeight(Graphics g);
    void paint(Graphics g, int top, int bottom, int width, int shortcutOffset, boolean selected);
    void setMenuPeer(XMenuPeer parentMenu);
}
