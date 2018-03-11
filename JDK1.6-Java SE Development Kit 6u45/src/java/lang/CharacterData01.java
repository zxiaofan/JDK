// This file was generated AUTOMATICALLY from a template file Tue Mar 26 15:08:50 PDT 2013

/* %W% %E%
 *
 * Copyright (c) 1994, 2002, Oracle and/or its affiliates. All rights reserved.
 *
 * This software is the proprietary information of Oracle.
 * Use is subject to license terms.
 *
 */

package java.lang;

/** The CharacterData class encapsulates the large tables once found in
 *  java.lang.Character. 
 */

class CharacterData01 {
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

    static int getProperties(int ch) {
        char offset = (char)ch;
        int props = A[Y[(X[offset>>5]<<4)|((offset>>1)&0xF)]|(offset&0x1)];
        return props;
    }

    static int getType(int ch) {
        int props = getProperties(ch);
        return (props & 0x1F);
    }

    static boolean isLowerCase(int ch) {
        int type = getType(ch);
        return (type == Character.LOWERCASE_LETTER);
    }

    static boolean isUpperCase(int ch) {
        int type = getType(ch);
        return (type == Character.UPPERCASE_LETTER);
                                                                                                                              }

    static boolean isTitleCase(int ch) {
        int type = getType(ch);
        return (type == Character.TITLECASE_LETTER);
    }

    static boolean isDigit(int ch) {
        int type = getType(ch);
        return (type == Character.DECIMAL_DIGIT_NUMBER);
    }

    static boolean isDefined(int ch) {
        int type = getType(ch);
        return (type != Character.UNASSIGNED);
    }

    static boolean isLetter(int ch) {
        int type = getType(ch);
        return (((((1 << Character.UPPERCASE_LETTER) |
            (1 << Character.LOWERCASE_LETTER) |
            (1 << Character.TITLECASE_LETTER) |
            (1 << Character.MODIFIER_LETTER) |
            (1 << Character.OTHER_LETTER)) >> type) & 1) != 0);
    }

    static boolean isLetterOrDigit(int ch) {
        int type = getType(ch);
        return (((((1 << Character.UPPERCASE_LETTER) |
            (1 << Character.LOWERCASE_LETTER) |
            (1 << Character.TITLECASE_LETTER) |
            (1 << Character.MODIFIER_LETTER) |
            (1 << Character.OTHER_LETTER) |
            (1 << Character.DECIMAL_DIGIT_NUMBER)) >> type) & 1) != 0);
    }

    static boolean isSpaceChar(int ch) {
        int type = getType(ch);
        return (((((1 << Character.SPACE_SEPARATOR) |
            (1 << Character.LINE_SEPARATOR) |
            (1 << Character.PARAGRAPH_SEPARATOR)) >> type) & 1) != 0);
    }


