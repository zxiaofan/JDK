/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.*;
import com.sun.glass.ui.delegate.ClipboardDelegate;
import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;

public final class MacPlatformFactory extends PlatformFactory {

    @Override public Application createApplication(){
        return new MacApplication();
    }

    @Override public MenuBarDelegate createMenuBarDelegate(MenuBar menubar) {
        return new MacMenuBarDelegate();
    }

    @Override public MenuDelegate createMenuDelegate(Menu menu) {
        return new MacMenuDelegate(menu);
    }

    @Override public MenuItemDelegate createMenuItemDelegate(MenuItem item) {
        return new MacMenuDelegate();
    }

    @Override public ClipboardDelegate createClipboardDelegate() {
        return new MacClipboardDelegate();
    }
}
