/*
 * Copyright (c) 2002, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.peer.ComponentPeer;

import sun.awt.AWTAccessor;
import sun.awt.EmbeddedFrame;
import sun.util.logging.PlatformLogger;

@SuppressWarnings("serial") // JDK-implementation class
public class XEmbeddedFrame extends EmbeddedFrame {

    private static final PlatformLogger log =
            PlatformLogger.getLogger(XEmbeddedFrame.class.getName());

    long handle;
    public XEmbeddedFrame() {
    }

    // handle should be a valid X Window.
    public XEmbeddedFrame(long handle) {
        this(handle, false);
    }

    // Handle is the valid X window
    public XEmbeddedFrame(long handle, boolean supportsXEmbed, boolean isTrayIconWindow) {
        super(handle, supportsXEmbed);

        if (isTrayIconWindow) {
            XTrayIconPeer.suppressWarningString(this);
        }

        this.handle = handle;
        if (handle != 0) { // Has actual parent
            addNotify();
            if (!isTrayIconWindow) {
                show();
            }
        }
    }

    public void addNotify()
    {
        if (!isDisplayable()) {
            XToolkit toolkit = (XToolkit)Toolkit.getDefaultToolkit();
            setPeer(toolkit.createEmbeddedFrame(this));
        }
        super.addNotify();
    }

    public XEmbeddedFrame(long handle, boolean supportsXEmbed) {
        this(handle, supportsXEmbed, false);
    }

    /*
     * The method shouldn't be called in case of active XEmbed.
     */
    public boolean traverseIn(boolean direction) {
        XEmbeddedFramePeer peer = AWTAccessor.getComponentAccessor()
                                             .getPeer(this);
        if (peer != null) {
            if (peer.supportsXEmbed() && peer.isXEmbedActive()) {
                log.fine("The method shouldn't be called when XEmbed is active!");
            } else {
                return super.traverseIn(direction);
            }
        }
        return false;
    }

    protected boolean traverseOut(boolean direction) {
        XEmbeddedFramePeer xefp = AWTAccessor.getComponentAccessor()
                                             .getPeer(this);
        if (direction == FORWARD) {
            xefp.traverseOutForward();
        }
        else {
            xefp.traverseOutBackward();
        }
        return true;
    }

    /*
     * The method shouldn't be called in case of active XEmbed.
     */
    public void synthesizeWindowActivation(boolean doActivate) {
        XEmbeddedFramePeer peer = AWTAccessor.getComponentAccessor()
                                             .getPeer(this);
        if (peer != null) {
            if (peer.supportsXEmbed() && peer.isXEmbedActive()) {
                log.fine("The method shouldn't be called when XEmbed is active!");
            } else {
                peer.synthesizeFocusInOut(doActivate);
            }
        }
    }

    public void registerAccelerator(AWTKeyStroke stroke) {
        XEmbeddedFramePeer xefp = AWTAccessor.getComponentAccessor()
                                             .getPeer(this);
        if (xefp != null) {
            xefp.registerAccelerator(stroke);
        }
    }

    public void unregisterAccelerator(AWTKeyStroke stroke) {
        XEmbeddedFramePeer xefp = AWTAccessor.getComponentAccessor()
                                             .getPeer(this);
        if (xefp != null) {
            xefp.unregisterAccelerator(stroke);
        }
    }
}
