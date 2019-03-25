/*
 * Copyright (c) 1996, 2005, Oracle and/or its affiliates. All rights reserved.
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

package sun.font;

import java.nio.CharBuffer;
import java.nio.ByteBuffer;
import java.nio.charset.*;
import sun.nio.cs.*;
import static sun.nio.cs.CharsetMapping.*;

public class X11KSC5601 extends Charset {
    public X11KSC5601 () {
        super("X11KSC5601", null);
    }
    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }
    public CharsetDecoder newDecoder() {
        return new Decoder(this);
    }

    public boolean contains(Charset cs) {
        return cs instanceof X11KSC5601;
    }

    private class Encoder extends CharsetEncoder {
        private DoubleByte.Encoder enc = (DoubleByte.Encoder)new EUC_KR().newEncoder();

        public Encoder(Charset cs) {
            super(cs, 2.0f, 2.0f);
        }

        public boolean canEncode(char c) {
            if (c <= 0x7F) {
                return false;
            }
            return enc.canEncode(c);
        }

        protected int encodeDouble(char c) {
            return enc.encodeChar(c);
        }

        protected CoderResult encodeLoop(CharBuffer src, ByteBuffer dst) {
            char[] sa = src.array();
            int sp = src.arrayOffset() + src.position();
            int sl = src.arrayOffset() + src.limit();
            byte[] da = dst.array();
            int dp = dst.arrayOffset() + dst.position();
            int dl = dst.arrayOffset() + dst.limit();

            try {
                while (sp < sl) {
                    char c = sa[sp];
                    if (c <= '\u007f')
                        return CoderResult.unmappableForLength(1);
                    int ncode = encodeDouble(c);
                    if (ncode != 0 && c != '\u0000' ) {
                        da[dp++] = (byte) ((ncode  >> 8) & 0x7f);
                        da[dp++] = (byte) (ncode & 0x7f);
                        sp++;
                        continue;
                    }
                    return CoderResult.unmappableForLength(1);
                }
                return CoderResult.UNDERFLOW;
            } finally {
                src.position(sp - src.arrayOffset());
                dst.position(dp - dst.arrayOffset());
            }
        }
        public boolean isLegalReplacement(byte[] repl) {
            return true;
        }
    }

    private class Decoder extends  CharsetDecoder {
        private DoubleByte.Decoder dec = (DoubleByte.Decoder)new EUC_KR().newDecoder();

        public Decoder(Charset cs) {
            super(cs, 0.5f, 1.0f);
        }

        protected char decodeDouble(int b1, int b2) {
            return dec.decodeDouble(b1, b2);
        }

        protected CoderResult decodeLoop(ByteBuffer src, CharBuffer dst) {
            byte[] sa = src.array();
            int sp = src.arrayOffset() + src.position();
            int sl = src.arrayOffset() + src.limit();
            assert (sp <= sl);
            sp = (sp <= sl ? sp : sl);
            char[] da = dst.array();
            int dp = dst.arrayOffset() + dst.position();
            int dl = dst.arrayOffset() + dst.limit();
            assert (dp <= dl);
            dp = (dp <= dl ? dp : dl);


            try {
                while (sp < sl) {
                    if ( sl - sp < 2) {
                        return CoderResult.UNDERFLOW;
                    }
                    int b1 = sa[sp] & 0xFF | 0x80;
                    int b2 = sa[sp + 1] & 0xFF | 0x80;
                    char c = decodeDouble(b1, b2);
                    if (c == UNMAPPABLE_DECODING) {
                        return CoderResult.unmappableForLength(2);
                    }
                    if (dl - dp < 1)
                        return CoderResult.OVERFLOW;
                    da[dp++] = c;
                    sp +=2;
                }
                return CoderResult.UNDERFLOW;
            } finally {
                src.position(sp - src.arrayOffset());
                dst.position(dp - dst.arrayOffset());
            }

        }
    }
}
