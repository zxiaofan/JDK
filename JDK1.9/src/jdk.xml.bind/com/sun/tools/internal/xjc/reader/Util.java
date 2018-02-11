/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.xml.sax.InputSource;

public class Util
{
    /**
     * Parses the specified string either as an {@link URL} or as a {@link File}.
     *
     * @throws IOException
     *      if the parameter is neither.
     */
    public static Object getFileOrURL(String fileOrURL) throws IOException {
        try {
            return new URL(fileOrURL);
        } catch (MalformedURLException e) {
            return new File(fileOrURL).getCanonicalFile();
        }
    }
    /**
     * Gets an InputSource from a string, which contains either
     * a file name or an URL.
     */
    public static InputSource getInputSource(String fileOrURL) {
        try {
            Object o = getFileOrURL(fileOrURL);
            if(o instanceof URL) {
                return new InputSource(escapeSpace(((URL)o).toExternalForm()));
            } else {
                String url = ((File)o).toURL().toExternalForm();
                return new InputSource(escapeSpace(url));
            }
        } catch (IOException e) {
            return new InputSource(fileOrURL);
        }
    }

    public static String escapeSpace( String url ) {
        // URLEncoder didn't work.
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < url.length(); i++) {
            // TODO: not sure if this is the only character that needs to be escaped.
            if (url.charAt(i) == ' ')
                buf.append("%20");
            else
                buf.append(url.charAt(i));
        }
        return buf.toString();
    }
}
