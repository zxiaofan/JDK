/*
 * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
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
import sun.nio.cs.DoubleByte;
import sun.nio.cs.HistoricallyNamedCharset;
import java.util.Arrays;
import static sun.nio.cs.CharsetMapping.*;

public class Big5_Solaris extends Charset implements HistoricallyNamedCharset
{
    public Big5_Solaris() {
        super("x-Big5-Solaris", ExtendedCharsets.aliasesFor("x-Big5-Solaris"));
    }

    public String historicalName() {
        return "Big5_Solaris";
    }

    public boolean contains(Charset cs) {
        return ((cs.name().equals("US-ASCII"))
                || (cs instanceof Big5)
                || (cs instanceof Big5_Solaris));
    }

    public CharsetDecoder newDecoder() {
        return new DoubleByte.Decoder(this, Holder.b2c, Holder.b2cSB, 0x40, 0xfe, true);
    }

    public CharsetEncoder newEncoder() {
        return new DoubleByte.Encoder(this, Holder.c2b, Holder.c2bIndex, true);
    }

    private static class Holder {
        static final char[][] b2c;
        static final char[] b2cSB;
        static final char[] c2b;
        static final char[] c2bIndex;

        static {
            b2c = Big5.DecodeHolder.b2c.clone();
            // Big5 Solaris implementation has 7 additional mappings
            int[] sol = new int[] {
                0xF9D6, 0x7881,
                0xF9D7, 0x92B9,
                0xF9D8, 0x88CF,
                0xF9D9, 0x58BB,
                0xF9DA, 0x6052,
                0xF9DB, 0x7CA7,
                0xF9DC, 0x5AFA };
            if (b2c[0xf9] == DoubleByte.B2C_UNMAPPABLE) {
                b2c[0xf9] = new char[0xfe - 0x40 + 1];
                Arrays.fill(b2c[0xf9], UNMAPPABLE_DECODING);
            }

            for (int i = 0; i < sol.length;) {
                b2c[0xf9][sol[i++] & 0xff - 0x40] = (char)sol[i++];
            }
            b2cSB = Big5.DecodeHolder.b2cSB;

            c2b = Big5.EncodeHolder.c2b.clone();
            c2bIndex = Big5.EncodeHolder.c2bIndex.clone();
            sol = new int[] {
                0x7881, 0xF9D6,
                0x92B9, 0xF9D7,
                0x88CF, 0xF9D8,
                0x58BB, 0xF9D9,
                0x6052, 0xF9DA,
                0x7CA7, 0xF9DB,
                0x5AFA, 0xF9DC };

            for (int i = 0; i < sol.length;) {
                int c = sol[i++];
                // no need to check c2bIndex[c >>8], we know it points
                // to the appropriate place.
                c2b[c2bIndex[c >> 8] + (c & 0xff)] = (char)sol[i++];
            }
        }
    }
}
