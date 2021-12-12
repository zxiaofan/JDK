/*
 * Copyright (c) 1999, 2016, Oracle and/or its affiliates. All rights reserved.
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

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;

/**
 * WAVE file format class.
 *
 * @author Jan Borgersen
 */
final class WaveFileFormat extends StandardFileFormat {

    /**
     * Wave format type.
     */
    private final int waveType;

    //$$fb 2001-07-13: added management of header size in this class
    //$$fb 2002-04-16: Fix for 4636355: RIFF audio headers could be _more_ spec compliant
    private static final int STANDARD_HEADER_SIZE = 28;

    //$$fb 2002-04-16: Fix for 4636355: RIFF audio headers could be _more_ spec compliant
    /**
     * fmt_ chunk size in bytes.
     */
    private static final int STANDARD_FMT_CHUNK_SIZE = 16;

    // magic numbers
    static final int RIFF_MAGIC = 1380533830;
    static final int WAVE_MAGIC = 1463899717;
    static final int FMT_MAGIC  = 0x666d7420; // "fmt "
    static final int DATA_MAGIC = 0x64617461; // "data"

    // encodings
    static final int WAVE_FORMAT_UNKNOWN   = 0x0000;
    static final int WAVE_FORMAT_PCM       = 0x0001;
    static final int WAVE_FORMAT_ADPCM     = 0x0002;
    static final int WAVE_FORMAT_IEEE_FLOAT= 0x0003;
    static final int WAVE_FORMAT_ALAW      = 0x0006;
    static final int WAVE_FORMAT_MULAW     = 0x0007;
    static final int WAVE_FORMAT_OKI_ADPCM = 0x0010;
    static final int WAVE_FORMAT_DIGISTD   = 0x0015;
    static final int WAVE_FORMAT_DIGIFIX   = 0x0016;
    static final int WAVE_IBM_FORMAT_MULAW = 0x0101;
    static final int WAVE_IBM_FORMAT_ALAW  = 0x0102;
    static final int WAVE_IBM_FORMAT_ADPCM = 0x0103;
    static final int WAVE_FORMAT_DVI_ADPCM = 0x0011;
    static final int WAVE_FORMAT_SX7383    = 0x1C07;
    static final int WAVE_FORMAT_EXTENSIBLE= 0xFFFE;

    WaveFileFormat(final AudioFileFormat.Type type, final long byteLength,
                   final AudioFormat format, final long frameLength) {
        super(type, byteLength, format, frameLength);

        AudioFormat.Encoding encoding = format.getEncoding();

        if( encoding.equals(AudioFormat.Encoding.ALAW) ) {
            waveType = WAVE_FORMAT_ALAW;
        } else if( encoding.equals(AudioFormat.Encoding.ULAW) ) {
            waveType = WAVE_FORMAT_MULAW;
        } else if( encoding.equals(AudioFormat.Encoding.PCM_SIGNED) ||
                   encoding.equals(AudioFormat.Encoding.PCM_UNSIGNED) ) {
            waveType = WAVE_FORMAT_PCM;
        } else {
            waveType = WAVE_FORMAT_UNKNOWN;
        }
    }

    int getWaveType() {
        return waveType;
    }

    int getHeaderSize() {
        return getHeaderSize(getWaveType());
    }

    static int getHeaderSize(int waveType) {
        //$$fb 2002-04-16: Fix for 4636355: RIFF audio headers could be _more_ spec compliant
        // use dynamic format chunk size
        return STANDARD_HEADER_SIZE + getFmtChunkSize(waveType);
    }

    static int getFmtChunkSize(int waveType) {
        //$$fb 2002-04-16: Fix for 4636355: RIFF audio headers could be _more_ spec compliant
        // add 2 bytes for "codec specific data length" for non-PCM codecs
        int result = STANDARD_FMT_CHUNK_SIZE;
        if (waveType != WAVE_FORMAT_PCM) {
            result += 2; // WORD for "codec specific data length"
        }
        return result;
    }
}
