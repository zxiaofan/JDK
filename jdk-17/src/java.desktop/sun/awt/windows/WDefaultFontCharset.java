/*
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
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
package sun.awt.windows;

import java.nio.charset.*;
import sun.awt.AWTCharset;

final class WDefaultFontCharset extends AWTCharset
{
    static {
       initIDs();
    }

    // Name for Windows FontSet.
    private String fontName;

    WDefaultFontCharset(String name){
        super("WDefaultFontCharset", Charset.forName("windows-1252"));
        fontName = name;
    }

    @Override
    public CharsetEncoder newEncoder() {
        return new Encoder();
    }

    private class Encoder extends AWTCharset.Encoder {
        @Override
        public boolean canEncode(char c){
            return canConvert(c);
        }
    }

    private synchronized native boolean canConvert(char ch);

    /**
     * Initialize JNI field and method IDs
     */
    private static native void initIDs();
}
