/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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
/*
 * $Id: KeySelectorException.java,v 1.3 2005/05/10 15:47:42 mullan Exp $
 */
package javax.xml.crypto;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Indicates an exceptional condition thrown by a {@link KeySelector}.
 *
 * <p>A {@code KeySelectorException} can contain a cause: another
 * throwable that caused this {@code KeySelectorException} to get thrown.
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 */
public class KeySelectorException extends Exception {

    private static final long serialVersionUID = -7480033639322531109L;

    /**
     * The throwable that caused this exception to get thrown, or
     * {@code null} if this exception was not caused by another throwable
     * or if the causative throwable is unknown.
     *
     * @serial
     */
    private Throwable cause;

    /**
     * Constructs a new {@code KeySelectorException} with
     * {@code null} as its detail message.
     */
    public KeySelectorException() {
        super();
    }

    /**
     * Constructs a new {@code KeySelectorException} with the specified
     * detail message.
     *
     * @param message the detail message
     */
    public KeySelectorException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code KeySelectorException} with the
     * specified detail message and cause.
     * <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message
     * @param cause the cause (A {@code null} value is permitted, and
     *        indicates that the cause is nonexistent or unknown.)
     */
    public KeySelectorException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
    }

    /**
     * Constructs a new {@code KeySelectorException} with the specified
     * cause and a detail message of
     * {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of
     * {@code cause}).
     *
     * @param cause the cause (A {@code null} value is permitted, and
     *        indicates that the cause is nonexistent or unknown.)
     */
    public KeySelectorException(Throwable cause) {
        super(cause==null ? null : cause.toString());
        this.cause = cause;
    }

    /**
     * Returns the cause of this {@code KeySelectorException} or
     * {@code null} if the cause is nonexistent or unknown.  (The
     * cause is the throwable that caused this
     * {@code KeySelectorException} to get thrown.)
     *
     * @return the cause of this {@code KeySelectorException} or
     *         {@code null} if the cause is nonexistent or unknown.
     */
    public Throwable getCause() {
        return cause;
    }

    /**
     * Prints this {@code KeySelectorException}, its backtrace and
     * the cause's backtrace to the standard error stream.
     */
    public void printStackTrace() {
        super.printStackTrace();
        //XXX print backtrace of cause
    }

    /**
     * Prints this {@code KeySelectorException}, its backtrace and
     * the cause's backtrace to the specified print stream.
     *
     * @param s {@code PrintStream} to use for output
     */
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
        //XXX print backtrace of cause
    }

    /**
     * Prints this {@code KeySelectorException}, its backtrace and
     * the cause's backtrace to the specified print writer.
     *
     * @param s {@code PrintWriter} to use for output
     */
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
        //XXX print backtrace of cause
    }
}
