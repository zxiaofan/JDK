/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.util.zip;

/**
 * Signals that a data format error has occurred.
 *
 * @version 	%I%, %G%
 * @author 	David Connelly
 */
public
class DataFormatException extends Exception {
    /**
     * Constructs a DataFormatException with no detail message.
     */
    public DataFormatException() {
	super();
    }

    /**
     * Constructs a DataFormatException with the specified detail message.
     * A detail message is a String that describes this particular exception.
     * @param s the String containing a detail message
     */
    public DataFormatException(String s) {
	super(s);
    }
}
