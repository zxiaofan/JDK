/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.java.swing.plaf.gtk;

/**
 * @version %I%, %G%
 * @author Scott Violet
 */
public interface GTKConstants {

    /**
     * Used to indicate a constant is not defined.
     */
    public static final int UNDEFINED = -100;

    /**
     * Java representation of native GtkIconSize enum
     */
    public enum IconSize {
        INVALID,
        MENU,
        SMALL_TOOLBAR,
        LARGE_TOOLBAR,
        BUTTON,
        DND,
        DIALOG
    }

    /**
     * Java representation of native GtkTextDirection enum
     */
    public enum TextDirection {
        NONE,
        LTR,
        RTL
    }

    /**
     * Java representation of native GtkShadowType enum
     */
    public enum ShadowType {
        NONE,
        IN,
        OUT,
        ETCHED_IN,
        ETCHED_OUT
    }

    /**
     * Java representation of native GtkStateType enum
     */
    public enum StateType {
        NORMAL,
        ACTIVE,
        PRELIGHT,
        SELECTED,
        INSENSITIVE
    }

    /**
     * Java representation of native GtkExpanderStyle enum
     */
    public enum ExpanderStyle {
        COLLAPSED,
        SEMI_COLLAPSED,
        SEMI_EXPANDED,
        EXPANDED,
    }

    /**
     * Java representation of native GtkPositionType enum
     */
    public enum PositionType {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    /**
     * Java representation of native GtkArrowType enum
     */
    public enum ArrowType {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**
     * Java representation of native GtkOrientation enum
     */
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }
    
    /** This enum mirrors that in gtk2_interface.h 
     *  We place it here - for common access, because some common parts of GTK L&F
     *  need access to the enumeration.
     */
    public enum WidgetType {
        BUTTON, CHECK_BOX, CHECK_BOX_MENU_ITEM, COLOR_CHOOSER, 
        COMBO_BOX, COMBO_BOX_ARROW_BUTTON, COMBO_BOX_TEXT_FIELD, 
        DESKTOP_ICON, DESKTOP_PANE, EDITOR_PANE, FORMATTED_TEXT_FIELD,
        HANDLE_BOX, 
        HSCROLL_BAR, HSCROLL_BAR_BUTTON_LEFT, HSCROLL_BAR_BUTTON_RIGHT, 
        HSCROLL_BAR_TRACK, HSCROLL_BAR_THUMB,
        HSEPARATOR, HSLIDER, HSLIDER_TRACK, HSLIDER_THUMB, HSPLIT_PANE_DIVIDER,
        INTERNAL_FRAME, INTERNAL_FRAME_TITLE_PANE, IMAGE, LABEL, LIST, MENU,
        MENU_BAR, MENU_ITEM, MENU_ITEM_ACCELERATOR, OPTION_PANE, PANEL,
        PASSWORD_FIELD, POPUP_MENU, POPUP_MENU_SEPARATOR, PROGRESS_BAR,
        RADIO_BUTTON, RADIO_BUTTON_MENU_ITEM, ROOT_PANE, SCROLL_PANE, 
        SPINNER, SPINNER_ARROW_BUTTON, SPINNER_TEXT_FIELD,
        SPLIT_PANE, TABBED_PANE, TABBED_PANE_TAB_AREA, TABBED_PANE_CONTENT,
        TABBED_PANE_TAB, TABLE, TABLE_HEADER, TEXT_AREA, TEXT_FIELD, TEXT_PANE,
        TOGGLE_BUTTON, TOOL_BAR, TOOL_BAR_DRAG_WINDOW, TOOL_BAR_SEPARATOR,
        TOOL_TIP, TREE, TREE_CELL, VIEWPORT, 
        VSCROLL_BAR, VSCROLL_BAR_BUTTON_UP, VSCROLL_BAR_BUTTON_DOWN, 
        VSCROLL_BAR_TRACK, VSCROLL_BAR_THUMB, 
        VSEPARATOR, VSLIDER, VSLIDER_TRACK, VSLIDER_THUMB,
        VSPLIT_PANE_DIVIDER
    }
}
