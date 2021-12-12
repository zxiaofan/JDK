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
 * An {@code UnsupportedAudioFileException} is an exception indicating that an
 * operation failed because a file did not contain valid data of a recognized
 * file type and format.
 *
 * @author Kara Kytle
 * @since 1.3
 */
public class UnsupportedAudioFileException extends Exception {

    /**
     * Use serialVersionUID from JDK 1.3 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -139127412623160368L;

    /**
     * Constructs an {@code UnsupportedAudioFileException} that has {@code null}
     * as its error detail message.
     */
    public UnsupportedAudioFileException() {
        super();
    }

    /**
     * Constructs an {@code UnsupportedAudioFileException} that has the
     * specified detail message.
     *
     * @param  message a string containing the error detail message
     */
    public UnsupportedAudioFileException(final String message) {
        super(message);
    }
}
