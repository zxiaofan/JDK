/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

/**
 * An <code>Error</code> is a subclass of <code>Throwable</code> 
 * that indicates serious problems that a reasonable application 
 * should not try to catch. Most such errors are abnormal conditions. 
 * The <code>ThreadDeath</code> error, though a "normal" condition,
 * is also a subclass of <code>Error</code> because most applications
 * should not try to catch it. 
 * <p>
 * A method is not required to declare in its <code>throws</code> 
 * clause any subclasses of <code>Error</code> that might be thrown 
 * during the execution of the method but not caught, since these 
 * errors are abnormal conditions that should never occur. 
 *
 * @author  Frank Yellin
 * @version %I%, %G%
 * @see     java.lang.ThreadDeath
 * @since   JDK1.0
 */
public class Error extends Throwable {
    static final long serialVersionUID = 4980196508277280342L;

    /**
     * Constructs a new error with <code>null</code> as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public Error() {
	super();
    }

    /**
     * Constructs a new error with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for 
     *          later retrieval by the {@link #getMessage()} method.
     */
    public Error(String message) {
	super(message);
    }

    /**
     * Constructs a new error with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * <code>cause</code> is <i>not</i> automatically incorporated in
     * this error's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.4
     */
    public Error(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new error with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     * This constructor is useful for errors that are little more than
     * wrappers for other throwables.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.4
     */
    public Error(Throwable cause) {
        super(cause);
    }
}
