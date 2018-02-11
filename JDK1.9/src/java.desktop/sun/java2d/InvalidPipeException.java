/*
 * Copyright (c) 1999, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d;

/**
 * Signals that some part of a graphics pipeline is not in an appropriate
 * state for the requested operation.  The most likely cause of this is
 * an asynchronous change to the configuration of the destination surface
 * since the current set of rendering loops was chosen.  Other potential
 * causes are the appearance or disappearance of overlapping opaque
 * windows which toggle the need to use platform graphics or direct
 * graphics access.
 */
@SuppressWarnings("serial") // JDK-implementation class
public class InvalidPipeException extends IllegalStateException {
    /**
     * Constructs an InvalidPipeException with no detail message.
     * A detail message is a String that describes this particular exception.
     */
    public InvalidPipeException() {
        super();
    }

    /**
     * Constructs an InvalidPipeException with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     * @param s the String that contains a detailed message
     */
    public InvalidPipeException(String s) {
        super(s);
    }
}
