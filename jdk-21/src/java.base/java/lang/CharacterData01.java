// This file was generated AUTOMATICALLY from a template file 
/*
 * Copyright (c) 2003, 2023, Oracle and/or its affiliates. All rights reserved.
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

/** The CharacterData class encapsulates the large tables once found in
 *  java.lang.Character. 
 */

class CharacterData01 extends CharacterData {
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
        int props = A[Y[X[offset>>5]|((offset>>1)&0xF)]|(offset&0x1)];
        return props;
    }

    int getPropertiesEx(int ch) {
        char offset = (char)ch;
        int props = B[Y[X[offset>>5]|((offset>>1)&0xF)]|(offset&0x1)];
        return props;
    }

    int getType(int ch) {
        int props = getProperties(ch);
        return (props & 0x1F);
    }

    boolean isOtherAlphabetic(int ch) {
        int props = getPropertiesEx(ch);
        return (props & 0x0004) != 0;
    }

    boolean isIdeographic(int ch) {
        int props = getPropertiesEx(ch);
        return (props & 0x0008) != 0;
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

    boolean isEmoji(int ch) {
        return (getPropertiesEx(ch) & 0x0040) != 0;
    }

    boolean isEmojiPresentation(int ch) {
        return (getPropertiesEx(ch) & 0x0080) != 0;
    }

    boolean isEmojiModifier(int ch) {
        return (getPropertiesEx(ch) & 0x0100) != 0;
    }

    boolean isEmojiModifierBase(int ch) {
        return (getPropertiesEx(ch) & 0x0200) != 0;
    }

    boolean isEmojiComponent(int ch) {
        return (getPropertiesEx(ch) & 0x0400) != 0;
    }

    boolean isExtendedPictographic(int ch) {
        return (getPropertiesEx(ch) & 0x0800) != 0;
    }

    int toLowerCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00020000) != 0) {
            int offset = val << 5 >> (5+18);
            mapChar = ch + offset;
        }
        return  mapChar;
    }

    int toUpperCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00010000) != 0) {
            int offset = val  << 5 >> (5+18);
            mapChar =  ch - offset;
        }
        return  mapChar;
    }

    int toTitleCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00008000) != 0) {
            // There is a titlecase equivalent.  Perform further checks:
            if ((val & 0x00010000) == 0) {
                // The character does not have an uppercase equivalent, so it must
                // already be uppercase; so add 1 to get the titlecase form.
                mapChar = ch + 1;
            }
            else if ((val & 0x00020000) == 0) {
                // The character does not have a lowercase equivalent, so it must
                // already be lowercase; so subtract 1 to get the titlecase form.
                mapChar = ch - 1;
            }
            // else {
            // The character has both an uppercase equivalent and a lowercase
            // equivalent, so it must itself be a titlecase form; return it.
            // return ch;
            //}
        }
        else if ((val & 0x00010000) != 0) {
            // This character has no titlecase equivalent but it does have an
            // uppercase equivalent, so use that (subtract the signed case offset).
            mapChar = toUpperCase(ch);
        }
        return  mapChar;
    }

    int digit(int ch, int radix) {
        int value = -1;
        if (radix >= Character.MIN_RADIX && radix <= Character.MAX_RADIX) {
            int val = getProperties(ch);
            int kind = val & 0x1F;
            if (kind == Character.DECIMAL_DIGIT_NUMBER) {
                value = ch + ((val & 0x3E0) >> 5) & 0x1F;
            }
            else if ((val & 0xC00) == 0x00000C00) {
                // Java supradecimal digit
                value = (ch + ((val & 0x3E0) >> 5) & 0x1F) + 10;
            }
        }
        return (value < radix) ? value : -1;
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
            switch(ch) {
            case 0x10113: retval = 40; break;      // AEGEAN NUMBER FORTY
            case 0x10114: retval = 50; break;      // AEGEAN NUMBER FIFTY
            case 0x10115: retval = 60; break;      // AEGEAN NUMBER SIXTY
            case 0x10116: retval = 70; break;      // AEGEAN NUMBER SEVENTY
            case 0x10117: retval = 80; break;      // AEGEAN NUMBER EIGHTY
            case 0x10118: retval = 90; break;      // AEGEAN NUMBER NINETY
            case 0x10119: retval = 100; break;     // AEGEAN NUMBER ONE HUNDRED
            case 0x1011A: retval = 200; break;     // AEGEAN NUMBER TWO HUNDRED
            case 0x1011B: retval = 300; break;     // AEGEAN NUMBER THREE HUNDRED
            case 0x1011C: retval = 400; break;     // AEGEAN NUMBER FOUR HUNDRED
            case 0x1011D: retval = 500; break;     // AEGEAN NUMBER FIVE HUNDRED
            case 0x1011E: retval = 600; break;     // AEGEAN NUMBER SIX HUNDRED
            case 0x1011F: retval = 700; break;     // AEGEAN NUMBER SEVEN HUNDRED
            case 0x10120: retval = 800; break;     // AEGEAN NUMBER EIGHT HUNDRED
            case 0x10121: retval = 900; break;     // AEGEAN NUMBER NINE HUNDRED
            case 0x10122: retval = 1000; break;    // AEGEAN NUMBER ONE THOUSAND
            case 0x10123: retval = 2000; break;    // AEGEAN NUMBER TWO THOUSAND
            case 0x10124: retval = 3000; break;    // AEGEAN NUMBER THREE THOUSAND
            case 0x10125: retval = 4000; break;    // AEGEAN NUMBER FOUR THOUSAND
            case 0x10126: retval = 5000; break;    // AEGEAN NUMBER FIVE THOUSAND
            case 0x10127: retval = 6000; break;    // AEGEAN NUMBER SIX THOUSAND
            case 0x10128: retval = 7000; break;    // AEGEAN NUMBER SEVEN THOUSAND
            case 0x10129: retval = 8000; break;    // AEGEAN NUMBER EIGHT THOUSAND
            case 0x1012A: retval = 9000; break;    // AEGEAN NUMBER NINE THOUSAND
            case 0x1012B: retval = 10000; break;   // AEGEAN NUMBER TEN THOUSAND
            case 0x1012C: retval = 20000; break;   // AEGEAN NUMBER TWENTY THOUSAND
            case 0x1012D: retval = 30000; break;   // AEGEAN NUMBER THIRTY THOUSAND
            case 0x1012E: retval = 40000; break;   // AEGEAN NUMBER FORTY THOUSAND
            case 0x1012F: retval = 50000; break;   // AEGEAN NUMBER FIFTY THOUSAND
            case 0x10130: retval = 60000; break;   // AEGEAN NUMBER SIXTY THOUSAND
            case 0x10131: retval = 70000; break;   // AEGEAN NUMBER SEVENTY THOUSAND
            case 0x10132: retval = 80000; break;   // AEGEAN NUMBER EIGHTY THOUSAND
            case 0x10133: retval = 90000; break;   // AEGEAN NUMBER NINETY THOUSAND
            case 0x10144: retval = 50; break;      // GREEK ACROPHONIC ATTIC FIFTY
            case 0x10145: retval = 500; break;     // GREEK ACROPHONIC ATTIC FIVE HUNDRED
            case 0x10146: retval = 5000; break;    // GREEK ACROPHONIC ATTIC FIVE THOUSAND
            case 0x10147: retval = 50000; break;   // GREEK ACROPHONIC ATTIC FIFTY THOUSAND
            case 0x1014A: retval = 50; break;      // GREEK ACROPHONIC ATTIC FIFTY TALENTS
            case 0x1014B: retval = 100; break;     // GREEK ACROPHONIC ATTIC ONE HUNDRED TALENTS
            case 0x1014C: retval = 500; break;     // GREEK ACROPHONIC ATTIC FIVE HUNDRED TALENTS
            case 0x1014D: retval = 1000; break;    // GREEK ACROPHONIC ATTIC ONE THOUSAND TALENTS
            case 0x1014E: retval = 5000; break;    // GREEK ACROPHONIC ATTIC FIVE THOUSAND TALENTS
            case 0x10151: retval = 50; break;      // GREEK ACROPHONIC ATTIC FIFTY STATERS
            case 0x10152: retval = 100; break;     // GREEK ACROPHONIC ATTIC ONE HUNDRED STATERS
            case 0x10153: retval = 500; break;     // GREEK ACROPHONIC ATTIC FIVE HUNDRED STATERS
            case 0x10154: retval = 1000; break;    // GREEK ACROPHONIC ATTIC ONE THOUSAND STATERS
            case 0x10155: retval = 10000; break;   // GREEK ACROPHONIC ATTIC TEN THOUSAND STATERS
            case 0x10156: retval = 50000; break;   // GREEK ACROPHONIC ATTIC FIFTY THOUSAND STATERS
            case 0x10166: retval = 50; break;      // GREEK ACROPHONIC TROEZENIAN FIFTY
            case 0x10167: retval = 50; break;      // GREEK ACROPHONIC TROEZENIAN FIFTY ALTERNATE FORM
            case 0x10168: retval = 50; break;      // GREEK ACROPHONIC HERMIONIAN FIFTY
            case 0x10169: retval = 50; break;      // GREEK ACROPHONIC THESPIAN FIFTY
            case 0x1016A: retval = 100; break;     // GREEK ACROPHONIC THESPIAN ONE HUNDRED
            case 0x1016B: retval = 300; break;     // GREEK ACROPHONIC THESPIAN THREE HUNDRED
            case 0x1016C: retval = 500; break;     // GREEK ACROPHONIC EPIDAUREAN FIVE HUNDRED
            case 0x1016D: retval = 500; break;     // GREEK ACROPHONIC TROEZENIAN FIVE HUNDRED
            case 0x1016E: retval = 500; break;     // GREEK ACROPHONIC THESPIAN FIVE HUNDRED
            case 0x1016F: retval = 500; break;     // GREEK ACROPHONIC CARYSTIAN FIVE HUNDRED
            case 0x10170: retval = 500; break;     // GREEK ACROPHONIC NAXIAN FIVE HUNDRED
            case 0x10171: retval = 1000; break;    // GREEK ACROPHONIC THESPIAN ONE THOUSAND
            case 0x10172: retval = 5000; break;    // GREEK ACROPHONIC THESPIAN FIVE THOUSAND
            case 0x10174: retval = 50; break;      // GREEK ACROPHONIC STRATIAN FIFTY MNAS
            case 0x102ED: retval = 40; break;      // COPTIC EPACT NUMBER FORTY
            case 0x102EE: retval = 50; break;      // COPTIC EPACT NUMBER FIFTY
            case 0x102EF: retval = 60; break;      // COPTIC EPACT NUMBER SIXTY
            case 0x102F0: retval = 70; break;      // COPTIC EPACT NUMBER SEVENTY
            case 0x102F1: retval = 80; break;      // COPTIC EPACT NUMBER EIGHTY
            case 0x102F2: retval = 90; break;      // COPTIC EPACT NUMBER NINETY
            case 0x102F3: retval = 100; break;     // COPTIC EPACT NUMBER ONE HUNDRED
            case 0x102F4: retval = 200; break;     // COPTIC EPACT NUMBER TWO HUNDRED
            case 0x102F5: retval = 300; break;     // COPTIC EPACT NUMBER THREE HUNDRED
            case 0x102F6: retval = 400; break;     // COPTIC EPACT NUMBER FOUR HUNDRED
            case 0x102F7: retval = 500; break;     // COPTIC EPACT NUMBER FIVE HUNDRED
            case 0x102F8: retval = 600; break;     // COPTIC EPACT NUMBER SIX HUNDRED
            case 0x102F9: retval = 700; break;     // COPTIC EPACT NUMBER SEVEN HUNDRED
            case 0x102FA: retval = 800; break;     // COPTIC EPACT NUMBER EIGHT HUNDRED
            case 0x102FB: retval = 900; break;     // COPTIC EPACT NUMBER NINE HUNDRED
            case 0x10323: retval = 50; break;      // OLD ITALIC NUMERAL FIFTY
            case 0x10341: retval = 90; break;      // GOTHIC LETTER NINETY
            case 0x1034A: retval = 900; break;     // GOTHIC LETTER NINE HUNDRED
            case 0x103D5: retval = 100; break;     // OLD PERSIAN NUMBER HUNDRED
            case 0x1085D: retval = 100; break;     // IMPERIAL ARAMAIC NUMBER ONE HUNDRED
            case 0x1085E: retval = 1000; break;    // IMPERIAL ARAMAIC NUMBER ONE THOUSAND
            case 0x1085F: retval = 10000; break;   // IMPERIAL ARAMAIC NUMBER TEN THOUSAND
            case 0x108AF: retval = 100; break;     // NABATAEAN NUMBER ONE HUNDRED
            case 0x108FF: retval = 100; break;     // HATRAN NUMBER ONE HUNDRED
            case 0x10919: retval = 100; break;     // PHOENICIAN NUMBER ONE HUNDRED
            case 0x109CC: retval = 40; break;      // MEROITIC CURSIVE NUMBER FORTY
            case 0x109CD: retval = 50; break;      // MEROITIC CURSIVE NUMBER FIFTY
            case 0x109CE: retval = 60; break;      // MEROITIC CURSIVE NUMBER SIXTY
            case 0x109CF: retval = 70; break;      // MEROITIC CURSIVE NUMBER SEVENTY
            case 0x109D2: retval = 100; break;     // MEROITIC CURSIVE NUMBER ONE HUNDRED
            case 0x109D3: retval = 200; break;     // MEROITIC CURSIVE NUMBER TWO HUNDRED
            case 0x109D4: retval = 300; break;     // MEROITIC CURSIVE NUMBER THREE HUNDRED
            case 0x109D5: retval = 400; break;     // MEROITIC CURSIVE NUMBER FOUR HUNDRED
            case 0x109D6: retval = 500; break;     // MEROITIC CURSIVE NUMBER FIVE HUNDRED
            case 0x109D7: retval = 600; break;     // MEROITIC CURSIVE NUMBER SIX HUNDRED
            case 0x109D8: retval = 700; break;     // MEROITIC CURSIVE NUMBER SEVEN HUNDRED
            case 0x109D9: retval = 800; break;     // MEROITIC CURSIVE NUMBER EIGHT HUNDRED
            case 0x109DA: retval = 900; break;     // MEROITIC CURSIVE NUMBER NINE HUNDRED
            case 0x109DB: retval = 1000; break;    // MEROITIC CURSIVE NUMBER ONE THOUSAND
            case 0x109DC: retval = 2000; break;    // MEROITIC CURSIVE NUMBER TWO THOUSAND
            case 0x109DD: retval = 3000; break;    // MEROITIC CURSIVE NUMBER THREE THOUSAND
            case 0x109DE: retval = 4000; break;    // MEROITIC CURSIVE NUMBER FOUR THOUSAND
            case 0x109DF: retval = 5000; break;    // MEROITIC CURSIVE NUMBER FIVE THOUSAND
            case 0x109E0: retval = 6000; break;    // MEROITIC CURSIVE NUMBER SIX THOUSAND
            case 0x109E1: retval = 7000; break;    // MEROITIC CURSIVE NUMBER SEVEN THOUSAND
            case 0x109E2: retval = 8000; break;    // MEROITIC CURSIVE NUMBER EIGHT THOUSAND
            case 0x109E3: retval = 9000; break;    // MEROITIC CURSIVE NUMBER NINE THOUSAND
            case 0x109E4: retval = 10000; break;   // MEROITIC CURSIVE NUMBER TEN THOUSAND
            case 0x109E5: retval = 20000; break;   // MEROITIC CURSIVE NUMBER TWENTY THOUSAND
            case 0x109E6: retval = 30000; break;   // MEROITIC CURSIVE NUMBER THIRTY THOUSAND
            case 0x109E7: retval = 40000; break;   // MEROITIC CURSIVE NUMBER FORTY THOUSAND
            case 0x109E8: retval = 50000; break;   // MEROITIC CURSIVE NUMBER FIFTY THOUSAND
            case 0x109E9: retval = 60000; break;   // MEROITIC CURSIVE NUMBER SIXTY THOUSAND
            case 0x109EA: retval = 70000; break;   // MEROITIC CURSIVE NUMBER SEVENTY THOUSAND
            case 0x109EB: retval = 80000; break;   // MEROITIC CURSIVE NUMBER EIGHTY THOUSAND
            case 0x109EC: retval = 90000; break;   // MEROITIC CURSIVE NUMBER NINETY THOUSAND
            case 0x109ED: retval = 100000; break;  // MEROITIC CURSIVE NUMBER ONE HUNDRED THOUSAND
            case 0x109EE: retval = 200000; break;  // MEROITIC CURSIVE NUMBER TWO HUNDRED THOUSAND
            case 0x109EF: retval = 300000; break;  // MEROITIC CURSIVE NUMBER THREE HUNDRED THOUSAND
            case 0x109F0: retval = 400000; break;  // MEROITIC CURSIVE NUMBER FOUR HUNDRED THOUSAND
            case 0x109F1: retval = 500000; break;  // MEROITIC CURSIVE NUMBER FIVE HUNDRED THOUSAND
            case 0x109F2: retval = 600000; break;  // MEROITIC CURSIVE NUMBER SIX HUNDRED THOUSAND
            case 0x109F3: retval = 700000; break;  // MEROITIC CURSIVE NUMBER SEVEN HUNDRED THOUSAND
            case 0x109F4: retval = 800000; break;  // MEROITIC CURSIVE NUMBER EIGHT HUNDRED THOUSAND
            case 0x109F5: retval = 900000; break;  // MEROITIC CURSIVE NUMBER NINE HUNDRED THOUSAND
            case 0x10A46: retval = 100; break;     // KHAROSHTHI NUMBER ONE HUNDRED
            case 0x10A47: retval = 1000; break;    // KHAROSHTHI NUMBER ONE THOUSAND
            case 0x10A7E: retval = 50; break;      // OLD SOUTH ARABIAN NUMBER FIFTY
            case 0x10AEF: retval = 100; break;     // MANICHAEAN NUMBER ONE HUNDRED
            case 0x10B5E: retval = 100; break;     // INSCRIPTIONAL PARTHIAN NUMBER ONE HUNDRED
            case 0x10B5F: retval = 1000; break;    // INSCRIPTIONAL PARTHIAN NUMBER ONE THOUSAND
            case 0x10B7E: retval = 100; break;     // INSCRIPTIONAL PAHLAVI NUMBER ONE HUNDRED
            case 0x10B7F: retval = 1000; break;    // INSCRIPTIONAL PAHLAVI NUMBER ONE THOUSAND
            case 0x10BAF: retval = 100; break;     // PSALTER PAHLAVI NUMBER ONE HUNDRED
            case 0x10CFD: retval = 50; break;      // OLD HUNGARIAN NUMBER FIFTY
            case 0x10CFE: retval = 100; break;     // OLD HUNGARIAN NUMBER ONE HUNDRED
            case 0x10CFF: retval = 1000; break;    // OLD HUNGARIAN NUMBER ONE THOUSAND
            case 0x10E6C: retval = 40; break;      // RUMI NUMBER FORTY
            case 0x10E6D: retval = 50; break;      // RUMI NUMBER FIFTY
            case 0x10E6E: retval = 60; break;      // RUMI NUMBER SIXTY
            case 0x10E6F: retval = 70; break;      // RUMI NUMBER SEVENTY
            case 0x10E70: retval = 80; break;      // RUMI NUMBER EIGHTY
            case 0x10E71: retval = 90; break;      // RUMI NUMBER NINETY
            case 0x10E72: retval = 100; break;     // RUMI NUMBER ONE HUNDRED
            case 0x10E73: retval = 200; break;     // RUMI NUMBER TWO HUNDRED
            case 0x10E74: retval = 300; break;     // RUMI NUMBER THREE HUNDRED
            case 0x10E75: retval = 400; break;     // RUMI NUMBER FOUR HUNDRED
            case 0x10E76: retval = 500; break;     // RUMI NUMBER FIVE HUNDRED
            case 0x10E77: retval = 600; break;     // RUMI NUMBER SIX HUNDRED
            case 0x10E78: retval = 700; break;     // RUMI NUMBER SEVEN HUNDRED
            case 0x10E79: retval = 800; break;     // RUMI NUMBER EIGHT HUNDRED
            case 0x10E7A: retval = 900; break;     // RUMI NUMBER NINE HUNDRED
            case 0x10F25: retval = 100; break;     // OLD SOGDIAN NUMBER ONE HUNDRED
            case 0x10F54: retval = 100; break;     // SOGDIAN NUMBER ONE HUNDRED
            case 0x10FCB: retval = 100; break;     // CHORASMIAN NUMBER ONE HUNDRED
            case 0x1105E: retval = 40; break;      // BRAHMI NUMBER FORTY
            case 0x1105F: retval = 50; break;      // BRAHMI NUMBER FIFTY
            case 0x11060: retval = 60; break;      // BRAHMI NUMBER SIXTY
            case 0x11061: retval = 70; break;      // BRAHMI NUMBER SEVENTY
            case 0x11062: retval = 80; break;      // BRAHMI NUMBER EIGHTY
            case 0x11063: retval = 90; break;      // BRAHMI NUMBER NINETY
            case 0x11064: retval = 100; break;     // BRAHMI NUMBER ONE HUNDRED
            case 0x11065: retval = 1000; break;    // BRAHMI NUMBER ONE THOUSAND
            case 0x11C66: retval = 40; break;      // BHAIKSUKI NUMBER FORTY
            case 0x11C67: retval = 50; break;      // BHAIKSUKI NUMBER FIFTY
            case 0x11C68: retval = 60; break;      // BHAIKSUKI NUMBER SIXTY
            case 0x11C69: retval = 70; break;      // BHAIKSUKI NUMBER SEVENTY
            case 0x11C6A: retval = 80; break;      // BHAIKSUKI NUMBER EIGHTY
            case 0x11C6B: retval = 90; break;      // BHAIKSUKI NUMBER NINETY
            case 0x11C6C: retval = 100; break;     // BHAIKSUKI HUNDREDS UNIT MARK
            case 0x111ED: retval = 40; break;      // SINHALA ARCHAIC NUMBER FORTY
            case 0x111EE: retval = 50; break;      // SINHALA ARCHAIC NUMBER FIFTY
            case 0x111EF: retval = 60; break;      // SINHALA ARCHAIC NUMBER SIXTY
            case 0x111F0: retval = 70; break;      // SINHALA ARCHAIC NUMBER SEVENTY
            case 0x111F1: retval = 80; break;      // SINHALA ARCHAIC NUMBER EIGHTY
            case 0x111F2: retval = 90; break;      // SINHALA ARCHAIC NUMBER NINETY
            case 0x111F3: retval = 100; break;     // SINHALA ARCHAIC NUMBER ONE HUNDRED
            case 0x111F4: retval = 1000; break;    // SINHALA ARCHAIC NUMBER ONE THOUSAND
            case 0x118ED: retval = 40; break;      // WARANG CITI NUMBER FORTY
            case 0x118EE: retval = 50; break;      // WARANG CITI NUMBER FIFTY
            case 0x118EF: retval = 60; break;      // WARANG CITI NUMBER SIXTY
            case 0x118F0: retval = 70; break;      // WARANG CITI NUMBER SEVENTY
            case 0x118F1: retval = 80; break;      // WARANG CITI NUMBER EIGHTY
            case 0x118F2: retval = 90; break;      // WARANG CITI NUMBER NINETY
            case 0x12432: retval = 216000; break;  // CUNEIFORM NUMERIC SIGN SHAR2 TIMES GAL PLUS DISH
            case 0x12433: retval = 432000; break;  // CUNEIFORM NUMERIC SIGN SHAR2 TIMES GAL PLUS MIN
            case 0x12467: retval = 40; break;      // CUNEIFORM NUMERIC SIGN ELAMITE FORTY
            case 0x12468: retval = 50; break;      // CUNEIFORM NUMERIC SIGN ELAMITE FIFTY
            case 0x16B5C: retval = 100; break;     // PAHAWH HMONG NUMBER HUNDREDS
            case 0x16B5D: retval = 10000; break;   // PAHAWH HMONG NUMBER TEN THOUSANDS
            case 0x16B5E: retval = 1000000; break; // PAHAWH HMONG NUMBER MILLIONS
            case 0x16B5F: retval = 100000000; break;// PAHAWH HMONG NUMBER HUNDRED MILLIONS
            case 0x1D36C: retval = 40; break;      // COUNTING ROD TENS DIGIT FOUR
            case 0x1D36D: retval = 50; break;      // COUNTING ROD TENS DIGIT FIVE
            case 0x1D36E: retval = 60; break;      // COUNTING ROD TENS DIGIT SIX
            case 0x1D36F: retval = 70; break;      // COUNTING ROD TENS DIGIT SEVEN
            case 0x1D370: retval = 80; break;      // COUNTING ROD TENS DIGIT EIGHT
            case 0x1D371: retval = 90; break;      // COUNTING ROD TENS DIGIT NINE
            case 0x1EC7D: retval = 40; break;      // INDIC SIYAQ NUMBER FORTY
            case 0x1EC7E: retval = 50; break;      // INDIC SIYAQ NUMBER FIFTY
            case 0x1EC7F: retval = 60; break;      // INDIC SIYAQ NUMBER SIXTY
            case 0X1EC80: retval = 70; break;      // INDIC SIYAQ NUMBER SEVENTY
            case 0X1EC81: retval = 80; break;      // INDIC SIYAQ NUMBER EIGHTY
            case 0X1EC82: retval = 90; break;      // INDIC SIYAQ NUMBER NINETY
            case 0X1EC83: retval = 100; break;     // INDIC SIYAQ NUMBER ONE HUNDRED
            case 0X1EC84: retval = 200; break;     // INDIC SIYAQ NUMBER TWO HUNDRED
            case 0X1EC85: retval = 300; break;     // INDIC SIYAQ NUMBER THREE HUNDRED
            case 0X1EC86: retval = 400; break;     // INDIC SIYAQ NUMBER FOUR HUNDRED
            case 0X1EC87: retval = 500; break;     // INDIC SIYAQ NUMBER FIVE HUNDRED
            case 0X1EC88: retval = 600; break;     // INDIC SIYAQ NUMBER SIX HUNDRED
            case 0X1EC89: retval = 700; break;     // INDIC SIYAQ NUMBER SEVEN HUNDRED
            case 0X1EC8A: retval = 800; break;     // INDIC SIYAQ NUMBER EIGHT HUNDRED
            case 0X1EC8B: retval = 900; break;     // INDIC SIYAQ NUMBER NINE HUNDRED
            case 0X1EC8C: retval = 1000; break;    // INDIC SIYAQ NUMBER ONE THOUSAND
            case 0X1EC8D: retval = 2000; break;    // INDIC SIYAQ NUMBER TWO THOUSAND
            case 0X1EC8E: retval = 3000; break;    // INDIC SIYAQ NUMBER THREE THOUSAND
            case 0X1EC8F: retval = 4000; break;    // INDIC SIYAQ NUMBER FOUR THOUSAND
            case 0X1EC90: retval = 5000; break;    // INDIC SIYAQ NUMBER FIVE THOUSAND
            case 0X1EC91: retval = 6000; break;    // INDIC SIYAQ NUMBER SIX THOUSAND
            case 0X1EC92: retval = 7000; break;    // INDIC SIYAQ NUMBER SEVEN THOUSAND
            case 0X1EC93: retval = 8000; break;    // INDIC SIYAQ NUMBER EIGHT THOUSAND
            case 0X1EC94: retval = 9000; break;    // INDIC SIYAQ NUMBER NINE THOUSAND
            case 0X1EC95: retval = 10000; break;   // INDIC SIYAQ NUMBER TEN THOUSAND
            case 0X1EC96: retval = 20000; break;   // INDIC SIYAQ NUMBER TWENTY THOUSAND
            case 0X1EC97: retval = 30000; break;   // INDIC SIYAQ NUMBER THIRTY THOUSAND
            case 0X1EC98: retval = 40000; break;   // INDIC SIYAQ NUMBER FORTY THOUSAND
            case 0X1EC99: retval = 50000; break;   // INDIC SIYAQ NUMBER FIFTY THOUSAND
            case 0X1EC9A: retval = 60000; break;   // INDIC SIYAQ NUMBER SIXTY THOUSAND
            case 0X1EC9B: retval = 70000; break;   // INDIC SIYAQ NUMBER SEVENTY THOUSAND
            case 0X1EC9C: retval = 80000; break;   // INDIC SIYAQ NUMBER EIGHTY THOUSAND
            case 0X1EC9D: retval = 90000; break;   // INDIC SIYAQ NUMBER NINETY THOUSAND
            case 0X1EC9E: retval = 100000; break;  // INDIC SIYAQ NUMBER LAKH
            case 0X1EC9F: retval = 200000; break;  // INDIC SIYAQ NUMBER LAKHAN
            case 0X1ECA0: retval = 100000; break;  // INDIC SIYAQ LAKH MARK
            case 0X1ECA1: retval = 10000000; break;// INDIC SIYAQ NUMBER KAROR
            case 0X1ECA2: retval = 20000000; break;// INDIC SIYAQ NUMBER KARORAN
            case 0X1ECB3: retval = 10000; break;   // INDIC SIYAQ NUMBER ALTERNATE TEN THOUSAND
            case 0X1ECB4: retval = 100000; break;  // INDIC SIYAQ NUMBER ALTERNATE LAKH MARK
            case 0X1ED0D: retval = 40; break;      // OTTOMAN SIYAQ NUMBER FORTY
            case 0X1ED0E: retval = 50; break;      // OTTOMAN SIYAQ NUMBER FIFTY
            case 0X1ED0F: retval = 60; break;      // OTTOMAN SIYAQ NUMBER SIXTY
            case 0X1ED10: retval = 70; break;      // OTTOMAN SIYAQ NUMBER SEVENTY
            case 0X1ED11: retval = 80; break;      // OTTOMAN SIYAQ NUMBER EIGHTY
            case 0X1ED12: retval = 90; break;      // OTTOMAN SIYAQ NUMBER NINETY
            case 0X1ED13: retval = 100; break;     // OTTOMAN SIYAQ NUMBER ONE HUNDRED
            case 0X1ED14: retval = 200; break;     // OTTOMAN SIYAQ NUMBER TWO HUNDRED
            case 0X1ED15: retval = 300; break;     // OTTOMAN SIYAQ NUMBER THREE HUNDRED
            case 0X1ED16: retval = 400; break;     // OTTOMAN SIYAQ NUMBER FOUR HUNDRED
            case 0X1ED17: retval = 500; break;     // OTTOMAN SIYAQ NUMBER FIVE HUNDRED
            case 0X1ED18: retval = 600; break;     // OTTOMAN SIYAQ NUMBER SIX HUNDRED
            case 0X1ED19: retval = 700; break;     // OTTOMAN SIYAQ NUMBER SEVEN HUNDRED
            case 0X1ED1A: retval = 800; break;     // OTTOMAN SIYAQ NUMBER EIGHT HUNDRED
            case 0X1ED1B: retval = 900; break;     // OTTOMAN SIYAQ NUMBER NINE HUNDRED
            case 0X1ED1C: retval = 1000; break;    // OTTOMAN SIYAQ NUMBER ONE THOUSAND
            case 0X1ED1D: retval = 2000; break;    // OTTOMAN SIYAQ NUMBER TWO THOUSAND
            case 0X1ED1E: retval = 3000; break;    // OTTOMAN SIYAQ NUMBER THREE THOUSAND
            case 0X1ED1F: retval = 4000; break;    // OTTOMAN SIYAQ NUMBER FOUR THOUSAND
            case 0X1ED20: retval = 5000; break;    // OTTOMAN SIYAQ NUMBER FIVE THOUSAND
            case 0X1ED21: retval = 6000; break;    // OTTOMAN SIYAQ NUMBER SIX THOUSAND
            case 0X1ED22: retval = 7000; break;    // OTTOMAN SIYAQ NUMBER SEVEN THOUSAND
            case 0X1ED23: retval = 8000; break;    // OTTOMAN SIYAQ NUMBER EIGHT THOUSAND
            case 0X1ED24: retval = 9000; break;    // OTTOMAN SIYAQ NUMBER NINE THOUSAND
            case 0X1ED25: retval = 10000; break;   // OTTOMAN SIYAQ NUMBER TEN THOUSAND
            case 0X1ED26: retval = 20000; break;   // OTTOMAN SIYAQ NUMBER TWENTY THOUSAND
            case 0X1ED27: retval = 30000; break;   // OTTOMAN SIYAQ NUMBER THIRTY THOUSAND
            case 0X1ED28: retval = 40000; break;   // OTTOMAN SIYAQ NUMBER FORTY THOUSAND
            case 0X1ED29: retval = 50000; break;   // OTTOMAN SIYAQ NUMBER FIFTY THOUSAND
            case 0X1ED2A: retval = 60000; break;   // OTTOMAN SIYAQ NUMBER SIXTY THOUSAND
            case 0X1ED2B: retval = 70000; break;   // OTTOMAN SIYAQ NUMBER SEVENTY THOUSAND
            case 0X1ED2C: retval = 80000; break;   // OTTOMAN SIYAQ NUMBER EIGHTY THOUSAND
            case 0X1ED2D: retval = 90000; break;   // OTTOMAN SIYAQ NUMBER NINETY THOUSAND
            case 0X1ED38: retval = 400; break;     // OTTOMAN SIYAQ ALTERNATE NUMBER FOUR HUNDRED
            case 0X1ED39: retval = 600; break;     // OTTOMAN SIYAQ ALTERNATE NUMBER SIX HUNDRED
            case 0X1ED3A: retval = 2000; break;    // OTTOMAN SIYAQ ALTERNATE NUMBER TWO THOUSAND
            case 0X1ED3B: retval = 10000; break;   // OTTOMAN SIYAQ ALTERNATE NUMBER TEN THOUSAND
            default: retval = -2; break;
            }
            
            break;
        case (0x00000C00):           // Java supradecimal
            retval = (ch + ((val & 0x3E0) >> 5) & 0x1F) + 10;
            break;
        }
        return retval;
    }

    boolean isDigit(int ch) {
        int props = getProperties(ch);
        return (props & 0x1F) == Character.DECIMAL_DIGIT_NUMBER;
    }

    boolean isLowerCase(int ch) {
        return (getPropertiesEx(ch) & 0x0001) != 0;
    }

    boolean isUpperCase(int ch) {
        return (getPropertiesEx(ch) & 0x0002) != 0;
    }

    boolean isWhitespace(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00007000) == 0x00004000);
    }

    byte getDirectionality(int ch) {
        int val = getProperties(ch);
        byte directionality = (byte)((val & 0x78000000) >> 27);
        if (directionality == 0xF ) {
            directionality = Character.DIRECTIONALITY_UNDEFINED;
        }
        return directionality;
    }

    boolean isMirrored(int ch) {
        int props = getProperties(ch);
        return ((props & 0x80000000) != 0);
    }

    static final CharacterData instance = new CharacterData01();
    private CharacterData01() {};

    // The X table has 2048 entries for a total of 4096 bytes.

  static final char X[] = (
    "\000\020\040\060\100\100\100\120\140\160\200\220\240\260\300\320\060\060\060"+
    "\060\340\100\360\u0100\100\u0110\u0120\u0130\u0140\100\u0150\060\u0160\u0170"+
    "\u0180\100\u0190\u01A0\u01B0\u01C0\100\u01D0\100\u01E0\u01F0\u0200\060\060"+
    "\100\100\100\100\100\100\100\100\100\u0210\u0220\u0230\u0240\u0250\060\060"+
    "\u0260\u0270\u0280\u0290\u02A0\u02B0\060\u02C0\u02D0\u02E0\060\060\u02F0\u0300"+
    "\u0310\u0320\u0330\u0340\u0350\u0360\u0370\060\u0380\u0390\u02F0\u03A0\u03B0"+
    "\u03C0\u03D0\u03E0\060\060\u02F0\u02F0\u03F0\060\u0400\u0410\u0420\u0430\u0440"+
    "\u0450\060\060\060\060\060\060\060\060\060\u0460\u02F0\u0470\060\u0480\u0490"+
    "\u04A0\u04B0\u04C0\u04D0\u04C0\u04E0\u04F0\u0500\u0510\u0520\u0530\u0540\u0550"+
    "\u0560\u0570\u0580\u0590\u05A0\u05B0\u0540\u05C0\u05D0\u05E0\u05F0\u0600\u0610"+
    "\060\u0620\u0630\u0640\u0650\u0660\u0670\u0680\u0690\060\060\060\060\100\u06A0"+
    "\u06B0\u06C0\100\u06D0\u06E0\060\060\060\060\060\100\u06F0\u0700\060\100\u0710"+
    "\u0720\u0730\100\u0740\u0750\060\u0760\u0770\u0780\060\060\060\060\060\100"+
    "\u0790\060\060\060\u07A0\u07B0\u07C0\u07D0\u07E0\u07F0\060\060\u0800\u0810"+
    "\u0820\u0830\u0840\u0850\100\u0860\u0870\100\u0880\u0890\060\060\060\060\060"+
    "\060\060\u08A0\u08B0\u08C0\u08D0\u08E0\u08F0\060\060\u0900\u0910\u0920\u0930"+
    "\u0940\u0750\060\060\060\060\060\060\060\060\060\u0950\u0960\u0970\u0980\060"+
    "\060\u0990\u09A0\u09B0\100\100\100\100\100\100\100\100\100\100\100\100\100"+
    "\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\u09C0\060\060"+
    "\060\u09D0\u09E0\u09F0\u0A00\100\100\100\100\100\100\u0A10\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\u0A20\100\100\u0A30\100\100\100\100\100\100\100\100\100\100\100\100\100"+
    "\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100"+
    "\100\u0A40\u0A50\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\100\100\100\100"+
    "\100\100\100\100\100\100\100\100\100\100\100\100\100\100\u0780\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\u0880"+
    "\u0A60\u0A70\100\u0A60\u0A80\u0A90\100\u0AA0\u0AB0\u0AC0\u0AD0\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\u07A0"+
    "\u07B0\u0AE0\060\060\060\100\100\u0AF0\u0B00\u0B10\060\060\u0B20\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B40\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B50\060\u0B60\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\u0B70\100\100\100\100\100\100\100\100\100"+
    "\u0B80\u0B90\u0BA0\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30\u0B30"+
    "\u0B30\u0BB0\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\100"+
    "\100\100\u0BC0\u0BD0\u0BE0\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\u0BF0\u0C00\u0C10\u0C20\u0C20\u0C20\u0C30\060\u0C20\u0C20\u0C20\u0C20"+
    "\u0C20\u0C20\u0C20\u0C40\u0C20\u0C50\u0C20\u0C60\u0C70\u0C80\u0C20\u0C90\u0CA0"+
    "\u0CA0\u0CB0\060\060\060\u0CC0\u0CC0\u0CA0\u0CA0\u0CD0\u0CE0\060\060\060\060"+
    "\u0CF0\u0D00\u0D10\u0D20\u0D30\u0D40\u0D50\u0D60\u0D70\u0D80\u0D90\u0DA0\u0DB0"+
    "\u0CF0\u0D00\u0DC0\u0D20\u0DD0\u0DE0\u0DF0\u0D60\u0E00\u0E10\u0E20\u0E30\u0E40"+
    "\u0E50\u0E60\u0E70\u0E80\u0E90\u0EA0\u0C20\u0C20\u0C20\u0C20\u0C20\u0C20\u0C20"+
    "\u0C20\u0C20\u0C20\u0C20\u0C20\u0C20\u0C20\u0C20\u0C20\u0BF0\u0EB0\u0BF0\u0EC0"+
    "\u0ED0\u0EE0\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\u0EF0"+
    "\u0F00\060\060\060\060\060\060\u0F10\u0F20\u0F30\u0F40\u0F50\060\060\060\100"+
    "\u0F60\u0F70\060\060\060\060\060\060\060\060\060\u0A20\u0F80\100\u0F90\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\u0A20\u0FA0\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\u0FB0\u02F0\u02F0\u02F0\u02F0\u02F0\u02F0\u0FC0\060\u0FD0\u0FE0\u0FF0"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\u1000\u1010\u1020\060\060\u1030\u1040\060\060\060\060"+
    "\060\060\u1050\u1060\u1070\u1080\u1090\u10A0\060\u10B0\060\060\060\060\060"+
    "\060\060\060\u10C0\u10D0\u10E0\u10E0\u10F0\u1100\u1110\u1120\u1130\u1140\u1150"+
    "\u1160\u1170\u1180\u1190\u11A0\u11B0\u11C0\u11D0\u11E0\u1190\u1190\u1190\u1190"+
    "\u11F0\u1200\u11F0\u1210\u1220\u11F0\u1230\u1240\u11F0\u1250\u1260\u1270\u1280"+
    "\u1290\u11F0\u12A0\u11F0\u12B0\u12C0\u12D0\u12E0\u12F0\u1300\u1310\u11F0\u11F0"+
    "\u1320\u0CA0\u11F0\u1330\u1340\u1350\u0CA0\u0CA0\u0CA0\u1360\u0CA0\u0CA0\u1370"+
    "\u1380\u1390\u0CA0\u13A0\u0CA0\u13B0\u13C0\u1190\u1190\u13D0\u13E0\u13F0\u1400"+
    "\u11F0\u1410\u1420\u11F0\u10E0\u10E0\u10F0\u1430\u1440\u1450\u1460\u1470\u0CA0"+
    "\u0CA0\u0CA0\u0CA0\u1480\u0CA0\u1490\u14A0\u1190\u1190\u1190\u1190\u1190\u1190"+
    "\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190"+
    "\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u1190\u14B0").toCharArray();

  // The Y table has 5312 entries for a total of 10624 bytes.

  static final char Y[] = (
    "\000\000\000\000\000\000\002\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\004\000\000\000\000\000\000\000\000\000\004\000\002\000\000\000\000\000\000"+
    "\000\006\000\000\000\000\000\000\000\006\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\006\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\004\006"+
    "\006\010\012\006\014\016\016\016\016\020\022\024\024\024\024\024\024\024\024"+
    "\024\024\024\024\024\024\024\024\006\026\030\030\030\030\032\034\032\032\036"+
    "\032\032\040\042\032\032\044\046\050\052\054\056\060\062\032\032\032\032\032"+
    "\032\064\066\070\072\074\074\074\074\074\074\074\074\076\100\102\074\074\074"+
    "\074\074\074\104\006\104\006\006\006\006\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\006\006\006\006\030\030\030\030\030\030\030\030\030"+
    "\030\030\030\030\030\030\030\030\030\030\030\030\030\106\006\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\004\006\000\000\000\000\000\000\000"+
    "\000\004\006\006\006\006\006\006\006\110\112\112\112\112\114\116\120\120\120"+
    "\120\120\120\120\006\006\122\124\006\006\006\006\002\000\000\000\000\000\000"+
    "\000\000\000\126\000\000\000\000\130\006\006\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\132\132\134\006\006\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\136\000\000\006\006\000\000"+
    "\000\000\140\142\144\006\006\006\006\006\146\146\146\146\146\146\146\146\146"+
    "\146\146\146\146\146\146\146\146\146\146\146\150\150\150\150\150\150\150\150"+
    "\150\150\150\150\150\150\150\150\150\150\150\150\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\006\152\152"+
    "\152\152\152\006\006\006\146\146\146\146\146\146\146\146\146\146\146\146\146"+
    "\146\146\146\146\146\006\006\150\150\150\150\150\150\150\150\150\150\150\150"+
    "\150\150\150\150\150\150\006\006\000\000\000\000\006\006\006\006\000\000\000"+
    "\000\000\000\000\000\000\000\006\006\006\006\006\136\154\154\154\154\154\156"+
    "\154\154\154\154\154\154\154\156\154\154\154\156\154\160\162\162\162\162\162"+
    "\160\162\162\162\162\162\162\162\160\162\162\162\160\164\006\000\000\000\000"+
    "\000\000\000\000\000\000\000\004\006\006\006\006\000\000\000\000\000\000\000"+
    "\000\000\000\000\006\006\006\006\006\000\000\000\000\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\166\170\172\174\172\172\172\172\172\172\172\172\172"+
    "\172\172\172\172\172\172\172\172\172\172\172\176\172\172\172\172\176\006\006"+
    "\200\200\200\006\202\200\200\200\200\200\200\200\200\200\200\200\200\200\200"+
    "\200\200\200\200\200\200\200\200\204\202\006\202\204\200\200\200\200\200\200"+
    "\200\200\200\200\200\206\210\212\214\216\200\200\200\200\200\200\200\200\200"+
    "\200\200\220\222\224\224\226\200\200\200\200\200\200\200\200\200\200\200\200"+
    "\200\200\200\202\006\006\006\230\232\234\236\240\006\006\006\006\006\006\006"+
    "\006\200\200\200\200\200\200\200\200\200\202\200\006\006\242\244\246\200\200"+
    "\200\200\200\200\200\200\200\200\200\250\252\224\006\254\200\200\200\200\200"+
    "\200\200\200\200\200\200\200\200\006\006\206\200\200\200\200\200\200\200\200"+
    "\200\200\200\200\200\200\200\200\200\200\200\200\200\200\200\200\200\200\200"+
    "\200\006\006\216\200\256\256\256\256\256\260\216\216\006\216\216\216\216\216"+
    "\216\216\216\216\216\216\216\216\216\216\216\216\216\216\216\216\216\216\262"+
    "\132\264\134\006\006\132\132\200\200\204\200\204\200\200\200\200\200\200\200"+
    "\200\200\200\200\200\200\200\006\266\270\006\272\256\256\274\216\276\006\006"+
    "\006\300\300\300\300\302\006\006\006\200\200\200\200\200\200\200\200\200\200"+
    "\200\200\200\200\304\306\200\200\200\200\200\200\200\200\200\200\200\200\200"+
    "\200\304\226\200\200\200\200\310\200\200\200\200\200\200\200\200\200\200\200"+
    "\200\200\312\270\006\314\236\240\300\300\300\302\006\006\006\006\200\200\200"+
    "\200\200\200\200\200\200\200\200\006\254\316\316\316\200\200\200\200\200\200"+
    "\200\200\200\200\200\006\210\210\320\216\200\200\200\200\200\200\200\200\200"+
    "\202\006\006\210\210\320\216\200\200\200\200\200\200\200\200\200\006\006\006"+
    "\206\300\302\006\006\006\006\006\322\324\326\240\006\006\006\006\006\006\006"+
    "\006\200\200\200\200\202\006\006\006\006\006\006\006\006\006\006\006\330\330"+
    "\330\330\330\330\330\330\330\330\330\330\330\330\330\330\330\330\330\330\330"+
    "\330\330\330\330\332\006\006\006\006\006\006\334\334\334\334\334\334\334\334"+
    "\334\334\334\334\334\334\334\334\334\334\334\334\334\334\334\334\334\336\006"+
    "\006\006\340\342\216\344\344\344\344\344\344\344\344\344\344\344\344\344\344"+
    "\344\344\344\344\132\132\006\006\006\006\346\346\346\346\346\006\006\006\350"+
    "\350\350\350\350\352\354\354\354\354\354\354\354\354\354\356\200\200\200\200"+
    "\200\264\360\006\200\006\006\006\006\006\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\006\272\266\200\200\200\200\200\200\200\200\200\200"+
    "\200\200\200\200\304\362\362\364\366\370\006\006\006\006\344\344\344\344\344"+
    "\344\344\344\344\344\344\266\266\266\266\266\372\374\376\u0100\u0100\006\006"+
    "\006\006\006\006\006\006\006\006\006\200\200\200\200\200\200\200\200\200\266"+
    "\266\300\300\006\006\006\006\006\006\006\006\006\006\006\200\200\u0102\u0104"+
    "\u0106\u0108\006\006\006\006\006\006\006\006\006\006\200\200\200\200\200\200"+
    "\200\200\200\200\200\202\006\006\006\006\u010A\u010C\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\132\132\132\132\132\132\132\u010E\u0110\u0110\u0110\006\006\u0112\u0112"+
    "\u0112\u0112\u0112\u0114\070\070\070\070\u0116\u0116\u0116\u0116\u0116\u0118"+
    "\u011A\u011C\006\006\006\006\272\132\u010C\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\u011E\u010A\132\u0120"+
    "\u0122\u010E\u0124\u0110\u0110\134\006\006\006\006\u0126\006\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\004\006\006\006\u0128\u0128\u0128\u0128\u0128"+
    "\006\006\006\132\u011C\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\u011A\132\132\u010A\132\132\u012A\270\u012C\u012C\u012C\u012C"+
    "\u012C\u0110\u0110\u012E\u010C\006\006\006\006\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\u0130\u0110\004\006\006\006\006\000"+
    "\000\000\000\000\000\000\000\000\u012E\u011E\132\132\132\132\u0120\u0132\000"+
    "\u0134\u0110\u0136\266\u010E\u010A\u0128\u0128\u0128\u0128\u0128\u0134\u0134"+
    "\u0110\u0138\u013A\u013A\u013A\u013A\u013C\u013E\024\024\024\u0140\006\006"+
    "\006\006\006\000\000\000\000\000\000\000\000\000\002\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\u011E\u010A\132\u011E\u0142\u0144\u0110\u0110\u0110"+
    "\u011C\u011A\006\006\006\006\006\006\006\006\006\006\006\006\006\006\006\000"+
    "\000\000\004\004\000\000\002\000\000\000\000\000\000\000\002\000\000\000\000"+
    "\u0134\006\006\006\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\u011A\u011E\u010A\132\132\u012A\270\006"+
    "\006\u0128\u0128\u0128\u0128\u0128\006\006\006\132\u011E\002\000\000\000\004"+
    "\002\004\002\000\000\000\000\000\000\000\000\000\000\004\000\000\000\004\000"+
    "\002\000\000\272\u0118\u011E\u0120\u011E\u0146\u0148\u0146\u0148\u014A\006"+
    "\004\006\006\u0148\006\006\002\000\000\u011E\006\266\266\266\270\006\266\266"+
    "\270\006\006\006\006\006\000\000\000\000\000\000\000\000\000\000\u012E\u011E"+
    "\132\132\132\132\u011E\u0144\u0120\u0118\000\u0134\u0110\u0110\u0128\u0128"+
    "\u0128\u0128\u0128\u0110\136\u0118\000\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\000\000\000\000\000\000\000\000\u011E\u010A\132\132"+
    "\u0120\u0120\u011E\u010A\u0120\266\000\u014C\006\006\006\006\u0128\u0128\u0128"+
    "\u0128\u0128\006\006\006\000\000\000\000\000\000\000\u012E\u011E\132\132\006"+
    "\u011E\u011E\132\u0122\u010E\u0110\u0110\u0110\u0110\u0110\u0110\u0110\u0110"+
    "\u0110\u0110\u0110\000\000\132\006\000\000\000\000\000\000\000\000\u011E\u010A"+
    "\132\132\132\u0120\u010A\u0122\u014E\u0110\004\006\006\006\006\006\u0128\u0128"+
    "\u0128\u0128\u0128\006\006\006\316\316\316\316\316\316\u0150\006\006\006\006"+
    "\006\006\006\006\006\000\000\000\000\000\u011A\u010A\u011E\132\132\132\u0152"+
    "\u0134\006\006\006\152\152\152\152\152\006\006\006\006\006\006\006\006\006"+
    "\006\006\000\000\000\000\000\000\000\000\000\000\000\000\000\004\264\132\u011E"+
    "\132\132\u010A\132\u012A\006\006\u0128\u0128\u0128\u0128\u0128\u0154\u0110"+
    "\u0156\000\000\000\004\006\006\006\006\006\006\006\006\006\006\006\006\000"+
    "\000\000\000\000\000\u011E\u010A\132\132\132\132\u0122\u010E\006\006\u0158"+
    "\u0158\u0158\u0158\u0158\u0158\u0158\u0158\u0158\u0158\u0158\u0158\u0158\u0158"+
    "\u0158\u0158\u015A\u015A\u015A\u015A\u015A\u015A\u015A\u015A\u015A\u015A\u015A"+
    "\u015A\u015A\u015A\u015A\u015A\152\152\152\152\152\u013C\u013E\024\024\u0140"+
    "\006\006\006\006\006\002\000\000\000\004\002\006\000\000\000\000\002\004\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\u011E\u011E\u011E\u0148\u0146"+
    "\264\u0142\u0118\u010C\u0122\u0110\012\006\006\006\006\u0128\u0128\u0128\u0128"+
    "\u0128\006\006\006\000\000\000\000\006\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\u012E\u011E\132\132\006\132\u011E"+
    "\u011E\u0118\u014C\u0146\006\006\006\006\006\006\006\006\006\006\006\006\006"+
    "\u011A\132\132\u015C\u015E\u011C\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\u0130\u0144\132\u0120\u011A\132\u014E\u0110"+
    "\u0110\u0110\u0136\006\006\006\006\u011A\132\132\u0120\u010A\132\000\000\000"+
    "\000\000\000\000\132\132\132\132\132\132\u0120\266\u0110\u014C\u0110\u0110"+
    "\012\006\006\006\006\006\006\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\004\006\006\006\u0110\u0110\u0110\u0110\u0110"+
    "\006\006\006\006\006\006\006\006\006\006\006\000\000\000\000\004\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\u012E\132\132"+
    "\132\134\132\132\132\u0160\u0134\u0110\u0110\006\006\006\006\006\u0128\u0128"+
    "\u0128\u0128\u0128\u0162\u0162\u0162\u0162\u0162\u0154\024\024\024\u0140\006"+
    "\u0110\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\006\132"+
    "\132\132\132\132\132\132\132\132\132\132\u0148\132\132\132\u0120\132\u010A"+
    "\134\006\006\006\006\000\000\000\004\000\002\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\u011A\132\132\134\006\134\132\264"+
    "\132\u0144\266\u011A\006\006\006\006\u0128\u0128\u0128\u0128\u0128\006\006"+
    "\006\000\000\000\002\004\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\u011E\u011E\u0146\132\u0148\u010A\u0122\004\006\006\006\000\000"+
    "\000\000\000\000\000\000\000\u011A\u0120\u0164\012\006\006\006\132\u012E\000"+
    "\000\000\000\000\000\004\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\u011E\132\132\134\006\u011E\u0142\u010E\u0110\u0110\u0110"+
    "\u0110\u0110\u0110\u0128\u0128\u0128\u0128\u0128\006\006\006\006\006\006\006"+
    "\006\006\006\006\004\006\006\006\006\006\006\006\024\024\024\024\024\024\024"+
    "\024\024\024\u0166\074\074\074\u0168\u016A\u016C\074\074\074\074\074\074\074"+
    "\074\006\006\006\006\006\006\136\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\006\006\006\u016E\u016E\u016E\u016E\u0170\u0170\u0170\u0172\u0174"+
    "\u0174\u0176\u0178\u0178\u0178\u0178\u017A\u017A\u017C\u017E\u0180\u0180\u0180"+
    "\u0174\u0182\u0184\u0186\u0188\u018A\u0178\u018C\u018E\u0190\u0192\u0194\u0196"+
    "\u0198\u019A\u019C\u019C\u019E\u01A0\u01A2\u01A4\u0178\u01A6\u0186\u0186\u0186"+
    "\u0186\u0186\u0186\u0186\u01A8\u0170\u0170\u01AA\u0110\u0110\012\006\006\006"+
    "\006\006\000\000\006\006\006\006\006\006\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\006\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\u0134\012\006\006\006\006\006\006\000\000\000\000\000\000"+
    "\000\000\u01AC\u01AC\u01AC\u01AC\u01AC\u01AC\u01AC\u01AC\u0118\000\000\u0130"+
    "\266\266\266\266\266\266\266\006\006\006\006\006\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\004\152\152\152\152\152\006\006\u0110\000"+
    "\000\000\000\000\000\000\000\152\152\152\152\152\006\006\006\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\006\266\266\u010E\006\006\006"+
    "\006\006\000\000\000\000\000\000\000\000\266\266\266\u010E\u0110\u0110\030"+
    "\030\u01AE\u01AE\u0156\006\006\006\006\006\u0128\u0128\u0128\u0128\u0128\u01B0"+
    "\024\024\024\002\000\000\000\000\000\000\000\000\000\000\006\006\002\000\000"+
    "\000\000\000\000\000\000\000\006\006\006\006\006\006\006\006\u013A\u013A\u013A"+
    "\u013A\u013A\u013A\u013A\u013A\u013A\u013A\u01B2\u01B4\u0110\012\006\006\000"+
    "\000\000\000\000\004\006\264\u012E\u011E\u011E\u011E\u011E\u011E\u011E\u011E"+
    "\u011E\u011E\u011E\u011E\u011E\u011E\u011E\u011E\u011E\u011E\u011E\u011E\u011E"+
    "\u011E\u011E\u011E\u011E\u011E\u011E\u011E\006\006\006\264\132\u01B6\u01AE"+
    "\u01AE\u01AE\u01AE\u01AE\u01AE\u01AE\u01B8\u01BA\006\006\006\006\006\u011E"+
    "\006\006\006\006\006\006\006\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC"+
    "\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC"+
    "\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\006\006\006\006\u01BC\u01BC\u01BC"+
    "\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\006\006\006\006\006\u01BC"+
    "\u01BC\u01BC\u01BC\u01BE\006\006\006\006\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\u01AE\u01AE\u01C0\u01AE\u01AE\u01AE\u01C0\u01C2\000"+
    "\004\006\006\006\006\006\006\006\004\006\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\000\004\002\006\006\006\006\006\006\006\000\000\006\006\006"+
    "\006\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC"+
    "\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\u01BC\006\006\000\000"+
    "\000\000\000\004\006\006\000\000\000\000\000\000\004\006\000\000\000\000\004"+
    "\006\006\006\000\000\000\000\000\006\106\u014E\u01C4\u01C4\006\006\006\006"+
    "\006\006\006\006\006\006\006\006\006\006\266\266\266\266\266\266\266\266\266"+
    "\266\266\266\266\266\266\266\266\266\266\266\266\266\266\006\266\266\266\266"+
    "\266\266\266\266\266\266\266\270\006\006\006\006\030\030\030\030\030\030\030"+
    "\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030"+
    "\006\006\006\006\006\006\006\006\006\006\006\006\006\006\030\030\030\030\030"+
    "\030\030\030\030\030\030\006\006\006\006\006\030\030\030\102\026\030\030\030"+
    "\030\030\030\030\030\030\030\030\030\030\u01C6\u0152\266\030\u01C6\u01C8\u01C8"+
    "\u01CA\u01C4\u01C4\u01C4\u01CC\266\266\266\u01CE\106\266\266\266\030\030\030"+
    "\030\030\030\030\030\030\030\030\030\030\030\030\266\266\030\030\030\030\030"+
    "\030\030\030\030\030\030\030\030\u01D0\104\006\006\006\006\006\006\006\006"+
    "\006\006\074\074\074\074\074\074\074\074\074\074\074\074\074\074\074\074\074"+
    "\266\u01D2\006\006\006\006\006\006\006\006\006\006\006\006\006\u013A\u013A"+
    "\u013A\u013A\u013A\u013A\u013A\u013A\u013A\u013A\006\006\006\006\006\006\074"+
    "\074\074\074\074\074\074\074\074\074\074\104\006\006\006\006\u01D4\u01D4\u01D4"+
    "\u01D4\u01D4\u01D6\024\024\024\u01D8\u01D8\u01DA\u01DC\006\006\006\u01DE\u01DE"+
    "\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01E0\u01E0"+
    "\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01DE\u01DE"+
    "\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01E0\u01E0"+
    "\u01E0\u01E2\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01DE\u01DE"+
    "\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01E0\u01E0"+
    "\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E4\u01DE"+
    "\006\u01E4\u01E6\u01E4\u01E6\u01DE\u01E4\u01DE\u01DE\u01DE\u01DE\u01E0\u01E0"+
    "\u01E8\u01E8\u01E0\u01E0\u01E0\u01E8\u01E0\u01E0\u01E0\u01E0\u01E0\u01DE\u01DE"+
    "\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01E0\u01E0"+
    "\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01DE\u01E6"+
    "\u01DE\u01E4\u01E6\u01DE\u01DE\u01DE\u01E4\u01DE\u01DE\u01DE\u01E4\u01E0\u01E0"+
    "\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01DE\u01E6"+
    "\u01DE\u01E4\u01DE\u01DE\u01E4\u01E4\006\u01DE\u01DE\u01DE\u01E4\u01E0\u01E0"+
    "\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01DE\u01DE"+
    "\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01E0\u01E0"+
    "\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01DE\u01DE"+
    "\u01DE\u01DE\u01DE\u01DE\u01DE\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0"+
    "\u01E0\u01DE\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0"+
    "\u01E0\u01E0\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE"+
    "\u01DE\u01DE\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0"+
    "\u01E0\u01E0\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01E0\u01E0\u01E0"+
    "\006\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE"+
    "\u01EA\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0"+
    "\u01EC\u01E0\u01E0\u01E0\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE"+
    "\u01DE\u01DE\u01DE\u01EA\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0"+
    "\u01E0\u01E0\u01E0\u01EC\u01E0\u01E0\u01E0\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE"+
    "\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01EA\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0"+
    "\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01EC\u01E0\u01E0\u01E0\u01DE\u01DE\u01DE"+
    "\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01EA\u01E0\u01E0\u01E0"+
    "\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01EC\u01E0\u01E0\u01E0"+
    "\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01DE\u01EA"+
    "\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01EC"+
    "\u01E0\u01E0\u01E0\u01EE\006\u01F0\u01F0\u01F0\u01F0\u01F0\u01F2\u01F2\u01F2"+
    "\u01F2\u01F2\u01F4\u01F4\u01F4\u01F4\u01F4\u01F6\u01F6\u01F6\u01F6\u01F6\u01F8"+
    "\u01F8\u01F8\u01F8\u01F8\266\266\266\266\266\266\266\266\266\266\266\u01CE"+
    "\030\106\266\266\266\266\266\266\266\266\u01CE\030\030\030\106\030\030\030"+
    "\030\030\030\030\u01CE\u01FA\u0110\u0110\006\006\006\006\006\006\006\272\266"+
    "\266\272\266\266\266\266\266\266\266\006\006\006\006\006\006\006\006\u01E0"+
    "\u01E0\u01E0\u01E0\u01E0\u01FC\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0\u01E0"+
    "\u01E0\u01E2\006\006\u01E8\u01E0\u01E0\u01E2\006\006\006\006\006\006\006\006"+
    "\006\006\132\132\132\134\132\132\132\132\132\132\132\132\134\264\132\132\132"+
    "\264\134\132\132\134\006\006\172\172\172\172\172\172\172\172\172\172\172\172"+
    "\172\172\172\172\172\172\172\172\172\172\172\172\172\172\172\172\172\172\172"+
    "\006\006\006\006\006\006\006\006\006\006\006\006\006\006\006\006\264\006\006"+
    "\006\006\006\006\006\006\000\000\000\000\000\000\004\006\266\266\266\u01FE"+
    "\u01AE\u01AE\u01AE\006\152\152\152\152\152\006\006\u0200\006\006\006\006\006"+
    "\006\006\006\000\000\000\000\000\000\000\270\006\006\006\006\006\006\006\006"+
    "\000\000\000\000\000\000\266\266\u0128\u0128\u0128\u0128\u0128\006\006\u0202"+
    "\000\000\000\000\000\u0204\266\266\u0128\u0128\u0128\u0128\u0128\006\006\006"+
    "\000\000\000\004\000\000\002\004\000\000\000\000\000\000\000\004\200\200\202"+
    "\230\232\232\232\232\266\266\266\270\006\006\006\006\u0206\u0206\u0206\u0206"+
    "\u0206\u0206\u0206\u0206\u0206\u0206\u0206\u0206\u0206\u0206\u0206\u0206\u0206"+
    "\u0208\u0208\u0208\u0208\u0208\u0208\u0208\u0208\u0208\u0208\u0208\u0208\u0208"+
    "\u0208\u0208\u0208\u0208\266\u0144\266\u020A\006\006\u020C\u020C\u020C\u020C"+
    "\u020C\006\006\300\006\006\006\006\006\006\006\006\u020E\u0210\u0210\u0210"+
    "\u0210\u0212\u0214\u0216\u0216\u0216\u0216\u0216\u0216\u0216\u0216\u0216\u0216"+
    "\u0216\u0216\u0216\u0216\u0216\u0216\u0216\u0216\u0218\u021A\u021A\u021A\u021A"+
    "\u021C\u0216\u021E\u0220\u0222\006\006\006\006\006\u0224\u0226\u0226\u0226"+
    "\u0226\u0228\u022A\u0216\u0216\u0216\u0216\u0216\u0216\u0216\u0216\u0216\u0216"+
    "\u0216\u0216\u0216\u0216\u0216\u0216\u022C\u022E\u022E\u022E\u022E\u0216\u0216"+
    "\u0216\006\344\344\u0230\344\344\344\344\344\344\344\344\344\344\344\344\344"+
    "\u0230\u0232\u0232\u0230\u0230\344\344\344\344\u0232\344\344\u0230\u0230\006"+
    "\006\006\u0232\006\u0230\u0230\u0230\u0230\344\u0230\u0232\u0232\u0230\u0230"+
    "\u0230\u0230\u0230\u0230\u0232\u0232\u0230\344\u0232\344\344\344\u0232\344"+
    "\344\u0230\344\u0232\u0232\344\344\344\344\344\u0230\344\344\344\344\344\344"+
    "\344\344\006\006\u0230\344\u0230\344\344\u0230\344\344\344\344\344\344\344"+
    "\344\006\006\006\006\006\006\006\006\006\006\u0234\006\006\006\006\006\006"+
    "\006\u0236\u0236\u0238\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236"+
    "\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u023A\u023A\u0236"+
    "\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236"+
    "\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236"+
    "\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u023A\u023A\u023A\u023A\u023A\u023A"+
    "\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u023C\u023E\u0236\u0236\u0236\u0236"+
    "\u0236\u0236\u0236\u023E\u0236\u0236\u0236\u0236\u0236\u0236\u0240\u023E\u0236"+
    "\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u0236"+
    "\u0236\u0236\u0236\u0236\u023A\u023A\u023A\u023A\u023A\u0242\u0244\u0244\u0244"+
    "\u0244\u0246\u0248\u0236\030\030\030\030\030\030\030\030\030\030\030\030\030"+
    "\030\030\u024A\u024C\u024C\u024C\u024C\u024C\u024C\u024C\u024C\u024C\u024C"+
    "\u024C\u024C\u024C\030\030\030\u024C\u024C\u024C\u024C\u024C\u024C\u024C\u024C"+
    "\u024C\u024C\u024C\u024C\u024C\074\u0236\u0236\u024E\u024C\u024C\u024C\u024C"+
    "\u024C\u024C\u024E\u024C\u024C\u024C\u024C\u024C\030\030\u0250\u0252\u0254"+
    "\u0254\u0254\u0254\u0250\030\030\030\030\030\030\030\030\u024A\u023A\u023A"+
    "\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A"+
    "\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A"+
    "\u0256\u0256\u0256\u0256\u0256\u0256\u0256\u0256\u0256\u0256\u0256\u0256\u0256"+
    "\u0252\u0258\u023A\u023A\u023A\u023A\u023A\u023A\030\030\030\030\030\u0250"+
    "\030\030\030\030\030\030\030\030\030\u0252\030\u0254\u0254\u025A\u0254\u0250"+
    "\u023A\u023A\030\030\030\030\u025C\u023A\u023A\u023A\u0254\u023A\u023A\u023A"+
    "\u023A\u023A\u023A\u023A\u0236\u0236\u0236\u023A\u023A\u023A\u023A\u023A\u023A"+
    "\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u0260\u0236\u0262"+
    "\u0262\u0262\u0262\u0264\u025E\u025E\u025E\u025E\u0264\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u0260\u025E\u025E\u025E\u0266\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u0236\u0262\u0268\u0262\u0236\u0262\u025E\u026A\u026C\u0266\u025E\u026E\u0270"+
    "\u0264\u025E\u025E\u0262\u0262\u0262\u0262\u0262\u0262\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u0238\u0268\u0260\u0268\u025E\u0272\u0274\u0274\u025E"+
    "\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u0260\u0260\u026A\u025E\u026A\u026A\u026A\u026A\u026A\u026C\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u026A\u026A\u026A\u026A\u026A"+
    "\u026A\u026A\u026A\u026A\u026C\u025E\u026C\u025E\u0266\u026A\u0266\u026A\u025E"+
    "\u025E\u025E\u0266\u0266\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u026C\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u0260\u0240\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u025E\u025E\074\074\074\074\u0236\u0268\u0264\u025E"+
    "\u0238\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u0236\u0236\u0236\u0268\u0276\u0268\u0278\u0262\u0262\u027A\u0236\u0236\u0236"+
    "\u0236\u0236\u0268\u0236\u0262\u0262\u0236\u027C\u0236\u027E\u027A\u0236\u0236"+
    "\u0236\u0236\u0236\u0236\u0260\u0236\u0276\u0236\u0236\u0236\u0268\u0276\u0236"+
    "\u0236\u0236\u0236\u0276\u0236\u0236\u0262\u0276\u0236\u0236\u0236\u0236\u0236"+
    "\u0268\u0262\u0236\u0236\u0236\u0236\u0262\u0276\u0268\u0268\u0236\u0236\u0276"+
    "\u0236\u0236\u0268\u0236\u0268\u0236\u0236\u0236\u0264\u025E\u025E\u025E\u025E"+
    "\u0266\u026A\u025E\u0266\u026A\u026A\074\074\074\074\074\074\074\074\u025E"+
    "\u0266\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u026A\u026C\u025E\u025E"+
    "\u025E\u025E\u026C\u025E\u025E\u0236\u0236\u0268\u0280\u0262\u025E\u0238\u0240"+
    "\u025E\u023A\u023A\u025E\u025E\u0262\u0262\u0262\u0236\u0268\u0240\u0282\u023A"+
    "\u0276\u0268\u025E\u025E\u025E\u025E\u0282\u023A\074\074\074\074\074\074\074"+
    "\074\074\074\u0236\u023C\u023A\u023E\u0236\u0236\074\074\074\074\074\074\074"+
    "\074\074\074\u0284\u0236\u0236\u023A\u023A\u023A\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u023A\u023A\u0282\u023A\u023A\u023A\u023A\u023A\u023A\u023A\074\074"+
    "\074\074\074\074\u023A\u023A\074\074\074\074\074\074\074\074\074\074\074\074"+
    "\u023A\u023A\u023A\u023A\074\074\074\074\074\u023A\u023A\u023A\074\074\074"+
    "\074\u023A\u023A\u023A\u023A\074\074\074\074\074\074\074\074\074\074\074\074"+
    "\074\074\074\u023A\u0236\u023A\u023A\u023A\u023A\u023A\u023A\u023A\074\074"+
    "\074\074\074\074\u026C\u0266\u025E\u025E\u025E\u025E\u026A\u026A\u026A\u026A"+
    "\u025E\u025E\u025E\u026C\u025E\u025E\u025E\u025E\u026A\u026A\u026A\u026A\u026A"+
    "\u0286\u026A\u026C\u025E\u025E\u025E\u0288\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u0266\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u028A\u028A\u0266\u026C\u026A\u0266\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u025E\u0266\u026A\u0266\u026A\u026A\u026A\u026A\u026A"+
    "\u026A\u025E\u0236\u0236\u0236\u0236\u0236\u0236\u0236\u023A\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u0282\u023A\u025E\u025E\u025E\u025E\u0282\u023A\u023A\u023A"+
    "\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E"+
    "\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u028C\u025E\u0266"+
    "\u026A\u023A\u023A\u023A\u023A\u025E\u025E\u025E\u025E\u025E\u025E\u025E\u023A"+
    "\u023A\u025E\u025E\u025E\u025E\u0282\u023A\u023A\u023A\u026A\u026A\u026A\u026A"+
    "\u028E\u023A\u023A\u023A\074\074\074\074\074\074\074\074\074\104\074\074\074"+
    "\074\074\074\074\074\074\074\074\104\006\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\006\006\u0290\u0290\u0290\u0290\u0290\006\006\006"+
    "\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A\u023A"+
    "\u023A\u023A\006").toCharArray();

  // The A table has 658 entries for a total of 2632 bytes.

  static final int A[] = new int[658];
  static final String A_DATA =
    "\000\u7005\000\u7005\u7800\000\000\u7005\000\u7005\u7800\000\u7800\000\u7800"+
    "\000\000\030\u6800\030\000\030\u7800\000\u7800\000\000\u074B\000\u074B\000"+
    "\u074B\000\u074B\000\u046B\000\u058B\000\u080B\000\u080B\000\u080B\u7800\000"+
    "\000\034\000\034\000\034\u6800\u780A\u6800\u780A\u6800\u77EA\u6800\u744A\u6800"+
    "\u77AA\u6800\u742A\u6800\u780A\u6800\u76CA\u6800\u774A\u6800\u780A\u6800\u780A"+
    "\u6800\u766A\u6800\u752A\u6800\u750A\u6800\u74EA\u6800\u74EA\u6800\u74CA\u6800"+
    "\u74AA\u6800\u748A\u6800\u74CA\u6800\u754A\u6800\u752A\u6800\u750A\u6800\u74EA"+
    "\u6800\u74CA\u6800\u772A\u6800\u780A\u6800\u764A\u6800\u780A\u6800\u080B\u6800"+
    "\u080B\u6800\u080B\u6800\u080B\u6800\034\u6800\034\u6800\034\u6800\u06CB\u6800"+
    "\u080B\u6800\034\000\034\000\034\u7800\000\u6800\034\u7800\000\000\034\u4000"+
    "\u3006\u4000\u3006\u1800\u040B\u1800\u040B\u1800\u040B\u1800\u040B\u1800\u052B"+
    "\u1800\u064B\u1800\u080B\u1800\u080B\u1800\u080B\000\u042B\000\u048B\000\u050B"+
    "\000\u080B\000\u7005\000\u780A\000\u780A\u7800\000\u4000\u3006\u4000\u3006"+
    "\u4000\u3006\u7800\000\u7800\000\000\030\000\030\000\u760A\000\u760A\000\u76EA"+
    "\000\u740A\000\u780A\242\u7001\242\u7001\241\u7002\241\u7002\000\u3409\000"+
    "\u3409\236\u7001\236\u7001\236\u7001\u7800\000\u7800\000\235\u7002\235\u7002"+
    "\235\u7002\235\u7002\u7800\000\000\u7004\000\u7004\000\u7004\000\u7004\000"+
    "\u7004\000\u7004\u7800\000\000\u7004\000\u7004\u7800\000\u0800\u7005\u0800"+
    "\u7005\u0800\u7005\u7800\000\u7800\000\u0800\u7005\u7800\000\u0800\030\u0800"+
    "\u052B\u0800\u052B\u0800\u052B\u0800\u05EB\u0800\u070B\u0800\u080B\u0800\u080B"+
    "\u0800\u080B\u0800\u7005\u0800\034\u0800\034\u0800\u050B\u0800\u050B\u0800"+
    "\u050B\u0800\u058B\u0800\u06AB\u7800\000\u0800\u074B\u0800\u074B\u0800\u074B"+
    "\u0800\u074B\u0800\u072B\u0800\u072B\u0800\u07AB\u0800\u04CB\u0800\u080B\u7800"+
    "\000\u0800\u04CB\u0800\u052B\u0800\u05AB\u0800\u06CB\u0800\u080B\u0800\u056B"+
    "\u0800\u066B\u0800\u078B\u0800\u080B\u7800\000\u6800\030\u0800\u042B\u0800"+
    "\u042B\u0800\u054B\u0800\u066B\u0800\u7005\u4000\u3006\u7800\000\u4000\u3006"+
    "\u4000\u3006\u4000\u3006\u4000\u3006\u7800\000\u7800\000\u4000\u3006\u0800"+
    "\u04CB\u0800\u05EB\u0800\u080B\u7800\000\u0800\030\u0800\030\u0800\030\u7800"+
    "\000\u0800\u7005\u0800\u048B\u0800\u080B\u0800\030\u0800\034\u0800\u7005\u0800"+
    "\u7005\u4000\u3006\u7800\000\u0800\u06CB\u6800\030\u6800\030\u0800\u05CB\u0800"+
    "\u06EB\u7800\000\u0800\u070B\u0800\u070B\u0800\u070B\u0800\u070B\u0800\u07AB"+
    "\u0902\u7001\u0902\u7001\u0902\u7001\u7800\000\u0901\u7002\u0901\u7002\u0901"+
    "\u7002\u7800\000\u0800\u04EB\u0800\u054B\u0800\u05CB\u0800\u080B\u1000\u7005"+
    "\u1000\u7005\u3000\u3609\u3000\u3609\u3000\u042B\u3000\u042B\u3000\u054B\u3000"+
    "\u066B\u3000\u080B\u3000\u080B\u3000\u080B\u7800\000\u4000\u3006\u0800\024"+
    "\u0800\u048B\u0800\u048B\u0800\u050B\u0800\u062B\u0800\u074B\u0800\u080B\u0800"+
    "\u080B\u0800\u7005\u4000\u3006\u1000\u060B\u1000\u070B\u1000\u042B\u1000\u080B"+
    "\u1000\030\u1000\030\u1000\030\u0800\u7005\u0800\u078B\u0800\u078B\u0800\u078B"+
    "\u0800\u078B\u0800\u042B\u0800\u054B\u0800\u080B\000\u3008\u4000\u3006\000"+
    "\u3008\000\u7005\u4000\u3006\000\030\000\030\000\030\u6800\u05EB\u6800\u05EB"+
    "\u6800\u070B\u6800\u042B\000\u3749\000\u3749\u4000\u3006\000\u7005\000\u7005"+
    "\u4000\u3006\u4000\u3006\000\u7005\000\u3008\000\u3008\u4000\u3006\000\u3008"+
    "\000\u3008\u4000\u3006\000\030\000\u1010\u7800\000\000\u1010\000\u3609\000"+
    "\u3609\u4000\u3006\u4000\u3006\000\u3549\000\u3549\000\u7005\000\u3008\000"+
    "\u7005\u4000\u3006\000\u3008\000\u7005\000\u7005\000\030\000\030\u4000\u3006"+
    "\u7800\000\000\u040B\000\u040B\000\u040B\000\u040B\000\u052B\000\u064B\000"+
    "\u080B\000\u080B\u7800\000\u4000\u3006\000\u3008\u4000\u3006\u4000\u3006\000"+
    "\u3008\u7800\000\u7800\000\000\u3008\000\u3008\000\u3008\000\030\000\u7005"+
    "\u4000\u3006\000\030\u6800\030\u7800\000\000\u3008\u4000\u3006\000\u060B\000"+
    "\u072B\000\030\000\034\202\u7001\202\u7001\201\u7002\201\u7002\u4000\u3006"+
    "\000\u3006\000\u3006\u4000\u3006\000\u3008\000\u3006\000\u04EB\000\u04EB\000"+
    "\u3008\000\030\000\u080B\u6800\034\u6800\034\u2800\u601A\u2800\u601A\u2800"+
    "\u601A\u2800\u601A\u6800\034\000\u744A\000\u744A\000\u776A\000\u776A\000\u776A"+
    "\000\u76AA\000\u76AA\000\u76AA\000\u76AA\000\u758A\000\u758A\000\u758A\000"+
    "\u746A\000\u746A\000\u746A\000\u77EA\000\u77EA\000\u77CA\000\u77CA\000\u77CA"+
    "\000\u76AA\000\u768A\000\u768A\000\u768A\000\u780A\000\u780A\000\u75AA\000"+
    "\u75AA\000\u75AA\000\u758A\000\u752A\000\u750A\000\u750A\000\u74EA\000\u74CA"+
    "\000\u74AA\000\u74CA\000\u74CA\000\u74AA\000\u748A\000\u748A\000\u746A\000"+
    "\u746A\000\u744A\000\u742A\000\u740A\000\u770A\000\u770A\000\u770A\000\u764A"+
    "\000\u764A\000\u764A\000\u764A\000\u762A\000\u762A\000\u760A\000\u752A\000"+
    "\u752A\000\u780A\000\u776A\000\u776A\u7800\000\000\u1010\000\u1010\000\u7004"+
    "\000\u7004\u7800\000\000\u05EB\000\u05AB\000\u05AB\000\u05AB\000\030\u4000"+
    "\u3006\000\u7004\u6800\030\000\u7004\u4000\u3006\u7800\000\000\u7005\000\u7005"+
    "\000\u7005\u7800\000\u7800\000\000\u7004\000\u7004\u7800\000\u4800\u1010\u4800"+
    "\u1010\000\034\000\u3008\000\u3008\000\u3008\000\u3008\u4800\u1010\u4800\u1010"+
    "\u4000\u3006\u4000\u3006\000\034\000\034\u6800\034\u4000\u3006\u6800\034\000"+
    "\u042B\000\u042B\000\u054B\000\u066B\000\u05EB\000\u05EB\000\u05EB\000\u054B"+
    "\000\u05AB\u7800\000\000\u7001\000\u7001\000\u7002\000\u7002\000\u7002\u7800"+
    "\000\000\u7001\u7800\000\u7800\000\000\u7001\u7800\000\000\u7002\000\u7001"+
    "\000\031\000\u7002\uE800\031\000\u7001\000\u7002\u1800\u3649\u1800\u3649\u1800"+
    "\u3509\u1800\u3509\u1800\u37C9\u1800\u37C9\u1800\u3689\u1800\u3689\u1800\u3549"+
    "\u1800\u3549\000\034\000\030\000\u7005\000\u7002\u4000\u3006\000\u7004\000"+
    "\u7005\000\034\u7800\000\u2800\u601A\000\u7005\000\u7004\u088A\u7001\u088A"+
    "\u7001\u0889\u7002\u0889\u7002\u4000\u3006\u0800\u7004\u0800\u3609\u0800\u3609"+
    "\u7800\000\u1000\u060B\u1000\u060B\u1000\u060B\u1000\u060B\u1000\u072B\u1000"+
    "\u044B\u1000\u080B\u1000\u080B\u1000\u080B\u1000\u080B\u1000\u07CB\u1000\u07CB"+
    "\u1000\u07CB\u1000\034\u1000\u080B\u1000\u601A\u1000\u060B\u1000\u060B\u1000"+
    "\u080B\u1000\u080B\u7800\000\u7800\000\u1000\u040B\u1000\u040B\u1000\u040B"+
    "\u1000\u040B\u1000\u052B\u1000\u064B\u1000\u080B\u1000\034\u1000\u066B\u1000"+
    "\u066B\u1000\u066B\u7800\000\u1000\u7005\u1000\u7005\u7800\000\u6800\031\u6800"+
    "\031\u6800\034\u6800\034\u6800\034\u6800\034\u7800\000\u7800\000\u6800\034"+
    "\u7800\000\u7800\000\u6800\034\u6800\034\u6800\034\u1800\u040B\u1800\u07EB"+
    "\u1800\u07EB\u1800\u07EB\u1800\u07EB\u6800\u06AB\u6800\u068B\u6800\034\000"+
    "\034\u6800\034\000\034\000\034\000\034\000\034\000\034\000\034\000\034\000"+
    "\034\000\034\000\034\000\034\000\034\000\034\u7800\000\000\034\000\034\000"+
    "\034\u7800\000\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034"+
    "\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800"+
    "\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034"+
    "\u6800\033\u6800\033\u6800\033\u6800\034\u6800\034\u6800\034\u6800\034\u6800"+
    "\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034"+
    "\u6800\034\u7800\000\u6800\034\u6800\034\u6800\034\u6800\034\u6800\034\u6800"+
    "\034\u6800\034\u6800\034\u7800\000\u6800\034\u6800\034\u7800\000\u1800\u3609"+
    "\u1800\u3609";

  // The B table has 658 entries for a total of 1316 bytes.

  static final char B[] = (
    "\060\060\000\060\060\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\040\040\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\060\060\060\000\044\044\044\000\000"+
    "\000\000\060\060\060\060\060\062\062\061\061\040\040\062\062\062\000\000\061"+
    "\061\061\061\000\061\060\060\061\061\061\000\061\061\000\060\060\060\000\000"+
    "\060\000\000\000\000\000\000\000\000\000\000\060\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\060\044\000\044\040\040\040\000\000\040\000\000"+
    "\000\000\000\000\000\000\060\000\000\000\000\060\060\040\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\062\062\062\000\061\061\061\000\000\000\000\000"+
    "\060\060\040\040\000\000\000\000\000\000\000\000\044\000\000\000\000\000\000"+
    "\000\000\060\040\000\000\000\000\000\000\000\060\000\000\000\000\000\000\000"+
    "\044\044\044\060\040\000\000\000\000\000\000\000\040\040\040\060\060\044\044"+
    "\060\044\044\044\044\044\040\000\000\000\000\040\040\044\040\040\040\060\044"+
    "\060\040\040\060\060\000\000\040\000\000\000\000\000\000\000\000\000\000\044"+
    "\040\040\044\044\000\000\044\044\040\000\060\044\000\000\000\040\040\000\000"+
    "\000\000\062\062\061\061\044\044\044\044\044\040\000\000\044\000\000\000\000"+
    "\000\000\000\000\000\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060\060"+
    "\060\060\060\060\060\060\060\060\060\000\000\000\060\060\000\000\000\000\000"+
    "\000\044\060\000\060\050\000\070\070\070\000\000\060\060\000\000\000\000\040"+
    "\040\040\040\000\000\040\040\000\000\000\040\000\000\000\000\000\000\000\000"+
    "\000\000\000\062\062\061\061\061\000\062\000\000\062\000\061\062\000\061\000"+
    "\062\061\040\040\040\040\040\040\040\040\040\040\000\000\060\061\040\060\060"+
    "\000\000\000\060\060\062\062\061\061\040\060\040\040\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\060\060\000\000\000\u0800\u0800\u08C0"+
    "\u0800\u0800\u0800\u0800\u0800\u0800\u0800\u0800\u08C0\000\000\000\000\000"+
    "\000\000\u0800\000\u0800\006\006\u0846\u0846\u08C0\000\000\u08C0\u08C0\u08C0"+
    "\u04C0\u04C0\u0840\u0800\u08C0\u0840\000\u0800\u08C0\u08C0\u08C0\u0840\u0840"+
    "\u0840\u0840\u08C0\u08C0\u0AC0\u0800\u0840\u0AC0\u0AC0\u0AC0\u08C0\u0AC0\u0A40"+
    "\u0A40\u0840\u08C0\u05C0\u05C0\u05C0\u0840\u0800\u0A40\u0A40\u0AC0\u0800\u0A40"+
    "\u0800\u0800\u0AC0\u0AC0\u0840\u08C0\u0800\000\u0800\u08C0\000\000\u08C0\u0CC0"+
    "\u0CC0\u0800\u08C0\u0AC0\u0800\040\040").toCharArray();

  // In all, the character property tables require 17352 bytes.

    static {
                { // THIS CODE WAS AUTOMATICALLY CREATED BY GenerateCharacter:
            char[] data = A_DATA.toCharArray();
            assert (data.length == (658 * 2));
            int i = 0, j = 0;
            while (i < (658 * 2)) {
                int entry = data[i++] << 16;
                A[j++] = entry | data[i++];
            }
        }

    }        
}
