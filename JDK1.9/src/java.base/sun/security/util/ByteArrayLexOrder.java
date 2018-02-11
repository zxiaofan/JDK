/*
 * Copyright (c) 1997, 2006, Oracle and/or its affiliates. All rights reserved.
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


package sun.security.util;

import java.util.Comparator;

/**
 * Compare two byte arrays in lexicographical order.
 *
 * @author D. N. Hoover
 */
public class ByteArrayLexOrder implements Comparator<byte[]> {

    /**
     * Perform lexicographical comparison of two byte arrays,
     * regarding each byte as unsigned.  That is, compare array entries
     * in order until they differ--the array with the smaller entry
     * is "smaller". If array entries are
     * equal till one array ends, then the longer array is "bigger".
     *
     * @param  bytes1 first byte array to compare.
     * @param  bytes2 second byte array to compare.
     * @return negative number if {@code bytes1 < bytes2},
     *         0 if {@code bytes1 == bytes2},
     *         positive number if {@code bytes1 > bytes2}.
     *
     * @exception <code>ClassCastException</code>
     * if either argument is not a byte array.
     */
    public final int compare( byte[] bytes1, byte[] bytes2) {
        int diff;
        for (int i = 0; i < bytes1.length && i < bytes2.length; i++) {
            diff = (bytes1[i] & 0xFF) - (bytes2[i] & 0xFF);
            if (diff != 0) {
                return diff;
            }
        }
        // if array entries are equal till the first ends, then the
        // longer is "bigger"
        return bytes1.length - bytes2.length;
    }


}
