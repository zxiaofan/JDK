/*
 * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.cs.ext;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharsetDecoder;
import sun.nio.cs.DoubleByte;
import sun.nio.cs.*;
import static sun.nio.cs.CharsetMapping.*;

public class MS932_0213 extends Charset {
    public MS932_0213() {
        super("x-MS932_0213", ExtendedCharsets.aliasesFor("x-MS932_0213"));
    }

    public boolean contains(Charset cs) {
        return ((cs.name().equals("US-ASCII"))
                || (cs instanceof MS932)
                || (cs instanceof MS932_0213));
    }

    public CharsetDecoder newDecoder() {
        return new Decoder(this);
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    protected static class Decoder extends SJIS_0213.Decoder {
        static final DoubleByte.Decoder decMS932 =
            (DoubleByte.Decoder)new MS932().newDecoder();
        protected Decoder(Charset cs) {
            super(cs);
        }

        protected char decodeDouble(int b1, int b2) {
            char c = decMS932.decodeDouble(b1, b2);
            if (c == UNMAPPABLE_DECODING)
                return super.decodeDouble(b1, b2);
            return c;
        }
    }

    protected static class Encoder extends SJIS_0213.Encoder {
        // we only use its encodeChar() method
        static final DoubleByte.Encoder encMS932 =
            (DoubleByte.Encoder)new MS932().newEncoder();
        protected Encoder(Charset cs) {
            super(cs);
        }

        protected int encodeChar(char ch) {
            int db = encMS932.encodeChar(ch);
            if (db == UNMAPPABLE_ENCODING)
                return super.encodeChar(ch);
            return db;
        }
    }
}
