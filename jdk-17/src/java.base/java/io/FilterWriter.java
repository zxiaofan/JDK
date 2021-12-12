/*
 * Copyright (c) 1996, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.io;


/**
 * Abstract class for writing filtered character streams.
 * The abstract class {@code FilterWriter} itself
 * provides default methods that pass all requests to the
 * contained stream. Subclasses of {@code FilterWriter}
 * should override some of these methods and may also
 * provide additional methods and fields.
 *
 * @author      Mark Reinhold
 * @since       1.1
 */

public abstract class FilterWriter extends Writer {

    /**
     * The underlying character-output stream.
     */
    protected Writer out;

    /**
     * Create a new filtered writer.
     *
     * @param out  a Writer object to provide the underlying stream.
     * @throws NullPointerException if {@code out} is {@code null}
     */
    protected FilterWriter(Writer out) {
        super(out);
        this.out = out;
    }

    /**
     * Writes a single character.
     *
     * @throws     IOException  If an I/O error occurs
     */
    public void write(int c) throws IOException {
        out.write(c);
    }

    /**
     * Writes a portion of an array of characters.
     *
     * @param  cbuf  Buffer of characters to be written
     * @param  off   Offset from which to start reading characters
     * @param  len   Number of characters to be written
     *
     * @throws  IndexOutOfBoundsException
     *          If the values of the {@code off} and {@code len} parameters
     *          cause the corresponding method of the underlying {@code Writer}
     *          to throw an {@code IndexOutOfBoundsException}
     *
     * @throws  IOException  If an I/O error occurs
     */
    public void write(char cbuf[], int off, int len) throws IOException {
        out.write(cbuf, off, len);
    }

    /**
     * Writes a portion of a string.
     *
     * @param  str  String to be written
     * @param  off  Offset from which to start reading characters
     * @param  len  Number of characters to be written
     *
     * @throws  IndexOutOfBoundsException
     *          If the values of the {@code off} and {@code len} parameters
     *          cause the corresponding method of the underlying {@code Writer}
     *          to throw an {@code IndexOutOfBoundsException}
     *
     * @throws  IOException  If an I/O error occurs
     */
    public void write(String str, int off, int len) throws IOException {
        out.write(str, off, len);
    }

    /**
     * Flushes the stream.
     *
     * @throws     IOException  If an I/O error occurs
     */
    public void flush() throws IOException {
        out.flush();
    }

    public void close() throws IOException {
        out.close();
    }

}
