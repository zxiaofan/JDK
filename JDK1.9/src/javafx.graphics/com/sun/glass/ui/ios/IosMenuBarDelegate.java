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

import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;


/**
 * MenuBarDelegate implementation stub for iOS.
 * Calling IosMenuBarDelegate's methods has no effect.
 */
final class IosMenuBarDelegate implements MenuBarDelegate {

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public boolean createMenuBar() {
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
    public boolean remove(MenuDelegate menu, int pos) {
        return true;
    }

    /**
     * @inheritDoc
     * Unsupported on iOS.
     */
    @Override
    public long getNativeMenu() {
        return 0;
    }
}
