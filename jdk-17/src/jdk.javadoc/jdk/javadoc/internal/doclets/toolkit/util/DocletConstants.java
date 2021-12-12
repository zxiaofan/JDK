/*
 * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.util;

/**
 * Stores all constants for a Doclet.  Extend this class if you have doclet
 * specific constants to add.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
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
     * The default module or a package name.
     */
    public static final String DEFAULT_ELEMENT_NAME = "<Unnamed>";

    /**
     * The module prefix in the element-list file.
     */
    public static final String MODULE_PREFIX = "module:";

}
