/*
 * Copyright (c) 1999, 2005, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.charset.*;
import sun.nio.cs.*;
import static sun.nio.cs.CharsetMapping.*;

public class X11GBK extends Charset {
    public X11GBK () {
        super("X11GBK", null);
    }
    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }
    public CharsetDecoder newDecoder() {
        return new GBK().newDecoder();
    }

    public boolean contains(Charset cs) {
        return cs instanceof X11GBK;
    }

    private class Encoder extends DoubleByte.Encoder {

        private DoubleByte.Encoder enc = (DoubleByte.Encoder)new GBK().newEncoder();

        Encoder(Charset cs) {
            super(cs, (char[])null, (char[])null);
        }

        public boolean canEncode(char ch){
            if (ch < 0x80) return false;
            return enc.canEncode(ch);
        }

        public int encodeChar(char ch) {
            if (ch < 0x80)
                return UNMAPPABLE_ENCODING;
            return enc.encodeChar(ch);
        }
    }
}
