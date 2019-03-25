/*
 * Copyright (c) 2003, 2007, Oracle and/or its affiliates. All rights reserved.
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

// This class serves as the base class for all the wrappers.
import sun.util.logging.PlatformLogger;

abstract class XWrapperBase {
    static final PlatformLogger log = PlatformLogger.getLogger("sun.awt.X11.wrappers");

    public String toString() {
        String ret = "";

        ret += getName() + " = " + getFieldsAsString();

        return ret;
    }

    String getFieldsAsString() {
        return "";
    }

    String getName() {
        return "XWrapperBase";
    }
    public void zero() {
        log.finest("Cleaning memory");
        if (getPData() != 0) {
            XlibWrapper.unsafe.setMemory(getPData(), (long)getDataSize(), (byte)0);
        }
    }
    public abstract int getDataSize();
    String getWindow(long window) {
        XBaseWindow w = XToolkit.windowToXWindow(window);
        if (w == null) {
            return Long.toHexString(window);
        } else {
            return w.toString();
        }
    }
    public abstract long getPData();
    public XEvent clone() {
        long copy = XlibWrapper.unsafe.allocateMemory(getDataSize());
        XlibWrapper.unsafe.copyMemory(getPData(), copy, getDataSize());
        return new XEvent(copy);
    }
}
