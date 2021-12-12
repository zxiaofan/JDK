/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
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

package javax.imageio;

import java.io.IOException;
import java.io.Serial;

/**
 * An exception class used for signaling run-time failure of reading
 * and writing operations.
 *
 * <p> In addition to a message string, a reference to another
 * {@code Throwable} ({@code Error} or
 * {@code Exception}) is maintained.  This reference, if
 * non-{@code null}, refers to the event that caused this
 * exception to occur.  For example, an {@code IOException} while
 * reading from a {@code File} would be stored there.
 *
 */
public class IIOException extends IOException {

    /**
     * Use serialVersionUID from JDK 9 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -3216210718638985251L;

    /**
     * Constructs an {@code IIOException} with a given message
     * {@code String}.  No underlying cause is set;
     * {@code getCause} will return {@code null}.
     *
     * @param message the error message.
     *
     * @see #getMessage
     */
    public IIOException(String message) {
        super(message);
    }

    /**
     * Constructs an {@code IIOException} with a given message
     * {@code String} and a {@code Throwable} that was its
     * underlying cause.
     *
     * @param message the error message.
     * @param cause the {@code Throwable} ({@code Error} or
     * {@code Exception}) that caused this exception to occur.
     *
     * @see #getCause
     * @see #getMessage
     */
    public IIOException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
}
