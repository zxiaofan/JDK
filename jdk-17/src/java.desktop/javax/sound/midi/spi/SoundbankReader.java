/*
 * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.midi.spi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

/**
 * A {@code SoundbankReader} supplies soundbank file-reading services. Concrete
 * subclasses of {@code SoundbankReader} parse a given soundbank file, producing
 * a {@link Soundbank} object that can be loaded into a {@link Synthesizer}.
 *
 * @author Kara Kytle
 * @since 1.3
 */
public abstract class SoundbankReader {

    /**
     * Constructor for subclasses to call.
     */
    protected SoundbankReader() {}

    /**
     * Obtains a soundbank object from the {@code URL} provided.
     *
     * @param  url {@code URL} representing the soundbank
     * @return soundbank object
     * @throws InvalidMidiDataException if the {@code URL} does not point to
     *         valid MIDI soundbank data recognized by this soundbank reader
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if {@code url} is {@code null}
     */
    public abstract Soundbank getSoundbank(URL url)
            throws InvalidMidiDataException, IOException;

    /**
     * Obtains a soundbank object from the {@code InputStream} provided.
     *
     * @param  stream {@code InputStream} representing the soundbank
     * @return soundbank object
     * @throws InvalidMidiDataException if the stream does not point to valid
     *         MIDI soundbank data recognized by this soundbank reader
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if {@code stream} is {@code null}
     */
    public abstract Soundbank getSoundbank(InputStream stream)
            throws InvalidMidiDataException, IOException;

    /**
     * Obtains a soundbank object from the {@code File} provided.
     *
     * @param  file the {@code File} representing the soundbank
     * @return soundbank object
     * @throws InvalidMidiDataException if the file does not point to valid MIDI
     *         soundbank data recognized by this soundbank reader
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if {@code file} is {@code null}
     */
    public abstract Soundbank getSoundbank(File file)
            throws InvalidMidiDataException, IOException;
}
