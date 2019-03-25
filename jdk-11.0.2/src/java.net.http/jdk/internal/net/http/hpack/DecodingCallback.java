/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.ByteBuffer;

/**
 * Delivers results of the {@link Decoder#decode(ByteBuffer, boolean,
 * DecodingCallback) decoding operation}.
 *
 * <p> Methods of the callback are never called by a decoder with any of the
 * arguments being {@code null}.
 *
 * @apiNote
 *
 * <p> The callback provides methods for all possible
 * <a href="https://tools.ietf.org/html/rfc7541#section-6">binary representations</a>.
 * This could be useful for implementing an intermediary, logging, debugging,
 * etc.
 *
 * <p> The callback is an interface in order to interoperate with lambdas (in
 * the most common use case):
 * <pre>{@code
 *     DecodingCallback callback = (name, value) -> System.out.println(name + ", " + value);
 * }</pre>
 *
 * <p> Names and values are {@link CharSequence}s rather than {@link String}s in
 * order to allow users to decide whether or not they need to create objects. A
 * {@code CharSequence} might be used in-place, for example, to be appended to
 * an {@link Appendable} (e.g. {@link StringBuilder}) and then discarded.
 *
 * <p> That said, if a passed {@code CharSequence} needs to outlast the method
 * call, it needs to be copied.
 *
 * @since 9
 */
@FunctionalInterface
public interface DecodingCallback {

    /**
     * A method the more specific methods of the callback forward their calls
     * to.
     *
     * @param name
     *         header name
     * @param value
     *         header value
     */
    void onDecoded(CharSequence name, CharSequence value);

    /**
     * A more finer-grained version of {@link #onDecoded(CharSequence,
     * CharSequence)} that also reports on value sensitivity.
     *
     * <p> Value sensitivity must be considered, for example, when implementing
     * an intermediary. A {@code value} is sensitive if it was represented as <a
     * href="https://tools.ietf.org/html/rfc7541#section-6.2.3">Literal Header
     * Field Never Indexed</a>.
     *
     * <p> It is required that intermediaries MUST use the {@linkplain
     * Encoder#header(CharSequence, CharSequence, boolean) same representation}
     * for encoding this header field in order to protect its value which is not
     * to be put at risk by compressing it.
     *
     * @implSpec
     *
     * <p> The default implementation invokes {@code onDecoded(name, value)}.
     *
     * @param name
     *         header name
     * @param value
     *         header value
     * @param sensitive
     *         whether or not the value is sensitive
     *
     * @see #onLiteralNeverIndexed(int, CharSequence, CharSequence, boolean)
     * @see #onLiteralNeverIndexed(CharSequence, boolean, CharSequence, boolean)
     */
    default void onDecoded(CharSequence name,
                           CharSequence value,
                           boolean sensitive) {
        onDecoded(name, value);
    }

    /**
     * An <a href="https://tools.ietf.org/html/rfc7541#section-6.1">Indexed
     * Header Field</a> decoded.
     *
     * @implSpec
     *
     * <p> The default implementation invokes
     * {@code onDecoded(name, value, false)}.
     *
     * @param index
     *         index of an entry in the table
     * @param name
     *         header name
     * @param value
     *         header value
     */
    default void onIndexed(int index, CharSequence name, CharSequence value) {
        onDecoded(name, value, false);
    }

    /**
     * A <a href="https://tools.ietf.org/html/rfc7541#section-6.2.2">Literal
     * Header Field without Indexing</a> decoded, where a {@code name} was
     * referred by an {@code index}.
     *
     * @implSpec
     *
     * <p> The default implementation invokes
     * {@code onDecoded(name, value, false)}.
     *
     * @param index
     *         index of an entry in the table
     * @param name
     *         header name
     * @param value
     *         header value
     * @param valueHuffman
     *         if the {@code value} was Huffman encoded
     */
    default void onLiteral(int index,
                           CharSequence name,
                           CharSequence value,
                           boolean valueHuffman) {
        onDecoded(name, value, false);
    }

