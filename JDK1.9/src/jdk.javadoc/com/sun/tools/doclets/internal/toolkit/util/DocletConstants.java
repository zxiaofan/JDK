/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.util;

/**
 * Stores all constants for a Doclet.  Extend this class if you have doclet
 * specific constants to add.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 * @since 1.5
 */
@Deprecated
public class DocletConstants {

    /**
     * The default amount of space between tab stops.
     */
    public static final int DEFAULT_TAB_STOP_LENGTH = 8;

    /**
     * The line separator for the current operating system.
     */
    public static final String NL = System.getProperty("line.separator");

    /**
     * The default package name.
     */
    public static final String DEFAULT_PACKAGE_NAME = "<Unnamed>";

    /**
     * The default package file name.
     */
    public static final String DEFAULT_PACKAGE_FILE_NAME = "default";
}
