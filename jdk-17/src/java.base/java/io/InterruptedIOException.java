/*
 * Copyright (c) 1995, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.io;

/**
 * Signals that an I/O operation has been interrupted. An
 * {@code InterruptedIOException} is thrown to indicate that an
 * input or output transfer has been terminated because the thread
 * performing it was interrupted. The field {@link #bytesTransferred}
 * indicates how many bytes were successfully transferred before
 * the interruption occurred.
 *
 * @see     java.io.InputStream
 * @see     java.io.OutputStream
 * @see     java.lang.Thread#interrupt()
 * @since   1.0
 */
public class InterruptedIOException extends IOException {
    @java.io.Serial
    private static final long serialVersionUID = 4020568460727500567L;

    /**
     * Constructs an {@code InterruptedIOException} with
     * {@code null} as its error detail message.
     */
    public InterruptedIOException() {
        super();
    }

    /**
     * Constructs an {@code InterruptedIOException} with the
     * specified detail message. The string {@code s} can be
     * retrieved later by the
     * {@link java.lang.Throwable#getMessage}
     * method of class {@code java.lang.Throwable}.
     *
     * @param   s   the detail message.
     */
    public InterruptedIOException(String s) {
        super(s);
    }

    /**
     * Reports how many bytes had been transferred as part of the I/O
     * operation before it was interrupted.
     *
     * @serial
     */
    public int bytesTransferred = 0;
}
