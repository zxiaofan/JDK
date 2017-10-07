/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk;

import java.util.List;

import com.sun.javafx.menu.MenuBase;


/**
 * We use this interface to access the Glass native system menu
 */
public interface TKSystemMenu {

    /**
     * Check whether top level global system menubar support is
     * available on this OS.  Currently supported on Mac OSX only.
     *
     * @return  whether top-level global system menus are supported
     */
    public boolean isSupported();

    public void setMenus(List<MenuBase> menus);

}
