// This file was generated AUTOMATICALLY from a template file Wed Feb 20 18:21:52 PST 2019
/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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
        int props = A[(Y[(X[offset>>5]<<4)|((offset>>1)&0xF)]<<1)|(offset&0x1)];
        return props;
    }

    int getPropertiesEx(int ch) {
        char offset = (char)ch;
        int props = B[(Y[(X[offset>>5]<<4)|((offset>>1)&0xF)]<<1)|(offset&0x1)];
        return props;
    }

    int getType(int ch) {
        int props = getProperties(ch);
        return (props & 0x1F);
    }

    boolean isOtherLowercase(int ch) {
        int props = getPropertiesEx(ch);
        return (props & 0x0001) != 0;
    }

    boolean isOtherUppercase(int ch) {
        int props = getPropertiesEx(ch);
        return (props & 0x0002) != 0;
    }
 
    boolean isOtherAlphabetic(int ch) {
        int props = getPropertiesEx(ch);
        return (props & 0x0004) != 0;
    }

    boolean isIdeographic(int ch) {
        int props = getPropertiesEx(ch);
        return (props & 0x0010) != 0;
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
        int props = getProperties(ch);
        return ((props & 0x00007000) == 0x00007000);
    }

    boolean isUnicodeIdentifierPart(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00001000) != 0);
    }

    boolean isIdentifierIgnorable(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00007000) == 0x00001000);
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
            case 0X1EC95: retval = 10000; break;    // INDIC SIYAQ NUMBER TEN THOUSAND
            case 0X1EC96: retval = 20000; break;    // INDIC SIYAQ NUMBER TWENTY THOUSAND
            case 0X1EC97: retval = 30000; break;    // INDIC SIYAQ NUMBER THIRTY THOUSAND
            case 0X1EC98: retval = 40000; break;    // INDIC SIYAQ NUMBER FORTY THOUSAND
            case 0X1EC99: retval = 50000; break;    // INDIC SIYAQ NUMBER FIFTY THOUSAND
            case 0X1EC9A: retval = 60000; break;    // INDIC SIYAQ NUMBER SIXTY THOUSAND
            case 0X1EC9B: retval = 70000; break;    // INDIC SIYAQ NUMBER SEVENTY THOUSAND
            case 0X1EC9C: retval = 80000; break;    // INDIC SIYAQ NUMBER EIGHTY THOUSAND
            case 0X1EC9D: retval = 90000; break;    // INDIC SIYAQ NUMBER NINETY THOUSAND
            case 0X1EC9E: retval = 100000; break;    // INDIC SIYAQ NUMBER LAKH
            case 0X1EC9F: retval = 200000; break;    // INDIC SIYAQ NUMBER LAKHAN
            case 0X1ECA0: retval = 100000; break;    // INDIC SIYAQ LAKH MARK
            case 0X1ECA1: retval = 10000000; break;  // INDIC SIYAQ NUMBER KAROR
            case 0X1ECA2: retval = 20000000; break;  // INDIC SIYAQ NUMBER KARORAN
            case 0X1ECB3: retval = 10000; break;    // INDIC SIYAQ NUMBER ALTERNATE TEN THOUSAND
            case 0X1ECB4: retval = 100000; break;   // INDIC SIYAQ NUMBER ALTERNATE LAKH MARK
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
        int props = getProperties(ch);
        return (props & 0x1F) == Character.LOWERCASE_LETTER;
    }

    boolean isUpperCase(int ch) {
        int props = getProperties(ch);
        return (props & 0x1F) == Character.UPPERCASE_LETTER;
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

    // The following tables and code generated using:
  // java GenerateCharacter -string -plane 1 -template /scratch/opt/mach5/mesos/work_dir/slaves/2dd962d0-8988-479b-a804-57ab764ada59-S1254/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/f2448e11-af07-4931-ba4b-f7fcc53664cb/runs/1f786c06-50de-4f58-8401-8213090807ac/workspace/open/make/data/characterdata/CharacterData01.java.template -spec /scratch/opt/mach5/mesos/work_dir/slaves/2dd962d0-8988-479b-a804-57ab764ada59-S1254/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/f2448e11-af07-4931-ba4b-f7fcc53664cb/runs/1f786c06-50de-4f58-8401-8213090807ac/workspace/open/make/data/unicodedata/UnicodeData.txt -specialcasing /scratch/opt/mach5/mesos/work_dir/slaves/2dd962d0-8988-479b-a804-57ab764ada59-S1254/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/f2448e11-af07-4931-ba4b-f7fcc53664cb/runs/1f786c06-50de-4f58-8401-8213090807ac/workspace/open/make/data/unicodedata/SpecialCasing.txt -proplist /scratch/opt/mach5/mesos/work_dir/slaves/2dd962d0-8988-479b-a804-57ab764ada59-S1254/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/f2448e11-af07-4931-ba4b-f7fcc53664cb/runs/1f786c06-50de-4f58-8401-8213090807ac/workspace/open/make/data/unicodedata/PropList.txt -o /scratch/opt/mach5/mesos/work_dir/slaves/2dd962d0-8988-479b-a804-57ab764ada59-S1254/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/f2448e11-af07-4931-ba4b-f7fcc53664cb/runs/1f786c06-50de-4f58-8401-8213090807ac/workspace/build/linux-x64/support/gensrc/java.base/java/lang/CharacterData01.java -usecharforbyte 11 4 1
  // The X table has 2048 entries for a total of 4096 bytes.

  static final char X[] = (
    "\000\001\002\003\004\004\004\005\006\007\010\011\012\013\014\015\003\003\003"+
    "\003\016\004\017\020\004\021\022\023\024\004\025\003\026\027\030\004\031\032"+
    "\033\034\004\035\004\036\003\003\003\003\004\004\004\004\004\004\004\004\004"+
    "\037\040\041\003\003\003\003\042\043\044\045\046\047\003\050\051\052\003\003"+
    "\053\054\055\056\057\060\061\062\063\003\064\065\053\066\067\070\071\072\003"+
    "\003\053\053\073\003\074\075\076\077\100\101\003\003\003\003\003\003\003\003"+
    "\003\102\003\003\003\003\103\104\105\003\003\003\003\003\106\107\110\111\112"+
    "\113\114\115\116\117\120\121\122\123\124\125\126\127\003\003\130\131\132\133"+
    "\134\135\136\137\003\003\003\003\004\140\141\003\004\142\143\003\003\003\003"+
    "\003\004\144\145\003\004\146\147\150\004\151\152\003\153\154\003\003\003\003"+
    "\003\003\004\155\003\003\003\156\157\160\003\003\003\003\003\003\003\003\161"+
    "\162\163\004\164\165\004\166\003\003\003\003\003\003\003\003\167\170\171\172"+
    "\173\174\003\003\175\176\177\200\201\152\003\003\003\003\003\003\003\003\003"+
    "\202\003\003\003\003\003\003\003\003\004\004\004\004\004\004\004\004\004\004"+
    "\004\004\004\004\004\004\004\004\004\004\004\004\004\004\004\004\004\004\203"+
    "\003\003\003\204\205\206\207\004\004\004\004\004\004\210\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\004\004\004\004\004\004\004\004\004\004\004\004\004\004\004"+
    "\004\004\004\004\004\004\004\004\004\004\004\004\004\004\004\004\004\004\211"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\004\004\004\004\004\004\004"+
    "\004\004\004\004\004\004\004\004\004\004\004\212\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\004\004\004\004"+
    "\004\004\004\004\004\004\004\004\004\004\004\004\004\166\213\214\003\003\215"+
    "\216\004\217\220\221\222\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\156\157\223\003\003\003\004\004\224\225\226"+
    "\003\003\227\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\231\230\230\230\230\230\230\230\230\230\230\230\230\230\230"+
    "\230\230\230\230\230\230\230\230\230\232\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\004\004\004\004\004\004\004\004\213\003\003\233\230\230\230\230\230"+
    "\230\230\230\230\230\230\234\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\004\004\004\235\236\237\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\240\240\240\240\240\240\240\241"+
    "\240\242\240\243\244\245\240\246\247\247\250\003\003\003\003\251\247\247\252"+
    "\253\003\003\003\003\254\255\256\257\260\261\262\263\264\265\266\267\270\254"+
    "\255\271\257\272\273\274\263\275\276\277\300\301\302\303\304\305\306\307\240"+
    "\240\240\240\240\240\240\240\240\240\240\240\240\240\240\240\310\311\310\312"+
    "\313\314\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\315\316\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\053\053\053\053\053\053"+
    "\317\003\320\321\322\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\323\324\325\003\003\003\003\003\003"+
    "\003\003\003\003\326\327\330\331\332\333\003\334\003\003\003\003\003\003\003"+
    "\003\247\335\247\247\336\337\340\341\342\343\344\345\346\347\003\350\351\352"+
    "\353\354\003\003\003\003\247\247\247\247\247\247\247\355\247\247\247\247\247"+
    "\247\247\247\247\247\247\247\247\247\247\247\247\247\247\247\247\247\356\357"+
    "\247\247\247\336\247\247\360\003\335\247\361\247\362\363\003\003\335\364\247"+
    "\365\247\366\367\247\003\003\003\363\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003").toCharArray();

  // The Y table has 3968 entries for a total of 7936 bytes.

  static final char Y[] = (
    "\000\000\000\000\000\000\001\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\002\000\000\000\000\000\000\000\000\000\002\000\001\000\000\000\000\000\000"+
    "\000\003\000\000\000\000\000\000\000\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\002\003"+
    "\003\004\005\003\006\007\007\007\007\010\011\012\012\012\012\012\012\012\012"+
    "\012\012\012\012\012\012\012\012\003\013\014\014\014\014\015\016\015\015\017"+
    "\015\015\020\021\015\015\022\023\024\025\026\027\030\031\015\015\015\015\015"+
    "\015\032\033\034\035\036\036\036\036\036\036\036\036\037\040\041\036\036\036"+
    "\036\036\036\003\003\042\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\014\014\014\014\014\014\014\014\014"+
    "\014\014\014\014\014\014\014\014\014\014\014\014\014\043\003\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\002\003\000\000\000\000\000\000\000"+
    "\000\002\003\003\003\003\003\003\003\044\045\045\045\045\046\047\050\050\050"+
    "\050\050\050\050\003\003\051\052\003\003\003\003\001\000\000\000\000\000\000"+
    "\000\000\000\053\000\000\000\000\054\003\003\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\055\055\056\003\003\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\057\000\000\003\003\000\000"+
    "\000\000\060\061\062\003\003\003\003\003\063\063\063\063\063\063\063\063\063"+
    "\063\063\063\063\063\063\063\063\063\063\063\064\064\064\064\064\064\064\064"+
    "\064\064\064\064\064\064\064\064\064\064\064\064\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\003\065\065"+
    "\065\065\065\003\003\003\063\063\063\063\063\063\063\063\063\063\063\063\063"+
    "\063\063\063\063\063\003\003\064\064\064\064\064\064\064\064\064\064\064\064"+
    "\064\064\064\064\064\064\003\003\000\000\000\000\003\003\003\003\000\000\000"+
    "\000\000\000\000\000\000\000\003\003\003\003\003\057\003\003\003\003\003\003"+
    "\003\003\000\000\000\000\000\000\000\000\000\000\000\002\003\003\003\003\000"+
    "\000\000\000\000\000\000\000\000\000\000\003\003\003\003\003\000\000\000\000"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\066\066\066\003\067\066\066"+
    "\066\066\066\066\066\066\066\066\066\066\066\066\066\066\066\066\066\066\066"+
    "\066\070\067\003\067\070\066\066\066\066\066\066\066\066\066\066\066\071\072"+
    "\073\074\075\066\066\066\066\066\066\066\066\066\066\066\076\077\100\100\101"+
    "\066\066\066\066\066\066\066\066\066\066\066\066\066\066\066\067\003\003\003"+
    "\102\103\104\105\106\003\003\003\003\003\003\003\003\066\066\066\066\066\066"+
    "\066\066\066\067\066\003\003\107\110\111\066\066\066\066\066\066\066\066\066"+
    "\066\066\112\113\100\003\114\066\066\066\066\066\066\066\066\066\066\066\066"+
    "\066\003\003\071\066\066\066\066\066\066\066\066\066\066\066\066\066\066\066"+
    "\066\066\066\066\066\066\066\066\066\066\066\066\066\003\003\075\066\115\115"+
    "\115\115\115\116\075\075\003\075\075\075\075\075\075\075\075\075\075\075\075"+
    "\075\075\075\075\075\075\075\075\075\075\075\117\055\120\056\003\003\055\055"+
    "\066\066\070\066\070\066\066\066\066\066\066\066\066\066\066\066\066\066\066"+
    "\003\121\122\003\123\115\115\124\075\125\003\003\003\126\126\126\126\127\003"+
    "\003\003\066\066\066\066\066\066\066\066\066\066\066\066\066\066\130\131\066"+
    "\066\066\066\066\066\066\066\066\066\066\066\066\066\130\101\066\066\066\066"+
    "\132\066\066\066\066\066\066\066\066\066\066\066\066\066\133\122\003\134\105"+
    "\106\126\126\126\127\003\003\003\003\066\066\066\066\066\066\066\066\066\066"+
    "\066\003\114\135\135\135\066\066\066\066\066\066\066\066\066\066\066\003\072"+
    "\072\136\075\066\066\066\066\066\066\066\066\066\067\003\003\072\072\136\075"+
    "\066\066\066\066\066\066\066\066\066\003\003\003\071\126\127\003\003\003\003"+
    "\003\137\140\141\106\003\003\003\003\003\003\003\003\066\066\066\066\067\003"+
    "\003\003\003\003\003\003\003\003\003\003\142\142\142\142\142\142\142\142\142"+
    "\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142\143\003\003"+
    "\003\003\003\003\144\144\144\144\144\144\144\144\144\144\144\144\144\144\144"+
    "\144\144\144\144\144\144\144\144\144\144\145\003\003\003\146\147\075\150\150"+
    "\150\150\150\150\150\150\150\150\150\150\150\150\150\150\150\150\055\055\003"+
    "\003\003\003\151\151\151\151\151\003\003\003\152\152\152\152\152\153\154\154"+
    "\154\154\154\154\154\154\154\155\066\066\066\066\066\066\066\066\066\066\066"+
    "\066\066\066\130\156\156\157\160\161\003\003\003\003\150\150\150\150\150\150"+
    "\150\150\150\150\150\121\121\121\121\121\162\163\164\165\165\003\003\003\166"+
    "\167\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\055\055\055\055\055\055\055\170\171\171\171"+
    "\003\003\172\172\172\172\172\173\034\034\034\034\174\174\174\174\174\003\003"+
    "\003\003\003\003\003\123\121\167\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\175\166\055\176\177\170\200\171"+
    "\171\003\003\003\003\003\201\003\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\002\003\003\003\202\202\202\202\202\003\003\003\055\203\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\204\055\055\166\055\055"+
    "\205\122\206\206\206\206\206\171\171\207\210\003\003\003\003\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\211\171\002\003\003\003"+
    "\003\055\167\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\207\175\055\055\055\055\176\212\000\213\171\214"+
    "\121\170\003\202\202\202\202\202\213\213\171\215\216\216\216\216\217\220\012"+
    "\012\012\221\003\003\003\003\003\000\000\000\000\000\000\000\000\000\001\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\175\166\055\175\222\223\171\171"+
    "\171\056\000\000\000\002\002\000\000\001\000\000\000\000\000\000\000\001\000"+
    "\000\000\000\213\003\003\003\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\204\175\166\055\055\205\122\003"+
    "\003\202\202\202\202\202\003\003\003\055\175\001\000\000\000\002\001\002\001"+
    "\000\000\000\000\000\000\000\000\000\000\002\000\000\000\002\000\001\000\000"+
    "\123\224\175\176\175\210\225\210\225\226\003\002\003\003\225\003\003\001\000"+
    "\000\175\003\121\121\121\122\003\121\121\122\003\003\003\003\003\000\000\000"+
    "\000\000\000\000\000\000\000\207\175\055\055\055\055\175\223\176\224\000\213"+
    "\171\171\202\202\202\202\202\057\057\122\000\000\000\000\000\000\000\000\175"+
    "\166\055\055\176\176\175\166\176\121\000\227\003\003\003\003\202\202\202\202"+
    "\202\003\003\003\000\000\000\000\000\000\000\207\175\055\055\003\175\175\055"+
    "\177\170\171\171\171\171\171\171\171\171\171\171\171\000\000\055\003\000\000"+
    "\000\000\000\000\000\000\175\166\055\055\055\176\166\177\230\171\002\003\003"+
    "\003\003\003\202\202\202\202\202\003\003\003\135\135\135\135\135\135\231\003"+
    "\003\003\003\003\003\003\003\003\000\000\000\000\000\204\166\175\055\055\055"+
    "\232\003\003\003\003\065\065\065\065\065\003\003\003\003\003\003\003\003\003"+
    "\003\003\000\000\000\000\000\000\000\000\000\000\000\000\000\002\120\055\175"+
    "\055\055\166\055\205\003\003\202\202\202\202\202\233\171\234\000\000\000\000"+
    "\000\000\175\166\055\055\055\055\177\170\003\003\235\235\235\235\235\235\235"+
    "\235\235\235\235\235\235\235\235\235\236\236\236\236\236\236\236\236\236\236"+
    "\236\236\236\236\236\236\065\065\065\065\065\217\220\012\012\221\003\003\003"+
    "\003\003\001\204\055\055\237\240\203\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\211\223\055\176\204\055\230\171\171\171"+
    "\214\003\003\003\003\204\055\055\176\166\055\000\000\000\000\003\000\000\055"+
    "\055\055\055\055\055\176\121\171\227\171\171\005\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\002\003\003\003\000\000\000\000\002\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\207\055\055\055\056\055\055\055\241\213\171"+
    "\171\003\003\003\003\003\202\202\202\202\202\242\242\242\242\242\233\012\012"+
    "\012\221\003\171\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\003\055\055\055\055\055\055\055\055\055\055\055\225\055\055\055\176\055\166"+
    "\056\003\003\003\003\000\000\000\002\000\001\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\204\055\055\056\003\056\055\120\055"+
    "\223\121\204\003\003\003\003\202\202\202\202\202\003\003\003\000\000\000\001"+
    "\002\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\175\175"+
    "\210\055\225\166\177\002\003\003\003\000\000\000\000\000\000\000\000\000\204"+
    "\176\243\005\003\003\003\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\003\003\003\244\244\244\244\245\245\245\246\247\247\250\251\251\251\251\252"+
    "\252\253\254\255\255\255\247\256\257\260\261\262\251\263\264\265\266\267\270"+
    "\271\272\273\273\274\275\276\277\251\300\260\260\260\260\260\260\260\301\245"+
    "\245\302\171\171\005\003\003\003\003\003\000\000\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\000\000\000\000\000\000\000\002\003\003\003\003"+
    "\003\003\003\003\000\000\000\002\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\002\065\065"+
    "\065\065\065\003\003\171\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\003"+
    "\121\121\170\003\003\003\003\003\000\000\000\000\000\000\000\000\055\055\055"+
    "\230\171\171\014\014\303\303\234\003\003\003\003\003\202\202\202\202\202\304"+
    "\012\012\012\001\000\000\000\000\000\000\000\000\000\000\003\003\001\000\000"+
    "\000\000\000\000\000\000\000\003\003\003\003\003\003\003\003\216\216\216\216"+
    "\216\216\216\216\216\216\305\306\171\005\003\003\000\000\002\003\003\003\003"+
    "\003\207\175\175\175\175\175\175\175\175\175\175\175\175\175\175\175\175\175"+
    "\175\175\175\175\175\210\003\003\003\003\003\003\003\123\121\307\303\303\303"+
    "\303\303\303\303\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310"+
    "\310\310\310\310\310\310\003\003\003\003\003\003\003\310\310\310\310\310\310"+
    "\310\310\310\311\003\003\003\003\003\003\003\003\003\003\003\003\003\003\310"+
    "\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310"+
    "\310\310\003\003\000\000\000\000\000\002\003\003\000\000\000\000\000\000\002"+
    "\003\000\000\000\000\002\003\003\003\000\000\000\000\000\003\043\230\312\312"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\014\014\014\014\014"+
    "\014\014\014\014\014\014\014\014\014\014\014\014\014\014\014\014\014\014\014"+
    "\014\014\014\003\003\003\003\003\014\014\014\041\013\014\014\014\014\014\014"+
    "\014\014\014\014\014\014\014\313\232\121\014\313\314\314\315\312\312\312\316"+
    "\121\121\121\317\043\121\121\121\014\014\014\014\014\014\014\014\014\014\014"+
    "\014\014\014\014\121\121\014\014\014\014\014\014\014\014\014\014\014\014\014"+
    "\041\003\003\003\003\003\003\003\003\003\003\003\036\036\036\036\036\036\036"+
    "\036\036\036\036\036\036\036\036\036\036\121\320\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\216\216\216\216\216\216\216\216\216\216\003\003\003"+
    "\003\003\003\036\036\036\036\036\036\036\036\036\036\036\042\003\003\003\003"+
    "\321\321\321\321\321\322\012\012\012\323\323\324\325\003\003\003\326\326\326"+
    "\326\326\326\326\326\326\326\326\326\326\327\327\327\327\327\327\327\327\327"+
    "\327\327\327\327\326\326\326\326\326\326\326\326\326\326\326\326\326\327\327"+
    "\327\330\327\327\327\327\327\327\327\327\327\326\326\326\326\326\326\326\326"+
    "\326\326\326\326\326\327\327\327\327\327\327\327\327\327\327\327\327\327\331"+
    "\326\003\331\332\331\332\326\331\326\326\326\326\327\327\333\333\327\327\327"+
    "\333\327\327\327\327\327\326\326\326\326\326\326\326\326\326\326\326\326\326"+
    "\327\327\327\327\327\327\327\327\327\327\327\327\327\326\332\326\331\332\326"+
    "\326\326\331\326\326\326\331\327\327\327\327\327\327\327\327\327\327\327\327"+
    "\327\326\332\326\331\326\326\331\331\003\326\326\326\331\327\327\327\327\327"+
    "\327\327\327\327\327\327\327\327\326\326\326\326\326\326\326\326\326\326\326"+
    "\326\326\327\327\327\327\327\327\327\327\327\327\327\327\327\326\326\326\326"+
    "\326\326\326\327\327\327\327\327\327\327\327\327\326\327\327\327\327\327\327"+
    "\327\327\327\327\327\327\327\326\326\326\326\326\326\326\326\326\326\326\326"+
    "\326\327\327\327\327\327\327\327\327\327\327\327\327\327\326\326\326\326\326"+
    "\326\326\326\327\327\327\003\326\326\326\326\326\326\326\326\326\326\326\326"+
    "\334\327\327\327\327\327\327\327\327\327\327\327\327\335\327\327\327\326\326"+
    "\326\326\326\326\326\326\326\326\326\326\334\327\327\327\327\327\327\327\327"+
    "\327\327\327\327\335\327\327\327\326\326\326\326\326\326\326\326\326\326\326"+
    "\326\334\327\327\327\327\327\327\327\327\327\327\327\327\335\327\327\327\326"+
    "\326\326\326\326\326\326\326\326\326\326\326\334\327\327\327\327\327\327\327"+
    "\327\327\327\327\327\335\327\327\327\326\326\326\326\326\326\326\326\326\326"+
    "\326\326\334\327\327\327\327\327\327\327\327\327\327\327\327\335\327\327\327"+
    "\336\003\337\337\337\337\337\340\340\340\340\340\341\341\341\341\341\342\342"+
    "\342\342\342\343\343\343\343\343\121\121\121\121\121\121\121\121\121\121\121"+
    "\121\121\121\121\121\121\121\121\121\121\121\121\121\121\121\121\317\014\043"+
    "\121\121\121\121\121\121\121\121\317\014\014\014\043\014\014\014\014\014\014"+
    "\014\317\344\171\171\003\003\003\003\003\003\003\123\121\121\123\121\121\121"+
    "\121\121\121\121\003\003\003\003\003\003\003\003\055\055\055\056\055\055\055"+
    "\055\055\055\055\055\056\120\055\055\055\120\056\055\055\056\003\003\003\003"+
    "\003\003\003\003\003\003\066\066\067\102\103\103\103\103\121\121\121\122\003"+
    "\003\003\003\345\345\345\345\345\345\345\345\345\345\345\345\345\345\345\345"+
    "\345\346\346\346\346\346\346\346\346\346\346\346\346\346\346\346\346\346\121"+
    "\223\121\122\003\003\347\347\347\347\347\003\003\126\003\003\003\003\003\003"+
    "\003\003\350\351\351\351\351\352\353\354\354\354\354\354\354\354\354\354\354"+
    "\354\354\354\354\354\354\354\354\355\356\356\356\356\357\354\360\361\362\003"+
    "\003\003\003\003\150\150\363\150\150\150\150\150\150\150\150\150\150\150\150"+
    "\150\363\364\364\363\363\150\150\150\150\364\150\150\363\363\003\003\003\364"+
    "\003\363\363\363\363\150\363\364\364\363\363\363\363\363\363\364\364\363\150"+
    "\364\150\150\150\364\150\150\363\150\364\364\150\150\150\150\150\363\150\150"+
    "\150\150\150\150\150\150\003\003\363\150\363\150\150\363\150\150\150\150\150"+
    "\150\150\150\003\003\003\003\003\003\003\003\003\003\365\003\003\003\003\003"+
    "\003\003\036\036\036\036\036\036\003\003\036\036\036\036\036\036\036\036\036"+
    "\036\036\036\036\036\036\036\036\036\003\003\003\003\003\003\036\036\036\036"+
    "\036\036\036\042\366\036\036\036\036\036\036\036\366\036\036\036\036\036\036"+
    "\036\366\036\036\036\036\036\036\036\036\036\036\036\036\036\036\036\036\036"+
    "\036\003\003\003\003\003\367\370\370\370\370\371\372\003\014\014\014\014\014"+
    "\014\014\014\014\014\014\014\014\014\014\373\374\374\374\374\374\374\374\374"+
    "\374\374\374\374\374\014\014\014\374\374\374\374\374\374\374\374\374\374\374"+
    "\374\374\036\003\003\374\374\374\374\374\374\374\374\374\374\374\374\374\014"+
    "\014\014\014\014\014\014\014\014\014\014\014\014\014\014\014\014\041\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\014\014\014\014\014\014\014\014\014"+
    "\014\014\014\014\014\041\003\003\003\003\003\003\014\014\014\014\014\014\014"+
    "\014\014\014\014\014\014\014\014\014\014\014\014\014\014\014\003\003\014\014"+
    "\014\014\041\003\003\003\014\003\003\003\003\003\003\003\036\036\036\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\036\036\036\036\036\036\036\036"+
    "\036\036\036\036\036\375\376\376\036\036\036\036\036\036\036\036\036\036\042"+
    "\003\003\003\003\003\036\036\036\036\036\036\042\003\036\036\036\036\036\003"+
    "\003\003\036\036\036\036\036\036\036\036\036\036\036\036\042\003\003\003\036"+
    "\036\036\036\003\003\003\003\036\036\036\036\036\003\003\003\036\036\036\036"+
    "\003\003\003\003\036\036\036\036\036\036\036\036\036\036\036\036\036\036\036"+
    "\003\003\003\003\003\003\003\003\003\036\036\036\036\036\036\036\036\036\036"+
    "\036\036\036\036\036\042\036\036\036\036\036\036\036\036\042\366\036\042\003"+
    "\042\036\036\036\042\003\003\003\003\003\003\036\036\036\036\036\003\003\003"+
    "\036\042\003\003\003\003\003\003\036\036\036\036\036\036\036\036").toCharArray();

  // The A table has 510 entries for a total of 2040 bytes.

  static final int A[] = new int[510];
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
    "\u3409\u0800\u7005\u0800\u7005\u0800\u7005\u7800\000\u7800\000\u0800\u7005"+
    "\u7800\000\u0800\030\u0800\u052B\u0800\u052B\u0800\u052B\u0800\u05EB\u0800"+
    "\u070B\u0800\u080B\u0800\u080B\u0800\u080B\u0800\u7005\u0800\034\u0800\034"+
    "\u0800\u050B\u0800\u050B\u0800\u050B\u0800\u058B\u0800\u06AB\u7800\000\u0800"+
    "\u074B\u0800\u074B\u0800\u074B\u0800\u074B\u0800\u072B\u0800\u072B\u0800\u07AB"+
    "\u0800\u04CB\u0800\u080B\u7800\000\u0800\u04CB\u0800\u052B\u0800\u05AB\u0800"+
    "\u06CB\u0800\u080B\u0800\u056B\u0800\u066B\u0800\u078B\u0800\u080B\u7800\000"+
    "\u6800\030\u0800\u042B\u0800\u042B\u0800\u054B\u0800\u066B\u0800\u7005\u4000"+
    "\u3006\u7800\000\u4000\u3006\u4000\u3006\u4000\u3006\u4000\u3006\u7800\000"+
    "\u7800\000\u4000\u3006\u0800\u04CB\u0800\u05EB\u0800\u080B\u7800\000\u0800"+
    "\030\u0800\030\u0800\030\u7800\000\u0800\u7005\u0800\u048B\u0800\u080B\u0800"+
    "\030\u0800\034\u0800\u7005\u0800\u7005\u4000\u3006\u7800\000\u0800\u06CB\u6800"+
    "\030\u6800\030\u0800\u05CB\u0800\u06EB\u7800\000\u0800\u070B\u0800\u070B\u0800"+
    "\u070B\u0800\u070B\u0800\u07AB\u0902\u7001\u0902\u7001\u0902\u7001\u7800\000"+
    "\u0901\u7002\u0901\u7002\u0901\u7002\u7800\000\u0800\u04EB\u0800\u054B\u0800"+
    "\u05CB\u0800\u080B\u1000\u7005\u1000\u7005\u3000\u3609\u3000\u3609\u3000\u042B"+
    "\u3000\u042B\u3000\u054B\u3000\u066B\u3000\u080B\u3000\u080B\u3000\u080B\u7800"+
    "\000\u0800\u048B\u0800\u048B\u0800\u050B\u0800\u062B\u0800\u074B\u0800\u080B"+
    "\u0800\u080B\u0800\u7005\u4000\u3006\u1000\u060B\u1000\u070B\u1000\u042B\u1000"+
    "\u080B\u1000\030\u1000\030\u1000\030\000\u3008\u4000\u3006\000\u3008\000\u7005"+
    "\u4000\u3006\000\030\000\030\000\030\u6800\u05EB\u6800\u05EB\u6800\u070B\u6800"+
    "\u042B\000\u3749\000\u3749\000\u3008\000\u3008\u4000\u3006\000\u3008\000\u3008"+
    "\u4000\u3006\000\030\000\u1010\u7800\000\000\u1010\000\u3609\000\u3609\u4000"+
    "\u3006\000\u7005\000\u7005\u4000\u3006\u4000\u3006\u4000\u3006\000\u3549\000"+
    "\u3549\000\u7005\000\u3008\000\u3008\u7800\000\000\u7005\u4000\u3006\000\u3008"+
    "\000\u7005\000\u7005\000\030\000\030\u4000\u3006\u7800\000\000\u040B\000\u040B"+
    "\000\u040B\000\u040B\000\u052B\000\u064B\000\u080B\000\u080B\u7800\000\u4000"+
    "\u3006\000\u3008\u4000\u3006\u4000\u3006\u4000\u3006\000\u7005\u7800\000\000"+
    "\u3008\000\u3008\000\u3008\000\030\000\u7005\u4000\u3006\000\030\u6800\030"+
    "\u7800\000\000\u3008\u4000\u3006\000\u060B\000\u072B\000\030\000\034\202\u7001"+
    "\202\u7001\201\u7002\201\u7002\u4000\u3006\000\u3006\000\u3006\u4000\u3006"+
    "\000\u3008\000\u3006\000\u04EB\000\u04EB\000\u3008\000\030\000\u744A\000\u744A"+
    "\000\u776A\000\u776A\000\u776A\000\u76AA\000\u76AA\000\u76AA\000\u76AA\000"+
    "\u758A\000\u758A\000\u758A\000\u746A\000\u746A\000\u746A\000\u77EA\000\u77EA"+
    "\000\u77CA\000\u77CA\000\u77CA\000\u76AA\000\u768A\000\u768A\000\u768A\000"+
    "\u780A\000\u780A\000\u75AA\000\u75AA\000\u75AA\000\u758A\000\u752A\000\u750A"+
    "\000\u750A\000\u74EA\000\u74CA\000\u74AA\000\u74CA\000\u74CA\000\u74AA\000"+
    "\u748A\000\u748A\000\u746A\000\u746A\000\u744A\000\u742A\000\u740A\000\u770A"+
    "\000\u770A\000\u770A\000\u764A\000\u764A\000\u764A\000\u764A\000\u762A\000"+
    "\u762A\000\u760A\000\u752A\000\u752A\000\u780A\000\u776A\000\u776A\u7800\000"+
    "\000\u7004\000\u7004\u7800\000\000\u05EB\000\u05AB\000\u05AB\000\u05AB\000"+
    "\030\u4000\u3006\000\u7004\000\u7005\000\u7005\000\u7005\u7800\000\u4800\u1010"+
    "\u4800\u1010\000\034\000\u3008\000\u3008\000\u3008\000\u3008\u4800\u1010\u4800"+
    "\u1010\u4000\u3006\u4000\u3006\000\034\u4000\u3006\u6800\034\000\u042B\000"+
    "\u042B\000\u054B\000\u066B\000\u05EB\000\u05EB\000\u05EB\000\u054B\000\u05AB"+
    "\u7800\000\000\u7001\000\u7001\000\u7002\000\u7002\000\u7002\u7800\000\000"+
    "\u7001\u7800\000\u7800\000\000\u7001\u7800\000\000\u7002\000\u7001\000\031"+
    "\000\u7002\uE800\031\000\u7001\000\u7002\u1800\u3649\u1800\u3649\u1800\u3509"+
    "\u1800\u3509\u1800\u37C9\u1800\u37C9\u1800\u3689\u1800\u3689\u1800\u3549\u1800"+
    "\u3549\000\034\000\030\u088A\u7001\u088A\u7001\u0889\u7002\u0889\u7002\u0800"+
    "\u3609\u0800\u3609\u7800\000\u1000\u060B\u1000\u060B\u1000\u060B\u1000\u060B"+
    "\u1000\u072B\u1000\u044B\u1000\u080B\u1000\u080B\u1000\u080B\u1000\u080B\u1000"+
    "\u07CB\u1000\u07CB\u1000\u07CB\u1000\034\u1000\u080B\u1000\u601A\u1000\u060B"+
    "\u1000\u060B\u1000\u080B\u1000\u080B\u7800\000\u7800\000\u1000\u7005\u1000"+
    "\u7005\u7800\000\u6800\031\u6800\031\u7800\000\u6800\034\u1800\u040B\u1800"+
    "\u07EB\u1800\u07EB\u1800\u07EB\u1800\u07EB\u6800\u06AB\u6800\u068B\u7800\000"+
    "\000\034\u6800\034\000\034\000\034\u6800\034\u6800\033\u6800\033\u6800\033";

  // The B table has 510 entries for a total of 1020 bytes.

  static final char B[] = (
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\004\004\004\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\004\000\004\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\004\004\004\000\000\000\000\000\000\000\000"+
    "\000\000\000\004\004\004\004\004\000\000\000\000\000\000\000\004\000\000\004"+
    "\004\000\000\000\000\004\004\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\004\000\000\004\000\000\000\004\004\000\000\000"+
    "\004\000\000\000\000\000\000\000\000\000\000\000\000\000\004\004\004\004\004"+
    "\000\000\000\004\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\020\020\020\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\006\006\000\000\000\000").toCharArray();

  // In all, the character property tables require 14072 bytes.

    static {
                { // THIS CODE WAS AUTOMATICALLY CREATED BY GenerateCharacter:
            char[] data = A_DATA.toCharArray();
            assert (data.length == (510 * 2));
            int i = 0, j = 0;
            while (i < (510 * 2)) {
                int entry = data[i++] << 16;
                A[j++] = entry | data[i++];
            }
        }

    }        
}
