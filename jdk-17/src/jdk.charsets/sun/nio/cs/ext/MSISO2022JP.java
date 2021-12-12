/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

public class MSISO2022JP extends ISO2022_JP
{
    public MSISO2022JP() {
        super("x-windows-iso2022jp",
              ExtendedCharsets.aliasesFor("x-windows-iso2022jp"));
    }

    public String historicalName() {
        return "windows-iso2022jp";
    }

    public boolean contains(Charset cs) {
      return super.contains(cs) ||
             (cs instanceof MSISO2022JP);
    }

    public CharsetDecoder newDecoder() {
        return new Decoder(this, CoderHolder.DEC0208, null);
    }

    public CharsetEncoder newEncoder() {
        return new Encoder(this, CoderHolder.ENC0208, null, true);
    }

    private static class CoderHolder {
        static final DoubleByte.Decoder DEC0208 =
            (DoubleByte.Decoder)new JIS_X_0208_MS932().newDecoder();
        static final DoubleByte.Encoder ENC0208 =
            (DoubleByte.Encoder)new JIS_X_0208_MS932().newEncoder();
    }
}
