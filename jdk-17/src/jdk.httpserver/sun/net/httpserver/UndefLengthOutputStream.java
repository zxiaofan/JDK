/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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
 * a class which allows the caller to write an indefinite
 * number of bytes to an underlying stream , but without using
 * chunked encoding. Used for http/1.0 clients only
 * The underlying connection needs to be closed afterwards.
 */

class UndefLengthOutputStream extends FilterOutputStream
{
    private boolean closed = false;
    ExchangeImpl t;

    UndefLengthOutputStream (ExchangeImpl t, OutputStream src) {
        super (src);
        this.t = t;
    }

    public void write (int b) throws IOException {
        if (closed) {
            throw new IOException ("stream closed");
        }
        out.write(b);
    }

    public void write (byte[]b, int off, int len) throws IOException {
        if (closed) {
            throw new IOException ("stream closed");
        }
        out.write(b, off, len);
    }

    public void close () throws IOException {
        if (closed) {
            return;
        }
        closed = true;
        flush();
        LeftOverInputStream is = t.getOriginalInputStream();
        if (!is.isClosed()) {
            try {
                is.close();
            } catch (IOException e) {}
        }
        WriteFinishedEvent e = new WriteFinishedEvent (t);
        t.getHttpContext().getServerImpl().addEvent (e);
    }

    // flush is a pass-through
}
