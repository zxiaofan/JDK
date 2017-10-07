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

package sun.net.www.http;
import java.io.*;

/**
 * A Simple FilterInputStream subclass to capture HTTP traffic.
 * Every byte read is also passed to the HttpCapture class.
 *
 * @author jccollet
 */
public class HttpCaptureInputStream extends FilterInputStream {
    private HttpCapture capture = null;

    public HttpCaptureInputStream(InputStream in, HttpCapture cap) {
        super(in);
        capture = cap;
    }

    @Override
    public int read() throws IOException {
        int i = super.read();
        capture.received(i);
        return i;
    }

    @Override
    public void close() throws IOException {
        try {
            capture.flush();
        } catch (IOException iOException) {
        }
        super.close();
    }

    @Override
    public int read(byte[] b) throws IOException {
        int ret = super.read(b);
        for (int i = 0; i < ret; i++) {
            capture.received(b[i]);
        }
        return ret;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int ret = super.read(b, off, len);
        for (int i = 0; i < ret; i++) {
            capture.received(b[off+i]);
        }
        return ret;
    }
}
