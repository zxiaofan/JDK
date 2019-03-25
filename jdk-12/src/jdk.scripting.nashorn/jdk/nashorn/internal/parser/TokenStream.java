/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.parser;

/**
 *
 */

/**
 * Handles streaming of tokens between lexer and parser.
 *
 */
public class TokenStream {
    /** Initial buffer size. */
    private static final int INITIAL_SIZE = 256;

    /** Token buffer. */
    private long[] buffer;

    /** Token count. */
    private int count;

    /** Cursor to write position in buffer */
    private int in;

    /** Cursor to read position in buffer */
    private int out;

    /** Base index in buffer */
    private int base;

    /**
     * Constructor.
     */
    public TokenStream() {
        buffer = new long[INITIAL_SIZE];
        count = 0;
        in = 0;
        out = 0;
        base = 0;
    }

    /**
     * Get the next position in the buffer.
     * @param position Current position in buffer.
     * @return Next position in buffer.
     */
    private int next(final int position) {
        // Next position.
        int next = position + 1;

        // If exceeds buffer length.
        if (next >= buffer.length) {
            // Wrap around.
            next = 0;
        }

        return next;
    }

     /**
     * Get the index position in the buffer.
     * @param k Seek position.
     * @return Position in buffer.
     */
    private int index(final int k) {
        // Bias k.
        int index = k - (base - out);

        // If wrap around.
        if (index >= buffer.length) {
            index -= buffer.length;
        }

        return index;
    }

    /**
     * Test to see if stream is empty.
     * @return True if stream is empty.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Test to see if stream is full.
     * @return True if stream is full.
     */
    public boolean isFull() {
        return count == buffer.length;
    }

    /**
     * Get the number of tokens in the buffer.
     * @return Number of tokens.
     */
    public int count() {
        return count;
    }

    /**
     * Get the index of the first token in the stream.
     * @return Index of first buffered token in the stream.
     */
    public int first() {
        return base;
    }

    /**
     * Get the index of the last token in the stream.
     * @return Index of last buffered token in the stream.
     */
    public int last() {
        return base + count - 1;
    }

    /**
     * Remove the last token in the stream.
     */
    public void removeLast() {
        if (count != 0) {
            count--;
            in--;

            if (in < 0) {
                in = buffer.length - 1;
            }
        }
    }

    /**
     * Put a token descriptor to the stream.
     * @param token Token descriptor to add.
     */
    public void put(final long token) {
        if (count == buffer.length) {
            grow();
        }

        buffer[in] = token;
        count++;
        in = next(in);
    }

    /**
     * Get the kth token descriptor from the stream.
     * @param k index
     * @return Token descriptor.
     */
    public long get(final int k) {
        return buffer[index(k)];
    }

    /**
     * Advances the base of the stream.
     * @param k Position of token to be the new base.
     */
    public void commit(final int k) {
        // Advance out.
        out = index(k);
        // Adjust count.
        count -= k - base;
        // Set base.
        base = k;
    }

    /**
     * Grow the buffer to accommodate more token descriptors.
     */
    public void grow() {
        // Allocate new buffer.
        final long[] newBuffer = new long[buffer.length * 2];

        // If single chunk.
        if (in > out) {
            System.arraycopy(buffer, out, newBuffer, 0, count);
        } else {
            final int portion = buffer.length - out;
            System.arraycopy(buffer, out, newBuffer, 0, portion);
            System.arraycopy(buffer, 0, newBuffer, portion, count - portion);
        }

        // Update buffer and indices.
        out = 0;
        in = count;
        buffer = newBuffer;
    }

    void reset() {
        in = out = count = base = 0;
    }
}
