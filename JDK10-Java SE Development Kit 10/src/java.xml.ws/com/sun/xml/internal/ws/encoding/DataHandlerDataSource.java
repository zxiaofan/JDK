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

import javax.activation.DataSource;
import javax.activation.DataHandler;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * {@link DataSource} impl using a DataHandler
 *
 * @author Jitendra Kotamraju
 */
public class DataHandlerDataSource implements DataSource {
    private final DataHandler dataHandler;

    public DataHandlerDataSource(DataHandler dh) {
        this.dataHandler = dh;
    }

    /**
     * Returns an <code>InputStream</code> representing this object.
     *
     * @return the <code>InputStream</code>
     */
    public InputStream getInputStream() throws IOException {
        return dataHandler.getInputStream();
    }

    /**
     * Returns the <code>OutputStream</code> for this object.
     *
     * @return the <code>OutputStream</code>
     */
    public OutputStream getOutputStream() throws IOException {
        return dataHandler.getOutputStream();
    }

    /**
     * Returns the MIME type of the data represented by this object.
     *
     * @return the MIME type
     */
    public String getContentType() {
        return dataHandler.getContentType();
    }

    /**
     * Returns the name of this object.
     *
     * @return the name of this object
     */
    public String getName() {
        return dataHandler.getName();
    }
}
