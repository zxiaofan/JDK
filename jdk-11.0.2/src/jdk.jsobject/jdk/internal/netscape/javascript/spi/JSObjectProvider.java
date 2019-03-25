/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.netscape.javascript.spi;

import java.applet.Applet;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;

@SuppressWarnings("deprecation")
public interface JSObjectProvider {
    /**
     * Return a JSObject for the window containing the given applet.
     * Implementations of this class should return null if not connected to a
     * browser, for example, when running in AppletViewer.
     *
     * @param applet The applet.
     * @return JSObject for the window containing the given applet or null if we
     * are not connected to a browser.
     * @throws JSException when an error is encountered.
     */
    public JSObject getWindow(Applet applet) throws JSException;
}
