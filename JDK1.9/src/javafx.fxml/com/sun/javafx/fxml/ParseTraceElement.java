/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.fxml;

import java.net.URL;

/*
 * An element in a parse trace, as returned by
 * {@link javafx.fxml.FXMLLoader#getParseTrace()}.
 *
 * @since JavaFX 2.1
 */
public class ParseTraceElement {
    private URL location;
    private int lineNumber;

    public ParseTraceElement(URL location, int lineNumber) {
        this.location = location;
        this.lineNumber = lineNumber;
    }

    public URL getLocation() {
        return location;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        return ((location == null) ? "?" : location.getPath()) + ": " + lineNumber;
    }
}
