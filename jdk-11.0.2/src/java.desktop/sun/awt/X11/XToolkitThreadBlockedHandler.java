/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

import sun.awt.datatransfer.ToolkitThreadBlockedHandler;

final class XToolkitThreadBlockedHandler implements
                                 ToolkitThreadBlockedHandler {
    private static final ToolkitThreadBlockedHandler priveleged_lock;
    static {
        priveleged_lock = new XToolkitThreadBlockedHandler();
    }
    private static final XToolkit tk = (XToolkit)java.awt.Toolkit.getDefaultToolkit();

    private XToolkitThreadBlockedHandler() {}
    static ToolkitThreadBlockedHandler getToolkitThreadBlockedHandler() {
        return priveleged_lock;
    }
    public void lock() {
        XToolkit.awtLock();
    }
    public void unlock() {
        XToolkit.awtUnlock();
    }
    public void enter() {
        tk.run(XToolkit.SECONDARY_LOOP);
    }
    public void exit() {
        XlibWrapper.ExitSecondaryLoop();
    }
}
