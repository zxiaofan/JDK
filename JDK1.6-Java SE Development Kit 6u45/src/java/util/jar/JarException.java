/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.util.jar;

/**
 * Signals that an error of some sort has occurred while reading from
 * or writing to a JAR file.
 *
 * @author  David Connelly
 * @version %I%, %G%
 * @since   1.2
 */
public
class JarException extends java.util.zip.ZipException {
    /**
     * Constructs a JarException with no detail message.
     */
    public JarException() {
    }

    /**
     * Constructs a JarException with the specified detail message.
     * @param s the detail message
     */
    public JarException(String s) {
	super(s);
    }
}
