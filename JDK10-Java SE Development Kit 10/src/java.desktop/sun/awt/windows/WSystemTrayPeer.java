/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.SystemTray;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.peer.SystemTrayPeer;

final class WSystemTrayPeer extends WObjectPeer implements SystemTrayPeer {
    WSystemTrayPeer(SystemTray target) {
        this.target = target;
    }

    @Override
    public Dimension getTrayIconSize() {
        return new Dimension(WTrayIconPeer.TRAY_ICON_WIDTH, WTrayIconPeer.TRAY_ICON_HEIGHT);
    }

    public boolean isSupported() {
        return ((WToolkit)Toolkit.getDefaultToolkit()).isTraySupported();
    }

    @Override
    protected void disposeImpl() {
    }
}
