/*
 * Copyright (c) 1994, 2019, Oracle and/or its affiliates. All rights reserved.
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

/*
 *      FTP stream opener
 */

package sun.net.www.protocol.ftp;

import java.io.IOException;
import java.net.URL;
import java.net.Proxy;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import sun.net.ftp.FtpClient;
import sun.net.www.protocol.http.HttpURLConnection;

/** open an ftp connection given a URL */
public class Handler extends java.net.URLStreamHandler {

    protected int getDefaultPort() {
        return 21;
    }

    protected boolean equals(URL u1, URL u2) {
        String userInfo1 = u1.getUserInfo();
        String userInfo2 = u2.getUserInfo();
        return super.equals(u1, u2) && Objects.equals(userInfo1, userInfo2);
    }

    protected java.net.URLConnection openConnection(URL u)
        throws IOException {
        return openConnection(u, null);
    }

    protected java.net.URLConnection openConnection(URL u, Proxy p)
        throws IOException {
        return new FtpURLConnection(u, p);
    }
}
