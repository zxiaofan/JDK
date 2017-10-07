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

package com.sun.xml.internal.ws.transport.http.server;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import com.sun.xml.internal.ws.transport.http.HttpAdapter;
import com.sun.xml.internal.ws.transport.http.WSHTTPConnection;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * {@link HttpHandler} implementation that serves the actual request.
 *
 * @author Jitendra Kotamraju
 * @author Kohsuke Kawaguhi
 */
final class WSHttpHandler implements HttpHandler {

    private static final String GET_METHOD = "GET";
    private static final String POST_METHOD = "POST";
    private static final String HEAD_METHOD = "HEAD";
    private static final String PUT_METHOD = "PUT";
    private static final String DELETE_METHOD = "DELETE";

    private static final Logger LOGGER =
        Logger.getLogger(
            com.sun.xml.internal.ws.util.Constants.LoggingDomain + ".server.http");
    private static final boolean fineTraceEnabled = LOGGER.isLoggable(Level.FINE);

    private final HttpAdapter adapter;
    private final Executor executor;

    public WSHttpHandler(@NotNull HttpAdapter adapter, @Nullable Executor executor) {
        assert adapter!=null;
        this.adapter = adapter;
        this.executor = executor;
    }

    /**
     * Called by HttpServer when there is a matching request for the context
     */
    public void handle(HttpExchange msg) {
        try {
            if (fineTraceEnabled) {
                LOGGER.log(Level.FINE, "Received HTTP request:{0}", msg.getRequestURI());
            }
            if (executor != null) {
                // Use application's Executor to handle request. Application may
                // have set an executor using Endpoint.setExecutor().
                executor.execute(new HttpHandlerRunnable(msg));
            } else {
                handleExchange(msg);
            }
        } catch(Throwable e) {
            // Dont't propagate the exception otherwise it kills the httpserver
        }
    }

    private void handleExchange(HttpExchange msg) throws IOException {
        WSHTTPConnection con = new ServerConnectionImpl(adapter,msg);
        try {
            if (fineTraceEnabled) {
                LOGGER.log(Level.FINE, "Received HTTP request:{0}", msg.getRequestURI());
            }
            String method = msg.getRequestMethod();
            if(method.equals(GET_METHOD) || method.equals(POST_METHOD) || method.equals(HEAD_METHOD)
            || method.equals(PUT_METHOD) || method.equals(DELETE_METHOD)) {
                adapter.handle(con);
            } else {
                if (LOGGER.isLoggable(Level.WARNING)) {
                    LOGGER.warning(HttpserverMessages.UNEXPECTED_HTTP_METHOD(method));
                }
            }
        } finally {
            msg.close();
        }
    }

    /**
     * Wrapping the processing of request in a Runnable so that it can be
     * executed in Executor.
     */
    class HttpHandlerRunnable implements Runnable {
        final HttpExchange msg;

        HttpHandlerRunnable(HttpExchange msg) {
            this.msg = msg;
        }

        public void run() {
            try {
                handleExchange(msg);
            } catch (Throwable e) {
                // Does application's executor handle this exception ?
                e.printStackTrace();
            }
        }
    }


}
