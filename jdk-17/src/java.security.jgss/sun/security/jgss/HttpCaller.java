/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.jgss;

import sun.net.www.protocol.http.HttpCallerInfo;

/**
 * A special kind of GSSCaller, which origins from HTTP/Negotiate and contains
 * info about what triggers the JGSS calls.
 */
public class HttpCaller extends GSSCaller {
    private final HttpCallerInfo hci;

    public HttpCaller(HttpCallerInfo hci) {
        super("HTTP_CLIENT");
        this.hci = hci;
    }

    public HttpCallerInfo info() {
        return hci;
    }
}

