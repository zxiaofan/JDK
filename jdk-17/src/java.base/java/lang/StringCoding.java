/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
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

import jdk.internal.vm.annotation.IntrinsicCandidate;

/**
 * Utility class for string encoding and decoding.
 */
class StringCoding {

    private StringCoding() { }

    @IntrinsicCandidate
    public static boolean hasNegatives(byte[] ba, int off, int len) {
        for (int i = off; i < off + len; i++) {
            if (ba[i] < 0) {
                return true;
            }
        }
        return false;
    }

    @IntrinsicCandidate
    public static int implEncodeISOArray(byte[] sa, int sp,
                                          byte[] da, int dp, int len) {
        int i = 0;
        for (; i < len; i++) {
            char c = StringUTF16.getChar(sa, sp++);
            if (c > '\u00FF')
                break;
            da[dp++] = (byte)c;
        }
        return i;
    }

}
