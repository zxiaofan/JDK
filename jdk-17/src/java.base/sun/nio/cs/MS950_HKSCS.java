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

package sun.nio.cs;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import sun.nio.cs.HistoricallyNamedCharset;
import sun.nio.cs.*;
import static sun.nio.cs.CharsetMapping.*;

public class MS950_HKSCS extends Charset implements HistoricallyNamedCharset
{
    public MS950_HKSCS() {
        super("x-MS950-HKSCS", StandardCharsets.aliases_MS950_HKSCS());
    }

    public String historicalName() {
        return "MS950_HKSCS";
    }

    public boolean contains(Charset cs) {
        return ((cs.name().equals("US-ASCII"))
                || (cs instanceof MS950)
                || (cs instanceof MS950_HKSCS));
    }

    public CharsetDecoder newDecoder() {
        return new Decoder(this);
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    static class Decoder extends HKSCS.Decoder {
        private static DoubleByte.Decoder ms950 =
            (DoubleByte.Decoder)new MS950().newDecoder();

        private static final char[][] b2cBmp = new char[0x100][];
        private static final char[][] b2cSupp = new char[0x100][];
        static {
            initb2c(b2cBmp, HKSCSMapping.b2cBmpStr);
            initb2c(b2cSupp, HKSCSMapping.b2cSuppStr);
        }

        private Decoder(Charset cs) {
            super(cs, ms950, b2cBmp, b2cSupp);
        }
    }

    private static class Encoder extends HKSCS.Encoder {
        private static DoubleByte.Encoder ms950 =
            (DoubleByte.Encoder)new MS950().newEncoder();

        static final char[][] c2bBmp = new char[0x100][];
        static final char[][] c2bSupp = new char[0x100][];
        static {
            initc2b(c2bBmp, HKSCSMapping.b2cBmpStr, HKSCSMapping.pua);
            initc2b(c2bSupp, HKSCSMapping.b2cSuppStr, null);
        }

        private Encoder(Charset cs) {
            super(cs, ms950, c2bBmp, c2bSupp);
        }
    }
}
