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

import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;

class GtkMenuDelegate implements MenuDelegate {

    public GtkMenuDelegate() {
    }

    public boolean createMenu(String title, boolean enabled) {
        return true;
    }

    public boolean setTitle(String title) {
        return true;
    }

    public boolean setEnabled(boolean enabled) {
        return true;
    }

   public boolean setPixels(Pixels pixels) {
        return false;
    }

    public boolean insert(MenuDelegate menu, int pos) {
        return true;
    }

    public boolean insert(MenuItemDelegate item, int pos) {
        return true;
    }

    public boolean remove(MenuDelegate menu, int pos) {
        return true;
    }

    public boolean remove(MenuItemDelegate item, int pos) {
        return true;
    }

}
