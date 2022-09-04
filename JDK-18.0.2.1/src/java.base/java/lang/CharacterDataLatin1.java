// This file was generated AUTOMATICALLY from a template file 
/*
 * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package java.lang;

import jdk.internal.vm.annotation.IntrinsicCandidate;

/** The CharacterData class encapsulates the large tables found in
    Java.lang.Character. */

class CharacterDataLatin1 extends CharacterData {

    /* The character properties are currently encoded into 32 bits in the following manner:
        1 bit   mirrored property
        4 bits  directionality property
        9 bits  signed offset used for converting case
        1 bit   if 1, adding the signed offset converts the character to lowercase
        1 bit   if 1, subtracting the signed offset converts the character to uppercase
        1 bit   if 1, this character has a titlecase equivalent (possibly itself)
        3 bits  0  may not be part of an identifier
                1  ignorable control; may continue a Unicode identifier or Java identifier
                2  may continue a Java identifier but not a Unicode identifier (unused)
                3  may continue a Unicode identifier or Java identifier
                4  is a Java whitespace character
                5  may start or continue a Java identifier;
                   may continue but not start a Unicode identifier (underscores)
                6  may start or continue a Java identifier but not a Unicode identifier ($)
                7  may start or continue a Unicode identifier or Java identifier
                Thus:
                   5, 6, 7 may start a Java identifier
                   1, 2, 3, 5, 6, 7 may continue a Java identifier
                   7 may start a Unicode identifier
                   1, 3, 5, 7 may continue a Unicode identifier
                   1 is ignorable within an identifier
                   4 is Java whitespace
        2 bits  0  this character has no numeric property
                1  adding the digit offset to the character code and then
                   masking with 0x1F will produce the desired numeric value
                2  this character has a "strange" numeric value
                3  a Java supradecimal digit: adding the digit offset to the
                   character code, then masking with 0x1F, then adding 10
                   will produce the desired numeric value
        5 bits  digit offset
        5 bits  character type

        The encoding of character properties is subject to change at any time.
     */

    int getProperties(int ch) {
        char offset = (char)ch;
        int props = A[offset];
        return props;
    }

    int getPropertiesEx(int ch) {
        char offset = (char)ch;
        int props = B[offset];
        return props;
    }

    @IntrinsicCandidate
    boolean isDigit(int ch) {
        return '0' <= ch && ch <= '9';
    }

    @IntrinsicCandidate
    boolean isLowerCase(int ch) {
        return (getPropertiesEx(ch) & 0x0001) != 0;
    }

    @IntrinsicCandidate
    boolean isUpperCase(int ch) {
        return (getPropertiesEx(ch) & 0x0002) != 0;
    }

    boolean isOtherAlphabetic(int ch) {
        int props = getPropertiesEx(ch);
        return (props & 0x0004) != 0;
    }

    boolean isIdeographic(int ch) {
        int props = getPropertiesEx(ch);
        return (props & 0x0008) != 0;
    }

    int getType(int ch) {
        int props = getProperties(ch);
        return (props & 0x1F);
    }

