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

package com.sun.tools.internal.xjc.util;

import org.xml.sax.Locator;


/**
 * Other miscellaneous utility methods.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public final class Util {
    private Util() {}   // no instanciation please

    /**
     * An easier-to-use version of the System.getProperty method
     * that doesn't throw an exception even if a property cannot be
     * read.
     */
    public static String getSystemProperty( String name ) {
        try {
            return System.getProperty(name);
        } catch( SecurityException e ) {
            return null;
        }
    }

    /**
     * Compares if two {@link Locator}s point to the exact same position.
     */
    public static boolean equals(Locator lhs, Locator rhs) {
        return lhs.getLineNumber()==rhs.getLineNumber()
        && lhs.getColumnNumber()==rhs.getColumnNumber()
        && equals(lhs.getSystemId(),rhs.getSystemId())
        && equals(lhs.getPublicId(),rhs.getPublicId());
    }

    private static boolean equals(String lhs, String rhs) {
        if(lhs==null && rhs==null)  return true;
        if(lhs==null || rhs==null)  return false;
        return lhs.equals(rhs);
    }

    /**
     * Calls the other getSystemProperty method with
     * "[clazz]&#x2E;[name].
     */
    public static String getSystemProperty( Class clazz, String name ) {
        return getSystemProperty( clazz.getName()+'.'+name );
    }
}
