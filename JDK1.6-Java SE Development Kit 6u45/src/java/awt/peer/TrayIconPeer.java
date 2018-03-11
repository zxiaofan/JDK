/*
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved. Use is
 * subject to license terms.
 */

package java.awt.peer;

import java.awt.TrayIcon;
import java.awt.Dimension;
import java.awt.Point;

public interface TrayIconPeer {
    void dispose();
    void setToolTip(String tooltip);
    void updateImage();
    void displayMessage(String caption, String text, String messageType);
    void showPopupMenu(int x, int y);
}
