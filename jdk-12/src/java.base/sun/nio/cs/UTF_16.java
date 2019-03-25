/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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

public class UTF_16 extends Unicode
{

    public UTF_16() {
        super("UTF-16", StandardCharsets.aliases_UTF_16());
    }

    public String historicalName() {
        return "UTF-16";
    }

    public CharsetDecoder newDecoder() {
        return new Decoder(this);
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    private static class Decoder extends UnicodeDecoder {

        public Decoder(Charset cs) {
            super(cs, NONE);
        }
    }

    private static class Encoder extends UnicodeEncoder {

        public Encoder(Charset cs) {
            super(cs, BIG, true);
        }
    }

}
