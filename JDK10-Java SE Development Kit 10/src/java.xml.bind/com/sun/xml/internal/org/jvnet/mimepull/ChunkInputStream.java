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

import java.io.InputStream;
import java.io.IOException;

/**
 * Constructs a InputStream from a linked list of {@link Chunk}s.
 *
 * @author Kohsuke Kawaguchi
 * @author Jitendra Kotamraju
 */
final class ChunkInputStream extends InputStream {
    Chunk current;
    int offset;
    int len;
    final MIMEMessage msg;
    final MIMEPart part;
    byte[] buf;

    public ChunkInputStream(MIMEMessage msg, MIMEPart part, Chunk startPos) {
        this.current = startPos;
        len = current.data.size();
        buf = current.data.read();
        this.msg = msg;
        this.part = part;
    }

    @Override
    public int read(byte b[], int off, int sz) throws IOException {
        if (!fetch()) {
            return -1;
        }

        sz = Math.min(sz, len-offset);
        System.arraycopy(buf,offset,b,off,sz);
        return sz;
    }

    public int read() throws IOException {
        if (!fetch()) {
            return -1;
        }
        return (buf[offset++] & 0xff);
    }

    /**
     * Gets to the next chunk if we are done with the current one.
     * @return
     */
    private boolean fetch() {
        if (current == null) {
            throw new IllegalStateException("Stream already closed");
        }
        while(offset==len) {
            while(!part.parsed && current.next == null) {
                msg.makeProgress();
            }
            current = current.next;

            if (current == null) {
                return false;
            }
            this.offset = 0;
            this.buf = current.data.read();
            this.len = current.data.size();
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        super.close();
        current = null;
    }
}
