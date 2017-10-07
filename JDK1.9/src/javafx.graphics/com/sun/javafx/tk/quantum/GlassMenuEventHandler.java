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

package com.sun.javafx.tk.quantum;

import com.sun.glass.ui.Menu;
import com.sun.javafx.menu.MenuBase;

class GlassMenuEventHandler extends Menu.EventHandler {

    private MenuBase menuBase;
    private boolean  menuOpen;

    public GlassMenuEventHandler(final MenuBase mb) {
        this.menuBase = mb;
    }

    @Override public void handleMenuOpening(Menu menu, long time) {
        menuBase.show();
        menuOpen = true;
    }

    @Override public void handleMenuClosed(Menu menu, long time) {
        menuBase.hide();
        menuOpen = false;
    }

    protected boolean isMenuOpen() {
        return menuOpen;
    }
}
