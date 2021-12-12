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

package javax.sound.midi;

import java.io.Serial;

/**
 * An {@code InvalidMidiDataException} indicates that inappropriate MIDI data
 * was encountered. This often means that the data is invalid in and of itself,
 * from the perspective of the MIDI specification. An example would be an
 * undefined status byte. However, the exception might simply mean that the data
 * was invalid in the context it was used, or that the object to which the data
 * was given was unable to parse or use it. For example, a file reader might not
 * be able to parse a Type 2 MIDI file, even though that format is defined in
 * the MIDI specification.
 *
 * @author Kara Kytle
 */
public class InvalidMidiDataException extends Exception {

    /**
     * Use serialVersionUID from JDK 1.3 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 2780771756789932067L;

    /**
     * Constructs an {@code InvalidMidiDataException} with {@code null} for its
     * error detail message.
     */
    public InvalidMidiDataException() {
        super();
    }

    /**
     * Constructs an {@code InvalidMidiDataException} with the specified detail
     * message.
     *
     * @param  message the string to display as an error detail message
     */
    public InvalidMidiDataException(final String message) {
        super(message);
    }
}
