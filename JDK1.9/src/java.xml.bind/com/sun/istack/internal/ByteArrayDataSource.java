/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.istack.internal;

import javax.activation.DataSource;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;

/**
 * {@link DataSource} backed by a byte buffer.
 *
 * @author Kohsuke Kawaguchi
 */
public final class ByteArrayDataSource implements DataSource {

    private final String contentType;
    private final byte[] buf;
    private final int len;

    /**
     * @param buf input buffer - the byte array isn't being copied; used directly
     * @param contentType
     */
    public ByteArrayDataSource(byte[] buf, String contentType) {
        this(buf,buf.length,contentType);
    }

    /**
     * @param buf input buffer - the byte array isn't being copied; used directly
     * @param length
     * @param contentType
     */
    public ByteArrayDataSource(byte[] buf, int length, String contentType) {
        this.buf = buf;
        this.len = length;
        this.contentType = contentType;
    }

    public String getContentType() {
        if(contentType==null)
            return "application/octet-stream";
        return contentType;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(buf,0,len);
    }

    public String getName() {
        return null;
    }

    public OutputStream getOutputStream() {
        throw new UnsupportedOperationException();
    }
}
