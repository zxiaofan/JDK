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

/** 
 * The CharacterData00 class encapsulates the large tables once found in
 * java.lang.Character
*/

class CharacterData00 {
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
        int props = A[Y[X[offset>>5]|((offset>>1)&0xF)]|(offset&0x1)];
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
          if ((val & 0x07FC0000) == 0x07FC0000) {
            switch(ch) {
              // map the offset overflow chars
			case 0x0130 : mapChar = 0x0069; break;
            case 0x2126 : mapChar = 0x03C9; break;
            case 0x212A : mapChar = 0x006B; break;
            case 0x212B : mapChar = 0x00E5; break;
              // map the titlecase chars with both a 1:M uppercase map
              // and a lowercase map
            case 0x1F88 : mapChar = 0x1F80; break;
            case 0x1F89 : mapChar = 0x1F81; break;
            case 0x1F8A : mapChar = 0x1F82; break;
            case 0x1F8B : mapChar = 0x1F83; break;
            case 0x1F8C : mapChar = 0x1F84; break;
            case 0x1F8D : mapChar = 0x1F85; break;
            case 0x1F8E : mapChar = 0x1F86; break;
            case 0x1F8F : mapChar = 0x1F87; break;
            case 0x1F98 : mapChar = 0x1F90; break;
            case 0x1F99 : mapChar = 0x1F91; break;
            case 0x1F9A : mapChar = 0x1F92; break;
            case 0x1F9B : mapChar = 0x1F93; break;
            case 0x1F9C : mapChar = 0x1F94; break;
            case 0x1F9D : mapChar = 0x1F95; break;
            case 0x1F9E : mapChar = 0x1F96; break;
            case 0x1F9F : mapChar = 0x1F97; break;
            case 0x1FA8 : mapChar = 0x1FA0; break;
            case 0x1FA9 : mapChar = 0x1FA1; break;
            case 0x1FAA : mapChar = 0x1FA2; break;
            case 0x1FAB : mapChar = 0x1FA3; break;
            case 0x1FAC : mapChar = 0x1FA4; break;
            case 0x1FAD : mapChar = 0x1FA5; break;
            case 0x1FAE : mapChar = 0x1FA6; break;
            case 0x1FAF : mapChar = 0x1FA7; break;
            case 0x1FBC : mapChar = 0x1FB3; break;
            case 0x1FCC : mapChar = 0x1FC3; break;
            case 0x1FFC : mapChar = 0x1FF3; break;
              // default mapChar is already set, so no
              // need to redo it here.
              // default       : mapChar = ch;
            }
          }
          else {
            int offset = val << 5 >> (5+18);
            mapChar = ch + offset;
          }
        }
        return mapChar;
    }

    static int toUpperCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00010000) != 0) {
          if ((val & 0x07FC0000) == 0x07FC0000) {
            switch(ch) {
              // map chars with overflow offsets
            case 0x00B5 : mapChar = 0x039C; break;
            case 0x017F : mapChar = 0x0053; break;
            case 0x1FBE : mapChar = 0x0399; break;
              // map char that have both a 1:1 and 1:M map
            case 0x1F80 : mapChar = 0x1F88; break;
            case 0x1F81 : mapChar = 0x1F89; break;
            case 0x1F82 : mapChar = 0x1F8A; break;
            case 0x1F83 : mapChar = 0x1F8B; break;
            case 0x1F84 : mapChar = 0x1F8C; break;
            case 0x1F85 : mapChar = 0x1F8D; break;
            case 0x1F86 : mapChar = 0x1F8E; break;
            case 0x1F87 : mapChar = 0x1F8F; break;
            case 0x1F90 : mapChar = 0x1F98; break;
            case 0x1F91 : mapChar = 0x1F99; break;
            case 0x1F92 : mapChar = 0x1F9A; break;
            case 0x1F93 : mapChar = 0x1F9B; break;
            case 0x1F94 : mapChar = 0x1F9C; break;
            case 0x1F95 : mapChar = 0x1F9D; break;
            case 0x1F96 : mapChar = 0x1F9E; break;
            case 0x1F97 : mapChar = 0x1F9F; break;
            case 0x1FA0 : mapChar = 0x1FA8; break;
            case 0x1FA1 : mapChar = 0x1FA9; break;
            case 0x1FA2 : mapChar = 0x1FAA; break;
            case 0x1FA3 : mapChar = 0x1FAB; break;
            case 0x1FA4 : mapChar = 0x1FAC; break;
            case 0x1FA5 : mapChar = 0x1FAD; break;
            case 0x1FA6 : mapChar = 0x1FAE; break;
            case 0x1FA7 : mapChar = 0x1FAF; break;
            case 0x1FB3 : mapChar = 0x1FBC; break;
            case 0x1FC3 : mapChar = 0x1FCC; break;
            case 0x1FF3 : mapChar = 0x1FFC; break;
              // ch must have a 1:M case mapping, but we
              // can't handle it here. Return ch.
              // since mapChar is already set, no need
              // to redo it here.
              //default       : mapChar = ch;
            }
          }
          else {
            int offset = val  << 5 >> (5+18);
            mapChar =  ch - offset;
          }
        }
        return mapChar;
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
        return mapChar;
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
            switch (ch) {
                case 0x0BF1: retval = 100; break;         // TAMIL NUMBER ONE HUNDRED
                case 0x0BF2: retval = 1000; break;        // TAMIL NUMBER ONE THOUSAND
                case 0x1375: retval = 40; break;          // ETHIOPIC NUMBER FORTY
                case 0x1376: retval = 50; break;          // ETHIOPIC NUMBER FIFTY
                case 0x1377: retval = 60; break;          // ETHIOPIC NUMBER SIXTY
                case 0x1378: retval = 70; break;          // ETHIOPIC NUMBER SEVENTY
                case 0x1379: retval = 80; break;          // ETHIOPIC NUMBER EIGHTY
                case 0x137A: retval = 90; break;          // ETHIOPIC NUMBER NINETY
                case 0x137B: retval = 100; break;         // ETHIOPIC NUMBER HUNDRED
                case 0x137C: retval = 10000; break;       // ETHIOPIC NUMBER TEN THOUSAND
                case 0x215F: retval = 1; break;           // FRACTION NUMERATOR ONE
                case 0x216C: retval = 50; break;          // ROMAN NUMERAL FIFTY
                case 0x216D: retval = 100; break;         // ROMAN NUMERAL ONE HUNDRED
                case 0x216E: retval = 500; break;         // ROMAN NUMERAL FIVE HUNDRED
                case 0x216F: retval = 1000; break;        // ROMAN NUMERAL ONE THOUSAND
                case 0x217C: retval = 50; break;          // SMALL ROMAN NUMERAL FIFTY
                case 0x217D: retval = 100; break;         // SMALL ROMAN NUMERAL ONE HUNDRED
                case 0x217E: retval = 500; break;         // SMALL ROMAN NUMERAL FIVE HUNDRED
                case 0x217F: retval = 1000; break;        // SMALL ROMAN NUMERAL ONE THOUSAND
                case 0x2180: retval = 1000; break;        // ROMAN NUMERAL ONE THOUSAND C D
                case 0x2181: retval = 5000; break;        // ROMAN NUMERAL FIVE THOUSAND
                case 0x2182: retval = 10000; break;       // ROMAN NUMERAL TEN THOUSAND

                case 0x325C: retval = 32; break;

                case 0x325D: retval = 33; break;          // CIRCLED NUMBER THIRTY THREE
                case 0x325E: retval = 34; break;          // CIRCLED NUMBER THIRTY FOUR
                case 0x325F: retval = 35; break;          // CIRCLED NUMBER THIRTY FIVE
                case 0x32B1: retval = 36; break;          // CIRCLED NUMBER THIRTY SIX
                case 0x32B2: retval = 37; break;          // CIRCLED NUMBER THIRTY SEVEN
                case 0x32B3: retval = 38; break;          // CIRCLED NUMBER THIRTY EIGHT
                case 0x32B4: retval = 39; break;          // CIRCLED NUMBER THIRTY NINE
                case 0x32B5: retval = 40; break;          // CIRCLED NUMBER FORTY
                case 0x32B6: retval = 41; break;          // CIRCLED NUMBER FORTY ONE
                case 0x32B7: retval = 42; break;          // CIRCLED NUMBER FORTY TWO
                case 0x32B8: retval = 43; break;          // CIRCLED NUMBER FORTY THREE
                case 0x32B9: retval = 44; break;          // CIRCLED NUMBER FORTY FOUR
                case 0x32BA: retval = 45; break;          // CIRCLED NUMBER FORTY FIVE
                case 0x32BB: retval = 46; break;          // CIRCLED NUMBER FORTY SIX
                case 0x32BC: retval = 47; break;          // CIRCLED NUMBER FORTY SEVEN
                case 0x32BD: retval = 48; break;          // CIRCLED NUMBER FORTY EIGHT
                case 0x32BE: retval = 49; break;          // CIRCLED NUMBER FORTY NINE
                case 0x32BF: retval = 50; break;          // CIRCLED NUMBER FIFTY

                default:       retval = -2; break;
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
            switch(ch) {
                case 0x202A :
                    // This is the only char with LRE
                    directionality = Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING;
                    break;
                case 0x202B :
                    // This is the only char with RLE
                    directionality = Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING;
                    break;
                case 0x202C :
                    // This is the only char with PDF
                    directionality = Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT;
                    break;
                case 0x202D :
                    // This is the only char with LRO
                    directionality = Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE;
                    break;
                case 0x202E :
                    // This is the only char with RLO
                    directionality = Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE;
                    break;
                default :
                    directionality = Character.DIRECTIONALITY_UNDEFINED;
                    break;
            }
        }
        return directionality;
    }

    static boolean isMirrored(int ch) {
        int props = getProperties(ch);
        return ((props & 0x80000000) != 0);
    }

    static int toUpperCaseEx(int ch) {
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
                    case 0x017F : mapChar = 0x0053; break;
                    case 0x1FBE : mapChar = 0x0399; break;
                    default       : mapChar = Character.ERROR; break;
                }
            }
        }
        return mapChar;
    }

    static char[] toUpperCaseCharArray(int ch) {
        char[] upperMap = {(char)ch};
        int location = findInCharMap(ch);
        if (location != -1) {
            upperMap = charMap[location][1];
        }
        return upperMap;
    }


    /**
     * Finds the character in the uppercase mapping table.
     *
     * @param ch the <code>char</code> to search
     * @return the index location ch in the table or -1 if not found
     * @since 1.4
     */
    static  int findInCharMap(int ch) {
        if (charMap == null || charMap.length == 0) {
            return -1;
        }
        int top, bottom, current;
        bottom = 0;
        top = charMap.length;
        current = top/2;
        // invariant: top > current >= bottom && ch >= CharacterData.charMap[bottom][0]
        while (top - bottom > 1) {
            if (ch >= charMap[current][0][0]) {
                bottom = current;
            } else {
                top = current;
            }
            current = (top + bottom) / 2;
        }
        if (ch == charMap[current][0][0]) return current;
        else return -1;
    }


    // The following tables and code generated using:
  // java GenerateCharacter -plane 0 -template ../../tools/GenerateCharacter/CharacterData00.java.template -spec ../../tools/GenerateCharacter/UnicodeData.txt -specialcasing ../../tools/GenerateCharacter/SpecialCasing.txt -o /BUILD_AREA/jdk6_45/control/build/linux-amd64/gensrc/java/lang/CharacterData00.java -string -usecharforbyte 11 4 1
      static final char[][][] charMap;
