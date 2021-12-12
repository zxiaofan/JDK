/*
 * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * AU file format.
 *
 * @author Jan Borgersen
 */
final class AuFileFormat extends StandardFileFormat {

    // magic numbers
    static final int AU_SUN_MAGIC = 0x2e736e64; // ".snd"

    // encodings
    static final int AU_ULAW_8       = 1;  /* 8-bit ISDN u-law */
    static final int AU_LINEAR_8     = 2;  /* 8-bit linear PCM */
    static final int AU_LINEAR_16    = 3;  /* 16-bit linear PCM */
    static final int AU_LINEAR_24    = 4;  /* 24-bit linear PCM */
    static final int AU_LINEAR_32    = 5;  /* 32-bit linear PCM */
    static final int AU_FLOAT        = 6;  /* 32-bit IEEE floating point */
    static final int AU_DOUBLE       = 7;  /* 64-bit IEEE floating point */
//  we don't support these ...
//  static final int AU_ADPCM_G721   = 23; /* 4-bit CCITT g.721 ADPCM */
//  static final int AU_ADPCM_G722   = 24; /* CCITT g.722 ADPCM */
//  static final int AU_ADPCM_G723_3 = 25; /* CCITT g.723 3-bit ADPCM */
//  static final int AU_ADPCM_G723_5 = 26; /* CCITT g.723 5-bit ADPCM */
    static final int AU_ALAW_8       = 27; /* 8-bit ISDN A-law */

    static final int AU_HEADERSIZE       = 24;

    /**
     * According the specification of AU file format this is the value for
     * length field if length is not known. This is a maximum possible value for
     * the unsigned int.
     */
    static final long /*unsigned int */ UNKNOWN_SIZE = 0xffffffffL;

    private int auType;

    AuFileFormat(final AudioFileFormat.Type type, final long byteLength,
                 final AudioFormat format, final long frameLength) {
        super(type, byteLength, format, frameLength);

        AudioFormat.Encoding encoding = format.getEncoding();

        auType = -1;

        if (AudioFormat.Encoding.ALAW.equals(encoding)) {
            if (format.getSampleSizeInBits() == 8) {
                auType = AU_ALAW_8;
            }
        } else if (AudioFormat.Encoding.ULAW.equals(encoding)) {
            if (format.getSampleSizeInBits() == 8) {
                auType = AU_ULAW_8;
            }
        } else if (AudioFormat.Encoding.PCM_SIGNED.equals(encoding)) {
            if (format.getSampleSizeInBits() == 8) {
                auType = AU_LINEAR_8;
            } else if (format.getSampleSizeInBits() == 16) {
                auType = AU_LINEAR_16;
            } else if (format.getSampleSizeInBits() == 24) {
                auType = AU_LINEAR_24;
            } else if (format.getSampleSizeInBits() == 32) {
                auType = AU_LINEAR_32;
            }
        } else if (AudioFormat.Encoding.PCM_FLOAT.equals(encoding)) {
            if (format.getSampleSizeInBits() == 32) {
                auType = AU_FLOAT;
            } else if (format.getSampleSizeInBits() == 64) {
                auType = AU_DOUBLE;
            }
        }
    }

    public int getAuType() {
        return auType;
    }
}
