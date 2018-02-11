/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * @(#)ASCIIUtility.java      1.9 02/03/27
 */


package com.sun.xml.internal.messaging.saaj.packaging.mime.util;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;
import java.io.InputStream;

public class ASCIIUtility {

    // Private constructor so that this class is not instantiated
    private ASCIIUtility() {
    }


    /**
     * Convert the bytes within the specified range of the given byte
     * array into a signed integer in the given radix . The range extends
     * from <code>start</code> till, but not including <code>end</code>.
     *
     * Based on java.lang.Integer.parseInt().
     *
     * @param b     bytes to convert to integer.
     * @param start start of the range.
     * @param end   end of the range (not including).
     * @param radix radix.
     * @return integer.
     */
    public static int parseInt(byte[] b, int start, int end, int radix)
            throws NumberFormatException {
        if (b == null)
            throw new NumberFormatException("null");

        int result = 0;
        boolean negative = false;
        int i = start;
        int limit;
        int multmin;
        int digit;

        if (end > start) {
            if (b[i] == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;
                i++;
            } else {
                limit = -Integer.MAX_VALUE;
            }
            multmin = limit / radix;
            if (i < end) {
                digit = Character.digit((char) b[i++], radix);
                if (digit < 0) {
                    throw new NumberFormatException(
                            "illegal number: " + toString(b, start, end)
                    );
                } else {
                    result = -digit;
                }
            }
            while (i < end) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit((char) b[i++], radix);
                if (digit < 0) {
                    throw new NumberFormatException("illegal number");
                }
                if (result < multmin) {
                    throw new NumberFormatException("illegal number");
                }
                result *= radix;
                if (result < limit + digit) {
                    throw new NumberFormatException("illegal number");
                }
                result -= digit;
            }
        } else {
            throw new NumberFormatException("illegal number");
        }
        if (negative) {
            if (i > start + 1) {
                return result;
            } else {    /* Only got "-" */
                throw new NumberFormatException("illegal number");
            }
        } else {
            return -result;
        }
    }

    /**
     * Convert the bytes within the specified range of the given byte
     * array into a String. The range extends from <code>start</code>
     * till, but not including <code>end</code>.
     *
     * @param b     bytes to convert to integer.
     * @param start start of the range.
     * @param end   end of the range (not including).
     * @return integer.
     */
    public static String toString(byte[] b, int start, int end) {
        int size = end - start;
        char[] theChars = new char[size];

        for (int i = 0, j = start; i < size; )
            theChars[i++] = (char) (b[j++] & 0xff);

        return new String(theChars);
    }

    /**
     * Encodes specified String into a sequence of bytes using the platform's
     * default charset, storing the result into a new byte array.
     *
     * @param s string to encode into byte array.
     * @return byte array.
     */
    public static byte[] getBytes(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        byte[] bytes = new byte[size];

        for (int i = 0; i < size; )
            bytes[i] = (byte) chars[i++];
        return bytes;
    }

    /**
     * Converts input stream to array.
     *
     * @param is stream to convert to array.
     * @return byte array.
     * @throws IOException if an I/O error occurs.
     * @deprecated this is an expensive operation that require an additional
     * buffer reallocation just to get the array of an exact size.
     * Unless you absolutely need the exact size array, don't use this.
     * Use {@link ByteOutputStream} and {@link ByteOutputStream#write(InputStream)}.
     */
    @Deprecated
    public static byte[] getBytes(InputStream is) throws IOException {
        ByteOutputStream bos = null;
        try {
            bos = new ByteOutputStream();
            bos.write(is);
        } finally {
            if (bos != null)
                bos.close();
            is.close();
        }
        return bos.toByteArray();
    }
}
