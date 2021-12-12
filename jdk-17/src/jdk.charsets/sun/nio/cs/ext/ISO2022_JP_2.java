/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
import sun.nio.cs.*;

public class ISO2022_JP_2 extends ISO2022_JP
{
    public ISO2022_JP_2() {
        super("ISO-2022-JP-2",
              ExtendedCharsets.aliasesFor("ISO-2022-JP-2"));
    }

    public String historicalName() {
        return "ISO2022JP2";
    }

    public boolean contains(Charset cs) {
      return super.contains(cs) ||
             (cs instanceof JIS_X_0212) ||
             (cs instanceof ISO2022_JP_2);
    }

    public CharsetDecoder newDecoder() {
        return new Decoder(this, Decoder.DEC0208, CoderHolder.DEC0212);
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this, Encoder.ENC0208, CoderHolder.ENC0212, true);
    }

    private static class CoderHolder {
        static final DoubleByte.Decoder DEC0212 =
            (DoubleByte.Decoder)new JIS_X_0212().newDecoder();
        static final DoubleByte.Encoder ENC0212 =
            (DoubleByte.Encoder)new JIS_X_0212().newEncoder();
    }
}
