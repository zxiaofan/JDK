/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmedia;

/**
 * Class of exceptions which might be thrown while processing media.
 */
public class MediaException extends RuntimeException {
    // Suppress compilation warnings; 14 <=> JavaFX 1.4.
    private static final long serialVersionUID = 14L;

    private MediaError error = null;

    /**
     * Constructor which merely passes its parameter to the corresponding
     * superclass constructor
     * {@link RuntimeException#RuntimeException(java.lang.String)}.
     *
     * @param message The detail message.
     */
    public MediaException(String message) {
        super(message);
    }

    /**
     * Constructor which merely passes its parameters to the corresponding
     * superclass constructor
     * {@link RuntimeException#RuntimeException(java.lang.String, java.lang.Throwable)}.
     *
     * @param message The detail message.
     * @param cause The cause.
     */
    public MediaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor which merely passes its parameters to the corresponding
     * superclass constructor
     * {@link RuntimeException#RuntimeException(java.lang.String, java.lang.Throwable)}.
     *
     * @param message The detail message.
     * @param cause The cause.
     * @param error The media error.
     */
    public MediaException(String message, Throwable cause, MediaError error) {
        super(message, cause);
        this.error = error;
    }

    public MediaError getMediaError() {
        return error;
    }
}
