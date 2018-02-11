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

import java.io.ByteArrayInputStream;
import java.io.IOException;

// This class just gives access to the underlying buffer without copying.

public class ByteInputStream extends ByteArrayInputStream {
    private static final byte[] EMPTY_ARRAY = new byte[0];

    public ByteInputStream() {
        this(EMPTY_ARRAY, 0);
    }

    public ByteInputStream(byte buf[], int length) {
        super(buf, 0, length);
    }

    public ByteInputStream(byte buf[], int offset, int length) {
        super(buf, offset, length);
    }

    public byte[] getBytes() {
        return buf;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws IOException {
        reset();
    }

    public void setBuf(byte[] buf) {
        this.buf = buf;
        this.pos = 0;
        this.count = buf.length;
    }
}
