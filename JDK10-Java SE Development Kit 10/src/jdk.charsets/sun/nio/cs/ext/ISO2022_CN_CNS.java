/*
 * Copyright (c) 2002, 2006, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.charset.Charset;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import sun.nio.cs.HistoricallyNamedCharset;
import sun.nio.cs.*;

public class ISO2022_CN_CNS extends ISO2022 implements HistoricallyNamedCharset
{
    public ISO2022_CN_CNS() {
        super("x-ISO-2022-CN-CNS", ExtendedCharsets.aliasesFor("x-ISO-2022-CN-CNS"));
    }

    public boolean contains(Charset cs) {
        // overlapping repertoire of EUC_TW, CNS11643
        return ((cs instanceof EUC_TW) ||
                (cs.name().equals("US-ASCII")) ||
                (cs instanceof ISO2022_CN_CNS));
    }

    public String historicalName() {
        return "ISO2022CN_CNS";
    }

    public CharsetDecoder newDecoder() {
        return new ISO2022_CN.Decoder(this);
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    private static class Encoder extends ISO2022.Encoder {

        public Encoder(Charset cs)
        {
            super(cs);
            SODesig =  new byte[] {'$', ')', 'G' };
            SS2Desig = new byte[] {'$', '*', 'H' };
            SS3Desig = new byte[] {'$', '+', 'I' };

            try {
                Charset cset = Charset.forName("EUC_TW"); // CNS11643
                ISOEncoder = cset.newEncoder();
            } catch (Exception e) { }
        }

        private byte[] bb = new byte[4];
        public boolean canEncode(char c) {
            int n = 0;
            return (c <= '\u007f' ||
                    (n = ((EUC_TW.Encoder)ISOEncoder).toEUC(c, bb)) == 2 ||
                    (n == 4 && bb[0] == SS2 &&
                     (bb[1] == PLANE2 || bb[1] == PLANE3)));
        }

        /*
         * Since ISO2022-CN-CNS possesses a CharsetEncoder
         * without the corresponding CharsetDecoder half the
         * default replacement check needs to be overridden
         * since the parent class version attempts to
         * decode 0x3f (?).
         */

        public boolean isLegalReplacement(byte[] repl) {
            // 0x3f is OK as the replacement byte
            return (repl.length == 1 && repl[0] == (byte) 0x3f);
        }
    }
}