// The X table has 2048 entries for a total of 4096 bytes.

  static final char X[] = (
    "\000\020\040\060\100\120\140\160\200\220\240\260\300\320\340\360\200\u0100"+
    "\u0110\u0120\u0130\u0140\u0150\u0160\u0170\u0170\u0180\u0190\u01A0\u01B0\u01C0"+
    "\u01D0\u01E0\u01F0\u0200\200\u0210\200\u0220\u0230\u0240\u0250\u0260\u0270"+
    "\u0280\u0290\u02A0\u02B0\u02C0\u02D0\u02E0\u02F0\u0300\u0300\u0310\u0320\u0330"+
    "\u0340\u0350\u0360\u0300\u0370\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360"+
    "\u0360\u0360\u0380\u0390\u03A0\u03B0\u03C0\u03D0\u03E0\u03F0\u0400\u0410\u0420"+
    "\u0430\u0440\u0450\u0460\u0470\u03C0\u0480\u0490\u04A0\u04B0\u04C0\u04D0\u04E0"+
    "\u04F0\u0500\u0510\u0520\u0530\u0540\u0550\u0520\u0530\u0560\u0570\u0520\u0580"+
    "\u0590\u05A0\u05B0\u05C0\u05D0\u05E0\u0360\u05F0\u0600\u0610\u0360\u0620\u0630"+
    "\u0640\u0650\u0660\u0670\u0680\u0360\u0690\u06A0\u06B0\u0360\u0360\u06C0\u06D0"+
    "\u06E0\u0690\u0690\u06F0\u0690\u0690\u0700\u0690\u0710\u0720\u0690\u0730\u0690"+
    "\u0740\u0750\u0760\u0770\u0750\u0690\u0780\u0790\u0360\u0690\u0690\u07A0\u05C0"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u07B0\u07C0\u0690\u0690\u07D0\u07E0\u07F0\u0800"+
    "\u0810\u0690\u0820\u0830\u0840\u0850\u0690\u0860\u0870\u0690\u0880\u0360\u0360"+
    "\u0890\u08A0\u08B0\u08C0\u0360\u0360\u0360\u08D0\u0360\u0360\u0360\u0360\u0360"+
    "\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360"+
    "\u0360\u0360\u0360\u0360\u0360\u0360\u08E0\u08F0\u0900\u0910\u0360\u0360\u0360"+
    "\u0360\200\200\200\200\u0920\200\200\u0930\u0940\u0950\u0960\u0970\u0980\u0990"+
    "\u09A0\u09B0\u09C0\u09D0\u09E0\u09F0\u0A00\u0A10\u0A20\u0A30\u0A40\u0A50\u0A60"+
    "\u0A70\u0A80\u0A90\u0AA0\u0AB0\u0AC0\u0AD0\u0AE0\u0AF0\u0B00\u0B10\u0B20\u0B30"+
    "\u0B40\u0B50\u0B60\u0B70\u0B80\u0B90\u0BA0\u0360\u08D0\u0BB0\u0BC0\u0BD0\u0BE0"+
    "\u0BF0\u0C00\u0C10\u08D0\u08D0\u08D0\u08D0\u08D0\u0C20\u0C30\u0C40\u0C50\u08D0"+
    "\u08D0\u0C60\u0C70\u0C80\u0360\u0360\u0C90\u0CA0\u0CB0\u0CC0\u0CD0\u0CE0\u0CF0"+
    "\u0D00\u08D0\u08D0\u08D0\u08D0\u08D0\u08D0\u08D0\u08D0\u0D10\u0D10\u0D10\u0D10"+
    "\u0D20\u0D30\u0D40\u0D50\u0D60\u0D70\u0D80\u0D90\u0DA0\u0DB0\u0DC0\u0DD0\u0DE0"+
    "\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360"+
    "\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360"+
    "\u0360\u0DF0\u08D0\u08D0\u0E00\u08D0\u08D0\u08D0\u08D0\u08D0\u08D0\u0E10\u0E20"+
    "\u0E30\u0E40\u05C0\u0690\u0E50\u0E60\u0690\u0E70\u0E80\u0E90\u0690\u0690\u0EA0"+
    "\u0870\u0360\u0EB0\u0EC0\u0ED0\u0EE0\u0EF0\u0ED0\u0F00\u0F10\u0F20\u0B60\u0B60"+
    "\u0B60\u0F30\u0B60\u0B60\u0F40\u0F50\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0F60\u08D0\u08D0\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0F70\u0360\u0360\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0F80\u08D0\u0BB0\u0360"+
    "\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360"+
    "\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360"+
    "\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360"+
    "\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360\u0360"+
    "\u0360\u0360\u0360\u0360\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0F90\u0360\u0360\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0"+
    "\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0"+
    "\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0"+
    "\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0"+
    "\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0\u0FA0"+
    "\u0FA0\u0FA0\u0FA0\u0FA0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0"+
    "\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0FB0\u0690\u0690\u0690\u0690"+
    "\u0690\u0690\u0690\u0690\u0690\u0FC0\u0690\u0FD0\u0360\u0360\u0360\u0360\u0FE0"+
    "\u0FF0\u1000\u0300\u0300\u1010\u1020\u0300\u0300\u0300\u0300\u0300\u0300\u0300"+
    "\u0300\u0300\u0300\u1030\u1040\u0300\u1050\u0300\u1060\u1070\u1080\u1090\u10A0"+
    "\u10B0\u0300\u0300\u0300\u10C0\u10D0\040\u10E0\u10F0\u1100\u1110\u1120\u1130").toCharArray();

  // The Y table has 4416 entries for a total of 8832 bytes.

  static final char Y[] = (
    "\000\000\000\000\002\004\006\000\000\000\000\000\000\000\010\004\012\014\016"+
    "\020\022\024\026\030\032\032\032\032\032\034\036\040\042\044\044\044\044\044"+
    "\044\044\044\044\044\044\044\046\050\052\054\056\056\056\056\056\056\056\056"+
    "\056\056\056\056\060\062\064\000\000\066\000\000\000\000\000\000\000\000\000"+
    "\000\000\000\000\070\072\072\074\076\100\102\104\106\110\112\114\116\120\122"+
    "\124\126\126\126\126\126\126\126\126\126\126\126\130\126\126\126\132\134\134"+
    "\134\134\134\134\134\134\134\134\134\136\134\134\134\140\142\142\142\142\142"+
    "\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142"+
    "\144\142\142\142\146\150\150\150\150\150\150\150\152\142\142\142\142\142\142"+
    "\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142\142\154\150"+
    "\150\152\156\142\142\160\162\164\166\170\172\162\174\176\142\200\202\204\142"+
    "\142\142\206\210\200\142\206\212\214\150\216\142\220\142\222\224\224\226\230"+
    "\232\226\234\150\150\150\150\150\150\150\236\142\142\142\142\142\142\142\142"+
    "\142\240\232\142\242\142\142\142\142\244\142\142\142\142\142\142\142\142\142"+
    "\200\246\250\250\250\250\250\250\250\250\250\250\250\250\200\252\254\256\260"+
    "\262\200\200\264\266\200\200\270\200\200\272\200\274\276\200\200\200\200\200"+
    "\300\302\200\200\300\304\200\200\200\306\200\200\200\200\200\200\200\200\200"+
    "\200\200\200\200\200\310\310\310\310\312\314\310\310\310\316\316\320\320\320"+
    "\320\320\310\316\316\316\316\316\316\316\310\310\322\316\316\316\316\322\316"+
    "\316\316\316\316\316\316\316\324\324\324\324\324\324\324\324\324\324\324\324"+
    "\324\324\324\324\324\324\326\324\324\324\324\324\324\324\324\324\250\250\330"+
    "\324\324\324\324\324\324\324\324\324\250\250\316\250\250\332\250\334\250\250"+
    "\316\336\340\342\344\346\350\126\126\126\126\126\126\126\126\352\126\126\126"+
    "\126\354\356\360\134\134\134\134\134\134\134\134\362\134\134\134\134\364\366"+
    "\370\372\374\376\142\142\142\142\142\142\142\142\142\142\142\142\u0100\u0102"+
    "\u0104\u0106\u0108\142\250\250\u010A\u010A\u010A\u010A\u010A\u010A\u010A\u010A"+
    "\126\126\126\126\126\126\126\126\126\126\126\126\126\126\126\126\134\134\134"+
    "\134\134\134\134\134\134\134\134\134\134\134\134\134\u010C\u010C\u010C\u010C"+
    "\u010C\u010C\u010C\u010C\142\u010E\324\u0110\u0112\142\142\142\142\142\142"+
    "\142\142\142\142\142\u0114\150\150\150\150\150\150\u0116\142\142\142\142\142"+
    "\142\142\142\142\142\142\142\142\142\142\142\142\142\142\250\142\250\250\250"+
    "\142\142\142\142\142\142\142\142\250\250\250\250\250\250\250\250\250\250\250"+
    "\250\250\250\250\250\u0118\u011A\u011A\u011A\u011A\u011A\u011A\u011A\u011A"+
    "\u011A\u011A\u011A\u011A\u011A\u011A\u011A\u011A\u011A\u011A\u011C\u011E\u0120"+
    "\u0120\u0120\u0122\u0124\u0124\u0124\u0124\u0124\u0124\u0124\u0124\u0124\u0124"+
    "\u0124\u0124\u0124\u0124\u0124\u0124\u0124\u0124\u0126\u0128\u012A\250\250"+
    "\330\324\324\324\324\324\324\324\324\330\324\324\324\324\324\324\324\324\324"+
    "\324\324\330\324\u012C\u012C\u012E\u0110\250\250\250\250\250\u0130\u0130\u0130"+
    "\u0130\u0130\u0130\u0130\u0130\u0130\u0130\u0130\u0130\u0130\u0132\250\250"+
    "\u0130\u0134\u0136\250\250\250\250\250\u0138\u0138\250\250\250\250\u013A\074"+
    "\324\324\324\250\250\u013C\250\u013C\u013E\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\u0140\u0140\u0140\u0140\u0140\u0140\u0142\250\250\u0144\u0140\u0140\u0140"+
    "\u0140\u0146\324\324\324\324\324\324\u0110\250\250\250\u0148\u0148\u0148\u0148"+
    "\u0148\u014A\u014C\u0140\u014E\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0150"+
    "\324\324\324\u0152\u0154\324\324\u0156\u0158\u015A\324\324\u0140\032\032\032"+
    "\032\032\u0140\u015C\u015E\u0160\u0160\u0160\u0160\u0160\u0160\u0160\u0162"+
    "\u0146\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\u0140\u0140\u0140\324\324\324\324\324\324\324\324\324\324\324\324\324\u0110"+
    "\u013E\u0140\250\250\250\250\250\250\250\250\250\250\250\250\250\250\250\250"+
    "\250\250\250\250\250\250\250\250\u0140\u0140\u0140\324\324\324\324\324\u014E"+
    "\250\250\250\250\250\250\250\330\u0164\224\224\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\250"+
    "\u0166\u0168\u016A\324\324\324\u0164\u0168\u016A\250\u016C\324\u0110\250\224"+
    "\224\224\224\224\324\u0120\u016E\u016E\u016E\u016E\u016E\u0170\250\250\250"+
    "\250\250\250\250\330\u0168\u0172\224\224\224\u0174\u0172\u0174\u0172\224\224"+
    "\224\224\224\224\224\224\224\224\u0174\224\224\224\u0174\u0174\250\224\224"+
    "\250\u0166\u0168\u016A\324\u0110\u0176\u0178\u0176\u016A\250\250\250\250\u0176"+
    "\250\250\224\u0172\224\324\250\u016E\u016E\u016E\u016E\u016E\224\072\u017A"+
    "\u017A\u017C\u017E\250\250\330\u0164\u0172\224\224\u0174\250\u0172\u0174\u0172"+
    "\224\224\224\224\224\224\224\224\224\224\u0174\224\224\224\u0174\224\u0172"+
    "\u0174\224\250\u0110\u0168\u016A\u0110\250\330\u0110\330\324\250\250\250\250"+
    "\250\u0172\224\u0174\u0174\250\250\250\u016E\u016E\u016E\u016E\u016E\324\224"+
    "\u0174\250\250\250\250\250\330\u0164\u0172\224\224\224\224\u0172\224\u0172"+
    "\224\224\224\224\224\224\224\224\224\224\u0174\224\224\224\u0174\224\u0172"+
    "\224\224\250\u0166\u0168\u016A\324\324\330\u0164\u0176\u016A\250\u0174\250"+
    "\250\250\250\250\250\250\224\324\250\u016E\u016E\u016E\u016E\u016E\u0180\250"+
    "\250\250\250\250\250\250\224\224\224\224\u0174\224\224\224\u0174\224\u0172"+
    "\224\224\250\u0166\u016A\u016A\324\250\u0176\u0178\u0176\u016A\250\250\250"+
    "\250\u0164\250\250\224\u0172\224\250\250\u016E\u016E\u016E\u016E\u016E\u0182"+
    "\250\250\250\250\250\250\250\250\u0166\u0172\224\224\u0174\250\224\u0174\224"+
    "\224\250\u0172\u0174\u0174\224\250\u0172\u0174\250\224\u0174\250\224\224\224"+
    "\224\u0172\224\250\250\u0168\u0164\u0178\250\u0168\u0178\u0168\u016A\250\250"+
    "\250\250\u0176\250\250\250\250\250\250\250\u0184\u016E\u016E\u016E\u016E\u0186"+
    "\u0188\074\074\u018A\u018C\250\250\u0176\u0168\u0172\224\224\224\u0174\224"+
    "\u0174\224\224\224\224\224\224\224\224\224\224\224\u0174\224\224\224\224\224"+
    "\u0172\224\224\250\250\324\u0164\u0168\u0178\324\u0110\324\324\250\250\250"+
    "\330\u0110\250\250\250\250\224\250\250\u016E\u016E\u016E\u016E\u016E\250\250"+
    "\250\250\250\250\250\250\250\u0168\u0172\224\224\224\u0174\224\u0174\224\224"+
    "\224\224\224\224\224\224\224\224\224\u0174\224\224\224\224\224\u0172\224\224"+
    "\250\u0166\u018E\u0168\u0168\u0178\u0190\u0178\u0168\324\250\250\250\u0176"+
    "\u0178\250\250\250\u0174\224\224\224\224\u0174\224\224\224\224\224\224\224"+
    "\224\250\250\u0168\u016A\324\250\u0168\u0178\u0168\u016A\250\250\250\250\u0176"+
    "\250\250\250\250\250\u0168\u0172\224\224\224\224\224\224\224\224\u0174\250"+
    "\224\224\224\224\224\224\224\224\224\224\224\224\u0172\224\224\224\224\u0172"+
    "\250\224\224\224\u0174\250\u0110\250\u0176\u0168\324\u0110\u0110\u0168\u0168"+
    "\u0168\u0168\250\250\250\250\250\250\250\250\250\u0168\u0170\250\250\250\250"+
    "\250\u0172\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\u016C\224\324\324\324\u0110\250\u0180\224\224"+
    "\224\u0192\324\324\324\u0194\u0196\u0196\u0196\u0196\u0196\u0120\250\250\u0172"+
    "\u0174\u0174\u0172\u0174\u0174\u0172\250\250\250\224\224\u0172\224\224\224"+
    "\u0172\224\u0172\u0172\250\224\u0172\224\u016C\224\324\324\324\330\u0166\250"+
    "\224\224\u0174\332\324\324\324\250\u0196\u0196\u0196\u0196\u0196\250\224\250"+
    "\u0198\u019A\u0120\u0120\u0120\u0120\u0120\u0120\u0120\u019C\u019A\u019A\324"+
    "\u019A\u019A\u019A\u019E\u019E\u019E\u019E\u019E\u01A0\u01A0\u01A0\u01A0\u01A0"+
    "\u010E\u010E\u010E\u01A2\u01A2\u0168\224\224\224\224\u0172\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\224\224\224\224\u0174\250\250\330\324\324"+
    "\324\324\324\324\u0164\324\324\u0194\324\224\224\250\250\324\324\324\324\330"+
    "\324\324\324\324\324\324\324\324\324\324\324\324\324\324\324\324\324\u0110"+
    "\u019A\u019A\u019A\u019A\u01A4\u019A\u019A\u017E\u01A6\250\250\250\250\250"+
    "\250\250\250\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224"+
    "\224\u0172\224\224\u0172\u0174\u016A\324\u0164\u0110\250\324\u016A\250\250"+
    "\250\u019E\u019E\u019E\u019E\u019E\u0120\u0120\u0120\224\224\224\u0168\324"+
    "\250\250\250\372\372\372\372\372\372\372\372\372\372\372\372\372\372\372\372"+
    "\372\372\372\250\250\250\250\250\224\224\224\224\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\224\u0174\u0128\250\250\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\250\250\u0172\224\u0174\250\250\224\224\224"+
    "\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224"+
    "\224\224\224\250\250\250\224\224\224\u0174\224\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\u0174\u0174\224\224\250\224\224\224\u0174\u0174"+
    "\224\224\250\224\224\224\u0174\u0174\224\224\250\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\u0174\u0174\224\224\250\224\224\224\u0174"+
    "\u0174\224\224\250\224\224\224\u0174\224\224\224\u0174\224\224\224\224\224"+
    "\224\224\224\224\224\224\u0174\224\224\224\224\224\224\224\224\224\224\224"+
    "\u0174\224\224\224\224\224\224\224\224\224\u0174\250\250\u0128\u0120\u0120"+
    "\u0120\u01A8\u01AA\u01AA\u01AA\u01AA\u01AC\u01AE\u01A0\u01A0\u01A0\u01B0\250"+
    "\224\224\224\224\224\224\224\224\224\224\u0174\250\250\250\250\250\224\224"+
    "\224\224\224\224\u01B2\u01B4\224\224\224\u0174\250\250\250\250\u01B6\224\224"+
    "\224\224\224\224\224\224\224\224\224\224\u01B8\u01BA\250\224\224\224\224\224"+
    "\u01B2\u0120\u01BC\u01BE\250\250\250\250\250\250\250\224\224\224\224\224\224"+
    "\u0174\224\224\324\u0110\250\250\250\250\250\224\224\224\224\224\224\224\224"+
    "\224\324\u0194\u0170\250\250\250\250\224\224\224\224\224\224\224\224\224\324"+
    "\250\250\250\250\250\250\224\224\224\224\224\224\u0174\224\u0174\324\250\250"+
    "\250\250\250\250\224\224\224\224\224\224\224\224\224\224\u01C0\u016A\324\324"+
    "\324\u0168\u0168\u0168\u0168\u0164\u016A\324\324\324\324\324\u0120\u01C2\u0120"+
    "\u01C4\u016C\250\u019E\u019E\u019E\u019E\u019E\250\250\250\u01C6\u01C6\u01C6"+
    "\u01C6\u01C6\250\250\250\020\020\020\u01C8\020\u01CA\324\u01CC\u0196\u0196"+
    "\u0196\u0196\u0196\250\250\250\224\u01CE\224\224\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\250\250"+
    "\250\250\224\224\224\224\u016C\250\250\250\250\250\250\250\250\250\250\250"+
    "\224\224\224\224\224\224\224\224\224\224\224\224\224\224\u0174\250\324\u0164"+
    "\u0168\u016A\u01D0\u01D2\250\250\u0168\u0164\u0168\u0168\u016A\324\250\250"+
    "\u018C\250\020\u016E\u016E\u016E\u016E\u016E\224\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\250\224\224\u0174\250\250\250\250\250\074\074"+
    "\074\074\074\074\074\074\074\074\074\074\074\074\074\074\200\200\200\200\200"+
    "\200\200\200\200\200\200\200\200\200\200\200\200\200\200\200\200\200\310\310"+
    "\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310\310"+
    "\310\310\310\310\310\310\200\200\200\200\200\250\250\250\250\250\250\250\250"+
    "\250\250\142\142\142\142\142\142\142\142\142\142\142\u01D4\u01D4\u01D6\250"+
    "\250\142\142\142\142\142\142\142\142\142\142\142\142\142\250\250\250\u01D8"+
    "\u01D8\u01D8\u01D8\u01DA\u01DA\u01DA\u01DA\u01D8\u01D8\u01D8\250\u01DA\u01DA"+
    "\u01DA\250\u01D8\u01D8\u01D8\u01D8\u01DA\u01DA\u01DA\u01DA\u01D8\u01D8\u01D8"+
    "\u01D8\u01DA\u01DA\u01DA\u01DA\u01D8\u01D8\u01D8\250\u01DA\u01DA\u01DA\250"+
    "\u01DC\u01DC\u01DC\u01DC\u01DE\u01DE\u01DE\u01DE\u01D8\u01D8\u01D8\u01D8\u01DA"+
    "\u01DA\u01DA\u01DA\u01E0\u01E2\u01E2\u01E4\u01E6\u01E8\u01EA\250\u01D4\u01D4"+
    "\u01D4\u01D4\u01EC\u01EC\u01EC\u01EC\u01D4\u01D4\u01D4\u01D4\u01EC\u01EC\u01EC"+
    "\u01EC\u01D4\u01D4\u01D4\u01D4\u01EC\u01EC\u01EC\u01EC\u01D8\u01D4\u01EE\u01D4"+
    "\u01DA\u01F0\u01F2\u01F4\316\u01D4\u01EE\u01D4\u01F6\u01F6\u01F2\316\u01D8"+
    "\u01D4\250\u01D4\u01DA\u01F8\u01FA\316\u01D8\u01D4\u01FC\u01D4\u01DA\u01FE"+
    "\u0200\316\250\u01D4\u01EE\u01D4\u0202\u0204\u01F2\u0206\u0208\u0208\u0208"+
    "\u020A\u0208\u020C\u020E\u0210\u0212\u0212\u0212\020\u0214\u0216\u0214\u0216"+
    "\020\020\020\020\u0218\u021A\u021A\u021C\u021E\u021E\u0220\020\u0222\u0224"+
    "\020\u0226\u0228\020\u022A\u022C\020\020\020\020\020\u022E\u0230\u0232\250"+
    "\250\250\u0234\u020E\u020E\250\250\250\u020E\u020E\u020E\u0236\250\110\110"+
    "\110\u0238\u022A\u023A\u023C\u023C\u023C\u023C\u023C\u0238\u022A\u023E\250"+
    "\250\250\250\250\250\250\250\072\072\072\072\072\072\072\072\072\250\250\250"+
    "\250\250\250\250\250\250\250\250\250\250\250\250\324\324\324\324\324\324\u0240"+
    "\u0112\u0154\u0112\u0154\324\324\u0110\250\250\250\250\250\250\250\250\250"+
    "\250\074\u0242\074\u0244\074\u0246\372\200\372\u0248\u0244\074\u0244\372\372"+
    "\074\074\074\u0242\u024A\u0242\u024C\372\u024E\372\u0244\220\224\u0250\074"+
    "\u0252\372\036\u0254\u0256\200\200\u0258\250\250\250\u025A\122\122\122\122"+
    "\122\122\u025C\u025C\u025C\u025C\u025C\u025C\u025E\u025E\u0260\u0260\u0260"+
    "\u0260\u0260\u0260\u0262\u0262\u0264\u0266\250\250\250\250\250\250\u0254\u0254"+
    "\u0268\074\074\u0254\074\074\u0268\u0258\074\u0268\074\074\074\u0268\074\074"+
    "\074\074\074\074\074\074\074\074\074\074\074\074\074\u0254\074\u0268\u0268"+
    "\074\074\074\074\074\074\074\074\074\074\074\074\074\074\074\u0254\u0254\u0254"+
    "\u0254\u0254\u0254\u026A\u026C\036\u0254\u026C\u026C\u026C\u0254\u026A\u0238"+
    "\u026A\036\u0254\u026C\u026C\u026A\u026C\036\036\036\u0254\u026A\u026C\u026C"+
    "\u026C\u026C\u0254\u0254\u026A\u026A\u026C\u026C\u026C\u026C\u026C\u026C\u026C"+
    "\u026C\036\u0254\u0254\u026C\u026C\u0254\u0254\u0254\u0254\u026A\036\036\u026C"+
    "\u026C\u026C\u026C\u0254\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C"+
    "\u026C\u026C\u026C\u026C\u026C\u026C\036\u026A\u026C\036\u0254\u0254\036\u0254"+
    "\u0254\u0254\u0254\u026C\u0254\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C"+
    "\u026C\036\u0254\u0254\u026C\u0254\u0254\u0254\u0254\u026A\u026C\u026C\u0254"+
    "\u026C\u0254\u0254\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C"+
    "\u026C\u026C\u0254\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\074\074"+
    "\074\074\u026C\u026C\074\074\074\074\074\074\074\074\074\074\u026C\074\074"+
    "\074\u026E\u0270\074\074\074\074\074\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u0272\u0268\074\074\074\074\074\074\074\074\074\074\074\u0274\074\074"+
    "\u0258\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254"+
    "\u01A2\u0276\074\074\074\074\074\074\074\074\074\074\074\074\u018C\250\250"+
    "\250\250\250\250\250\074\074\074\u018C\250\250\250\250\250\250\250\250\250"+
    "\250\250\250\074\074\074\074\074\u018C\250\250\250\250\250\250\250\250\250"+
    "\250\u0278\u0278\u0278\u0278\u0278\u0278\u0278\u0278\u0278\u0278\u027A\u027A"+
    "\u027A\u027A\u027A\u027A\u027A\u027A\u027A\u027A\u027C\u027C\u027C\u027C\u027C"+
    "\u027C\u027C\u027C\u027C\u027C\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\u019A\u019A\u027E\u027E\u027E\u027E\u027E\u027E\u027E\u027E"+
    "\u027E\u027E\u027E\u027E\u027E\u0280\u0280\u0280\u0280\u0280\u0280\u0280\u0280"+
    "\u0280\u0280\u0280\u0280\u0280\u0282\u0284\u0284\u0284\u0284\u0286\u0288\u0288"+
    "\u0288\u0288\u028A\074\074\074\074\074\074\074\074\074\074\074\u0258\074\074"+
    "\074\074\u0258\074\074\074\074\074\074\074\074\074\074\074\074\074\074\074"+
    "\074\074\074\074\074\074\074\074\074\074\074\074\u0254\u0254\u0254\u0254\074"+
    "\074\074\074\074\074\074\074\074\074\074\074\u028C\074\074\074\074\074\074"+
    "\074\074\074\074\u0258\074\074\074\074\074\074\074\250\074\074\074\074\074"+
    "\074\074\074\074\250\250\250\250\250\250\250\074\250\250\250\250\250\250\250"+
    "\250\250\250\250\250\250\250\250\u028C\074\u018C\074\074\250\074\074\074\074"+
    "\074\074\074\074\074\074\074\074\074\074\u028C\074\074\074\074\074\074\074"+
    "\074\074\074\074\074\074\074\074\074\074\u028C\u028C\074\u018C\250\u018C\074"+
    "\074\074\u018C\u028C\074\074\074\022\022\022\022\022\022\022\u028E\u028E\u028E"+
    "\u028E\u028E\u0290\u0290\u0290\u0290\u0290\u0292\u0292\u0292\u0292\u0292\u018C"+
    "\250\074\074\074\074\074\074\074\074\074\074\074\074\u028C\074\074\074\074"+
    "\074\074\u018C\250\250\250\250\250\250\250\250\u0254\u026A\u026C\036\u0254"+
    "\u0254\u026C\036\u0254\u026C\u026C\022\022\022\250\250\u0254\u0254\u0254\u0254"+
    "\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254"+
    "\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u022A\u0294\u0294\u0294\u0294"+
    "\u0294\u0294\u0294\u0294\u0294\u0294\u0296\u026A\u026C\u026C\u026C\u026C\u026C"+
    "\u026C\u026C\u026C\u026C\u026C\u0254\u0254\u0254\u0254\036\u0254\u0254\u0254"+
    "\u026C\u026C\u026C\u0254\u026A\u0254\u0254\u026C\u026C\036\u026C\u0254\022"+
    "\022\036\u0254\u026A\u026A\u026C\u0254\u026C\u0254\u0254\u0254\u0254\u0254"+
    "\u026C\u026C\u026C\u0254\022\u0254\u0254\u0254\u0254\u0254\u0254\u026C\u026C"+
    "\u026C\u026C\u026C\u026C\u026C\u026C\u026C\036\u026C\u026C\u0254\036\036\u026A"+
    "\u026A\u026C\036\u0254\u0254\u026C\u0254\u0254\u0254\u026C\036\u0254\u0254"+
    "\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u0254\u026A\036\u0254\u0254"+
    "\u0254\u0254\u0254\u026C\u0254\u0254\u026C\u026C\u026A\036\u026A\036\u0254"+
    "\u026A\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C"+
    "\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u0254\u026C\u026C\u026C"+
    "\u026C\u026A\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C"+
    "\u026C\u026C\u026C\u026C\u026C\u026C\u026C\u026C\036\u0254\u0254\036\036\u0254"+
    "\u026C\u026C\036\u0254\u0254\u026C\036\u0254\u026A\u0254\u026A\u026C\u026C"+
    "\u026A\u0254\074\074\074\074\074\074\074\250\250\250\250\250\250\250\250\250"+
    "\074\074\074\074\074\074\074\074\074\074\074\074\074\u028C\074\074\074\074"+
    "\074\074\074\074\074\074\074\074\250\250\250\250\250\250\074\074\074\074\074"+
    "\074\074\074\074\074\074\250\250\250\250\250\250\250\250\250\250\250\250\250"+
    "\074\074\074\074\074\074\250\250\012\020\u0298\u029A\022\022\022\022\022\074"+
    "\022\022\022\022\u029C\u029E\u02A0\u02A2\u02A2\u02A2\u02A2\324\324\324\u02A4"+
    "\310\310\074\u02A6\u02A8\u02AA\074\224\224\224\224\224\224\224\224\224\224"+
    "\224\u0174\330\u02AC\u02AE\u02B0\u02B2\224\224\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224\224"+
    "\u02B4\310\u02B0\250\250\u0172\224\224\224\224\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\u0174\250\u0172\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\u0174\u019A\u02B6\u02B6\u019A\u019A\u019A\u019A"+
    "\u019A\250\250\250\250\250\250\250\250\224\224\224\224\224\224\224\224\u019A"+
    "\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u0272\u018C\u02B8\u02B8\u02B8\u02B8\u02B8\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\u019A\u019A\u019A\u019A\250\250\250\250\250\250\u02BA\u02BC"+
    "\u02BC\u02BC\u02BC\u02BC\122\122\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\u019A\u019A\u019A\u019A\074\u01A6\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\u019A\u02BE\122\122\122\122\122\122\122\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\074\074\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u017E\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u0272\074\u0274\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\074\u019A\u019A\u019A\u019A"+
    "\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u019A\u0272\224"+
    "\224\224\224\224\224\224\224\224\224\224\250\250\250\250\250\224\224\224\250"+
    "\250\250\250\250\250\250\250\250\250\250\250\250\224\224\224\224\224\224\u0174"+
    "\250\074\074\074\074\074\074\074\074\224\224\250\250\250\250\250\250\250\250"+
    "\250\250\250\250\250\250\u02C0\u02C0\u02C0\u02C0\u02C0\u02C0\u02C0\u02C0\u02C0"+
    "\u02C0\u02C0\u02C0\u02C0\u02C0\u02C0\u02C0\u02C2\u02C2\u02C2\u02C2\u02C2\u02C2"+
    "\u02C2\u02C2\u02C2\u02C2\u02C2\u02C2\u02C2\u02C2\u02C2\u02C2\224\224\224\224"+
    "\224\224\224\250\224\224\224\224\224\224\224\224\224\224\224\224\224\u0174"+
    "\250\250\250\250\250\250\250\250\250\250\u01D4\u01D4\u01D4\u01EE\250\250\250"+
    "\250\250\u02C4\u01D4\u01D4\250\250\u02C6\u02C8\u0130\u0130\u0130\u0130\u02CA"+
    "\u0130\u0130\u0130\u0130\u0130\u0130\u0132\u0130\u0130\u0132\u0132\u0130\u02C6"+
    "\u0132\u0130\u0130\u0130\u0130\u0130\u0140\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\250\250\250\250"+
    "\250\250\250\250\250\250\250\250\250\250\250\250\u013E\u0140\u0140\u0140\u0140"+
    "\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\u0140\u0140\u0140\u0140\u01A2\250\250\250\250\250\250\250\250\u0140\u0140"+
    "\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\u0140\250\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\250\250\250\250\250\250\250\250\250\250\250\250\250\250\250\250\250\250\250"+
    "\250\u0140\u0140\u0140\u0140\u0140\u0140\u02CC\250\324\324\324\324\324\324"+
    "\324\324\250\250\250\250\250\250\250\250\324\324\250\250\250\250\250\250\u02CE"+
    "\u02D0\u02D2\u02D4\u02D4\u02D4\u02D4\u02D4\u02D4\u02D4\u02D6\u02D8\u02D6\020"+
    "\u0226\u02DA\034\u02DC\u02DE\020\u029C\u02D4\u02D4\u02E0\020\u02E2\u0254\u02E4"+
    "\u02E6\u0220\250\250\u0140\u0140\u0142\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140\u0140"+
    "\u0142\u0162\u0232\014\016\020\022\024\026\030\032\032\032\032\032\034\036"+
    "\040\054\056\056\056\056\056\056\056\056\056\056\056\056\060\062\u022A\u022C"+
    "\022\u0226\224\224\224\224\224\u02B0\224\224\224\224\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\224\224\224\224\310\224\224\224\224\224\224"+
    "\224\224\224\224\224\224\224\224\224\u0174\250\224\224\224\250\224\224\224"+
    "\250\224\224\224\250\224\u0174\250\072\u02E8\u018A\u02EA\u0258\u0254\u0268"+
    "\u018C\250\250\250\250\u0162\u020E\074\250").toCharArray();

  // The A table has 748 entries for a total of 2992 bytes.

  static final int A[] = new int[748];
  static final String A_DATA =
    "\u4800\u100F\u4800\u100F\u4800\u100F\u5800\u400F\u5000\u400F\u5800\u400F\u6000"+
    "\u400F\u5000\u400F\u5000\u400F\u5000\u400F\u6000\u400C\u6800\030\u6800\030"+
    "\u2800\030\u2800\u601A\u2800\030\u6800\030\u6800\030\uE800\025\uE800\026\u6800"+
    "\030\u2800\031\u3800\030\u2800\024\u3800\030\u2000\030\u1800\u3609\u1800\u3609"+
    "\u3800\030\u6800\030\uE800\031\u6800\031\uE800\031\u6800\030\u6800\030\202"+
    "\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\uE800\025\u6800\030\uE800\026\u6800\033"+
    "\u6800\u5017\u6800\033\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\uE800\025\u6800"+
    "\031\uE800\026\u6800\031\u4800\u100F\u4800\u100F\u5000\u100F\u3800\014\u6800"+
    "\030\u2800\u601A\u2800\u601A\u6800\034\u6800\034\u6800\033\u6800\034\000\u7002"+
    "\uE800\035\u6800\031\u6800\u1010\u6800\034\u6800\033\u2800\034\u2800\031\u1800"+
    "\u060B\u1800\u060B\u6800\033\u07FD\u7002\u6800\034\u6800\030\u6800\033\u1800"+
    "\u050B\000\u7002\uE800\036\u6800\u080B\u6800\u080B\u6800\u080B\u6800\030\202"+
    "\u7001\202\u7001\202\u7001\u6800\031\202\u7001\u07FD\u7002\201\u7002\201\u7002"+
    "\201\u7002\u6800\031\201\u7002\u061D\u7002\006\u7001\005\u7002\u07FF\uF001"+
    "\u03A1\u7002\000\u7002\006\u7001\005\u7002\006\u7001\005\u7002\u07FD\u7002"+
    "\u061E\u7001\006\u7001\000\u7002\u034A\u7001\u033A\u7001\006\u7001\005\u7002"+
    "\u0336\u7001\u0336\u7001\006\u7001\005\u7002\000\u7002\u013E\u7001\u032A\u7001"+
    "\u032E\u7001\006\u7001\u033E\u7001\u067D\u7002\u034E\u7001\u0346\u7001\000"+
    "\u7002\000\u7002\u034E\u7001\u0356\u7001\u05F9\u7002\u035A\u7001\u036A\u7001"+
    "\006\u7001\005\u7002\u036A\u7001\005\u7002\u0366\u7001\u0366\u7001\006\u7001"+
    "\005\u7002\u036E\u7001\000\u7002\000\u7005\000\u7002\u0721\u7002\000\u7005"+
    "\000\u7005\012\uF001\007\uF003\011\uF002\012\uF001\007\uF003\011\uF002\011"+
    "\uF002\006\u7001\005\u7002\u013D\u7002\u07FD\u7002\012\uF001\u067E\u7001\u0722"+
    "\u7001\u05FA\u7001\000\u7002\000\u7002\u7800\000\u7800\000\u7800\000\000\u7002"+
    "\u0349\u7002\u0339\u7002\000\u7002\u0335\u7002\u0335\u7002\000\u7002\u0329"+
    "\u7002\000\u7002\u032D\u7002\u0335\u7002\000\u7002\000\u7002\u033D\u7002\u0345"+
    "\u7002\u034D\u7002\000\u7002\u034D\u7002\u0355\u7002\000\u7002\000\u7002\u0359"+
    "\u7002\u0369\u7002\000\u7002\000\u7002\u0369\u7002\u0365\u7002\u0365\u7002"+
    "\u036D\u7002\000\u7002\000\u7004\000\u7004\000\u7004\u6800\u7004\u6800\u7004"+
    "\000\u7004\u6800\033\u6800\033\u6800\u7004\u6800\u7004\000\u7004\u6800\033"+
    "\u4000\u3006\u4000\u3006\u4000\u3006\u46B1\u3006\u7800\000\u4000\u3006\000"+
    "\u7004\u7800\000\u6800\030\u7800\000\232\u7001\u6800\030\226\u7001\226\u7001"+
    "\226\u7001\u7800\000\u0102\u7001\u7800\000\376\u7001\376\u7001\u07FD\u7002"+
    "\202\u7001\u7800\000\202\u7001\231\u7002\225\u7002\225\u7002\225\u7002\u07FD"+
    "\u7002\201\u7002\175\u7002\201\u7002\u0101\u7002\375\u7002\375\u7002\u7800"+
    "\000\371\u7002\345\u7002\000\u7001\000\u7001\000\u7001\275\u7002\331\u7002"+
    "\000\u7002\u0159\u7002\u0141\u7002\u07E5\u7002\000\u7002\u0712\u7001\u0181"+
    "\u7002\u6800\031\006\u7001\005\u7002\u07E6\u7001\u0142\u7001\u0142\u7001\u0141"+
    "\u7002\u0141\u7002\000\034\u4000\u3006\u4000\u3006\u7800\000\u4000\007\u4000"+
    "\007\000\u7001\006\u7001\005\u7002\u7800\000\u7800\000\302\u7001\302\u7001"+
    "\302\u7001\302\u7001\u7800\000\u7800\000\000\u7004\000\030\000\030\u7800\000"+
    "\301\u7002\301\u7002\301\u7002\301\u7002\u07FD\u7002\u7800\000\000\030\u6800"+
    "\024\u7800\000\u0800\030\u4000\u3006\u4000\u3006\u0800\030\u0800\u7005\u0800"+
    "\u7005\u0800\u7005\u7800\000\u0800\u7005\u0800\030\u0800\030\u7800\000\u1000"+
    "\u1010\u1000\u1010\u3800\030\u1000\030\u7800\000\u1000\030\u7800\000\u1000"+
    "\u7005\u1000\u7005\u1000\u7005\u1000\u7005\u7800\000\u1000\u7004\u1000\u7005"+
    "\u1000\u7005\u4000\u3006\u3000\u3409\u3000\u3409\u2800\030\u3000\030\u3000"+
    "\030\u1000\030\u4000\u3006\u1000\u7005\u1000\030\u1000\u7005\u4000\u3006\u1000"+
    "\u1010\u4000\007\u4000\u3006\u4000\u3006\u1000\u7004\u1000\u7004\u4000\u3006"+
    "\u4000\u3006\u6800\034\u1000\u7005\u1000\034\u1000\034\u1000\u7005\u1000\030"+
    "\u1000\030\u7800\000\u4800\u1010\u4000\u3006\000\u3008\u4000\u3006\000\u7005"+
    "\000\u3008\000\u3008\000\u3008\u4000\u3006\000\u7005\u4000\u3006\000\u3749"+
    "\000\u3749\000\030\u7800\000\u7800\000\000\u7005\000\u7005\u7800\000\u7800"+
    "\000\000\u3008\000\u3008\u7800\000\000\u05AB\000\u05AB\000\013\000\u06EB\000"+
    "\034\u7800\000\u7800\000\u2800\u601A\000\034\000\u7005\u7800\000\000\u3749"+
    "\000\u074B\000\u080B\000\u080B\u6800\034\u6800\034\u2800\u601A\u6800\034\u7800"+
    "\000\000\u3008\000\u3006\000\u3006\000\u3008\000\u7004\u4000\u3006\u4000\u3006"+
    "\000\030\000\u3609\000\u3609\000\u7005\000\034\000\034\000\034\000\030\000"+
    "\034\000\u3409\000\u3409\000\u080B\000\u080B\u6800\025\u6800\026\u4000\u3006"+
    "\000\034\u7800\000\000\034\000\030\000\u3709\000\u3709\000\u3709\000\u070B"+
    "\000\u042B\000\u054B\000\u080B\000\u080B\u7800\000\000\u7005\000\030\000\030"+
    "\000\u7005\u6000\u400C\000\u7005\000\u7005\u6800\025\u6800\026\u7800\000\000"+
    "\u746A\000\u746A\000\u746A\u7800\000\000\u1010\000\u1010\000\030\000\u7004"+
    "\000\030\u2800\u601A\u6800\u060B\u6800\u060B\u6800\024\u6800\030\u6800\030"+
    "\u4000\u3006\u6000\u400C\u7800\000\000\u7005\000\u7004\u4000\u3006\u4000\u3008"+
    "\u4000\u3008\u4000\u3008\u07FD\u7002\u07FD\u7002\u07FD\u7002\355\u7002\u07E1"+
    "\u7002\u07E1\u7002\u07E2\u7001\u07E2\u7001\u07FD\u7002\u07E1\u7002\u7800\000"+
    "\u07E2\u7001\u06D9\u7002\u06D9\u7002\u06A9\u7002\u06A9\u7002\u0671\u7002\u0671"+
    "\u7002\u0601\u7002\u0601\u7002\u0641\u7002\u0641\u7002\u0609\u7002\u0609\u7002"+
    "\u07FF\uF003\u07FF\uF003\u07FD\u7002\u7800\000\u06DA\u7001\u06DA\u7001\u07FF"+
    "\uF003\u6800\033\u07FD\u7002\u6800\033\u06AA\u7001\u06AA\u7001\u0672\u7001"+
    "\u0672\u7001\u7800\000\u6800\033\u07FD\u7002\u07E5\u7002\u0642\u7001\u0642"+
    "\u7001\u07E6\u7001\u6800\033\u0602\u7001\u0602\u7001\u060A\u7001\u060A\u7001"+
    "\u6800\033\u7800\000\u6000\u400C\u6000\u400C\u6000\u400C\u6000\014\u6000\u400C"+
    "\u4800\u400C\u4800\u1010\u4800\u1010\000\u1010\u0800\u1010\u6800\024\u6800"+
    "\024\u6800\035\u6800\036\u6800\025\u6800\035\u6000\u400D\u5000\u400E\u7800"+
    "\u1010\u7800\u1010\u7800\u1010\u6000\014\u2800\030\u2800\030\u2800\030\u6800"+
    "\030\u6800\030\uE800\035\uE800\036\u6800\030\u6800\030\u6800\u5017\u6800\u5017"+
    "\u6800\030\u6800\031\uE800\025\uE800\026\u6800\030\u6800\031\u6800\030\u6800"+
    "\u5017\u7800\000\u7800\000\u6800\030\u7800\000\u6000\u400C\u1800\u060B\000"+
    "\u7002\u2800\031\u2800\031\uE800\026\000\u7002\u1800\u040B\u1800\u040B\uE800"+
    "\026\u7800\000\u4000\u3006\u4000\007\000\u7001\u6800\034\u6800\034\000\u7001"+
    "\000\u7002\000\u7001\000\u7001\000\u7002\u07FE\u7001\u6800\034\u07FE\u7001"+
    "\u07FE\u7001\u2800\034\000\u7002\000\u7005\000\u7002\u7800\000\000\u7002\u6800"+
    "\031\u6800\031\u6800\031\000\u7001\u6800\034\u6800\031\u7800\000\u6800\u080B"+
    "\102\u742A\102\u742A\102\u780A\102\u780A\101\u762A\101\u762A\101\u780A\101"+
    "\u780A\000\u780A\000\u780A\000\u780A\000\u700A\u6800\031\u6800\034\u6800\031"+
    "\uE800\031\uE800\031\uE800\031\u6800\034\uE800\025\uE800\026\u6800\034\000"+
    "\034\u6800\034\u6800\034\000\034\u6800\030\u6800\034\u1800\u042B\u1800\u042B"+
    "\u1800\u05AB\u1800\u05AB\u1800\u072B\u1800\u072B\152\034\152\034\151\034\151"+
    "\034\u1800\u06CB\u6800\u040B\u6800\u040B\u6800\u040B\u6800\u040B\u6800\u058B"+
    "\u6800\u058B\u6800\u058B\u6800\u058B\u6800\u042B\u7800\000\u6800\034\u6800"+
    "\u056B\u6800\u056B\u6800\u042B\u6800\u042B\u6800\u06EB\u6800\u06EB\uE800\026"+
    "\uE800\025\uE800\026\u6800\031\u6800\034\000\u7004\000\u7005\000\u772A\u6800"+
    "\024\u6800\025\u6800\026\u6800\026\u6800\034\000\u740A\000\u740A\000\u740A"+
    "\u6800\024\000\u7004\000\u764A\000\u776A\000\u748A\000\u7004\000\u7005\u6800"+
    "\030\u4000\u3006\u6800\033\u6800\033\000\u7004\000\u7004\000\u7005\u6800\024"+
    "\000\u7005\000\u7005\u6800\u5017\000\u05EB\000\u05EB\000\u042B\000\u042B\u6800"+
    "\034\u6800\u048B\u6800\u048B\u6800\u048B\000\034\u6800\u080B\000\023\000\023"+
    "\000\022\000\022\u7800\000\u07FD\u7002\u7800\000\u0800\u7005\u4000\u3006\u0800"+
    "\u7005\u0800\u7005\u2800\031\u1000\u601A\u6800\034\u6800\030\u6800\024\u6800"+
    "\024\u6800\u5017\u6800\u5017\u6800\025\u6800\026\u6800\025\u6800\026\u6800"+
    "\030\u6800\030\u6800\025\u6800\u5017\u6800\u5017\u3800\030\u7800\000\u6800"+
    "\030\u3800\030\u6800\026\u2800\030\u2800\031\u2800\024\u6800\031\u7800\000"+
    "\u6800\030\u2800\u601A\u6800\031\u6800\033\u2800\u601A\u7800\000";

  // In all, the character property tables require 15920 bytes.

    static {
            charMap = new char[][][] {
        { {'\u00DF'}, {'\u0053', '\u0053', } },
        { {'\u0130'}, {'\u0130', } },
        { {'\u0149'}, {'\u02BC', '\u004E', } },
        { {'\u01F0'}, {'\u004A', '\u030C', } },
        { {'\u0390'}, {'\u0399', '\u0308', '\u0301', } },
        { {'\u03B0'}, {'\u03A5', '\u0308', '\u0301', } },
        { {'\u0587'}, {'\u0535', '\u0552', } },
        { {'\u1E96'}, {'\u0048', '\u0331', } },
        { {'\u1E97'}, {'\u0054', '\u0308', } },
        { {'\u1E98'}, {'\u0057', '\u030A', } },
        { {'\u1E99'}, {'\u0059', '\u030A', } },
        { {'\u1E9A'}, {'\u0041', '\u02BE', } },
        { {'\u1F50'}, {'\u03A5', '\u0313', } },
        { {'\u1F52'}, {'\u03A5', '\u0313', '\u0300', } },
        { {'\u1F54'}, {'\u03A5', '\u0313', '\u0301', } },
        { {'\u1F56'}, {'\u03A5', '\u0313', '\u0342', } },
        { {'\u1F80'}, {'\u1F08', '\u0399', } },
        { {'\u1F81'}, {'\u1F09', '\u0399', } },
        { {'\u1F82'}, {'\u1F0A', '\u0399', } },
        { {'\u1F83'}, {'\u1F0B', '\u0399', } },
        { {'\u1F84'}, {'\u1F0C', '\u0399', } },
        { {'\u1F85'}, {'\u1F0D', '\u0399', } },
        { {'\u1F86'}, {'\u1F0E', '\u0399', } },
        { {'\u1F87'}, {'\u1F0F', '\u0399', } },
        { {'\u1F88'}, {'\u1F08', '\u0399', } },
        { {'\u1F89'}, {'\u1F09', '\u0399', } },
        { {'\u1F8A'}, {'\u1F0A', '\u0399', } },
        { {'\u1F8B'}, {'\u1F0B', '\u0399', } },
        { {'\u1F8C'}, {'\u1F0C', '\u0399', } },
        { {'\u1F8D'}, {'\u1F0D', '\u0399', } },
        { {'\u1F8E'}, {'\u1F0E', '\u0399', } },
        { {'\u1F8F'}, {'\u1F0F', '\u0399', } },
        { {'\u1F90'}, {'\u1F28', '\u0399', } },
        { {'\u1F91'}, {'\u1F29', '\u0399', } },
        { {'\u1F92'}, {'\u1F2A', '\u0399', } },
        { {'\u1F93'}, {'\u1F2B', '\u0399', } },
        { {'\u1F94'}, {'\u1F2C', '\u0399', } },
        { {'\u1F95'}, {'\u1F2D', '\u0399', } },
        { {'\u1F96'}, {'\u1F2E', '\u0399', } },
        { {'\u1F97'}, {'\u1F2F', '\u0399', } },
        { {'\u1F98'}, {'\u1F28', '\u0399', } },
        { {'\u1F99'}, {'\u1F29', '\u0399', } },
        { {'\u1F9A'}, {'\u1F2A', '\u0399', } },
        { {'\u1F9B'}, {'\u1F2B', '\u0399', } },
        { {'\u1F9C'}, {'\u1F2C', '\u0399', } },
        { {'\u1F9D'}, {'\u1F2D', '\u0399', } },
        { {'\u1F9E'}, {'\u1F2E', '\u0399', } },
        { {'\u1F9F'}, {'\u1F2F', '\u0399', } },
        { {'\u1FA0'}, {'\u1F68', '\u0399', } },
        { {'\u1FA1'}, {'\u1F69', '\u0399', } },
        { {'\u1FA2'}, {'\u1F6A', '\u0399', } },
        { {'\u1FA3'}, {'\u1F6B', '\u0399', } },
        { {'\u1FA4'}, {'\u1F6C', '\u0399', } },
        { {'\u1FA5'}, {'\u1F6D', '\u0399', } },
        { {'\u1FA6'}, {'\u1F6E', '\u0399', } },
        { {'\u1FA7'}, {'\u1F6F', '\u0399', } },
        { {'\u1FA8'}, {'\u1F68', '\u0399', } },
        { {'\u1FA9'}, {'\u1F69', '\u0399', } },
        { {'\u1FAA'}, {'\u1F6A', '\u0399', } },
        { {'\u1FAB'}, {'\u1F6B', '\u0399', } },
        { {'\u1FAC'}, {'\u1F6C', '\u0399', } },
        { {'\u1FAD'}, {'\u1F6D', '\u0399', } },
        { {'\u1FAE'}, {'\u1F6E', '\u0399', } },
        { {'\u1FAF'}, {'\u1F6F', '\u0399', } },
        { {'\u1FB2'}, {'\u1FBA', '\u0399', } },
        { {'\u1FB3'}, {'\u0391', '\u0399', } },
        { {'\u1FB4'}, {'\u0386', '\u0399', } },
        { {'\u1FB6'}, {'\u0391', '\u0342', } },
        { {'\u1FB7'}, {'\u0391', '\u0342', '\u0399', } },
        { {'\u1FBC'}, {'\u0391', '\u0399', } },
        { {'\u1FC2'}, {'\u1FCA', '\u0399', } },
        { {'\u1FC3'}, {'\u0397', '\u0399', } },
        { {'\u1FC4'}, {'\u0389', '\u0399', } },
        { {'\u1FC6'}, {'\u0397', '\u0342', } },
        { {'\u1FC7'}, {'\u0397', '\u0342', '\u0399', } },
        { {'\u1FCC'}, {'\u0397', '\u0399', } },
        { {'\u1FD2'}, {'\u0399', '\u0308', '\u0300', } },
        { {'\u1FD3'}, {'\u0399', '\u0308', '\u0301', } },
        { {'\u1FD6'}, {'\u0399', '\u0342', } },
        { {'\u1FD7'}, {'\u0399', '\u0308', '\u0342', } },
        { {'\u1FE2'}, {'\u03A5', '\u0308', '\u0300', } },
        { {'\u1FE3'}, {'\u03A5', '\u0308', '\u0301', } },
        { {'\u1FE4'}, {'\u03A1', '\u0313', } },
        { {'\u1FE6'}, {'\u03A5', '\u0342', } },
        { {'\u1FE7'}, {'\u03A5', '\u0308', '\u0342', } },
        { {'\u1FF2'}, {'\u1FFA', '\u0399', } },
        { {'\u1FF3'}, {'\u03A9', '\u0399', } },
        { {'\u1FF4'}, {'\u038F', '\u0399', } },
        { {'\u1FF6'}, {'\u03A9', '\u0342', } },
        { {'\u1FF7'}, {'\u03A9', '\u0342', '\u0399', } },
        { {'\u1FFC'}, {'\u03A9', '\u0399', } },
        { {'\uFB00'}, {'\u0046', '\u0046', } },
        { {'\uFB01'}, {'\u0046', '\u0049', } },
        { {'\uFB02'}, {'\u0046', '\u004C', } },
        { {'\uFB03'}, {'\u0046', '\u0046', '\u0049', } },
        { {'\uFB04'}, {'\u0046', '\u0046', '\u004C', } },
        { {'\uFB05'}, {'\u0053', '\u0054', } },
        { {'\uFB06'}, {'\u0053', '\u0054', } },
        { {'\uFB13'}, {'\u0544', '\u0546', } },
        { {'\uFB14'}, {'\u0544', '\u0535', } },
        { {'\uFB15'}, {'\u0544', '\u053B', } },
        { {'\uFB16'}, {'\u054E', '\u0546', } },
        { {'\uFB17'}, {'\u0544', '\u053D', } },
    };
        { // THIS CODE WAS AUTOMATICALLY CREATED BY GenerateCharacter:
            char[] data = A_DATA.toCharArray();
            assert (data.length == (748 * 2));
            int i = 0, j = 0;
            while (i < (748 * 2)) {
                int entry = data[i++] << 16;
                A[j++] = entry | data[i++];
            }
        }

    }        
}
