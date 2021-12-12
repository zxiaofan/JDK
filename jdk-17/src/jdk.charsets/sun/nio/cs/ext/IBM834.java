/*
 * Copyright (c) 2006, 2021, Oracle and/or its affiliates. All rights reserved.
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

/*
 */

package sun.nio.cs.ext;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import sun.nio.cs.DoubleByte;
import static sun.nio.cs.CharsetMapping.*;

// EBCDIC DBCS-only Korean
public class IBM834 extends Charset
{
    public IBM834() {
        super("x-IBM834", ExtendedCharsets.aliasesFor("x-IBM834"));
    }

    public boolean contains(Charset cs) {
        return (cs instanceof IBM834);
    }

    public CharsetDecoder newDecoder() {
        return new DoubleByte.Decoder_DBCSONLY(
            this, IBM933.DecodeHolder.b2c, null, 0x40, 0xfe);  // hardcode the b2min/max
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    protected static class Encoder extends DoubleByte.Encoder_DBCSONLY {
        public Encoder(Charset cs) {
            super(cs, new byte[] {(byte)0xfe, (byte)0xfe},
                  IBM933.EncodeHolder.c2b, IBM933.EncodeHolder.c2bIndex, false);
        }

        public int encodeChar(char ch) {
            int bb = super.encodeChar(ch);
            if (bb == UNMAPPABLE_ENCODING) {
                // Cp834 has 6 additional non-roundtrip char->bytes
                // mappings, see#6379808
                if (ch == '\u00b7') {
                    return 0x4143;
                } else if (ch == '\u00ad') {
                    return 0x4148;
                } else if (ch == '\u2015') {
                    return 0x4149;
                } else if (ch == '\u223c') {
                    return 0x42a1;
                } else if (ch == '\uff5e') {
                    return 0x4954;
                } else if (ch == '\u2299') {
                    return 0x496f;
                }
            }
            return bb;
        }

        public boolean isLegalReplacement(byte[] repl) {
            if (repl.length == 2 &&
                repl[0] == (byte)0xfe && repl[1] == (byte)0xfe)
                return true;
            return super.isLegalReplacement(repl);
        }

    }
}
