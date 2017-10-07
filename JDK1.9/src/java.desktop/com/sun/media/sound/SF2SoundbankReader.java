/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Soundbank;
import javax.sound.midi.spi.SoundbankReader;

/**
 * This class is used to connect the SF2SoundBank class
 * to the SoundbankReader SPI interface.
 *
 * @author Karl Helgason
 */
public final class SF2SoundbankReader extends SoundbankReader {

    @Override
    public Soundbank getSoundbank(URL url)
            throws InvalidMidiDataException, IOException {
        try {
            return new SF2Soundbank(url);
        } catch (RIFFInvalidFormatException e) {
            return null;
        } catch(IOException ioe) {
            return null;
        }
    }

    @Override
    public Soundbank getSoundbank(InputStream stream)
            throws InvalidMidiDataException, IOException {
        try {
            stream.mark(512);
            return new SF2Soundbank(stream);
        } catch (RIFFInvalidFormatException e) {
            stream.reset();
            return null;
        }
    }

    @Override
    public Soundbank getSoundbank(File file)
            throws InvalidMidiDataException, IOException {
        try {
            return new SF2Soundbank(file);
        } catch (RIFFInvalidFormatException e) {
            return null;
        }
    }
}
