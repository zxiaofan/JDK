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

package sun.net.www.protocol.jrt;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Protocol handler for accessing resources in the runtime image.
 */

public class Handler extends URLStreamHandler {
    public Handler() { }

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        return new JavaRuntimeURLConnection(url);
    }
}
