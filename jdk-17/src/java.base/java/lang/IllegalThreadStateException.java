/*
 * Copyright (c) 1994, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * Thrown to indicate that a thread is not in an appropriate state
 * for the requested operation. See, for example, the
 * {@code suspend} and {@code resume} methods in class
 * {@code Thread}.
 *
 * @see     java.lang.Thread#resume()
 * @see     java.lang.Thread#suspend()
 * @since   1.0
 */
public class IllegalThreadStateException extends IllegalArgumentException {
    @java.io.Serial
    private static final long serialVersionUID = -7626246362397460174L;

    /**
     * Constructs an {@code IllegalThreadStateException} with no
     * detail message.
     */
    public IllegalThreadStateException() {
        super();
    }

    /**
     * Constructs an {@code IllegalThreadStateException} with the
     * specified detail message.
     *
     * @param   s   the detail message.
     */
    public IllegalThreadStateException(String s) {
        super(s);
    }
}
