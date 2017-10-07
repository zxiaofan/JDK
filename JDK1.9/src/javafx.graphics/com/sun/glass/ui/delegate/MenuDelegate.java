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
package com.sun.glass.ui.delegate;

import com.sun.glass.ui.Pixels;

public interface MenuDelegate {
    // all methods report success status (true - success, false - failure)
    public boolean createMenu(String title, boolean enabled);
    public boolean setTitle(String title);
    public boolean setEnabled(boolean enabled);
    public boolean setPixels(Pixels pixels);
    public boolean insert(MenuDelegate menu, int pos);
    // if item == null => insert Separator
    public boolean insert(MenuItemDelegate item, int pos);
    // removes a submenu at {@code pos} which delegate is {@code menu} parameter
    public boolean remove(MenuDelegate menu, int pos);
    // removes an item at {@code pos} which delegate is {@code item} parameter
    public boolean remove(MenuItemDelegate item, int pos);
}
