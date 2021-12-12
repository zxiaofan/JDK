/*
 * Copyright (c) 1996, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.util.zip;

/**
 * Signals that a data format error has occurred.
 *
 * @author      David Connelly
 * @since 1.1
 */
public class DataFormatException extends Exception {
    @java.io.Serial
    private static final long serialVersionUID = 2219632870893641452L;

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
