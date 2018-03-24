/*
 * Copyright (c) 1997, Oracle and/or its affiliates. All rights reserved.
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

package sun.applet;

import java.util.EventListener;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;

/**
 * AppletEventMulticaster class.  This class manages an immutable
 * structure consisting of a chain of AppletListeners and is
 * responsible for dispatching events to them.
 *
 * @author  Sunita Mani
 *
 * @deprecated The Applet API is deprecated. See the
 * <a href="../../java/applet/package-summary.html"> java.applet package
 * documentation</a> for further information.
 */
@Deprecated(since = "9")
public class AppletEventMulticaster implements AppletListener {

    private final AppletListener a, b;

    public AppletEventMulticaster(AppletListener a, AppletListener b) {
        this.a = a; this.b = b;
    }

    public void appletStateChanged(AppletEvent e) {
        a.appletStateChanged(e);
        b.appletStateChanged(e);
    }

    /**
     * Adds Applet-listener-a with Applet-listener-b and
     * returns the resulting multicast listener.
     * @param a Applet-listener-a
     * @param b Applet-listener-b
     */
    public static AppletListener add(AppletListener a, AppletListener b) {
        return addInternal(a, b);
    }

    /**
     * Removes the old Applet-listener from Applet-listener-l and
     * returns the resulting multicast listener.
     * @param l Applet-listener-l
     * @param oldl the Applet-listener being removed
     */
    public static AppletListener remove(AppletListener l, AppletListener oldl) {
        return removeInternal(l, oldl);
    }

    /**
     * Returns the resulting multicast listener from adding listener-a
     * and listener-b together.
     * If listener-a is null, it returns listener-b;
     * If listener-b is null, it returns listener-a
     * If neither are null, then it creates and returns
     * a new AppletEventMulticaster instance which chains a with b.
     * @param a event listener-a
     * @param b event listener-b
     */
    private static AppletListener addInternal(AppletListener a, AppletListener b) {
        if (a == null)  return b;
        if (b == null)  return a;
        return new AppletEventMulticaster(a, b);
    }


    /**
     * Removes a listener from this multicaster and returns the
     * resulting multicast listener.
     * @param oldl the listener to be removed
     */
    protected AppletListener remove(AppletListener oldl) {
        if (oldl == a)  return b;
        if (oldl == b)  return a;
        AppletListener a2 = removeInternal(a, oldl);
        AppletListener b2 = removeInternal(b, oldl);
        if (a2 == a && b2 == b) {
            return this;        // it's not here
        }
        return addInternal(a2, b2);
    }


    /**
     * Returns the resulting multicast listener after removing the
     * old listener from listener-l.
     * If listener-l equals the old listener OR listener-l is null,
     * returns null.
     * Else if listener-l is an instance of AppletEventMulticaster
     * then it removes the old listener from it.
     * Else, returns listener l.
     * @param l the listener being removed from
     * @param oldl the listener being removed
     */
    private static AppletListener removeInternal(AppletListener l, AppletListener oldl) {
        if (l == oldl || l == null) {
            return null;
        } else if (l instanceof AppletEventMulticaster) {
            return ((AppletEventMulticaster)l).remove(oldl);
        } else {
            return l;           // it's not here
        }
    }
}
