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
package com.sun.glass.ui;

import com.sun.glass.ui.delegate.MenuBarDelegate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MenuBar {

    final private MenuBarDelegate delegate;

    private final List<Menu> menus = new ArrayList<Menu>();

    protected MenuBar() {
        Application.checkEventThread();
        delegate = PlatformFactory.getPlatformFactory().createMenuBarDelegate(this);
        if (!delegate.createMenuBar()) {
            throw new RuntimeException("MenuBar creation error.");
        }
    }

    long getNativeMenu() {
        return delegate.getNativeMenu();
    }

    public void add(Menu menu) {
        Application.checkEventThread();
        insert(menu, menus.size());
    }

    public void insert(Menu menu, int pos) {
        Application.checkEventThread();
        synchronized (menus) {
            if (delegate.insert(menu.getDelegate(), pos)) {
                menus.add(pos, menu);
            }
        }
    }

    public void remove(int pos) {
        Application.checkEventThread();
        synchronized (menus) {
            Menu menu = menus.get(pos);
            if (delegate.remove(menu.getDelegate(), pos)) {
                menus.remove(pos);
            }
        }
    }

    public void remove(Menu menu) {
        Application.checkEventThread();
        synchronized (menus) {
            int pos = menus.indexOf(menu);
            if (pos >= 0) {
                if (delegate.remove(menu.getDelegate(), pos)) {
                    menus.remove(pos);
                }
            } else {
                // throw some exception?
            }
        }
    }

    public List<Menu> getMenus() {
        Application.checkEventThread();
        return Collections.unmodifiableList(menus);
    }
}
