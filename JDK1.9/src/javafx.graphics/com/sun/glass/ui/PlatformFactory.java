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
package com.sun.glass.ui;

import java.util.Locale;

import com.sun.glass.ui.delegate.ClipboardDelegate;
import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;

public abstract class PlatformFactory {
    private static PlatformFactory instance;
    public static synchronized PlatformFactory getPlatformFactory() {
        if (instance == null) {
            try {
                String platform = Platform.determinePlatform();
                String factory = "com.sun.glass.ui." +  platform.toLowerCase(Locale.ROOT) + "."+ platform + "PlatformFactory";
                // System.out.println("Loading Glass Factory " + factory);
                Class c = Class.forName(factory);
                instance = (PlatformFactory) c.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to load Glass factory class");
            }
        }
        return instance;
    }

    public abstract Application createApplication();
    public abstract MenuBarDelegate createMenuBarDelegate(MenuBar menubar);
    public abstract MenuDelegate createMenuDelegate(Menu menu);
    public abstract MenuItemDelegate createMenuItemDelegate(MenuItem menuItem);
    public abstract ClipboardDelegate createClipboardDelegate();
}
