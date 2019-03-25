/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jshell.execution;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Packetize an OutputStream, dividing it into named channels.
 *
 * @author Jan Lahoda
 */
class MultiplexingOutputStream extends OutputStream {

    private static final int PACKET_SIZE = 127;
    private final byte[] name;
    private final OutputStream delegate;

    MultiplexingOutputStream(String name, OutputStream delegate) {
        try {
            this.name = name.getBytes("UTF-8");
            this.delegate = delegate;
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalStateException(ex); //should not happen
        }
    }

    @Override
    public void write(int b) throws IOException {
        write(new byte[] {(byte) b});
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        synchronized (delegate) {
            int i = 0;
            while (len > 0) {
                int size = Math.min(PACKET_SIZE, len);
                byte[] data = new byte[name.length + 1 + size + 1];
                data[0] = (byte) name.length; //assuming the len is small enough to fit into byte
                System.arraycopy(name, 0, data, 1, name.length);
                data[name.length + 1] = (byte) size;
                System.arraycopy(b, off + i, data, name.length + 2, size);
                delegate.write(data);
                i += size;
                len -= size;
            }
            delegate.flush();
        }
    }

    @Override
    public void flush() throws IOException {
        super.flush();
        delegate.flush();
    }

    @Override
    public void close() throws IOException {
        super.close();
        delegate.close();
    }

}
