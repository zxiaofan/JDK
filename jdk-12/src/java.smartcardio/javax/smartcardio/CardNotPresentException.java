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
 * Exception thrown when an application tries to establish a connection with a
 * terminal that has no card present.
 *
 * @since   1.6
 * @author  Andreas Sterbenz
 * @author  JSR 268 Expert Group
 */
public class CardNotPresentException extends CardException {

    private final static long serialVersionUID = 1346879911706545215L;

    /**
     * Constructs a new CardNotPresentException with the specified detail message.
     *
     * @param message the detail message
     */
    public CardNotPresentException(String message) {
        super(message);
    }

    /**
     * Constructs a new CardNotPresentException with the specified cause and a detail message
     * of {@code (cause==null ? null : cause.toString())}.
     *
     * @param cause the cause of this exception or null
     */
    public CardNotPresentException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new CardNotPresentException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of this exception or null
     */
    public CardNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}
