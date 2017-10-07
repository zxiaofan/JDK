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

package com.sun.glass.ui.lens;

import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;

final class LensMenuBarDelegate implements MenuBarDelegate {

    public boolean createMenuBar() {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean insert(MenuDelegate menu, int pos) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public boolean remove(MenuDelegate menu, int pos) {
        LensLogger.getLogger().severe("Not implemented");
        return true;
    }

    public long getNativeMenu() {
        LensLogger.getLogger().severe("Not implemented");
        return 0;
    }

}
