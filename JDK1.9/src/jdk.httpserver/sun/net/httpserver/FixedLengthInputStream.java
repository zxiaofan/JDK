/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.httpserver;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import com.sun.net.httpserver.spi.*;

/**
 * a class which allows the caller to read up to a defined
 * number of bytes off an underlying stream
 * close() does not close the underlying stream
 */

class FixedLengthInputStream extends LeftOverInputStream {
    private long remaining;

    FixedLengthInputStream (ExchangeImpl t, InputStream src, long len) {
        super (t, src);
        this.remaining = len;
    }

    protected int readImpl (byte[]b, int off, int len) throws IOException {

        eof = (remaining == 0L);
        if (eof) {
            return -1;
        }
        if (len > remaining) {
            len = (int)remaining;
        }
        int n = in.read(b, off, len);
        if (n > -1) {
            remaining -= n;
            if (remaining == 0) {
                t.getServerImpl().requestCompleted (t.getConnection());
            }
        }
        return n;
    }

    public int available () throws IOException {
        if (eof) {
            return 0;
        }
        int n = in.available();
        return n < remaining? n: (int)remaining;
    }

    public boolean markSupported () {return false;}

    public void mark (int l) {
    }

    public void reset () throws IOException {
        throw new IOException ("mark/reset not supported");
    }
}
