/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.util.xml.impl;

import java.io.Reader;
import java.io.InputStream;
import java.io.IOException;

/**
 * UTF-16 encoded stream reader.
 */
public class ReaderUTF16 extends Reader {

    private InputStream is;
    private char bo;

    /**
     * Constructor.
     *
     * Byte order argument can be: 'l' for little-endian or 'b' for big-endian.
     *
     * @param is A byte input stream.
     * @param bo A byte order in the input stream.
     */
    public ReaderUTF16(InputStream is, char bo) {
        switch (bo) {
            case 'l':
                break;

            case 'b':
                break;

            default:
                throw new IllegalArgumentException("");
        }
        this.bo = bo;
        this.is = is;
    }

    /**
     * Reads characters into a portion of an array.
     *
     * @param cbuf Destination buffer.
     * @param off Offset at which to start storing characters.
     * @param len Maximum number of characters to read.
     * @exception IOException If any IO errors occur.
     */
    public int read(char[] cbuf, int off, int len) throws IOException {
        int num = 0;
        int val;
        if (bo == 'b') {
            while (num < len) {
                if ((val = is.read()) < 0) {
                    return (num != 0) ? num : -1;
                }
                cbuf[off++] = (char) ((val << 8) | (is.read() & 0xff));
                num++;
            }
        } else {
            while (num < len) {
                if ((val = is.read()) < 0) {
                    return (num != 0) ? num : -1;
                }
                cbuf[off++] = (char) ((is.read() << 8) | (val & 0xff));
                num++;
            }
        }
        return num;
    }

    /**
     * Reads a single character.
     *
     * @return The character read, as an integer in the range 0 to 65535
     *  (0x0000-0xffff), or -1 if the end of the stream has been reached.
     * @exception IOException If any IO errors occur.
     */
    public int read() throws IOException {
        int val;
        if ((val = is.read()) < 0) {
            return -1;
        }
        if (bo == 'b') {
            val = (char) ((val << 8) | (is.read() & 0xff));
        } else {
            val = (char) ((is.read() << 8) | (val & 0xff));
        }
        return val;
    }

    /**
     * Closes the stream.
     *
     * @exception IOException If any IO errors occur.
     */
    public void close() throws IOException {
        is.close();
    }
}
