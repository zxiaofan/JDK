/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import sun.nio.cs.DoubleByte;
import sun.nio.cs.HistoricallyNamedCharset;

public class IBM943C extends Charset implements HistoricallyNamedCharset
{

    public IBM943C() {
        super("x-IBM943C", ExtendedCharsets.aliasesFor("x-IBM943C"));
    }

    public String historicalName() {
        return "Cp943C";
    }

    public boolean contains(Charset cs) {
        return ((cs.name().equals("US-ASCII"))
                || (cs instanceof IBM943C));
    }

    public CharsetDecoder newDecoder() {
        return new DoubleByte.Decoder(this,
                                      IBM943.DecodeHolder.b2c,
                                      Holder.b2cSB,
                                      0x40,
                                      0xfc);
    }

    public CharsetEncoder newEncoder() {
        return new DoubleByte.Encoder(this, Holder.c2b, Holder.c2bIndex);
    }

    private static class Holder {
        static final char[] b2cSB;
        static final char[] c2b;
        static final char[] c2bIndex;

        static {
            b2cSB = new char[0x100];
            for (int i = 0; i < 0x80; i++) {
                b2cSB[i] = (char)i;
            }
            for (int i = 0x80; i < 0x100; i++) {
                b2cSB[i] = IBM943.DecodeHolder.b2cSB[i];
            }
            c2b = Arrays.copyOf(IBM943.EncodeHolder.c2b, IBM943.EncodeHolder.c2b.length);
            c2bIndex = Arrays.copyOf(IBM943.EncodeHolder.c2bIndex, IBM943.EncodeHolder.c2bIndex.length);
            for (char c = '\0'; c < '\u0080'; ++c) {
                int index = c2bIndex[c >> 8];
                c2b[index + (c & 0xff)] = c;
            }
        }
    }
}
