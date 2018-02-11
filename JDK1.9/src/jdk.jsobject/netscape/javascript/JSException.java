/*
 * Copyright (c) 2006, 2016, Oracle and/or its affiliates. All rights reserved.
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

package netscape.javascript;

/**
 * Thrown when an exception is raised in the JavaScript engine. This is merely
 * a marker class to indicate an exception relating to the JavaScript
 * interface.
 */
public class JSException extends RuntimeException {
    private static final long serialVersionUID = 2778103758223661489L;

    /**
     * Constructs a new JavaScript exception with null as it's detail message.
     */
    public JSException() {
        super();
    }

    /**
     * Construct a new JavaScript exception with the specified detail message.
     *
     * @param s The detail message
     */
    public JSException(String s) {
        super(s);
    }

    /**
     * Construct a new JavaScript exception with the specified cause.
     *
     * @param t Throwable cause
     */
    public JSException(Throwable t) {
        super(t);
    }
}
