/*
 * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
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

package javax.security.auth.callback;

/**
 * Signals that a {@code CallbackHandler} does not
 * recognize a particular {@code Callback}.
 *
 * @since 1.4
 */
public class UnsupportedCallbackException extends Exception {

    @java.io.Serial
    private static final long serialVersionUID = -6873556327655666839L;

    /**
     * @serial
     */
    @SuppressWarnings("serial") // Not statically typed as Serializable
    private Callback callback;

    /**
     * Constructs an {@code UnsupportedCallbackException}
     * with no detail message.
     *
     * @param callback the unrecognized {@code Callback}.
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
     * @param callback the unrecognized {@code Callback}.
     *
     * @param msg the detail message.
     */
    public UnsupportedCallbackException(Callback callback, String msg) {
        super(msg);
        this.callback = callback;
    }

    /**
     * Get the unrecognized {@code Callback}.
     *
     * @return the unrecognized {@code Callback}.
     */
    public Callback getCallback() {
        return callback;
    }
}
