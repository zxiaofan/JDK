// This file was generated AUTOMATICALLY from a template file Tue Mar 26 15:08:52 PDT 2013
/* %W% %E%
 *
 * Copyright (c) 1994, 2002, Oracle and/or its affiliates. All rights reserved.
 *
 * This software is the proprietary information of Oracle.
 * Use is subject to license terms.
 *
 */

package java.lang;

/** The CharacterData class encapsulates the large tables found in
    Java.lang.Character. */

class CharacterData0E {
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
                   (1 << Character.PARAGRAPH_SEPARATOR))
                >> type) & 1) != 0);
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
        return mapChar;
    }

    static int toUpperCase(int ch) {
        int mapChar = ch;
        int val = getProperties(ch);

        if ((val & 0x00010000) != 0) {
            int offset = val  << 5 >> (5+18);
            mapChar =  ch - offset;
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
            retval = -2;
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
  // java GenerateCharacter -plane 14 -template ../../tools/GenerateCharacter/CharacterData0E.java.template -spec ../../tools/GenerateCharacter/UnicodeData.txt -specialcasing ../../tools/GenerateCharacter/SpecialCasing.txt -o /BUILD_AREA/jdk6_45/control/build/linux-amd64/gensrc/java/lang/CharacterData0E.java -string -usecharforbyte 11 4 1
  // The X table has 2048 entries for a total of 4096 bytes.

  static final char X[] = (
    "\000\020\020\020\040\040\040\040\060\060\060\060\060\060\060\100\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040"+
    "\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040").toCharArray();

  // The Y table has 80 entries for a total of 160 bytes.

  static final char Y[] = (
    "\000\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\004\004\004"+
    "\004\004\004\004\004\004\004\004\004\004\004\004\004\002\002\002\002\002\002"+
    "\002\002\002\002\002\002\002\002\002\002\006\006\006\006\006\006\006\006\006"+
    "\006\006\006\006\006\006\006\006\006\006\006\006\006\006\006\002\002\002\002"+
    "\002\002\002\002").toCharArray();

  // The A table has 8 entries for a total of 32 bytes.

  static final int A[] = new int[8];
  static final String A_DATA =
    "\u7800\000\u4800\u1010\u7800\000\u7800\000\u4800\u1010\u4800\u1010\u4000\u3006"+
    "\u4000\u3006";

  // In all, the character property tables require 4288 bytes.

    static {
                { // THIS CODE WAS AUTOMATICALLY CREATED BY GenerateCharacter:
            char[] data = A_DATA.toCharArray();
            assert (data.length == (8 * 2));
            int i = 0, j = 0;
            while (i < (8 * 2)) {
                int entry = data[i++] << 16;
                A[j++] = entry | data[i++];
            }
        }

    }        
}