    boolean isJavaIdentifierStart(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00007000) >= 0x00005000);
    }

    boolean isJavaIdentifierPart(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00003000) != 0);
    }

    boolean isUnicodeIdentifierStart(int ch) {
        return (getPropertiesEx(ch) & 0x0010) != 0;
    }

    boolean isUnicodeIdentifierPart(int ch) {
        return (getPropertiesEx(ch) & 0x0020) != 0 ||
               isIdentifierIgnorable(ch);
    }

    boolean isIdentifierIgnorable(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00007000) == 0x00001000);
    }

    int toLowerCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if (((val & 0x00020000) != 0) && 
                ((val & 0x07FC0000) != 0x07FC0000)) { 
            int offset = val << 5 >> (5+18);
            mapChar = ch + offset;
        }
        return mapChar;
    }

    int toUpperCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00010000) != 0) {
            if ((val & 0x07FC0000) != 0x07FC0000) {
                int offset = val  << 5 >> (5+18);
                mapChar =  ch - offset;
            } else if (ch == 0x00B5) {
                mapChar = 0x039C;
            }
        }
        return mapChar;
    }

    int toTitleCase(int ch) {
        return toUpperCase(ch);
    }

    // Digit values for codePoints in the 0-255 range. Contents generated using:
    // for (char i = 0; i < 256; i++) {
    //     int v = -1;
    //     if (i >= '0' && i <= '9') { v = i - '0'; } 
    //     else if (i >= 'A' && i <= 'Z') { v = i - 'A' + 10; }
    //     else if (i >= 'a' && i <= 'z') { v = i - 'a' + 10; }
    //     if (i % 20 == 0) System.out.println();
    //     System.out.printf("%2d, ", v);
    // }
    //
    // Analysis has shown that generating the whole array allows the JIT to generate
    // better code compared to a slimmed down array, such as one cutting off after 'z'
    private static final byte[] DIGITS = new byte[] {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, -1, -1,
        -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
        25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1, -1, 10, 11, 12,
        13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
        33, 34, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

    int digit(int ch, int radix) {
        int value = DIGITS[ch];
        return (value >= 0 && value < radix && radix >= Character.MIN_RADIX
                && radix <= Character.MAX_RADIX) ? value : -1;
    }

    int getNumericValue(int ch) {
        int val = getProperties(ch);
        int retval = -1;

        switch (val & 0xC00) {
            default: // cannot occur
            case (0x00000000):         // not numeric
                retval = -1;
                break;
            case (0x00000400):              // simple numeric
                retval = ch + ((val & 0x3E0) >> 5) & 0x1F;
                break;
            case (0x00000800)      :       // "strange" numeric
                 retval = -2; 
                 break;
            case (0x00000C00):           // Java supradecimal
                retval = (ch + ((val & 0x3E0) >> 5) & 0x1F) + 10;
                break;
        }
        return retval;
    }

    @IntrinsicCandidate
    boolean isWhitespace(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00007000) == 0x00004000);
    }

    byte getDirectionality(int ch) {
        int val = getProperties(ch);
        byte directionality = (byte)((val & 0x78000000) >> 27);

        if (directionality == 0xF ) {
            directionality = -1;
        }
        return directionality;
    }

    boolean isMirrored(int ch) {
        int props = getProperties(ch);
        return ((props & 0x80000000) != 0);
    }

    int toUpperCaseEx(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00010000) != 0) {
            if ((val & 0x07FC0000) != 0x07FC0000) {
                int offset = val  << 5 >> (5+18);
                mapChar =  ch - offset;
            }
            else {
                switch(ch) {
                    // map overflow characters
                    case 0x00B5 : mapChar = 0x039C; break;
                    default       : mapChar = Character.ERROR; break;
                }
            }
        }
        return mapChar;
    }

    static char[] sharpsMap = new char[] {'S', 'S'};

    char[] toUpperCaseCharArray(int ch) {
        char[] upperMap = {(char)ch};
        if (ch == 0x00DF) {
            upperMap = sharpsMap;
        }
        return upperMap;
    }

    static final CharacterDataLatin1 instance = new CharacterDataLatin1();
    private CharacterDataLatin1() {};

    // The A table has 256 entries for a total of 1024 bytes.

  static final int A[] = {
    0x4800100F,  //   0   Cc, ignorable
    0x4800100F,  //   1   Cc, ignorable
    0x4800100F,  //   2   Cc, ignorable
    0x4800100F,  //   3   Cc, ignorable
    0x4800100F,  //   4   Cc, ignorable
    0x4800100F,  //   5   Cc, ignorable
    0x4800100F,  //   6   Cc, ignorable
    0x4800100F,  //   7   Cc, ignorable
    0x4800100F,  //   8   Cc, ignorable
    0x5800400F,  //   9   Cc, S, whitespace
    0x5000400F,  //  10   Cc, B, whitespace
    0x5800400F,  //  11   Cc, S, whitespace
    0x6000400F,  //  12   Cc, WS, whitespace
    0x5000400F,  //  13   Cc, B, whitespace
    0x4800100F,  //  14   Cc, ignorable
    0x4800100F,  //  15   Cc, ignorable
    0x4800100F,  //  16   Cc, ignorable
    0x4800100F,  //  17   Cc, ignorable
    0x4800100F,  //  18   Cc, ignorable
    0x4800100F,  //  19   Cc, ignorable
    0x4800100F,  //  20   Cc, ignorable
    0x4800100F,  //  21   Cc, ignorable
    0x4800100F,  //  22   Cc, ignorable
    0x4800100F,  //  23   Cc, ignorable
    0x4800100F,  //  24   Cc, ignorable
    0x4800100F,  //  25   Cc, ignorable
    0x4800100F,  //  26   Cc, ignorable
    0x4800100F,  //  27   Cc, ignorable
    0x5000400F,  //  28   Cc, B, whitespace
    0x5000400F,  //  29   Cc, B, whitespace
    0x5000400F,  //  30   Cc, B, whitespace
    0x5800400F,  //  31   Cc, S, whitespace
    0x6000400C,  //  32   Zs, WS, whitespace
    0x68000018,  //  33   Po, ON
    0x68000018,  //  34   Po, ON
    0x28000018,  //  35   Po, ET
    0x2800601A,  //  36   Sc, ET, currency
    0x28000018,  //  37   Po, ET
    0x68000018,  //  38   Po, ON
    0x68000018,  //  39   Po, ON
    -0x17FFFFEB,  //  40   No, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    -0x17FFFFEA,  //  41   Nl, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x68000018,  //  42   Po, ON
    0x20000019,  //  43   Sm, ES
    0x38000018,  //  44   Po, CS
    0x20000014,  //  45   Pd, ES
    0x38000018,  //  46   Po, CS
    0x38000018,  //  47   Po, CS
    -0xE7FFC9F7,  //  48   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    -0xE7FFC9F7,  //  49   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    -0xE7FFC9F7,  //  50   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    -0xE7FFC9F7,  //  51   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    -0xE7FFC9F7,  //  52   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    -0xE7FFC9F7,  //  53   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    -0xE7FFC9F7,  //  54   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    -0xE7FFC9F7,  //  55   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    -0xE7FFC9F7,  //  56   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    -0xE7FFC9F7,  //  57   Pc, WS, hasUpper (subtract 511), hasLower (add 511), hasTitle, whitespace, strange
    0x38000018,  //  58   Po, CS
    0x68000018,  //  59   Po, ON
    -0x17FFFFE7,  //  60   Me, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x68000019,  //  61   Sm, ON
    -0x17FFFFE7,  //  62   Me, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x68000018,  //  63   Po, ON
    0x68000018,  //  64   Po, ON
    -0xFF7D801F,  //  65   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  66   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  67   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  68   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  69   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  70   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  71   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  72   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  73   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  74   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  75   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  76   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  77   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  78   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  79   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  80   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  81   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  82   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  83   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  84   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  85   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  86   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  87   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  88   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  89   , hasUpper (subtract 479), hasTitle
    -0xFF7D801F,  //  90   , hasUpper (subtract 479), hasTitle
    -0x17FFFFEB,  //  91   No, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x68000018,  //  92   Po, ON
    -0x17FFFFEA,  //  93   Nl, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x6800001B,  //  94   Sk, ON
    -0x97FFAFE9,  //  95   Nd, hasUpper (subtract 511), hasLower (add 511), hasTitle, supradecimal 31
    0x6800001B,  //  96   Sk, ON
    -0xFF7E801E,  //  97   , hasLower (add 479), hasTitle
    -0xFF7E801E,  //  98   , hasLower (add 479), hasTitle
    -0xFF7E801E,  //  99   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 100   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 101   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 102   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 103   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 104   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 105   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 106   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 107   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 108   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 109   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 110   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 111   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 112   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 113   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 114   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 115   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 116   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 117   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 118   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 119   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 120   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 121   , hasLower (add 479), hasTitle
    -0xFF7E801E,  // 122   , hasLower (add 479), hasTitle
    -0x17FFFFEB,  // 123   No, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x68000019,  // 124   Sm, ON
    -0x17FFFFEA,  // 125   Nl, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x68000019,  // 126   Sm, ON
    0x4800100F,  // 127   Cc, ignorable
    0x4800100F,  // 128   Cc, ignorable
    0x4800100F,  // 129   Cc, ignorable
    0x4800100F,  // 130   Cc, ignorable
    0x4800100F,  // 131   Cc, ignorable
    0x4800100F,  // 132   Cc, ignorable
    0x5000100F,  // 133   Cc, B, ignorable
    0x4800100F,  // 134   Cc, ignorable
    0x4800100F,  // 135   Cc, ignorable
    0x4800100F,  // 136   Cc, ignorable
    0x4800100F,  // 137   Cc, ignorable
    0x4800100F,  // 138   Cc, ignorable
    0x4800100F,  // 139   Cc, ignorable
    0x4800100F,  // 140   Cc, ignorable
    0x4800100F,  // 141   Cc, ignorable
    0x4800100F,  // 142   Cc, ignorable
    0x4800100F,  // 143   Cc, ignorable
    0x4800100F,  // 144   Cc, ignorable
    0x4800100F,  // 145   Cc, ignorable
    0x4800100F,  // 146   Cc, ignorable
    0x4800100F,  // 147   Cc, ignorable
    0x4800100F,  // 148   Cc, ignorable
    0x4800100F,  // 149   Cc, ignorable
    0x4800100F,  // 150   Cc, ignorable
    0x4800100F,  // 151   Cc, ignorable
    0x4800100F,  // 152   Cc, ignorable
    0x4800100F,  // 153   Cc, ignorable
    0x4800100F,  // 154   Cc, ignorable
    0x4800100F,  // 155   Cc, ignorable
    0x4800100F,  // 156   Cc, ignorable
    0x4800100F,  // 157   Cc, ignorable
    0x4800100F,  // 158   Cc, ignorable
    0x4800100F,  // 159   Cc, ignorable
    0x3800000C,  // 160   Zs, CS
    0x68000018,  // 161   Po, ON
    0x2800601A,  // 162   Sc, ET, currency
    0x2800601A,  // 163   Sc, ET, currency
    0x2800601A,  // 164   Sc, ET, currency
    0x2800601A,  // 165   Sc, ET, currency
    0x6800001C,  // 166   So, ON
    0x68000018,  // 167   Po, ON
    0x6800001B,  // 168   Sk, ON
    0x6800001C,  // 169   So, ON
    -0xFFFF8FFB,  // 170   Sk, hasUpper (subtract 511), hasLower (add 511), hasTitle, supradecimal 31
    -0x17FFFFE3,  // 171   Lt, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x68000019,  // 172   Sm, ON
    0x48001010,  // 173   Cf, ignorable
    0x6800001C,  // 174   So, ON
    0x6800001B,  // 175   Sk, ON
    0x2800001C,  // 176   So, ET
    0x28000019,  // 177   Sm, ET
    0x1800060B,  // 178   No, EN, decimal 16
    0x1800060B,  // 179   No, EN, decimal 16
    0x6800001B,  // 180   Sk, ON
    -0xF8028FFE,  // 181   , hasLower (add 0), hasTitle, supradecimal 31
    0x68000018,  // 182   Po, ON
    -0x97FFFFE8,  // 183   Mc, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x6800001B,  // 184   Sk, ON
    0x1800050B,  // 185   No, EN, decimal 8
    -0xFFFF8FFB,  // 186   Sk, hasUpper (subtract 511), hasLower (add 511), hasTitle, supradecimal 31
    -0x17FFFFE2,  // 187   Ll, hasUpper (subtract 511), hasLower (add 511), hasTitle, identifier start, supradecimal 31
    0x6800080B,  // 188   No, ON, strange
    0x6800080B,  // 189   No, ON, strange
    0x6800080B,  // 190   No, ON, strange
    0x68000018,  // 191   Po, ON
    -0xFF7D8FFF,  // 192   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 193   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 194   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 195   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 196   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 197   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 198   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 199   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 200   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 201   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 202   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 203   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 204   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 205   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 206   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 207   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 208   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 209   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 210   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 211   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 212   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 213   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 214   , hasUpper (subtract 479), hasTitle, supradecimal 31
    0x68000019,  // 215   Sm, ON
    -0xFF7D8FFF,  // 216   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 217   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 218   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 219   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 220   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 221   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xFF7D8FFF,  // 222   , hasUpper (subtract 479), hasTitle, supradecimal 31
    -0xF8028FFE,  // 223   , hasLower (add 0), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 224   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 225   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 226   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 227   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 228   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 229   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 230   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 231   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 232   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 233   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 234   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 235   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 236   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 237   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 238   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 239   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 240   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 241   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 242   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 243   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 244   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 245   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 246   , hasLower (add 479), hasTitle, supradecimal 31
    0x68000019,  // 247   Sm, ON
    -0xFF7E8FFE,  // 248   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 249   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 250   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 251   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 252   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 253   , hasLower (add 479), hasTitle, supradecimal 31
    -0xFF7E8FFE,  // 254   , hasLower (add 479), hasTitle, supradecimal 31
    -0xF9E28FFE   // 255   , hasLower (add 120), hasTitle, supradecimal 31
  };

  // The B table has 256 entries for a total of 256 bytes.

  static final byte B[] = {
    0x00,  //   0   unassigned, L
    0x00,  //   1   unassigned, L
    0x00,  //   2   unassigned, L
    0x00,  //   3   unassigned, L
    0x00,  //   4   unassigned, L
    0x00,  //   5   unassigned, L
    0x00,  //   6   unassigned, L
    0x00,  //   7   unassigned, L
    0x00,  //   8   unassigned, L
    0x00,  //   9   unassigned, L
    0x00,  //  10   unassigned, L
    0x00,  //  11   unassigned, L
    0x00,  //  12   unassigned, L
    0x00,  //  13   unassigned, L
    0x00,  //  14   unassigned, L
    0x00,  //  15   unassigned, L
    0x00,  //  16   unassigned, L
    0x00,  //  17   unassigned, L
    0x00,  //  18   unassigned, L
    0x00,  //  19   unassigned, L
    0x00,  //  20   unassigned, L
    0x00,  //  21   unassigned, L
    0x00,  //  22   unassigned, L
    0x00,  //  23   unassigned, L
    0x00,  //  24   unassigned, L
    0x00,  //  25   unassigned, L
    0x00,  //  26   unassigned, L
    0x00,  //  27   unassigned, L
    0x00,  //  28   unassigned, L
    0x00,  //  29   unassigned, L
    0x00,  //  30   unassigned, L
    0x00,  //  31   unassigned, L
    0x00,  //  32   unassigned, L
    0x00,  //  33   unassigned, L
    0x00,  //  34   unassigned, L
    0x00,  //  35   unassigned, L
    0x00,  //  36   unassigned, L
    0x00,  //  37   unassigned, L
    0x00,  //  38   unassigned, L
    0x00,  //  39   unassigned, L
    0x00,  //  40   unassigned, L
    0x00,  //  41   unassigned, L
    0x00,  //  42   unassigned, L
    0x00,  //  43   unassigned, L
    0x00,  //  44   unassigned, L
    0x00,  //  45   unassigned, L
    0x00,  //  46   unassigned, L
    0x00,  //  47   unassigned, L
    0x20,  //  48   unassigned, L
    0x20,  //  49   unassigned, L
    0x20,  //  50   unassigned, L
    0x20,  //  51   unassigned, L
    0x20,  //  52   unassigned, L
    0x20,  //  53   unassigned, L
    0x20,  //  54   unassigned, L
    0x20,  //  55   unassigned, L
    0x20,  //  56   unassigned, L
    0x20,  //  57   unassigned, L
    0x00,  //  58   unassigned, L
    0x00,  //  59   unassigned, L
    0x00,  //  60   unassigned, L
    0x00,  //  61   unassigned, L
    0x00,  //  62   unassigned, L
    0x00,  //  63   unassigned, L
    0x00,  //  64   unassigned, L
    0x32,  //  65   unassigned, L
    0x32,  //  66   unassigned, L
    0x32,  //  67   unassigned, L
    0x32,  //  68   unassigned, L
    0x32,  //  69   unassigned, L
    0x32,  //  70   unassigned, L
    0x32,  //  71   unassigned, L
    0x32,  //  72   unassigned, L
    0x32,  //  73   unassigned, L
    0x32,  //  74   unassigned, L
    0x32,  //  75   unassigned, L
    0x32,  //  76   unassigned, L
    0x32,  //  77   unassigned, L
    0x32,  //  78   unassigned, L
    0x32,  //  79   unassigned, L
    0x32,  //  80   unassigned, L
    0x32,  //  81   unassigned, L
    0x32,  //  82   unassigned, L
    0x32,  //  83   unassigned, L
    0x32,  //  84   unassigned, L
    0x32,  //  85   unassigned, L
    0x32,  //  86   unassigned, L
    0x32,  //  87   unassigned, L
    0x32,  //  88   unassigned, L
    0x32,  //  89   unassigned, L
    0x32,  //  90   unassigned, L
    0x00,  //  91   unassigned, L
    0x00,  //  92   unassigned, L
    0x00,  //  93   unassigned, L
    0x00,  //  94   unassigned, L
    0x20,  //  95   unassigned, L
    0x00,  //  96   unassigned, L
    0x31,  //  97   unassigned, L
    0x31,  //  98   unassigned, L
    0x31,  //  99   unassigned, L
    0x31,  // 100   unassigned, L
    0x31,  // 101   unassigned, L
    0x31,  // 102   unassigned, L
    0x31,  // 103   unassigned, L
    0x31,  // 104   unassigned, L
    0x31,  // 105   unassigned, L
    0x31,  // 106   unassigned, L
    0x31,  // 107   unassigned, L
    0x31,  // 108   unassigned, L
    0x31,  // 109   unassigned, L
    0x31,  // 110   unassigned, L
    0x31,  // 111   unassigned, L
    0x31,  // 112   unassigned, L
    0x31,  // 113   unassigned, L
    0x31,  // 114   unassigned, L
    0x31,  // 115   unassigned, L
    0x31,  // 116   unassigned, L
    0x31,  // 117   unassigned, L
    0x31,  // 118   unassigned, L
    0x31,  // 119   unassigned, L
    0x31,  // 120   unassigned, L
    0x31,  // 121   unassigned, L
    0x31,  // 122   unassigned, L
    0x00,  // 123   unassigned, L
    0x00,  // 124   unassigned, L
    0x00,  // 125   unassigned, L
    0x00,  // 126   unassigned, L
    0x00,  // 127   unassigned, L
    0x00,  // 128   unassigned, L
    0x00,  // 129   unassigned, L
    0x00,  // 130   unassigned, L
    0x00,  // 131   unassigned, L
    0x00,  // 132   unassigned, L
    0x00,  // 133   unassigned, L
    0x00,  // 134   unassigned, L
    0x00,  // 135   unassigned, L
    0x00,  // 136   unassigned, L
    0x00,  // 137   unassigned, L
    0x00,  // 138   unassigned, L
    0x00,  // 139   unassigned, L
    0x00,  // 140   unassigned, L
    0x00,  // 141   unassigned, L
    0x00,  // 142   unassigned, L
    0x00,  // 143   unassigned, L
    0x00,  // 144   unassigned, L
    0x00,  // 145   unassigned, L
    0x00,  // 146   unassigned, L
    0x00,  // 147   unassigned, L
    0x00,  // 148   unassigned, L
    0x00,  // 149   unassigned, L
    0x00,  // 150   unassigned, L
    0x00,  // 151   unassigned, L
    0x00,  // 152   unassigned, L
    0x00,  // 153   unassigned, L
    0x00,  // 154   unassigned, L
    0x00,  // 155   unassigned, L
    0x00,  // 156   unassigned, L
    0x00,  // 157   unassigned, L
    0x00,  // 158   unassigned, L
    0x00,  // 159   unassigned, L
    0x00,  // 160   unassigned, L
    0x00,  // 161   unassigned, L
    0x00,  // 162   unassigned, L
    0x00,  // 163   unassigned, L
    0x00,  // 164   unassigned, L
    0x00,  // 165   unassigned, L
    0x00,  // 166   unassigned, L
    0x00,  // 167   unassigned, L
    0x00,  // 168   unassigned, L
    0x00,  // 169   unassigned, L
    0x31,  // 170   unassigned, L
    0x00,  // 171   unassigned, L
    0x00,  // 172   unassigned, L
    0x00,  // 173   unassigned, L
    0x00,  // 174   unassigned, L
    0x00,  // 175   unassigned, L
    0x00,  // 176   unassigned, L
    0x00,  // 177   unassigned, L
    0x00,  // 178   unassigned, L
    0x00,  // 179   unassigned, L
    0x00,  // 180   unassigned, L
    0x31,  // 181   unassigned, L
    0x00,  // 182   unassigned, L
    0x20,  // 183   unassigned, L
    0x00,  // 184   unassigned, L
    0x00,  // 185   unassigned, L
    0x31,  // 186   unassigned, L
    0x00,  // 187   unassigned, L
    0x00,  // 188   unassigned, L
    0x00,  // 189   unassigned, L
    0x00,  // 190   unassigned, L
    0x00,  // 191   unassigned, L
    0x32,  // 192   unassigned, L
    0x32,  // 193   unassigned, L
    0x32,  // 194   unassigned, L
    0x32,  // 195   unassigned, L
    0x32,  // 196   unassigned, L
    0x32,  // 197   unassigned, L
    0x32,  // 198   unassigned, L
    0x32,  // 199   unassigned, L
    0x32,  // 200   unassigned, L
    0x32,  // 201   unassigned, L
    0x32,  // 202   unassigned, L
    0x32,  // 203   unassigned, L
    0x32,  // 204   unassigned, L
    0x32,  // 205   unassigned, L
    0x32,  // 206   unassigned, L
    0x32,  // 207   unassigned, L
    0x32,  // 208   unassigned, L
    0x32,  // 209   unassigned, L
    0x32,  // 210   unassigned, L
    0x32,  // 211   unassigned, L
    0x32,  // 212   unassigned, L
    0x32,  // 213   unassigned, L
    0x32,  // 214   unassigned, L
    0x00,  // 215   unassigned, L
    0x32,  // 216   unassigned, L
    0x32,  // 217   unassigned, L
    0x32,  // 218   unassigned, L
    0x32,  // 219   unassigned, L
    0x32,  // 220   unassigned, L
    0x32,  // 221   unassigned, L
    0x32,  // 222   unassigned, L
    0x31,  // 223   unassigned, L
    0x31,  // 224   unassigned, L
    0x31,  // 225   unassigned, L
    0x31,  // 226   unassigned, L
    0x31,  // 227   unassigned, L
    0x31,  // 228   unassigned, L
    0x31,  // 229   unassigned, L
    0x31,  // 230   unassigned, L
    0x31,  // 231   unassigned, L
    0x31,  // 232   unassigned, L
    0x31,  // 233   unassigned, L
    0x31,  // 234   unassigned, L
    0x31,  // 235   unassigned, L
    0x31,  // 236   unassigned, L
    0x31,  // 237   unassigned, L
    0x31,  // 238   unassigned, L
    0x31,  // 239   unassigned, L
    0x31,  // 240   unassigned, L
    0x31,  // 241   unassigned, L
    0x31,  // 242   unassigned, L
    0x31,  // 243   unassigned, L
    0x31,  // 244   unassigned, L
    0x31,  // 245   unassigned, L
    0x31,  // 246   unassigned, L
    0x00,  // 247   unassigned, L
    0x31,  // 248   unassigned, L
    0x31,  // 249   unassigned, L
    0x31,  // 250   unassigned, L
    0x31,  // 251   unassigned, L
    0x31,  // 252   unassigned, L
    0x31,  // 253   unassigned, L
    0x31,  // 254   unassigned, L
    0x31   // 255   unassigned, L
  };

  // In all, the character property tables require 1024 bytes.

    static {
        
    }
}

