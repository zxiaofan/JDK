/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www.protocol.jmod;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.MalformedURLException;
import java.io.IOException;

/**
 * Placeholder protocol handler for the jmod protocol.
 */

public class Handler extends URLStreamHandler {
    public Handler() { }

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        String s = url.toString();
        int index = s.indexOf("!/");
        if (index == -1)
            throw new MalformedURLException("no !/ found in url spec:" + s);

        throw new IOException("Can't connect to jmod URL");
    }
}
