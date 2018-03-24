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

import java.io.InputStream;
import java.io.IOException;

/**
 * Obtains the version number of the JAX-WS runtime.
 *
 * @author Kohsuke Kawaguchi
 * @author Jitendra Kotamraju
 */
public final class RuntimeVersion {

    public static final Version VERSION;

    static {
        Version version = null;
        InputStream in = RuntimeVersion.class.getResourceAsStream("version.properties");
        try {
            version = Version.create(in);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch(IOException ioe) {
                    // Nothing to do
                }
            }
        }
        VERSION = version == null ? Version.create(null) : version;
    }

    /**
     * Get JAX-WS version
     */
    public String getVersion() {
        return VERSION.toString();
    }

}
