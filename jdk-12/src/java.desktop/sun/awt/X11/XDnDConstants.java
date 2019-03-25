/*
 * Copyright (c) 2003, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.X11;

import java.awt.dnd.DnDConstants;

/**
 * XDnD protocol global constants.
 *
 * @since 1.5
 */
class XDnDConstants {
    static final XAtom XA_XdndActionCopy = XAtom.get("XdndActionCopy");
    static final XAtom XA_XdndActionMove = XAtom.get("XdndActionMove");
    static final XAtom XA_XdndActionLink = XAtom.get("XdndActionLink");
    static final XAtom XA_XdndActionList = XAtom.get("XdndActionList");
    static final XAtom XA_XdndTypeList   = XAtom.get("XdndTypeList");
    static final XAtom XA_XdndAware      = XAtom.get("XdndAware");
    static final XAtom XA_XdndProxy      = XAtom.get("XdndProxy");
    static final XAtom XA_XdndSelection  = XAtom.get("XdndSelection");
    static final XAtom XA_XdndEnter      = XAtom.get("XdndEnter");
    static final XAtom XA_XdndPosition   = XAtom.get("XdndPosition");
    static final XAtom XA_XdndLeave      = XAtom.get("XdndLeave");
    static final XAtom XA_XdndDrop       = XAtom.get("XdndDrop");
    static final XAtom XA_XdndStatus     = XAtom.get("XdndStatus");
    static final XAtom XA_XdndFinished   = XAtom.get("XdndFinished");

    static final XSelection XDnDSelection = new XSelection(XA_XdndSelection);

    public static final int XDND_MIN_PROTOCOL_VERSION = 3;
    public static final int XDND_PROTOCOL_VERSION     = 5;

    public static final int XDND_PROTOCOL_MASK        = 0xFF000000;
    public static final int XDND_PROTOCOL_SHIFT       = 24;
    public static final int XDND_DATA_TYPES_BIT       = 0x1;
    public static final int XDND_ACCEPT_DROP_FLAG     = 0x1;

    private XDnDConstants() {}

    static long getXDnDActionForJavaAction(int javaAction) {
        switch (javaAction) {
        case DnDConstants.ACTION_COPY : return XA_XdndActionCopy.getAtom();
        case DnDConstants.ACTION_MOVE : return XA_XdndActionMove.getAtom();
        case DnDConstants.ACTION_LINK : return XA_XdndActionLink.getAtom();
        default                       : return 0;
        }
    }

    static int getJavaActionForXDnDAction(long xdndAction) {
        if (xdndAction == XA_XdndActionCopy.getAtom()) {
            return DnDConstants.ACTION_COPY;
        } else if (xdndAction == XA_XdndActionMove.getAtom()) {
            return DnDConstants.ACTION_MOVE;
        } else if (xdndAction == XA_XdndActionLink.getAtom()) {
            return DnDConstants.ACTION_LINK;
        } else {
            return DnDConstants.ACTION_NONE;
        }
    }
}
