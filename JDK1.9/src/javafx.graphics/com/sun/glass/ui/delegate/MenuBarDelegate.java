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

public interface MenuBarDelegate {
    // all methods report success status (true - success, false - failure)
    public boolean createMenuBar();
    public boolean insert(MenuDelegate menu, int pos);
    // removes a submenu at {@code pos} which delegate is {@code menu} parameter
    public boolean remove(MenuDelegate menu, int pos);
    public long getNativeMenu();
}
