/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.parsers;

/**
 * Indicates a serious configuration error.
 *
 * @author Jeff Suttor
 * @since 1.4
 */

public class ParserConfigurationException extends Exception {
    private static final long serialVersionUID = -3688849216575373917L;
    /**
     * Create a new <code>ParserConfigurationException</code> with no
     * detail message.
     */

    public ParserConfigurationException() {
        super();
    }

    /**
     * Create a new <code>ParserConfigurationException</code> with
     * the <code>String</code> specified as an error message.
     *
     * @param msg The error message for the exception.
     */

    public ParserConfigurationException(String msg) {
        super(msg);
    }

}
