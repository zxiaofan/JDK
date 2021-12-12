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

package javax.sound.sampled.spi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Provider for audio file reading services. Classes providing concrete
 * implementations can parse the format information from one or more types of
 * audio file, and can produce audio input streams from files of these types.
 *
 * @author Kara Kytle
 * @since 1.3
 */
public abstract class AudioFileReader {

    /**
     * Constructor for subclasses to call.
     */
    protected AudioFileReader() {}

    /**
     * Obtains the audio file format of the input stream provided. The stream
     * must point to valid audio file data. In general, audio file readers may
     * need to read some data from the stream before determining whether they
     * support it. These parsers must be able to mark the stream, read enough
     * data to determine whether they support the stream, and reset the stream's
     * read pointer to its original position. If the input stream does not
     * support this, this method may fail with an {@code IOException}.
     *
     * @param  stream the input stream from which file format information should
     *         be extracted
     * @return an {@code AudioFileFormat} object describing the audio file
     *         format
     * @throws UnsupportedAudioFileException if the stream does not point to
     *         valid audio file data recognized by the system
     * @throws IOException if an I/O exception occurs
     * @throws NullPointerException if {@code stream} is {@code null}
     * @see InputStream#markSupported
     * @see InputStream#mark
     */
    public abstract AudioFileFormat getAudioFileFormat(InputStream stream)
            throws UnsupportedAudioFileException, IOException;

    /**
     * Obtains the audio file format of the {@code URL} provided. The
     * {@code URL} must point to valid audio file data.
     *
     * @param  url the {@code URL} from which file format information should be
     *         extracted
     * @return an {@code AudioFileFormat} object describing the audio file
     *         format
     * @throws UnsupportedAudioFileException if the {@code URL} does not point
     *         to valid audio file data recognized by the system
     * @throws IOException if an I/O exception occurs
     * @throws NullPointerException if {@code url} is {@code null}
     */
    public abstract AudioFileFormat getAudioFileFormat(URL url)
            throws UnsupportedAudioFileException, IOException;

    /**
     * Obtains the audio file format of the {@code File} provided. The
     * {@code File} must point to valid audio file data.
     *
     * @param  file the {@code File} from which file format information should
     *         be extracted
     * @return an {@code AudioFileFormat} object describing the audio file
     *         format
     * @throws UnsupportedAudioFileException if the {@code File} does not point
     *         to valid audio file data recognized by the system
     * @throws IOException if an I/O exception occurs
     * @throws NullPointerException if {@code file} is {@code null}
     */
    public abstract AudioFileFormat getAudioFileFormat(File file)
            throws UnsupportedAudioFileException, IOException;

    /**
     * Obtains an audio input stream from the input stream provided. The stream
     * must point to valid audio file data. In general, audio file readers may
     * need to read some data from the stream before determining whether they
     * support it. These parsers must be able to mark the stream, read enough
     * data to determine whether they support the stream, and reset the stream's
     * read pointer to its original position. If the input stream does not
     * support this, this method may fail with an {@code IOException}.
     *
     * @param  stream the input stream from which the {@code AudioInputStream}
     *         should be constructed
     * @return an {@code AudioInputStream} object based on the audio file data
     *         contained in the input stream
     * @throws UnsupportedAudioFileException if the stream does not point to
     *         valid audio file data recognized by the system
     * @throws IOException if an I/O exception occurs
     * @throws NullPointerException if {@code stream} is {@code null}
     * @see InputStream#markSupported
     * @see InputStream#mark
     */
    public abstract AudioInputStream getAudioInputStream(InputStream stream)
            throws UnsupportedAudioFileException, IOException;

    /**
     * Obtains an audio input stream from the {@code URL} provided. The
     * {@code URL} must point to valid audio file data.
     *
     * @param  url the {@code URL} for which the {@code AudioInputStream} should
     *         be constructed
     * @return an {@code AudioInputStream} object based on the audio file data
     *         pointed to by the {@code URL}
     * @throws UnsupportedAudioFileException if the {@code URL} does not point
     *         to valid audio file data recognized by the system
     * @throws IOException if an I/O exception occurs
     * @throws NullPointerException if {@code url} is {@code null}
     */
    public abstract AudioInputStream getAudioInputStream(URL url)
            throws UnsupportedAudioFileException, IOException;

    /**
     * Obtains an audio input stream from the {@code File} provided. The
     * {@code File} must point to valid audio file data.
     *
     * @param  file the {@code File} for which the {@code AudioInputStream}
     *         should be constructed
     * @return an {@code AudioInputStream} object based on the audio file data
     *         pointed to by the File
     * @throws UnsupportedAudioFileException if the {@code File} does not point
     *         to valid audio file data recognized by the system
     * @throws IOException if an I/O exception occurs
     * @throws NullPointerException if {@code file} is {@code null}
     */
    public abstract AudioInputStream getAudioInputStream(File file)
            throws UnsupportedAudioFileException, IOException;
}
