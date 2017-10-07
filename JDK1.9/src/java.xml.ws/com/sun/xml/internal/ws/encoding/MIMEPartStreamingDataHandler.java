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

package com.sun.xml.internal.ws.encoding;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEPart;

import javax.activation.DataSource;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;

import com.sun.xml.internal.ws.developer.StreamingDataHandler;

/**
 * Implementation of {@link StreamingDataHandler} to access MIME
 * attachments efficiently. Applications can use the additional methods and decide
 * on how to access the attachment data in JAX-WS applications.
 *
 * <p>
 * for e.g.:
 *
 * DataHandler dh = proxy.getData();
 * StreamingDataHandler sdh = (StreamingDataHandler)dh;
 * // readOnce() doesn't store attachment on the disk in some cases
 * // for e.g when only one huge attachment after soap envelope part in MIME message
 * InputStream in = sdh.readOnce();
 * ...
 * in.close();
 * sdh.close();
 *
 * @author Jitendra Kotamraju
 */
public class MIMEPartStreamingDataHandler extends StreamingDataHandler {
    private final StreamingDataSource ds;

    public MIMEPartStreamingDataHandler(MIMEPart part) {
        super(new StreamingDataSource(part));
        ds = (StreamingDataSource)getDataSource();
    }

    @Override
    public InputStream readOnce() throws IOException {
        return ds.readOnce();
    }

    @Override
    public void moveTo(File file) throws IOException {
        ds.moveTo(file);
    }

    @Override
    public void close() throws IOException {
        ds.close();
    }

    private static final class StreamingDataSource implements DataSource {
        private final MIMEPart part;

        StreamingDataSource(MIMEPart part) {
            this.part = part;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return part.read();             //readOnce() ??
        }

        InputStream readOnce() throws IOException {
            try {
                return part.readOnce();
            } catch(Exception e) {
                throw new MyIOException(e);
            }
        }

        void moveTo(File file) throws IOException {
            part.moveTo(file);
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            return null;
        }

        @Override
        public String getContentType() {
            return part.getContentType();
        }

        @Override
        public String getName() {
            return "";
        }

        public void close() throws IOException {
            part.close();
        }
    }

    private static final class MyIOException extends IOException {
        private final Exception linkedException;

        MyIOException(Exception linkedException) {
            this.linkedException = linkedException;
        }

        @Override
        public Throwable getCause() {
            return linkedException;
        }
    }

}
