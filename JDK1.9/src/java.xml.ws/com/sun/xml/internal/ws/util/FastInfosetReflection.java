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

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


/**
 *
 * @author Santiago.PericasGeertsen@sun.com
 * @author Paul.Sandoz@sun.com
 */
public class FastInfosetReflection {
    /**
     * FI StAXDocumentParser constructor using reflection.
     */
    public static final Constructor fiStAXDocumentParser_new;

    /**
     * FI <code>StAXDocumentParser.setInputStream()</code> method via reflection.
     */
    public static final Method fiStAXDocumentParser_setInputStream;

    /**
     * FI <code>StAXDocumentParser.setStringInterning()</code> method via reflection.
     */
    public static final Method fiStAXDocumentParser_setStringInterning;

    static {
        Constructor tmp_new = null;
        Method tmp_setInputStream = null;
        Method tmp_setStringInterning = null;

        // Use reflection to avoid static dependency with FI jar
        try {
            Class clazz = Class.forName("com.sun.xml.internal.fastinfoset.stax.StAXDocumentParser");
            tmp_new = clazz.getConstructor();
            tmp_setInputStream =
                clazz.getMethod("setInputStream", java.io.InputStream.class);
            tmp_setStringInterning =
                clazz.getMethod("setStringInterning", boolean.class);
        }
        catch (Exception e) {
            // falls through
        }
        fiStAXDocumentParser_new = tmp_new;
        fiStAXDocumentParser_setInputStream = tmp_setInputStream;
        fiStAXDocumentParser_setStringInterning = tmp_setStringInterning;
    }

}
