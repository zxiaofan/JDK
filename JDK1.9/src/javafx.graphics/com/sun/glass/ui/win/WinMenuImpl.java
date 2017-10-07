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
package com.sun.glass.ui.win;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.Menu;
import com.sun.glass.ui.MenuItem;
import com.sun.glass.ui.MenuItem.Callback;
import com.sun.glass.ui.Window;
import java.security.AccessController;
import java.security.PrivilegedAction;

/*
 * Base Windows menu implementation.
 * Used by WinMenuDelegate & WindowsMenubarDelegate.
 * This is package private class.
 */
class WinMenuImpl {

    private static native void _initIDs();
    static {
        _initIDs();
    }

    private long ptr = 0;   // HMENU

    WinMenuImpl() {
    }

    long getHMENU() {
        return ptr;
    }

    boolean create() {
        ptr = _create();
        return (ptr != 0);
    }

    void destroy() {
        if (ptr != 0) {
            _destroy(ptr);
            ptr = 0;
        }
    }

    boolean insertSubmenu(WinMenuDelegate menu, int pos) {
        menu.setParent(this);
        if (!_insertSubmenu(ptr, pos, menu.getHMENU(),
                menu.getOwner().getTitle(), menu.getOwner().isEnabled())) {
            menu.setParent(null);
            return false;
        }
        return true;
    }


    boolean insertItem(WinMenuItemDelegate item, int pos) {
        if (item == null) {
            return _insertSeparator(ptr, pos);
        }

        item.setParent(this);   // to get cmdID

        if (!_insertItem(ptr, pos, item.getCmdID(),
                    item.getOwner().getTitle(),
                    item.getOwner().isEnabled(),
                    item.getOwner().isChecked(),
                    item.getOwner().getCallback(),
                    item.getOwner().getShortcutKey(),
                    item.getOwner().getShortcutModifiers())) {
            item.setParent(null);
            return false;
        }
        return true;
    }

    boolean removeMenu(WinMenuDelegate submenu, int pos) {
        if (_removeAtPos(ptr, pos)) {
            submenu.setParent(null);
            return true;
        }
        return false;
    }

    boolean removeItem(WinMenuItemDelegate item, int pos) {
        if (_removeAtPos(ptr, pos)) {
            if (item != null) {  // null means it's a separator
                item.setParent(null);
            }
            return true;
        }
        return false;
    }

    boolean setSubmenuTitle(WinMenuDelegate submenu, String title) {
        return _setSubmenuTitle(ptr, submenu.getHMENU(), title);
    }

    boolean setItemTitle(WinMenuItemDelegate submenu, String title) {
        return _setItemTitle(ptr, submenu.getCmdID(), title);
    }

    boolean enableSubmenu(WinMenuDelegate submenu, boolean enable) {
        return _enableSubmenu(ptr, submenu.getHMENU(), enable);
    }

    boolean enableItem(WinMenuItemDelegate item, boolean enable) {
        return _enableItem(ptr, item.getCmdID(), enable);
    }

    public boolean checkItem(WinMenuItemDelegate item, boolean check) {
        return _checkItem(ptr, item.getCmdID(), check);
    }

    // callback for native
    private static boolean notifyCommand(Window window, int cmdID) {
        WinMenuItemDelegate item = WinMenuItemDelegate.CommandIDManager.getHandler(cmdID);
        if (item != null) {
            MenuItem.Callback callback = item.getOwner().getCallback();
            if (callback != null) {
                callback.action();
                return true;
            }
        }
        return false;
    }

    // *****************************************************
    // native methods
    // all methods return true on success, false on failure

    // menu methods
    private native long _create();
    private native void _destroy(long ptr);

    private native boolean _insertItem(long ptr, int pos, int cmdID,
            String title, boolean enabled, boolean checked,
            Callback callback, int shortcut, int modifiers);
    private native boolean _insertSubmenu(long ptr, int pos, long subPtr,
            String title, boolean enabled);
    private native boolean _insertSeparator(long ptr, int pos);

    private native boolean _removeAtPos(long ptr, int pos);

    // element methods
    private native boolean _setItemTitle(long ptr, int cmdID, String title);
    private native boolean _setSubmenuTitle(long ptr, long subPtr, String title);

    private native boolean _enableItem(long ptr, int cmdID, boolean enabled);
    private native boolean _enableSubmenu(long ptr, long subPtr, boolean enabled);

    private native boolean _checkItem(long ptr, int cmdID, boolean checked);
}
