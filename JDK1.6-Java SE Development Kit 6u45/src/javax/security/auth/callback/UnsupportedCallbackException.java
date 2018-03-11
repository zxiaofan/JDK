/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.security.auth.callback;

/**
 * Signals that a <code>CallbackHandler</code> does not
 * recognize a particular <code>Callback</code>.
 *
 * @version %I%, %G%
 */
public class UnsupportedCallbackException extends Exception {

    private static final long serialVersionUID = -6873556327655666839L;

    /**
     * @serial
     */
    private Callback callback;

    /**
     * Constructs a <code>UnsupportedCallbackException</code>
     * with no detail message.
     *
     * <p>
     *
     * @param callback the unrecognized <code>Callback</code>.
     */
    public UnsupportedCallbackException(Callback callback) {
	super();
	this.callback = callback;
    }

    /**
     * Constructs a UnsupportedCallbackException with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param callback the unrecognized <code>Callback</code>. <p>
     *
     * @param msg the detail message.
     */
    public UnsupportedCallbackException(Callback callback, String msg) {
	super(msg);
	this.callback = callback;
    }

    /**
     * Get the unrecognized <code>Callback</code>.
     *
     * <p>
     *
     * @return the unrecognized <code>Callback</code>.
     */
    public Callback getCallback() {
	return callback;
    }
}
