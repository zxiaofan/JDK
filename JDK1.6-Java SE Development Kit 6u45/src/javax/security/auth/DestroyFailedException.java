/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.security.auth;

/**
 * Signals that a <code>destroy</code> operation failed.
 * 
 * <p> This exception is thrown by credentials implementing
 * the <code>Destroyable</code> interface when the <code>destroy</code>
 * method fails.
 *
 * @version %I%, %G%
 */
public class DestroyFailedException extends Exception {

    private static final long serialVersionUID = -7790152857282749162L;

    /**
     * Constructs a DestroyFailedException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public DestroyFailedException() {
	super();
    }

    /**
     * Constructs a DestroyFailedException with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param msg the detail message.  
     */
    public DestroyFailedException(String msg) {
	super(msg);
    }
}
