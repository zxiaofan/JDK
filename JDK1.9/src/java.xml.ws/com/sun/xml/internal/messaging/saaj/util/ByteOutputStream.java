/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.messaging.saaj.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

/**
 * Customized {@link BufferedOutputStream}.
 *
 * <p>
 * Compared to {@link BufferedOutputStream},
 * this class:
 *
 * <ol>
 * <li>doesn't do synchronization
 * <li>allows access to the raw buffer
 * <li>almost no parameter check
 * </ol>
 */
public final class ByteOutputStream extends OutputStream {
    /**
     * The buffer where data is stored.
     */
    protected byte[] buf;

    /**
     * The number of valid bytes in the buffer.
     */
    protected int count = 0;

    public ByteOutputStream() {
        this(1024);
    }

    public ByteOutputStream(int size) {
        buf = new byte[size];
    }

    /**
     * Copies all the bytes from this input into this buffer.
     *
     * @param in input stream.
     * @exception IOException in case of an I/O error.
     */
    public void write(InputStream in) throws IOException {
        if (in instanceof ByteArrayInputStream) {
            int size = in.available();
            ensureCapacity(size);
            count += in.read(buf,count,size);
            return;
        }
        while(true) {
            int cap = buf.length-count;
            int sz = in.read(buf,count,cap);
            if(sz<0)    return;     // hit EOS

            count += sz;
            if(cap==sz)
                // the buffer filled up. double the buffer
                ensureCapacity(count);
        }
    }

    @Override
    public void write(int b) {
        ensureCapacity(1);
        buf[count] = (byte) b;
        count++;
    }

    /**
     * Ensure that the buffer has at least this much space.
     */
    private void ensureCapacity(int space) {
        int newcount = space + count;
        if (newcount > buf.length) {
            byte[] newbuf = new byte[Math.max(buf.length << 1, newcount)];
            System.arraycopy(buf, 0, newbuf, 0, count);
            buf = newbuf;
        }
    }

    @Override
    public void write(byte[] b, int off, int len) {
        ensureCapacity(len);
        System.arraycopy(b, off, buf, count, len);
        count += len;
    }

    @Override
    public void write(byte[] b) {
        write(b, 0, b.length);
    }

    /**
     * Writes a string as ASCII string.
     *
     * @param s string to write.
     */
    public void writeAsAscii(String s) {
        int len = s.length();

        ensureCapacity(len);

        int ptr = count;
        for( int i=0; i<len; i++ )
            buf[ptr++] = (byte)s.charAt(i);
        count = ptr;
    }

    public void writeTo(OutputStream out) throws IOException {
        out.write(buf, 0, count);
    }

    public void reset() {
        count = 0;
    }

    /**
     * Evil buffer reallocation method.
     * Don't use it unless you absolutely have to.
     *
     * @return byte array
     *
     * @deprecated
     *      because this is evil!
     */
    @Deprecated
    public byte toByteArray()[] {
        byte[] newbuf = new byte[count];
        System.arraycopy(buf, 0, newbuf, 0, count);
        return newbuf;
    }

    public int size() {
        return count;
    }

    public ByteInputStream newInputStream() {
        return new ByteInputStream(buf,count);
    }

    /**
     * Converts the buffer's contents into a string, translating bytes into
     * characters according to the platform's default character encoding.
     *
     * @return String translated from the buffer's contents.
     * @since JDK1.1
     */
    @Override
    public String toString() {
        return new String(buf, 0, count);
    }

    @Override
    public void close() {
    }

    public byte[] getBytes() {
        return buf;
    }


    public int getCount() {
        return count;
    }
}
