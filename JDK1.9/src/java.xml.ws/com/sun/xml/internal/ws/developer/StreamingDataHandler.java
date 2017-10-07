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

package com.sun.xml.internal.ws.developer;

import java.net.URL;

import javax.activation.DataSource;

/**
 * Implementation of {@link com.sun.xml.internal.org.jvnet.staxex.StreamingDataHandler} to access MIME
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
public abstract class StreamingDataHandler extends com.sun.xml.internal.org.jvnet.staxex.StreamingDataHandler {

    public StreamingDataHandler(Object o, String s) {
        super(o, s);
    }

    public StreamingDataHandler(URL url) {
        super(url);
    }

    public StreamingDataHandler(DataSource dataSource) {
        super(dataSource);
    }
}
