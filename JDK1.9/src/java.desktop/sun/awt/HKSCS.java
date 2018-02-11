/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharsetDecoder;

/* 2d/XMap and WFontConfiguration implementation need access HKSCS,
   make a subclass here to avoid expose HKSCS to the public in
   ExtendedCharsets class, because if we want to have a public HKSCS,
   it probably should be HKSCS_2001 not HKSCS.
*/
public class HKSCS extends Charset {
    private static Charset cs = Charset.forName("x-MS950-HKSCS-XP");

    public HKSCS () {
        super("HKSCS", null);
    }
    public boolean contains(Charset cs) {
        return (cs instanceof HKSCS);
    }

    public CharsetDecoder newDecoder() {
        return cs.newDecoder();
    }

    public CharsetEncoder newEncoder() {
        return cs.newEncoder();
    }
}
