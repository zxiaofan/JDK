/*
 * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.sampled;

import java.io.Serial;

/**
 * A {@code LineUnavailableException} is an exception indicating that a line
 * cannot be opened because it is unavailable. This situation arises most
 * commonly when a requested line is already in use by another application.
 *
 * @author Kara Kytle
 * @since 1.3
 */
public class LineUnavailableException extends Exception {

    /**
     * Use serialVersionUID from JDK 1.3 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -2046718279487432130L;

    /**
     * Constructs a {@code LineUnavailableException} that has {@code null} as
     * its error detail message.
     */
    public LineUnavailableException() {
        super();
    }

    /**
     * Constructs a {@code LineUnavailableException} that has the specified
     * detail message.
     *
     * @param  message a string containing the error detail message
     */
    public LineUnavailableException(final String message) {
        super(message);
    }
}
