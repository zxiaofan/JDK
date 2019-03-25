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

package jdk.javadoc.internal.doclets.toolkit;


/**
 * Supertype for all checked doclet exceptions.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 *
 * @apiNote This is primarily intended for the benefit of the builder API
 *  in {@code jdk.javadoc.internal.doclets.toolkit.builders}.
 */
public class DocletException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a DocletException with a given detail message.
     *
     * The message may or may not be intended for presentation to the end user.
     *
     * @param message the detail message.
     */
    protected DocletException(String message) {
        super(message);
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Creates a DocletException with a given detail message and underlying cause.
     *
     * The message may or may not be intended for presentation to the end user.
     *
     * @param message the detail message.
     * @param cause the underlying cause
     */
    protected DocletException(String message, Throwable cause) {
        super(message, cause);
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
