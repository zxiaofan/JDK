/*
 * Copyright (c) 1996, 2003, Oracle and/or its affiliates. All rights reserved.
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

package java.security;

/**
 * This is the generic Message Digest exception.
 *
 * @author Benjamin Renaud
 */
public class DigestException extends GeneralSecurityException {

    private static final long serialVersionUID = 5821450303093652515L;

    /**
     * Constructs a DigestException with no detail message.  (A
     * detail message is a String that describes this particular
     * exception.)
     */
    public DigestException() {
        super();
    }

    /**
     * Constructs a DigestException with the specified detail
     * message.  (A detail message is a String that describes this
     * particular exception.)
     *
     * @param msg the detail message.
     */
   public DigestException(String msg) {
       super(msg);
    }

    /**
     * Creates a <code>DigestException</code> with the specified
     * detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A <tt>null</tt> value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public DigestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a <code>DigestException</code> with the specified cause
     * and a detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A <tt>null</tt> value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public DigestException(Throwable cause) {
        super(cause);
    }
}
