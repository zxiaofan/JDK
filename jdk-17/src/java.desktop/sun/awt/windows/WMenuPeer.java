/*
 * Copyright (c) 1996, 2019, Oracle and/or its affiliates. All rights reserved.
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

class WMenuPeer extends WMenuItemPeer implements MenuPeer {

    // MenuPeer implementation
    @Override
    public void addItem(MenuItem item) {
    }
    @Override
    public native void delItem(int index);

    // Toolkit & peer internals

    WMenuPeer() {}   // used by subclasses.

    WMenuPeer(Menu target) {
        this.target = target;
        MenuContainer parent = target.getParent();

        if (parent instanceof MenuBar) {
            WMenuBarPeer mbPeer = (WMenuBarPeer) WToolkit.targetToPeer(parent);
            this.parent = mbPeer;
            mbPeer.addChildPeer(this);
            createMenu(mbPeer);
        }
        else if (parent instanceof Menu) {
            this.parent = (WMenuPeer) WToolkit.targetToPeer(parent);
            this.parent.addChildPeer(this);
            createSubMenu(this.parent);
        }
        else {
            throw new IllegalArgumentException("unknown menu container class");
        }
        // fix for 5088782: check if menu object is created successfully
        checkMenuCreation();
    }

    native void createMenu(WMenuBarPeer parent);
    native void createSubMenu(WMenuPeer parent);
}
