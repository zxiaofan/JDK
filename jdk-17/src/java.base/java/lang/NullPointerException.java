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
 * Thrown when an application attempts to use {@code null} in a
 * case where an object is required. These include:
 * <ul>
 * <li>Calling the instance method of a {@code null} object.
 * <li>Accessing or modifying the field of a {@code null} object.
 * <li>Taking the length of {@code null} as if it were an array.
 * <li>Accessing or modifying the slots of {@code null} as if it
 *     were an array.
 * <li>Throwing {@code null} as if it were a {@code Throwable}
 *     value.
 * </ul>
 * <p>
 * Applications should throw instances of this class to indicate
 * other illegal uses of the {@code null} object.
 *
 * {@code NullPointerException} objects may be constructed by the
 * virtual machine as if {@linkplain Throwable#Throwable(String,
 * Throwable, boolean, boolean) suppression were disabled and/or the
 * stack trace was not writable}.
 *
 * @since   1.0
 */
public class NullPointerException extends RuntimeException {
    @java.io.Serial
    private static final long serialVersionUID = 5162710183389028792L;

    /**
     * Constructs a {@code NullPointerException} with no detail message.
     */
    public NullPointerException() {
        super();
    }

    /**
     * Constructs a {@code NullPointerException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public NullPointerException(String s) {
        super(s);
    }

    // 0: no backtrace filled in, no message computed.
    // 1: backtrace filled in, no message computed.
    // 2: message computed
    private transient int extendedMessageState;
    private transient String extendedMessage;

    /**
     * {@inheritDoc}
     */
    public synchronized Throwable fillInStackTrace() {
        // If the stack trace is changed the extended NPE algorithm
        // will compute a wrong message. So compute it beforehand.
        if (extendedMessageState == 0) {
            extendedMessageState = 1;
        } else if (extendedMessageState == 1) {
            extendedMessage = getExtendedNPEMessage();
            extendedMessageState = 2;
        }
        return super.fillInStackTrace();
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * <p> If a non-null message was supplied in a constructor it is
     * returned. Otherwise, an implementation specific message or
     * {@code null} is returned.
     *
     * @implNote
     * If no explicit message was passed to the constructor, and as
     * long as certain internal information is available, a verbose
     * description of the null reference is returned.
     * The internal information is not available in deserialized
     * NullPointerExceptions.
     *
     * @return the detail message string, which may be {@code null}.
     */
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            synchronized(this) {
                if (extendedMessageState == 1) {
                    // Only the original stack trace was filled in. Message will
                    // compute correctly.
                    extendedMessage = getExtendedNPEMessage();
                    extendedMessageState = 2;
                }
                return extendedMessage;
            }
        }
        return message;
    }

    /**
     * Get an extended exception message. This returns a string describing
     * the location and cause of the exception. It returns null for
     * exceptions where this is not applicable.
     */
    private native String getExtendedNPEMessage();
}
