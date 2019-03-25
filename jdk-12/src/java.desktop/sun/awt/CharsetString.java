/*
 * Copyright (c) 1996, 2018, Oracle and/or its affiliates. All rights reserved.
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

public class CharsetString {
    /**
     * chars for this string.  See also offset, length.
     */
    public char[] charsetChars;

    /**
     * Offset within charsetChars of first character
    **/
    public int offset;

    /**
     * Length of the string we represent.
    **/
    public int length;

    /**
     * This string's FontDescriptor.
     */
    public FontDescriptor fontDescriptor;

    /**
     * Creates a new CharsetString
     */
    public CharsetString(char[] charsetChars, int offset, int length,
                         FontDescriptor fontDescriptor){

        this.charsetChars = charsetChars;
        this.offset = offset;
        this.length = length;
        this.fontDescriptor = fontDescriptor;
    }
}
