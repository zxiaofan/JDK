/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.util;

import jdk.javadoc.internal.doclets.toolkit.DocletException;


/**
 * An exception with a user-friendly detail message.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */
public class SimpleDocletException extends DocletException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception with a user-friendly detail message.
     *
     * @param message a localized detail message, suitable for direct presentation to the end user
     */
    public SimpleDocletException(String message) {
        super(message);
    }

    /**
     * Creates an exception with a user-friendly detail message, and underlying cause.
     * The cause may be used for debugging but in normal use, should not be presented to the user.
     *
     * @param message a localized detail message, suitable for direct presentation to the end user
     * @param cause the underlying cause for the exception
     */
    public SimpleDocletException(String message, Throwable cause) {
        super(message, cause);
    }
}
