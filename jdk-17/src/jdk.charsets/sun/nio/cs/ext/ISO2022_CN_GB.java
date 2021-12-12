/*
 * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
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
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import sun.nio.cs.*;
import sun.nio.cs.HistoricallyNamedCharset;

public class ISO2022_CN_GB extends ISO2022 implements HistoricallyNamedCharset
{
    public ISO2022_CN_GB() {
        super("x-ISO-2022-CN-GB",
               ExtendedCharsets.aliasesFor("x-ISO-2022-CN-GB"));
    }

    public boolean contains(Charset cs) {
        // overlapping repertoire of EUC_CN, GB2312
        return ((cs instanceof EUC_CN) ||
                (cs.name().equals("US-ASCII")) ||
                (cs instanceof ISO2022_CN_GB));
    }

    public String historicalName() {
        return "ISO2022CN_GB";
    }

    public CharsetDecoder newDecoder() {
        return new ISO2022_CN.Decoder(this);
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    private static class Encoder extends ISO2022.Encoder {

        private static final Charset gb2312 = new EUC_CN();

        private static final byte[] SOD = new byte[] {'$', ')', 'A' };

        public Encoder(Charset cs)
        {
            super(cs);
            SODesig = SOD;
            ISOEncoder = gb2312.newEncoder();
        }

        /*
         * Since ISO2022-CN-GB possesses a CharsetEncoder
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
