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

package com.sun.xml.internal.ws;

import javax.xml.ws.WebServiceException;
import javax.xml.ws.Dispatch;
import java.io.IOException;

/**
 * Closeable JAX-WS proxy object.
 *
 * @author Kohsuke Kawaguchi
 * @since JAX-WS 2.0.2
 */
// this interface is exposed to applications.
public interface Closeable extends java.io.Closeable {
    /**
     * Closes this object and cleans up any resources
     * it holds, such as network connections.
     *
     * <p>
     * This interface is implemented by a port proxy
     * or {@link Dispatch}. In particular, this signals
     * the implementation of certain specs (like WS-ReliableMessaging
     * and WS-SecureConversation) to terminate sessions that they
     * create during the life time of a proxy object.
     *
     * <p>
     * This is not a mandatory operation, so the application
     * does not have to call this method.
     *
     *
     * @throws WebServiceException
     *      If clean up fails unexpectedly, this exception
     *      will be thrown (instead of {@link IOException}.
     */
    public void close() throws WebServiceException;
}
