/*
 * Copyright (c) 2003, 2014, Oracle and/or its affiliates. All rights reserved.
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

/**
 * This class represents AWT application root window functionality.
 * Object of this class is singleton, all window reference it to have
 * common logical ancestor
 */
class XRootWindow extends XBaseWindow {
    private static class LazyHolder {
        private static final XRootWindow xawtRootWindow;

        static {
            XToolkit.awtLock();
            try {
                xawtRootWindow = new XRootWindow();
                xawtRootWindow.init(xawtRootWindow.getDelayedParams().delete(DELAYED));
            } finally {
                XToolkit.awtUnlock();
            }
        }

    }
    static XRootWindow getInstance() {
        return LazyHolder.xawtRootWindow;
    }

    private XRootWindow() {
        super(new XCreateWindowParams(new Object[] { DELAYED, Boolean.TRUE,
                                                     EVENT_MASK, XConstants.StructureNotifyMask }));
    }

    public void postInit(XCreateWindowParams params){
        super.postInit(params);
        setWMClass(getWMClass());
    }

    protected String getWMName() {
        return XToolkit.getAWTAppClassName();
    }
    protected String[] getWMClass() {
        return new String[] {XToolkit.getAWTAppClassName(), XToolkit.getAWTAppClassName()};
    }

  /* Fix 4976517.  Return awt_root_shell to XToolkit.c */
    private static long getXRootWindow() {
        return getXAWTRootWindow().getWindow();
    }
}
