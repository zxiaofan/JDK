/*
 * Copyright (c) 2010, 2021, Oracle and/or its affiliates. All rights reserved.
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
import sun.nio.cs.HKSCS;
import sun.nio.cs.HistoricallyNamedCharset;
import sun.nio.cs.*;
import static sun.nio.cs.CharsetMapping.*;

public class Big5_HKSCS extends Charset implements HistoricallyNamedCharset
{
    public Big5_HKSCS() {
        super("Big5-HKSCS", ExtendedCharsets.aliasesFor("Big5-HKSCS"));
    }

    public String historicalName() {
        return "Big5_HKSCS";
    }

    public boolean contains(Charset cs) {
        return ((cs.name().equals("US-ASCII"))
                || (cs instanceof Big5)
                || (cs instanceof Big5_HKSCS));
    }

    public CharsetDecoder newDecoder() {
        return new Decoder(this);
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    static class Decoder extends HKSCS.Decoder {
        private static final DoubleByte.Decoder big5 =
            (DoubleByte.Decoder)new Big5().newDecoder();

        private static final char[][] b2cBmp = new char[0x100][];
        private static final char[][] b2cSupp = new char[0x100][];
        static {
            initb2c(b2cBmp, HKSCSMapping.b2cBmpStr);
            initb2c(b2cSupp, HKSCSMapping.b2cSuppStr);
        }

        private Decoder(Charset cs) {
            super(cs, big5, b2cBmp, b2cSupp);
        }
    }

    static class Encoder extends HKSCS.Encoder {
        private static final DoubleByte.Encoder big5 =
            (DoubleByte.Encoder)new Big5().newEncoder();

        static final char[][] c2bBmp = new char[0x100][];
        static final char[][] c2bSupp = new char[0x100][];
        static {
            initc2b(c2bBmp, HKSCSMapping.b2cBmpStr, HKSCSMapping.pua);
            initc2b(c2bSupp, HKSCSMapping.b2cSuppStr, null);
        }

        private Encoder(Charset cs) {
            super(cs, big5, c2bBmp, c2bSupp);
        }
    }
}
