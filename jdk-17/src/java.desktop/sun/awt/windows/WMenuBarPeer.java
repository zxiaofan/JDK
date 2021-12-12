/*
 * Copyright (c) 1996, 2016, Oracle and/or its affiliates. All rights reserved.
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
package sun.awt.windows;

import java.awt.*;
import java.awt.peer.*;

final class WMenuBarPeer extends WMenuPeer implements MenuBarPeer {

    // MenuBarPeer implementation

    final WFramePeer framePeer;

    @Override
    public native void addMenu(Menu m);
    @Override
    public native void delMenu(int index);

    @Override
    public void addHelpMenu(Menu m) {
        addMenu(m);
    }

    // Toolkit & peer internals
    WMenuBarPeer(MenuBar target) {
        this.target = target;
        framePeer = (WFramePeer)
            WToolkit.targetToPeer(target.getParent());
        if (framePeer != null) {
            framePeer.addChildPeer(this);
        }
        create(framePeer);
        // fix for 5088782: check if menu object is created successfully
        checkMenuCreation();
    }
    native void create(WFramePeer f);
}
