/*
 * Copyright (c) 2003, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Component;
import java.awt.Window;

import sun.awt.AWTAccessor;
import java.awt.event.FocusEvent;
import sun.awt.KeyboardFocusManagerPeerImpl;
import sun.util.logging.PlatformLogger;

public class XKeyboardFocusManagerPeer extends KeyboardFocusManagerPeerImpl {
    private static final PlatformLogger focusLog = PlatformLogger.getLogger("sun.awt.X11.focus.XKeyboardFocusManagerPeer");
    private static final XKeyboardFocusManagerPeer inst = new XKeyboardFocusManagerPeer();

    private Component currentFocusOwner;
    private Window currentFocusedWindow;

    public static XKeyboardFocusManagerPeer getInstance() {
        return inst;
    }

    private XKeyboardFocusManagerPeer() {
    }

    @Override
    public void setCurrentFocusOwner(Component comp) {
        synchronized (this) {
            currentFocusOwner = comp;
        }
    }

    @Override
    public Component getCurrentFocusOwner() {
        synchronized(this) {
            return currentFocusOwner;
        }
    }

    @Override
    public void setCurrentFocusedWindow(Window win) {
        if (focusLog.isLoggable(PlatformLogger.Level.FINER)) {
            focusLog.finer("Setting current focused window " + win);
        }

        XWindowPeer from = null, to = null;

        synchronized(this) {
            if (currentFocusedWindow != null) {
                from = AWTAccessor.getComponentAccessor().getPeer(currentFocusedWindow);
            }

            currentFocusedWindow = win;

            if (currentFocusedWindow != null) {
                to = AWTAccessor.getComponentAccessor().getPeer(currentFocusedWindow);
            }
        }

        if (from != null) {
            from.updateSecurityWarningVisibility();
        }
        if (to != null) {
            to.updateSecurityWarningVisibility();
        }
    }

    @Override
    public Window getCurrentFocusedWindow() {
        synchronized(this) {
            return currentFocusedWindow;
        }
    }

    // TODO: do something to eliminate this forwarding
    public static boolean deliverFocus(Component lightweightChild,
                                       Component target,
                                       boolean temporary,
                                       boolean focusedWindowChangeAllowed,
                                       long time,
                                       FocusEvent.Cause cause)
    {
        return KeyboardFocusManagerPeerImpl.deliverFocus(lightweightChild,
                                                         target,
                                                         temporary,
                                                         focusedWindowChangeAllowed,
                                                         time,
                                                         cause,
                                                         getInstance().getCurrentFocusOwner());
    }
}
