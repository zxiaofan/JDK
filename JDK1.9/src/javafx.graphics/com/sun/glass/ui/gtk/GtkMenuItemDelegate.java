/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui.gtk;

import com.sun.glass.ui.MenuItem.Callback;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.delegate.MenuItemDelegate;

class GtkMenuItemDelegate implements MenuItemDelegate {

    public GtkMenuItemDelegate() {
    }

    public boolean createMenuItem(String title, Callback callback, int shortcutKey, int shortcutModifiers, Pixels pixels, boolean enabled, boolean checked) {
        return true;
    }

    public boolean setTitle(String title) {
        return true;
    }

    public boolean setCallback(Callback callback) {
        return true;
    }

    public boolean setShortcut(int shortcutKey, int shortcutModifiers) {
        return true;
    }

    public boolean setPixels(Pixels pixels) {
        return true;
    }

    public boolean setEnabled(boolean enabled) {
        return true;
    }

    public boolean setChecked(boolean checked) {
        return true;
    }

}
