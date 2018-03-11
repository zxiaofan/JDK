/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.util.concurrent;

/**
 * Exception indicating that the result of a value-producing task,
 * such as a {@link FutureTask}, cannot be retrieved because the task
 * was cancelled.
 *
 * @since 1.5
 * @author Doug Lea
 */
public class CancellationException extends IllegalStateException {
    private static final long serialVersionUID = -9202173006928992231L;

    /**
     * Constructs a <tt>CancellationException</tt> with no detail message.
     */
    public CancellationException() {}

    /**
     * Constructs a <tt>CancellationException</tt> with the specified detail
     * message.
     *
     * @param message the detail message
     */
    public CancellationException(String message) {
        super(message);
    }
}
