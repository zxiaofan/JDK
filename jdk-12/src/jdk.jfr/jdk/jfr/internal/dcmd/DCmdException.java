/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal.dcmd;

import java.util.Formatter;

/**
 * Thrown to indicate that a diagnostic command could not be executed
 * successfully.
 */
final class DCmdException extends Exception {
    private static final long serialVersionUID = -3792411099340016465L;

    /**
     * Constructs a new exception with message derived from a format string.
     *
     * @param format format string as described in {@link Formatter} class.
     *
     * @param args arguments referenced by the format specifiers in the format
     *        string.
     *
     */
    public DCmdException(String format, Object... args) {
        super(format(format, args));
    }

    /**
     * Constructs a new exception with message derived from a format string.
     *
     * @param cause exception that stopped the diagnostic command to complete.
     *
     * @param format format string as described in {@link Formatter} class.
     *
     * @param args arguments referenced by the format specifiers in the format
     *        string.
     *
     */
    public DCmdException(Throwable cause, String format, Object... args) {
        super(format(format, args), cause);
    }

    private static String format(String message, Object... args) {
        try (Formatter formatter = new Formatter()) {
            return formatter.format(message, args).toString();
        }
    }
}
