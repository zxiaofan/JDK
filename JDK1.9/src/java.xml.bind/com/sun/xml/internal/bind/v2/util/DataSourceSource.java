/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

/**
 * {@link Source} implementation backed by {@link DataHandler}.
 *
 * <p>
 * This implementation allows the same {@link Source} to be used
 * mutliple times.
 *
 * <p>
 * {@link Source} isn't really pluggable. As a consequence,
 * this implementation is clunky --- weak against unexpected
 * usage of the class.
 *
 * @author Kohsuke Kawaguchi
 */
public final class DataSourceSource extends StreamSource {
    private final DataSource source;

    /**
     * If null, default to the encoding declaration
     */
    private final String charset;

    // remember the value we returned so that the 2nd invocation
    // will return the same object, which is what's expeted out of
    // StreamSource
    private Reader r;
    private InputStream is;

    public DataSourceSource(DataHandler dh) throws MimeTypeParseException {
        this(dh.getDataSource());
    }

    public DataSourceSource(DataSource source) throws MimeTypeParseException {
        this.source = source;

        String ct = source.getContentType();
        if(ct==null) {
            charset = null;
        } else {
            MimeType mimeType = new MimeType(ct);
            this.charset = mimeType.getParameter("charset");
        }
    }

    @Override
    public void setReader(Reader reader) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setInputStream(InputStream inputStream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Reader getReader() {
        try {
            if(charset==null)   return null;
            if(r==null)
                r = new InputStreamReader(source.getInputStream(),charset);
            return r;
        } catch (IOException e) {
            // argh
            throw new RuntimeException(e);
        }
    }

    @Override
    public InputStream getInputStream() {
        try {
            if(charset!=null)   return null;
            if(is==null)
                is = source.getInputStream();
            return is;
        } catch (IOException e) {
            // argh
            throw new RuntimeException(e);
        }
    }

    public DataSource getDataSource() {
        return source;
    }
}
