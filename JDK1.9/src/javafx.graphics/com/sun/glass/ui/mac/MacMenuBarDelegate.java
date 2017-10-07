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
package com.sun.glass.ui.mac;

import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;

class MacMenuBarDelegate implements MenuBarDelegate {

    // NSMenu *
    long ptr;

    private native long _createMenuBar();
    @Override public boolean createMenuBar() {
        ptr = _createMenuBar();
        return ptr != 0;
    }

    private native void _insert(long menubarPtr, long menuPtr, int pos);
    @Override public boolean insert(MenuDelegate menu, int pos) {
        MacMenuDelegate macMenu = (MacMenuDelegate)menu;
        _insert(ptr, macMenu.ptr, pos);
        return true;
    }

    private native void _remove(long menubarPtr, long menuPtr, int pos);
    @Override public boolean remove(MenuDelegate menu, int pos) {
        MacMenuDelegate macMenu = (MacMenuDelegate)menu;
        _remove(ptr, macMenu.ptr, pos);
        return true;
    }

    @Override public long getNativeMenu() {
        return ptr;
    }
}
