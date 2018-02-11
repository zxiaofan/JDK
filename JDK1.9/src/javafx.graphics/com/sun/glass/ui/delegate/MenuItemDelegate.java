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

import com.sun.glass.ui.MenuItem.Callback;
import com.sun.glass.ui.Pixels;

public interface MenuItemDelegate {
    // all methods report success status (true - success, false - failure)
    public boolean createMenuItem(String title, Callback callback,
            int shortcutKey, int shortcutModifiers, Pixels pixels,
            boolean enabled, boolean checked);

    public boolean setTitle(String title);
    public boolean setCallback(Callback callback);
    public boolean setShortcut(int shortcutKey, int shortcutModifiers);
    public boolean setPixels(Pixels pixels);
    public boolean setEnabled(boolean enabled);
    public boolean setChecked(boolean checked);
}
