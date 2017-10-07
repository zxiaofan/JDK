/*
 * Copyright (c) 1997, Oracle and/or its affiliates. All rights reserved.
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

package sun.rmi.log;

import java.io.*;

public
class LogOutputStream extends OutputStream {

    private RandomAccessFile raf;

    /**
     * Creates an output file with the specified system dependent
     * file descriptor.
     * @param raf the system dependent file descriptor.
     * @exception IOException If an I/O error has occurred.
     */
    public LogOutputStream(RandomAccessFile raf) throws IOException {
        this.raf = raf;
    }

    /**
     * Writes a byte of data. This method will block until the byte is
     * actually written.
     * @param b the byte to be written
     * @exception IOException If an I/O error has occurred.
     */
    public void write(int b) throws IOException {
        raf.write(b);
    }

    /**
     * Writes an array of bytes. Will block until the bytes
     * are actually written.
     * @param b the data to be written
     * @exception IOException If an I/O error has occurred.
     */
    public void write(byte b[]) throws IOException {
        raf.write(b);
    }

    /**
     * Writes a sub array of bytes.
     * @param b the data to be written
     * @param off       the start offset in the data
     * @param len       the number of bytes that are written
     * @exception IOException If an I/O error has occurred.
     */
    public void write(byte b[], int off, int len) throws IOException {
        raf.write(b, off, len);
    }

    /**
     * Can not close a LogOutputStream, so this does nothing.
     * @exception IOException If an I/O error has occurred.
     */
    public final void close() throws IOException {
    }

}
