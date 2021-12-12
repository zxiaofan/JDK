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
 * A {@code MidiUnavailableException} is thrown when a requested MIDI component
 * cannot be opened or created because it is unavailable. This often occurs when
 * a device is in use by another application. More generally, it can occur when
 * there is a finite number of a certain kind of resource that can be used for
 * some purpose, and all of them are already in use (perhaps all by this
 * application). For an example of the latter case, see the
 * {@link Transmitter#setReceiver(Receiver) setReceiver} method of
 * {@code Transmitter}.
 *
 * @author Kara Kytle
 */
public class MidiUnavailableException extends Exception {

    /**
     * Use serialVersionUID from JDK 1.3 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 6093809578628944323L;

    /**
     * Constructs a {@code MidiUnavailableException} that has {@code null} as
     * its error detail message.
     */
    public MidiUnavailableException() {
        super();
    }

    /**
     * Constructs a {@code MidiUnavailableException} with the specified detail
     * message.
     *
     * @param  message the string to display as an error detail message
     */
    public MidiUnavailableException(final String message) {
        super(message);
    }
}
