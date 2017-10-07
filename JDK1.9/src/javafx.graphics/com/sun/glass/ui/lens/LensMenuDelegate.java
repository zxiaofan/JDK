/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.lens;

import com.sun.glass.ui.MenuItem.Callback;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;

final class LensMenuDelegate implements MenuDelegate, MenuItemDelegate {

    public boolean createMenu(String title, boolean enabled) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean setTitle(String title) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean setEnabled(boolean enabled) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean insert(MenuDelegate menu, int pos) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean insert(MenuItemDelegate item, int pos) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean remove(MenuDelegate menu, int pos) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean remove(MenuItemDelegate item, int pos) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean createMenuItem(String title, Callback callback, int shortcutKey, int shortcutModifiers, Pixels pixels, boolean enabled, boolean checked) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean setCallback(Callback callback) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean setShortcut(int shortcutKey, int shortcutModifiers) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean setPixels(Pixels pixels) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean setChecked(boolean checked) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

}
