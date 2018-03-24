/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.mimepull;

import java.io.*;

/**
 * Use {@link RandomAccessFile} for concurrent access of read
 * and write partial part's content.
 *
 * @author Kohsuke Kawaguchi
 * @author Jitendra Kotamraju
 */
final class DataFile {
    private WeakDataFile weak;
    private long writePointer;

    DataFile(File file) {
        writePointer=0;
        weak = new WeakDataFile(this, file);
    }

    /**
     *
     */
    void close() {
        weak.close();
    }

    /**
     * Read data from the given file pointer position.
     *
     * @param pointer read position
     * @param buf that needs to be filled
     * @param offset the start offset of the data.
     * @param length of data that needs to be read
     */
    synchronized void read(long pointer, byte[] buf, int offset, int length ) {
        weak.read(pointer, buf, offset, length);
    }

    void renameTo(File f) {
        weak.renameTo(f);
    }

    /**
     * Write data to the file
     *
     * @param data that needs to written to a file
     * @param offset start offset in the data
     * @param length no bytes to write
     * @return file pointer before the write operation(or at which the
     *         data is written)
     */
    synchronized long writeTo(byte[] data, int offset, int length) {
        long temp = writePointer;
        writePointer = weak.writeTo(writePointer, data, offset, length);
        return temp;
    }

}
