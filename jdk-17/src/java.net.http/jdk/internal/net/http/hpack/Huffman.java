/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.net.http.hpack;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Huffman coding.
 *
 * @since 9
 */
public final class Huffman {

    public interface Reader {

        void read(ByteBuffer source,
                  Appendable destination,
                  boolean isLast) throws IOException;

        /**
         * Brings this reader to the state it had upon construction.
         */
        void reset();
    }

    public interface Writer {

        Writer from(CharSequence input, int start, int end);

        boolean write(ByteBuffer destination);

        /**
         * Brings this writer to the state it had upon construction.
         *
         * @return this writer
         */
        Writer reset();

        /**
         * Calculates the number of bytes required to represent a subsequence of
         * the given {@code CharSequence} using the Huffman coding.
         *
         * @param value
         *         characters
         * @param start
         *         the start index, inclusive
         * @param end
         *         the end index, exclusive
         *
         * @return number of bytes
         * @throws NullPointerException
         *         if the value is null
         * @throws IndexOutOfBoundsException
         *         if any invocation of {@code value.charAt(i)}, where
         *         {@code start <= i < end}, throws an IndexOutOfBoundsException
         */
        int lengthOf(CharSequence value, int start, int end);

        default int lengthOf(CharSequence value) {
            return lengthOf(value, 0, value.length());
        }
    }
}
