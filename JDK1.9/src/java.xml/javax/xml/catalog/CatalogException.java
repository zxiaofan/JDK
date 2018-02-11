/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package javax.xml.catalog;

/**
 * The exception class handles errors that may happen while processing or using
 * a catalog.
 *
 * @since 9
 */
public class CatalogException extends RuntimeException {

    private static final long serialVersionUID = 653231525876459057L;

    /**
     * Constructs a new CatalogException with the specified detail message. The
     * cause is not initialized, and may subsequently be initialized by a call
     * to {@link #initCause}.
     *
     * @param message the detail message
     */
    public CatalogException(String message) {
        super(message);
    }

    /**
     * Constructs a new CatalogException with the specified detail message and
     * cause.
     *
     * @param message the detail message (which is saved for later retrieval by
     * the {@link #getMessage()} method)
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause()} method). (A {@code null} value is permitted, and
     * indicates that the cause is nonexistent or unknown.)
     */
    public CatalogException(String message, Throwable cause) {
        super(message, cause);
    }
}
