/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.webkit;

import javafx.scene.web.WebView;

/**
 *  Allows to receive Webkit JS Web console messages.
 */
public interface WebConsoleListener {

    public static void setDefaultListener(WebConsoleListener l) {
        WebPageClientImpl.setConsoleListener(l);
    }

    void messageAdded(WebView webView, String message, int lineNumber, String sourceId);
}
