/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.java.swing.plaf.windows;

import java.awt.Graphics;
import java.awt.Window;

import javax.swing.JWindow;

/**
 * A class which tags a window with a particular semantic usage,
 * either tooltip, menu, sub-menu, popup-menu, or comobobox-popup.
 * This is used as a temporary solution for getting native AWT support
 * for transition effects in Windows 98 and Windows 2000.  The native
 * code will interpret the windowType property and automatically
 * implement appropriate animation when the window is shown/hidden.
 * <p>
 * Note that support for transition effects may be supported with a
 * different mechanism in the future and so this class is
 * package-private and targeted for Swing implementation use only.
 *
 * @author Amy Fowler
 */
@SuppressWarnings("serial") // Superclass is not serializable across versions
class WindowsPopupWindow extends JWindow {

    static final int UNDEFINED_WINDOW_TYPE      = 0;
    static final int TOOLTIP_WINDOW_TYPE        = 1;
    static final int MENU_WINDOW_TYPE           = 2;
    static final int SUBMENU_WINDOW_TYPE        = 3;
    static final int POPUPMENU_WINDOW_TYPE      = 4;
    static final int COMBOBOX_POPUP_WINDOW_TYPE = 5;

    private int windowType;

    WindowsPopupWindow(Window parent) {
        super(parent);
        setFocusableWindowState(false);
    }

    void setWindowType(int type) {
        windowType = type;
    }

    int getWindowType() {
        return windowType;
    }

    public void update(Graphics g) {
        paint(g);
    }

    @SuppressWarnings("deprecation")
    public void hide() {
        super.hide();
        /** We need to call removeNotify() here because hide() does
         * something only if Component.visible is true. When the app
         * frame is miniaturized, the parent frame of this frame is
         * invisible, causing AWT to believe that this frame
         *  is invisible and causing hide() to do nothing
         */
        removeNotify();
    }

    @SuppressWarnings("deprecation")
    public void show() {
        super.show();
        this.pack();
    }
}
