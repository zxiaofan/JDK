/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Utility class used as a JEP 238 multi release jar versioned class.
 *
 * Version for {@code runtime >= 9}.
 */
public class MrJarUtil {

    /**
     * Get property used for disabling instance pooling of xml readers / writers.
     *
     * @param baseName Name of a {@linkplain com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory} class or
     *                 {@linkplain com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory} class.
     *
     * @return true if *.noPool system property is not set or is set to true.
     */
    public static boolean getNoPoolProperty(String baseName) {
        return AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
            @Override
            public Boolean run() {
                String noPool = System.getProperty(baseName + ".noPool");
                return noPool == null || Boolean.parseBoolean(noPool);
            }
        });
    }
}
