/*
 * Copyright (c) 1999, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.print.PrinterJob;

import sun.awt.AWTAccessor;

@SuppressWarnings("serial") // JDK-implementation class
class WPrintDialog extends Dialog {
    static {
        initIDs();
    }

    protected PrintJob job;
    protected PrinterJob pjob;

    WPrintDialog(Frame parent, PrinterJob control) {
        super(parent, true);
        this.pjob = control;
        setLayout(null);
    }

    WPrintDialog(Dialog parent, PrinterJob control) {
        super(parent, "", true);
        this.pjob = control;
        setLayout(null);
    }

    final void setPeer(final ComponentPeer p){
        AWTAccessor.getComponentAccessor().setPeer(this, p);
    }

    @Override
    public void addNotify() {
        synchronized(getTreeLock()) {
            Container parent = getParent();
            if (parent != null && !parent.isDisplayable()) {
                parent.addNotify();
            }

            if (!isDisplayable()) {
                ComponentPeer peer = ((WToolkit)Toolkit.getDefaultToolkit()).
                    createWPrintDialog(this);
                setPeer(peer);
            }
            super.addNotify();
        }
    }

    private boolean retval = false;

    final void setRetVal(boolean ret) {
        retval = ret;
    }

    final boolean getRetVal() {
        return retval;
    }

    /**
     * Initialize JNI field and method ids
     */
    private static native void initIDs();
}
