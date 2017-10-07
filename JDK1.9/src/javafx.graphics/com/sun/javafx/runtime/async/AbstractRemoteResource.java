/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.runtime.async;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Abstract base class for representing remote resources identified by a URL.  Subclasses may plug in arbitrary
 * post-processing on the stream to turn it into the desired result.  Manages progress indication if the remote resource
 * provides a content-length header.
 *
 */
public abstract class AbstractRemoteResource<T> extends AbstractAsyncOperation<T> {

    protected final String url;
    protected final String method;
    protected final String outboundContent;
    protected int fileSize;
    private Map<String, String> headers = new HashMap<String, String>();
    private Map<String, List<String>> responseHeaders = new HashMap<String, List<String>>();

    protected AbstractRemoteResource(String url, AsyncOperationListener<T> listener) {
        this(url, "GET", listener);
    }

    protected AbstractRemoteResource(String url, String method, AsyncOperationListener<T> listener) {
        this(url, method, null, listener);
    }

    protected AbstractRemoteResource(String url, String method, String outboundContent, AsyncOperationListener<T> listener) {
        super(listener);
        this.url = url;
        this.method = method;
        this.outboundContent = outboundContent;
    }

    protected abstract T processStream(InputStream stream) throws IOException;

    public T call() throws IOException {
        URL u = new URL(url);
        InputStream stream = null;
        final String protocol = u.getProtocol();
        if(protocol.equals("http") || protocol.equals("https")) {
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod(method);
            conn.setDoInput(true);

            for (Map.Entry<String,String> entry : headers.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value != null && !value.equals(""))
                    conn.setRequestProperty(key, value);
            }
            if(outboundContent != null && method.equals("POST")) {
                conn.setDoOutput(true);
                byte[] outBytes = outboundContent.getBytes("utf-8");
                conn.setRequestProperty("Content-Length", String.valueOf(outBytes.length));
                OutputStream out = conn.getOutputStream();
                out.write(outBytes);
                out.close();
            }
            conn.connect();
            fileSize = conn.getContentLength();
            setProgressMax(fileSize);
            responseHeaders = conn.getHeaderFields();

            stream = new ProgressInputStream(conn.getInputStream());
        } else { // protocol is something other than http...
            URLConnection con = u.openConnection();
            setProgressMax(con.getContentLength());
            stream = new ProgressInputStream(con.getInputStream());
        }

        try {
            return processStream(stream);
        }
        finally {
            stream.close();
        }
    }

    protected class ProgressInputStream extends BufferedInputStream {
        public ProgressInputStream(InputStream in) {
            super(in);
        }

        @Override
        public synchronized int read() throws IOException {
            if (Thread.currentThread().isInterrupted())
                throw new InterruptedIOException();
            int ch = super.read();
            addProgress(1);
            return ch;
        }

        @Override
        public synchronized int read(byte b[], int off, int len) throws IOException {
            if (Thread.currentThread().isInterrupted())
                throw new InterruptedIOException();
            int bytes = super.read(b, off, len);
            addProgress(bytes);
            return bytes;
        }

        @Override
        public int read(byte b[]) throws IOException {
            if (Thread.currentThread().isInterrupted())
                throw new InterruptedIOException();
            int bytes = super.read(b);
            addProgress(bytes);
            return bytes;
        }
    }

    public void setHeader(String header, String value) {
        headers.put(header, value);
    }

    public String getResponseHeader(String header) {
        String value = null;
        List<String> list = responseHeaders.get(header);
        // return a csv of the strings.
        if(list != null) {
            StringBuilder sb = new StringBuilder();
            Iterator iter = list.iterator();
            while(iter.hasNext()) {
                sb.append(iter.next());
                if(iter.hasNext()) {
                    sb.append(',');
                }
            }
            value = sb.toString();
        }
        return value;
    }
}
