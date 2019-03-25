/*
 * Copyright (c) 2002, 2013, Oracle and/or its affiliates. All rights reserved.
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
import sun.awt.IconInfo;

class XWindowAttributesData {
    static int NORMAL           = 0;
    static int ICONIC           = 1;
    static int MAXIMIZED        = 2;

    static int AWT_DECOR_NONE        = 0;
    static int AWT_DECOR_ALL         = 1;
    static int AWT_DECOR_BORDER      = 2;
    static int AWT_DECOR_RESIZEH     = 4;
    static int AWT_DECOR_TITLE       = 8;
    static int AWT_DECOR_MENU        = 0x10;
    static int AWT_DECOR_MINIMIZE    = 0x20;
    static int AWT_DECOR_MAXIMIZE    = 0x40;
    static int AWT_UNOBSCURED        = 0;   // X11 VisibilityUnobscured
    static int AWT_PARTIALLY_OBSCURED = 1;  // X11 VisibilityPartiallyObscured
    static int AWT_FULLY_OBSCURED    =  2;  // X11 VisibilityFullyObscured
    static int AWT_UNKNOWN_OBSCURITY = 3;

    boolean nativeDecor;
    boolean initialFocus;
    boolean isResizable;
    int initialState;
    boolean initialResizability;
    int visibilityState; // updated by native X11 event handling code.
    String title;
    java.util.List<IconInfo> icons;
    boolean iconsInherited;
    int decorations;            // for future expansion to be able to
                                // specify native decorations
    int functions; // MWM_FUNC_*

    XWindowAttributesData() {
        nativeDecor = false;
        initialFocus = false;
        isResizable = false;
        initialState = NORMAL;
        visibilityState = AWT_UNKNOWN_OBSCURITY;
        title = null;
        icons = null;
        iconsInherited = true;
        decorations = 0;
        functions = 0;
        initialResizability = true;
    }
}
