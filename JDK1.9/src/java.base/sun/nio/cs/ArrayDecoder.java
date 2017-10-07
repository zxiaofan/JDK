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
 * FastPath byte[]->char[] decoder, REPLACE on malformed or
 * unmappable input.
 */

public interface ArrayDecoder {
    int decode(byte[] src, int off, int len, char[] dst);

    default boolean isASCIICompatible() {
        return false;
    }
}
