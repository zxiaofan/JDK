/*
 * Copyright (c) 2001, 2011, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.reflect;

/** It is necessary to use a "bootstrap" UTF-8 encoder for encoding
    constant pool entries because the character set converters rely on
    Class.newInstance(). */

class UTF8 {
    // This encoder is not quite correct.  It does not handle surrogate pairs.
    static byte[] encode(String str) {
        int len = str.length();
        byte[] res = new byte[utf8Length(str)];
        int utf8Idx = 0;
        try {
            for (int i = 0; i < len; i++) {
                int c = str.charAt(i) & 0xFFFF;
                if (c >= 0x0001 && c <= 0x007F) {
                    res[utf8Idx++] = (byte) c;
                } else if (c == 0x0000 ||
                           (c >= 0x0080 && c <= 0x07FF)) {
                    res[utf8Idx++] = (byte) (0xC0 + (c >> 6));
                    res[utf8Idx++] = (byte) (0x80 + (c & 0x3F));
                } else {
                    res[utf8Idx++] = (byte) (0xE0 + (c >> 12));
                    res[utf8Idx++] = (byte) (0x80 + ((c >> 6) & 0x3F));
                    res[utf8Idx++] = (byte) (0x80 + (c & 0x3F));
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InternalError
                ("Bug in sun.reflect bootstrap UTF-8 encoder", e);
        }
        return res;
    }

    private static int utf8Length(String str) {
        int len = str.length();
        int utf8Len = 0;
        for (int i = 0; i < len; i++) {
            int c = str.charAt(i) & 0xFFFF;
            if (c >= 0x0001 && c <= 0x007F) {
                utf8Len += 1;
            } else if (c == 0x0000 ||
                       (c >= 0x0080 && c <= 0x07FF)) {
                utf8Len += 2;
            } else {
                utf8Len += 3;
            }
        }
        return utf8Len;
    }
}
