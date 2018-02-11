/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Jitendra Kotamraju
 */
public class StreamUtils {

    /*
     * Finds if the stream has some content or not
     *
     * @return null if there is no data
     *         else stream to be used
     */
    public static InputStream hasSomeData(InputStream in) {
        if (in != null) {
            try {
                if (in.available() < 1) {
                    if (!in.markSupported()) {
                        in = new BufferedInputStream(in);
                    }
                    in.mark(1);
                    if (in.read() != -1) {
                        in.reset();
                    } else {
                        in = null;          // No data
                    }
                }
            } catch(IOException ioe) {
                in = null;
            }
        }
        return in;
    }

}
