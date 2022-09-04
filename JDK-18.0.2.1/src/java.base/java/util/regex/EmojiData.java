/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.util.regex;

/**
 * Holds data contained in the Unicode Technical Standard #51: Unicode
 * Emoji. 
 * 
 * Currently it is only used for the rule "GB11" in UAX #29 Unicode Text
 * Segmentation.
 */
final class EmojiData {
    /**
     * Returns whether the code point is an extended pictographic or not.
     *
     * @param cp code point to examine
     * @return true if {@code cp} is an extended pictographic
     */
    static boolean isExtendedPictographic(int cp) {
        if (cp < 0x2000) {
            return
                cp == 0x00A9 ||
                cp == 0x00AE;

        } else {
            return isHigh(cp);
        }
    }

    private static boolean isHigh(int cp) {
        return
                cp == 0x203C ||
                cp == 0x2049 ||
                cp == 0x2122 ||
                cp == 0x2139 ||
               (cp >= 0x2194 && cp <= 0x2199) ||
                cp == 0x21A9 ||
                cp == 0x21AA ||
                cp == 0x231A ||
                cp == 0x231B ||
                cp == 0x2328 ||
                cp == 0x2388 ||
                cp == 0x23CF ||
               (cp >= 0x23E9 && cp <= 0x23F3) ||
               (cp >= 0x23F8 && cp <= 0x23FA) ||
                cp == 0x24C2 ||
                cp == 0x25AA ||
                cp == 0x25AB ||
                cp == 0x25B6 ||
                cp == 0x25C0 ||
               (cp >= 0x25FB && cp <= 0x25FE) ||
               (cp >= 0x2600 && cp <= 0x2605) ||
               (cp >= 0x2607 && cp <= 0x2612) ||
               (cp >= 0x2614 && cp <= 0x2685) ||
               (cp >= 0x2690 && cp <= 0x2705) ||
               (cp >= 0x2708 && cp <= 0x2712) ||
                cp == 0x2714 ||
                cp == 0x2716 ||
                cp == 0x271D ||
                cp == 0x2721 ||
                cp == 0x2728 ||
                cp == 0x2733 ||
                cp == 0x2734 ||
                cp == 0x2744 ||
                cp == 0x2747 ||
                cp == 0x274C ||
                cp == 0x274E ||
               (cp >= 0x2753 && cp <= 0x2755) ||
                cp == 0x2757 ||
               (cp >= 0x2763 && cp <= 0x2767) ||
               (cp >= 0x2795 && cp <= 0x2797) ||
                cp == 0x27A1 ||
                cp == 0x27B0 ||
                cp == 0x27BF ||
                cp == 0x2934 ||
                cp == 0x2935 ||
               (cp >= 0x2B05 && cp <= 0x2B07) ||
                cp == 0x2B1B ||
                cp == 0x2B1C ||
                cp == 0x2B50 ||
                cp == 0x2B55 ||
                cp == 0x3030 ||
                cp == 0x303D ||
                cp == 0x3297 ||
                cp == 0x3299 ||
               (cp >= 0x1F000 && cp <= 0x1F0FF) ||
               (cp >= 0x1F10D && cp <= 0x1F10F) ||
                cp == 0x1F12F ||
               (cp >= 0x1F16C && cp <= 0x1F171) ||
                cp == 0x1F17E ||
                cp == 0x1F17F ||
                cp == 0x1F18E ||
               (cp >= 0x1F191 && cp <= 0x1F19A) ||
               (cp >= 0x1F1AD && cp <= 0x1F1E5) ||
               (cp >= 0x1F201 && cp <= 0x1F20F) ||
                cp == 0x1F21A ||
                cp == 0x1F22F ||
               (cp >= 0x1F232 && cp <= 0x1F23A) ||
               (cp >= 0x1F23C && cp <= 0x1F23F) ||
               (cp >= 0x1F249 && cp <= 0x1F3FA) ||
               (cp >= 0x1F400 && cp <= 0x1F53D) ||
               (cp >= 0x1F546 && cp <= 0x1F64F) ||
               (cp >= 0x1F680 && cp <= 0x1F6FF) ||
               (cp >= 0x1F774 && cp <= 0x1F77F) ||
               (cp >= 0x1F7D5 && cp <= 0x1F7FF) ||
               (cp >= 0x1F80C && cp <= 0x1F80F) ||
               (cp >= 0x1F848 && cp <= 0x1F84F) ||
               (cp >= 0x1F85A && cp <= 0x1F85F) ||
               (cp >= 0x1F888 && cp <= 0x1F88F) ||
               (cp >= 0x1F8AE && cp <= 0x1F8FF) ||
               (cp >= 0x1F90C && cp <= 0x1F93A) ||
               (cp >= 0x1F93C && cp <= 0x1F945) ||
               (cp >= 0x1F947 && cp <= 0x1FAFF) ||
               (cp >= 0x1FC00 && cp <= 0x1FFFD);

    }
}
