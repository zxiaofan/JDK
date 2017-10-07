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

package com.sun.xml.internal.ws.api.server;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Callback interface to signal JAX-WS RI that the processing of an asynchronous request is complete.
 *
 * <p>
 * The application is responsible for invoking one of the two defined methods to
 * indicate the result of the request processing.
 *
 * <p>
 * Both methods will return immediately, and the JAX-WS RI will
 * send out an actual response at some later point.
 *
 * @author Jitendra Kotamraju
 * @author Kohsuke Kawaguchi
 * @since 2.1
 * @see AsyncProvider
 */
public interface AsyncProviderCallback<T> {
    /**
     * Indicates that a request was processed successfully.
     *
     * @param response
     *      Represents an object to be sent back to the client
     *      as a response. To indicate one-way, response needs to be null
     */
    void send(@Nullable T response);

    /**
     * Indicates that an error had occured while processing a request.
     *
     * @param t
     *      The error is propagated to the client. For example, if this is
     *      a SOAP-based web service, the server will send back a SOAP fault.
     */
    void sendError(@NotNull Throwable t);
}
