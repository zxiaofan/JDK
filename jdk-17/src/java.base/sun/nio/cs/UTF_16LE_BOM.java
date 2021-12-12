/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.cs;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

class UTF_16LE_BOM extends Unicode
{

    public UTF_16LE_BOM() {
        super("x-UTF-16LE-BOM", StandardCharsets.aliases_UTF_16LE_BOM());
    }

    public String historicalName() {
        return "UnicodeLittle";
    }

    public CharsetDecoder newDecoder() {
        return new Decoder(this);
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    private static class Decoder extends UnicodeDecoder {

        public Decoder(Charset cs) {
            super(cs, NONE, LITTLE);
        }
    }

    private static class Encoder extends UnicodeEncoder {

        public Encoder(Charset cs) {
            super(cs, LITTLE, true);
        }
    }

}
