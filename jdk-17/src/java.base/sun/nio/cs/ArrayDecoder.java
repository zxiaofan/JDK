/*
 * Copyright (c) 2009, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.cs;

/*
 * FastPath byte[]->char[] decoder, REPLACE on malformed or
 * unmappable input.
 *
 * FastPath encoded byte[]-> "String Latin1 coding" byte[] decoder for use when
 * charset is always decodable to the internal String Latin1 coding byte[], ie. all mappings <=0xff
 */

public interface ArrayDecoder {
    int decode(byte[] src, int off, int len, char[] dst);

    default boolean isASCIICompatible() {
        return false;
    }

    // Is always decodable to internal String Latin1 coding, ie. all mappings <= 0xff
    default boolean isLatin1Decodable() {
        return false;
    }

    // Decode to internal String Latin1 coding byte[] fastpath for when isLatin1Decodable == true
    default int decodeToLatin1(byte[] src, int sp, int len, byte[] dst) {
        return 0;
    }
}
