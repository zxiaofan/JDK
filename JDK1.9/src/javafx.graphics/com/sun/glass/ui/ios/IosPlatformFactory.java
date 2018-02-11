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

package com.sun.glass.ui.ios;

import com.sun.glass.ui.*;
import com.sun.glass.ui.delegate.ClipboardDelegate;
import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;

@SuppressWarnings({"UnusedDeclaration"})
public final class IosPlatformFactory extends PlatformFactory {

    /**
     * @inheritDoc
     */
    @Override
    public Application createApplication(){
        return new IosApplication();
    }

    /**
     * @inheritDoc
     */
    @Override
    public MenuBarDelegate createMenuBarDelegate(final MenuBar menubar) {
        return new IosMenuBarDelegate();
    }

    /**
     * @inheritDoc
     */
    @Override
    public MenuDelegate createMenuDelegate(final Menu menu) {
        return new IosMenuDelegate();
    }

    /**
     * @inheritDoc
     */
    @Override
    public MenuItemDelegate createMenuItemDelegate(final MenuItem item) {
        return new IosMenuDelegate();
    }

    /**
     * @inheritDoc
     */
    @Override
    public ClipboardDelegate createClipboardDelegate() {
        return new IosClipboardDelegate();
    }
}