    /**
     * A <a href="https://tools.ietf.org/html/rfc7541#section-6.2.2">Literal
     * Header Field without Indexing</a> decoded, where both a {@code name} and
     * a {@code value} were literal.
     *
     * @implSpec
     *
     * <p> The default implementation invokes
     * {@code onDecoded(name, value, false)}.
     *
     * @param name
     *         header name
     * @param nameHuffman
     *         if the {@code name} was Huffman encoded
     * @param value
     *         header value
     * @param valueHuffman
     *         if the {@code value} was Huffman encoded
     */
    default void onLiteral(CharSequence name,
                           boolean nameHuffman,
                           CharSequence value,
                           boolean valueHuffman) {
        onDecoded(name, value, false);
    }

    /**
     * A <a href="https://tools.ietf.org/html/rfc7541#section-6.2.3">Literal
     * Header Field Never Indexed</a> decoded, where a {@code name}
     * was referred by an {@code index}.
     *
     * @implSpec
     *
     * <p> The default implementation invokes
     * {@code onDecoded(name, value, true)}.
     *
     * @param index
     *         index of an entry in the table
     * @param name
     *         header name
     * @param value
     *         header value
     * @param valueHuffman
     *         if the {@code value} was Huffman encoded
     */
    default void onLiteralNeverIndexed(int index,
                                       CharSequence name,
                                       CharSequence value,
                                       boolean valueHuffman) {
        onDecoded(name, value, true);
    }

    /**
     * A <a href="https://tools.ietf.org/html/rfc7541#section-6.2.3">Literal
     * Header Field Never Indexed</a> decoded, where both a {@code
     * name} and a {@code value} were literal.
     *
     * @implSpec
     *
     * <p> The default implementation invokes
     * {@code onDecoded(name, value, true)}.
     *
     * @param name
     *         header name
     * @param nameHuffman
     *         if the {@code name} was Huffman encoded
     * @param value
     *         header value
     * @param valueHuffman
     *         if the {@code value} was Huffman encoded
     */
    default void onLiteralNeverIndexed(CharSequence name,
                                       boolean nameHuffman,
                                       CharSequence value,
                                       boolean valueHuffman) {
        onDecoded(name, value, true);
    }

    /**
     * A <a href="https://tools.ietf.org/html/rfc7541#section-6.2.1">Literal
     * Header Field with Incremental Indexing</a> decoded, where a {@code name}
     * was referred by an {@code index}.
     *
     * @implSpec
     *
     * <p> The default implementation invokes
     * {@code onDecoded(name, value, false)}.
     *
     * @param index
     *         index of an entry in the table
     * @param name
     *         header name
     * @param value
     *         header value
     * @param valueHuffman
     *         if the {@code value} was Huffman encoded
     */
    default void onLiteralWithIndexing(int index,
                                       CharSequence name,
                                       CharSequence value,
                                       boolean valueHuffman) {
        onDecoded(name, value, false);
    }

    /**
     * A <a href="https://tools.ietf.org/html/rfc7541#section-6.2.1">Literal
     * Header Field with Incremental Indexing</a> decoded, where both a {@code
     * name} and a {@code value} were literal.
     *
     * @implSpec
     *
     * <p> The default implementation invokes
     * {@code onDecoded(name, value, false)}.
     *
     * @param name
     *         header name
     * @param nameHuffman
     *         if the {@code name} was Huffman encoded
     * @param value
     *         header value
     * @param valueHuffman
     *         if the {@code value} was Huffman encoded
     */
    default void onLiteralWithIndexing(CharSequence name,
                                       boolean nameHuffman,
                                       CharSequence value,
                                       boolean valueHuffman) {
        onDecoded(name, value, false);
    }

    /**
     * A <a href="https://tools.ietf.org/html/rfc7541#section-6.3">Dynamic Table
     * Size Update</a> decoded.
     *
     * @implSpec
     *
     * <p> The default implementation does nothing.
     *
     * @param capacity
     *         new capacity of the header table
     */
    default void onSizeUpdate(int capacity) { }
}
