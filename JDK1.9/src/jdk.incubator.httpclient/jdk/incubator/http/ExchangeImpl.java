/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.http;

import java.io.IOException;
import jdk.incubator.http.RequestProcessors.ProcessorBase;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import jdk.incubator.http.internal.common.MinimalFuture;
import static jdk.incubator.http.HttpClient.Version.HTTP_1_1;

/**
 * Splits request so that headers and body can be sent separately with optional
 * (multiple) responses in between (e.g. 100 Continue). Also request and
 * response always sent/received in different calls.
 *
 * Synchronous and asynchronous versions of each method are provided.
 *
 * Separate implementations of this class exist for HTTP/1.1 and HTTP/2
 *      Http1Exchange   (HTTP/1.1)
 *      Stream          (HTTP/2)
 *
 * These implementation classes are where work is allocated to threads.
 */
abstract class ExchangeImpl<T> {

    final Exchange<T> exchange;

    ExchangeImpl(Exchange<T> e) {
        this.exchange = e;
        if (e != null) {
            // e == null means a http/2 pushed stream, therefore no request
            setClientForRequest(e.requestProcessor);
        }
    }

    final Exchange<T> getExchange() {
        return exchange;
    }


    /**
     * Returns the {@link HttpConnection} instance to which this exchange is
     * assigned.
     */
    abstract HttpConnection connection();

    /**
     * Initiates a new exchange and assigns it to a connection if one exists
     * already. connection usually null.
     */
    static <U> ExchangeImpl<U> get(Exchange<U> exchange, HttpConnection connection)
        throws IOException, InterruptedException
    {
        HttpRequestImpl req = exchange.request();
        if (exchange.version() == HTTP_1_1) {
            return new Http1Exchange<>(exchange, connection);
        } else {
            Http2ClientImpl c2 = exchange.client().client2(); // TODO: improve
            HttpRequestImpl request = exchange.request();
            Http2Connection c;
            try {
                c = c2.getConnectionFor(request);
            } catch (Http2Connection.ALPNException e) {
                // failed to negotiate "h2"
                AsyncSSLConnection as = e.getConnection();
                as.stopAsyncReading();
                SSLConnection sslc = new SSLConnection(as);
                ExchangeImpl<U> ex = new Http1Exchange<>(exchange, sslc);
                return ex;
            }
            if (c == null) {
                // no existing connection. Send request with HTTP 1 and then
                // upgrade if successful
                ExchangeImpl<U> ex = new Http1Exchange<>(exchange, connection);
                exchange.h2Upgrade();
                return ex;
            }
            return c.createStream(exchange);
        }
    }

    /* The following methods have separate HTTP/1.1 and HTTP/2 implementations */

    /**
     * Sends the request headers only. May block until all sent.
     */
    abstract void sendHeadersOnly() throws IOException, InterruptedException;

    // Blocking impl but in async style

    CompletableFuture<ExchangeImpl<T>> sendHeadersAsync() {
        // this is blocking. cf will already be completed.
        return MinimalFuture.supply(() -> {
            sendHeadersOnly();
            return this;
        });
    }

    /**
     * Gets response by blocking if necessary. This may be an
     * intermediate response (like 101) or a final response 200 etc. Returns
     * before body is read.
     */
    abstract Response getResponse() throws IOException;

    abstract T readBody(HttpResponse.BodyHandler<T> handler,
                        boolean returnConnectionToPool) throws IOException;

    abstract CompletableFuture<T> readBodyAsync(HttpResponse.BodyHandler<T> handler,
                                                boolean returnConnectionToPool,
                                                Executor executor);

    // Builtin processors need access to HttpClientImpl
    final void setClientForResponse(HttpResponse.BodyProcessor<T> proc) {
        if (proc instanceof ResponseProcessors.AbstractProcessor) {
            ResponseProcessors.AbstractProcessor<T> abProc =
                    (ResponseProcessors.AbstractProcessor<T>)proc;
            abProc.setClient(exchange.client());
        }
    }

    final void setClientForRequest(HttpRequest.BodyProcessor proc) {
        if (proc instanceof ProcessorBase) {
            ProcessorBase abProc = (ProcessorBase)proc;
            abProc.setClient(exchange.client());
        }
    }

    /**
     * Async version of getResponse. Completes before body is read.
     */
    abstract CompletableFuture<Response> getResponseAsync(Executor executor);

    /**
     * Sends a request body after request headers.
     */
    abstract void sendBody() throws IOException, InterruptedException;

    // Async version of sendBody(). This only used when body sent separately
    // to headers (100 continue)
    CompletableFuture<ExchangeImpl<T>> sendBodyAsync() {
        return MinimalFuture.supply(() -> {
            sendBody();
            return this;
        });
    }

    /**
     * Cancels a request.  Not currently exposed through API.
     */
    abstract void cancel();

    /**
     * Cancels a request with a cause.  Not currently exposed through API.
     */
    abstract void cancel(IOException cause);
}
