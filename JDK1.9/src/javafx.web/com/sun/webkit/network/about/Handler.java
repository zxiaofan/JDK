/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.network.about;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class Handler extends URLStreamHandler {

    public Handler() {
    }


    @Override
    protected URLConnection openConnection(URL url) {
        return new AboutURLConnection(url);
    }
}
