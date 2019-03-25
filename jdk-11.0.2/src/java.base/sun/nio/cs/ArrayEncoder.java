/*
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
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
 * FastPath char[]/byte[] -> byte[] encoder, REPLACE on malformed input or
 * unmappable input.
 */

public interface ArrayEncoder {

    //  is only used by j.u.zip.ZipCoder for utf8
    int encode(char[] src, int off, int len, byte[] dst);

    default int encodeFromLatin1(byte[] src, int sp, int len, byte[] dst) {
        return -1;
    }

    default int encodeFromUTF16(byte[] src, int sp, int len, byte[] dst) {
        return -1;
    }

    default boolean isASCIICompatible() {
        return false;
    }
}
