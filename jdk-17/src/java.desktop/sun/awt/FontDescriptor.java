/*
 * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class FontDescriptor implements Cloneable {

    static {
        NativeLibLoader.loadLibraries();
        initIDs();
    }

    String nativeName;
    public CharsetEncoder encoder;
    String charsetName;
    private int[] exclusionRanges;

    public FontDescriptor(String nativeName, CharsetEncoder encoder,
                          int[] exclusionRanges){

        this.nativeName = nativeName;
        this.encoder = encoder;
        this.exclusionRanges = exclusionRanges;
        this.useUnicode = false;
        Charset cs = encoder.charset();
        // The following looks odd but its the only public way to get the
        // historical name if one exists and the canonical name otherwise.
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new ByteArrayOutputStream(), cs);
            this.charsetName = osw.getEncoding();
            osw.close();
        } catch (IOException ioe) {
        }
    }

    public String getNativeName() {
        return nativeName;
    }

    public CharsetEncoder getFontCharsetEncoder() {
        return encoder;
    }

    public String getFontCharsetName() {
        return charsetName;
    }

    public int[] getExclusionRanges() {
        return exclusionRanges;
    }

    /**
     * Return true if the character is exclusion character.
     */
    public boolean isExcluded(char ch){
        for (int i = 0; i < exclusionRanges.length; ){

            int lo = (exclusionRanges[i++]);
            int up = (exclusionRanges[i++]);

            if (ch >= lo && ch <= up){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return super.toString() + " [" + nativeName + "|" + encoder + "]";
    }

    /**
     * Initialize JNI field and method IDs
     */
    private static native void initIDs();


    public CharsetEncoder unicodeEncoder;
    boolean useUnicode; // set to true from native code on Unicode-based systems

    public boolean useUnicode() {
        if (useUnicode && unicodeEncoder == null) {
            try {
                this.unicodeEncoder = isLE?
                    StandardCharsets.UTF_16LE.newEncoder():
                    StandardCharsets.UTF_16BE.newEncoder();
            } catch (IllegalArgumentException x) {}
        }
        return useUnicode;
    }
    static boolean isLE;
    static {
        @SuppressWarnings("removal")
        String enc = java.security.AccessController.doPrivileged(
           new sun.security.action.GetPropertyAction("sun.io.unicode.encoding",
                                                          "UnicodeBig"));
        isLE = !"UnicodeBig".equals(enc);
    }
}