    static boolean isJavaIdentifierStart(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00007000) >= 0x00005000);
    }

    static boolean isJavaIdentifierPart(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00003000) != 0);
    }

    static boolean isUnicodeIdentifierStart(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00007000) == 0x00007000);
    }

    static boolean isUnicodeIdentifierPart(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00001000) != 0);
    }

    static boolean isIdentifierIgnorable(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00007000) == 0x00001000);
    }

    static int toLowerCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00020000) != 0) {
            int offset = val << 5 >> (5+18);
            mapChar = ch + offset;
        }
        return  mapChar;
    }

    static int toUpperCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00010000) != 0) {
            int offset = val  << 5 >> (5+18);
            mapChar =  ch - offset;
        }
        return  mapChar;
    }

    static int toTitleCase(int ch) {
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

    static int digit(int ch, int radix) {
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

    static int getNumericValue(int ch) {
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
            case 0x10323: retval = 50; break;      // OLD ITALIC NUMERAL FIFTY
            default: retval = -2; break;
            }
            
            break;
        case (0x00000C00):           // Java supradecimal
            retval = (ch + ((val & 0x3E0) >> 5) & 0x1F) + 10;
            break;
        }
        return retval;
    }

    static boolean isWhitespace(int ch) {
        int props = getProperties(ch);
        return ((props & 0x00007000) == 0x00004000);
    }

    static byte getDirectionality(int ch) {
        int val = getProperties(ch);
        byte directionality = (byte)((val & 0x78000000) >> 27);
        if (directionality == 0xF ) {
            directionality = Character.DIRECTIONALITY_UNDEFINED;
        }
        return directionality;
    }

    static boolean isMirrored(int ch) {
        int props = getProperties(ch);
        return ((props & 0x80000000) != 0);
    }

	// may need to implement for JSR 204
    // static int toUpperCaseEx(int ch);
    // static char[] toUpperCaseCharArray(int ch);

    // The following tables and code generated using:
  // java GenerateCharacter -plane 1 -template ../../tools/GenerateCharacter/CharacterData01.java.template -spec ../../tools/GenerateCharacter/UnicodeData.txt -specialcasing ../../tools/GenerateCharacter/SpecialCasing.txt -o /BUILD_AREA/jdk6_45/control/build/linux-amd64/gensrc/java/lang/CharacterData01.java -string -usecharforbyte 11 4 1
  // The X table has 2048 entries for a total of 4096 bytes.

  static final char X[] = (
    "\000\001\002\003\004\004\004\005\006\007\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\010\011\012\003\013\003\003\003\014\015\016\004\017\020"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\021\022\003\003\003\003\003\003\003\003\003\003"+
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
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\023\023\023\023\023\023\023\024"+
    "\023\025\023\026\027\030\031\003\003\003\003\003\003\003\003\003\032\032\033"+
    "\003\003\003\003\003\034\035\036\037\040\041\042\043\044\045\046\047\050\034"+
    "\035\051\037\052\053\054\043\055\056\057\060\061\062\063\064\065\066\067\003"+
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
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003"+
    "\003\003\003\003\003\003\003\003\003\003\003\003\003\003\003").toCharArray();

  // The Y table has 896 entries for a total of 1792 bytes.

  static final char Y[] = (
    "\000\000\000\000\000\000\002\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\004\000\000\000\000\000\000\000\000\000\004\000\002\000\000\000\000\000\000"+
    "\000\006\000\000\000\000\000\000\000\006\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\006\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\004\006"+
    "\006\010\012\006\014\016\016\016\016\020\022\024\024\024\024\024\024\024\024"+
    "\024\024\024\024\024\024\024\024\006\026\030\030\030\030\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\000\000\004\032\034\006\006\006\006\006\006"+
    "\000\000\000\000\000\000\000\000\000\000\000\000\000\036\006\006\006\006\006"+
    "\006\006\006\006\006\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\040\042\042\042\042\042\042\042\042\042\042\042\042\042\042\042\042\042"+
    "\042\042\042\044\044\044\044\044\044\044\044\044\044\044\044\044\044\044\044"+
    "\044\044\044\044\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\000\000\000\000\006\046\046\046\046\046\006\006\006\006\006"+
    "\006\006\006\006\006\006\050\050\050\006\052\050\050\050\050\050\050\050\050"+
    "\050\050\050\050\050\050\050\050\050\050\050\050\050\050\054\052\006\052\054"+
    "\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030"+
    "\030\030\030\030\030\030\030\030\006\006\006\006\006\030\030\030\012\006\030"+
    "\030\030\030\030\030\030\030\030\030\030\030\030\056\060\062\030\056\064\064"+
    "\066\070\070\070\072\062\062\062\074\076\062\062\062\030\030\030\030\030\030"+
    "\030\030\030\030\030\030\030\030\030\062\062\030\030\030\030\030\030\030\030"+
    "\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\030\006\100\100"+
    "\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100\100"+
    "\100\100\100\100\100\100\102\006\006\006\006\104\104\104\104\104\104\104\104"+
    "\104\104\104\104\104\106\106\106\106\106\106\106\106\106\106\106\106\106\104"+
    "\104\104\104\104\104\104\104\104\104\104\104\104\106\106\106\110\106\106\106"+
    "\106\106\106\106\106\106\104\104\104\104\104\104\104\104\104\104\104\104\104"+
    "\106\106\106\106\106\106\106\106\106\106\106\106\106\112\104\006\112\114\112"+
    "\114\104\112\104\104\104\104\106\106\116\116\106\106\106\116\106\106\106\106"+
    "\106\104\104\104\104\104\104\104\104\104\104\104\104\104\106\106\106\106\106"+
    "\106\106\106\106\106\106\106\106\104\114\104\112\114\104\104\104\112\104\104"+
    "\104\112\106\106\106\106\106\106\106\106\106\106\106\106\106\104\114\104\112"+
    "\104\104\112\112\006\104\104\104\112\106\106\106\106\106\106\106\106\106\106"+
    "\106\106\106\104\104\104\104\104\104\104\104\104\104\104\104\104\106\106\106"+
    "\106\106\106\106\106\106\106\106\106\106\104\104\104\104\104\104\104\106\106"+
    "\106\106\106\106\106\106\106\104\106\106\106\106\106\106\106\106\106\106\106"+
    "\106\106\104\104\104\104\104\104\104\104\104\104\104\104\104\106\106\106\106"+
    "\106\106\106\106\106\106\106\106\106\104\104\104\104\104\104\104\104\106\106"+
    "\006\006\104\104\104\104\104\104\104\104\104\104\104\104\120\106\106\106\106"+
    "\106\106\106\106\106\106\106\106\122\106\106\106\104\104\104\104\104\104\104"+
    "\104\104\104\104\104\120\106\106\106\106\106\106\106\106\106\106\106\106\122"+
    "\106\106\106\104\104\104\104\104\104\104\104\104\104\104\104\120\106\106\106"+
    "\106\106\106\106\106\106\106\106\106\122\106\106\106\104\104\104\104\104\104"+
    "\104\104\104\104\104\104\120\106\106\106\106\106\106\106\106\106\106\106\106"+
    "\122\106\106\106\104\104\104\104\104\104\104\104\104\104\104\104\120\106\106"+
    "\106\106\106\106\106\106\106\106\106\106\122\106\106\106\006\006\124\124\124"+
    "\124\124\126\126\126\126\126\130\130\130\130\130\132\132\132\132\132\134\134"+
    "\134\134\134").toCharArray();

  // The A table has 94 entries for a total of 376 bytes.

  static final int A[] = new int[94];
  static final String A_DATA =
    "\000\u7005\000\u7005\u7800\000\000\u7005\000\u7005\u7800\000\u7800\000\u7800"+
    "\000\000\030\u6800\030\000\034\u7800\000\u7800\000\000\u074B\000\u074B\000"+
    "\u074B\000\u074B\000\u046B\000\u058B\000\u080B\000\u080B\000\u080B\u7800\000"+
    "\000\034\000\034\000\034\000\u042B\000\u048B\000\u050B\000\u080B\000\u700A"+
    "\u7800\000\u7800\000\000\030\242\u7001\242\u7001\241\u7002\241\u7002\000\u3409"+
    "\000\u3409\u0800\u7005\u0800\u7005\u0800\u7005\u7800\000\u7800\000\u0800\u7005"+
    "\000\034\000\u3008\000\u3008\u4000\u3006\u4000\u3006\u4000\u3006\000\u3008"+
    "\000\u3008\000\u3008\u4800\u1010\u4800\u1010\u4800\u1010\u4800\u1010\u4000"+
    "\u3006\u4000\u3006\000\034\000\034\u4000\u3006\u6800\034\u6800\034\u6800\034"+
    "\u7800\000\000\u7001\000\u7001\000\u7002\000\u7002\000\u7002\u7800\000\000"+
    "\u7001\u7800\000\u7800\000\000\u7001\u7800\000\000\u7002\000\u7001\000\031"+
    "\000\u7002\000\031\u1800\u3649\u1800\u3649\u1800\u3509\u1800\u3509\u1800\u37C9"+
    "\u1800\u37C9\u1800\u3689\u1800\u3689\u1800\u3549\u1800\u3549";

  // In all, the character property tables require 6264 bytes.

    static {
                { // THIS CODE WAS AUTOMATICALLY CREATED BY GenerateCharacter:
            char[] data = A_DATA.toCharArray();
            assert (data.length == (94 * 2));
            int i = 0, j = 0;
            while (i < (94 * 2)) {
                int entry = data[i++] << 16;
                A[j++] = entry | data[i++];
            }
        }

    }        
}
