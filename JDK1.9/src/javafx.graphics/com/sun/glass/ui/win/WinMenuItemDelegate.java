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

import com.sun.glass.events.KeyEvent;
import com.sun.glass.ui.MenuItem;
import com.sun.glass.ui.MenuItem.Callback;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.delegate.MenuItemDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class WinMenuItemDelegate implements MenuItemDelegate {
    final private MenuItem owner;

    private WinMenuImpl parent = null;

    private int cmdID = -1;

    public WinMenuItemDelegate(MenuItem item) {
        owner = item;
    }

    public MenuItem getOwner() {
        return owner;
    }

    @Override public boolean createMenuItem(String title, Callback callback,
            int shortcutKey, int shortcutModifiers, Pixels pixels,
            boolean enabled, boolean checked) {
        // nothing to to
        return true;
    }

    // all methods report success status (true - success, false - failure)

    @Override public boolean setTitle(String title) {
        if (parent != null) {
            title = getTitle(title, getOwner().getShortcutKey(),
                    getOwner().getShortcutModifiers());
            return parent.setItemTitle(this, title);
        }
        return true;
    }

    @Override public boolean setCallback(Callback callback) {
        // nothing to do
        return true;
    }

    @Override public boolean setShortcut(int shortcutKey, int shortcutModifiers) {
        if (parent != null) {
            String title = getTitle(getOwner().getTitle(),
                    shortcutKey, shortcutModifiers);
            return parent.setItemTitle(this, title);
        }
        return true;
    }

    @Override public boolean setPixels(Pixels pixels) {
        // TODO: implement images in menuItem
        return false;
    }

    @Override public boolean setEnabled(boolean enabled) {
        if (parent != null) {
            return parent.enableItem(this, enabled);
        }
        return true;
    }

    @Override public boolean setChecked(boolean checked) {
        if (parent != null) {
            return parent.checkItem(this, checked);
        }
        return true;
    }


    /**
     * Obtains title for the specified title & shortcut
     */
    private String getTitle(String title, int key, int modifiers) {
        if (key == KeyEvent.VK_UNDEFINED) {
            return title;
        }
        return title;
    }

    WinMenuImpl getParent() {
        return parent;
    }

    void setParent(WinMenuImpl newParent) {
        // we always switch parent through null (i.e. oldParent => null => newParent)
        if (parent != null) {
            CommandIDManager.freeID(cmdID);
            cmdID = -1;
        }
        if (newParent != null) {
            cmdID = CommandIDManager.getID(this);
        }
        parent = newParent;
    }

    int getCmdID() {
        return cmdID;
    }


    static class CommandIDManager {
        final private static int FIRST_ID = 1;
        final private static int LAST_ID = 0xFFFF;
        private static List<Integer> freeList = new ArrayList<Integer>();

        final private static Map<Integer, WinMenuItemDelegate> map =
                new HashMap<Integer, WinMenuItemDelegate>();
        private static int nextID = FIRST_ID;

        public static synchronized int getID(WinMenuItemDelegate menu) {
            Integer id;
            if (freeList.isEmpty()) {
                if (nextID > LAST_ID) {
                    // TODO: handle
                    nextID = FIRST_ID;
                }
                id = nextID;
                nextID++;
            } else {
                // get & remove last item in the list (it's faster for ArrayList)
                id = freeList.remove(freeList.size() - 1);
            }
            map.put(id, menu);
            return id;
        }

        public static synchronized void freeID(int cmdID) {
            Integer id = Integer.valueOf(cmdID);
            if (map.remove(id) != null) {
                freeList.add(id);
            }
        }

        public static WinMenuItemDelegate getHandler(int cmdID) {
            return map.get(Integer.valueOf(cmdID));
        }
    }
}
