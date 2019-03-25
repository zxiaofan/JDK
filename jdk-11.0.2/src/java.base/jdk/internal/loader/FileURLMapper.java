/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.loader;

import java.net.URL;
import java.io.File;
import sun.net.www.ParseUtil;

/**
 * (Solaris) platform specific handling for file: URLs .
 * urls must not contain a hostname in the authority field
 * other than "localhost".
 *
 * This implementation could be updated to map such URLs
 * on to /net/host/...
 *
 * @author      Michael McMahon
 */

public class FileURLMapper {

    URL url;
    String path;

    public FileURLMapper (URL url) {
        this.url = url;
    }

    /**
     * @return the platform specific path corresponding to the URL
     *  so long as the URL does not contain a hostname in the authority field.
     */

    public String getPath () {
        if (path != null) {
            return path;
        }
        String host = url.getHost();
        if (host == null || "".equals(host) || "localhost".equalsIgnoreCase (host)) {
            path = url.getFile();
            path = ParseUtil.decode (path);
        }
        return path;
    }

    /**
     * Checks whether the file identified by the URL exists.
     */
    public boolean exists () {
        String s = getPath ();
        if (s == null) {
            return false;
        } else {
            File f = new File (s);
            return f.exists();
        }
    }
}
