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

package javax.smartcardio;

/**
 * Exception for errors that occur during communication with the
 * Smart Card stack or the card itself.
 *
 * @since   1.6
 * @author  Andreas Sterbenz
 * @author  JSR 268 Expert Group
 */
public class CardException extends Exception {

    private static final long serialVersionUID = 7787607144922050628L;

    /**
     * Constructs a new CardException with the specified detail message.
     *
     * @param message the detail message
     */
    public CardException(String message) {
        super(message);
    }

    /**
     * Constructs a new CardException with the specified cause and a detail message
     * of {@code (cause==null ? null : cause.toString())}.
     *
     * @param cause the cause of this exception or null
     */
    public CardException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new CardException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of this exception or null
     */
    public CardException(String message, Throwable cause) {
        super(message, cause);
    }
}
