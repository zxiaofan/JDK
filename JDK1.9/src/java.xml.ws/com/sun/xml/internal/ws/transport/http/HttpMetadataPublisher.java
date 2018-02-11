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

package com.sun.xml.internal.ws.transport.http;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.Component;
import com.sun.xml.internal.ws.api.server.WSEndpoint;

import java.io.IOException;

/**
 * Intercepts GET HTTP requests to process the requests.
 *
 * <p>
 * {@link HttpAdapter} looks for this SPI in {@link WSEndpoint#getComponents()}
 * to allow components to expose additional information through HTTP.
 *
 * @author Kohsuke Kawaguchi
 * @see Component#getSPI(Class)
 * @since 2.1.2
 */
public abstract class HttpMetadataPublisher {
    /**
     * When {@link HttpAdapter} receives a GET request with a query string
     * (which is a convention for metadata requests, such as '?wsdl' or '?xsd=...'),
     * then this method is invoked to allow components to intercept the request.
     *
     * @param adapter
     *      Adapter that accepted the connection.
     * @param connection
     *      Represents the current connection.
     * @return
     *      true if the request is processed. If false is returned the default processing kicks in.
     */
    public abstract boolean handleMetadataRequest(@NotNull HttpAdapter adapter, @NotNull WSHTTPConnection connection) throws IOException;
}
