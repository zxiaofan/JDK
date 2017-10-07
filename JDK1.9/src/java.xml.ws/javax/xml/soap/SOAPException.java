/*
 * Copyright (c) 2004, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.soap;

/**
 * An exception that signals that a SOAP exception has occurred. A
 * {@code SOAPException} object may contain a {@code String}
 * that gives the reason for the exception, an embedded
 * {@code Throwable} object, or both. This class provides methods
 * for retrieving reason messages and for retrieving the embedded
 * {@code Throwable} object.
 *
 * <P> Typical reasons for throwing a {@code SOAPException}
 * object are problems such as difficulty setting a header, not being
 * able to send a message, and not being able to get a connection with
 * the provider.  Reasons for embedding a {@code Throwable}
 * object include problems such as input/output errors or a parsing
 * problem, such as an error in parsing a header.
 *
 * @since 1.6
 */
public class SOAPException extends Exception {
    private Throwable cause;

    /**
     * Constructs a {@code SOAPException} object with no
     * reason or embedded {@code Throwable} object.
     */
    public SOAPException() {
        super();
        this.cause = null;
    }

    /**
     * Constructs a {@code SOAPException} object with the given
     * {@code String} as the reason for the exception being thrown.
     *
     * @param reason a description of what caused the exception
     */
    public SOAPException(String reason) {
        super(reason);
        this.cause = null;
    }

    /**
     * Constructs a {@code SOAPException} object with the given
     * {@code String} as the reason for the exception being thrown
     * and the given {@code Throwable} object as an embedded
     * exception.
     *
     * @param reason a description of what caused the exception
     * @param cause a {@code Throwable} object that is to
     *        be embedded in this {@code SOAPException} object
     */
    public SOAPException(String reason, Throwable cause) {
        super(reason);
        initCause(cause);
    }

    /**
     * Constructs a {@code SOAPException} object initialized
     * with the given {@code Throwable} object.
     *
     * @param cause a {@code Throwable} object that is to
     *        be embedded in this {@code SOAPException} object
     */
    public SOAPException(Throwable cause) {
        super(cause.toString());
        initCause(cause);
    }

    /**
     * Returns the detail message for this {@code SOAPException}
     * object.
     * <P>
     * If there is an embedded {@code Throwable} object, and if the
     * {@code SOAPException} object has no detail message of its
     * own, this method will return the detail message from the embedded
     * {@code Throwable} object.
     *
     * @return the error or warning message for this
     *         {@code SOAPException} or, if it has none, the
     *         message of the embedded {@code Throwable} object,
     *         if there is one
     */
    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message == null && cause != null) {
            return cause.getMessage();
        } else {
            return message;
        }
    }

    /**
     * Returns the {@code Throwable} object embedded in this
     * {@code SOAPException} if there is one. Otherwise, this method
     * returns {@code null}.
     *
     * @return the embedded {@code Throwable} object or {@code null}
     *         if there is none
     */

    @Override
    public Throwable getCause() {
        return cause;
    }

    /**
     * Initializes the {@code cause} field of this {@code SOAPException}
     * object with the given {@code Throwable} object.
     * <P>
     * This method can be called at most once.  It is generally called from
     * within the constructor or immediately after the constructor has
     * returned a new {@code SOAPException} object.
     * If this {@code SOAPException} object was created with the
     * constructor {@link #SOAPException(Throwable)} or
     * {@link #SOAPException(String,Throwable)}, meaning that its
     * {@code cause} field already has a value, this method cannot be
     * called even once.
     *
     * @param  cause the {@code Throwable} object that caused this
     *         {@code SOAPException} object to be thrown.  The value of this
     *         parameter is saved for later retrieval by the
     *         {@link #getCause()} method.  A {@code null} value is
     *         permitted and indicates that the cause is nonexistent or
     *         unknown.
     * @return  a reference to this {@code SOAPException} instance
     * @throws IllegalArgumentException if {@code cause} is this
     *         {@code Throwable} object.  (A {@code Throwable} object
     *         cannot be its own cause.)
     * @throws IllegalStateException if the cause for this {@code SOAPException} object
     *         has already been initialized
     */
    @Override
    public synchronized Throwable initCause(Throwable cause) {
        if (this.cause != null) {
            throw new IllegalStateException("Can't override cause");
        }
        if (cause == this) {
            throw new IllegalArgumentException("Self-causation not permitted");
        }
        this.cause = cause;

        return this;
    }
}
