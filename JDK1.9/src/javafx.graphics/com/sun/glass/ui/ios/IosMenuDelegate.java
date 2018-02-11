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

package com.sun.glass.ui.ios;

import com.sun.glass.ui.MenuItem;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;

/**
 * MenuDelegate implementation stub for iOS.
 * Calling IosMenuDelegate's methods has no effect.
 */
final class IosMenuDelegate implements MenuDelegate, MenuItemDelegate {

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean createMenu(String title, boolean enabled) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean createMenuItem(String title, MenuItem.Callback callback, int shortcutKey, int shortcutModifiers, Pixels pixels, boolean enabled, boolean checked) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean setTitle(String title) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean setCallback(MenuItem.Callback callback) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean setShortcut(int shortcutKey, int shortcutModifiers) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean setPixels(Pixels pixels) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean setEnabled(boolean enabled) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean setChecked(boolean checked) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean insert(MenuDelegate menu, int pos) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean insert(MenuItemDelegate item, int pos) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean remove(MenuDelegate menu, int pos) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean remove(MenuItemDelegate item, int pos) {
        return true;
    }
}
