/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import jdk.incubator.http.internal.common.Log;
import static jdk.incubator.http.HttpClient.Version.HTTP_1_1;

/**
 * Handles a HTTP/1.1 response in two blocking calls. readHeaders() and
 * readBody(). There can be more than one of these per Http exchange.
 */
class Http1Response<T> {

    private volatile ResponseContent content;
    private final HttpRequestImpl request;
    private Response response;
    private final HttpConnection connection;
    private ResponseHeaders headers;
    private int responseCode;
    private ByteBuffer buffer;
    private final Http1Exchange<T> exchange;
    private final boolean redirecting; // redirecting
    private boolean return2Cache; // return connection to cache when finished

    Http1Response(HttpConnection conn, Http1Exchange<T> exchange) {
        this.request = exchange.request();
        this.exchange = exchange;
        this.connection = conn;
        this.redirecting = false;
        buffer = exchange.getBuffer();
    }

    @SuppressWarnings("unchecked")
    public void readHeaders() throws IOException {
        String statusline = readStatusLine();
        if (statusline == null) {
            if (Log.errors()) {
                Log.logError("Connection closed. Retry");
            }
            connection.close();
            // connection was closed
            throw new IOException("Connection closed");
        }
        if (!statusline.startsWith("HTTP/1.")) {
            throw new IOException("Invalid status line: " + statusline);
        }
        if (Log.trace()) {
            Log.logTrace("Statusline: {0}", statusline);
        }
        char c = statusline.charAt(7);
        responseCode = Integer.parseInt(statusline.substring(9, 12));

        headers = new ResponseHeaders(connection, buffer);
        if (Log.headers()) {
            logHeaders(headers);
        }
        response = new Response(
                request, exchange.getExchange(),
                headers, responseCode, HTTP_1_1);
    }

    private boolean finished;

    synchronized void completed() {
        finished = true;
    }

    synchronized boolean finished() {
        return finished;
    }

    ByteBuffer getBuffer() {
        return buffer;
    }

    int fixupContentLen(int clen) {
        if (request.method().equalsIgnoreCase("HEAD")) {
            return 0;
        }
        if (clen == -1) {
            if (headers.firstValue("Transfer-encoding").orElse("")
                       .equalsIgnoreCase("chunked")) {
                return -1;
            }
            return 0;
        }
        return clen;
    }

    public CompletableFuture<T> readBody(
            HttpResponse.BodyProcessor<T> p,
            boolean return2Cache,
            Executor executor) {
        final BlockingPushPublisher<ByteBuffer> publisher = new BlockingPushPublisher<>();
        return readBody(p, return2Cache, publisher, executor);
    }

    private CompletableFuture<T> readBody(
            HttpResponse.BodyProcessor<T> p,
            boolean return2Cache,
            AbstractPushPublisher<ByteBuffer> publisher,
            Executor executor) {
        this.return2Cache = return2Cache;
        final jdk.incubator.http.HttpResponse.BodyProcessor<T> pusher = p;
        final CompletableFuture<T> cf = p.getBody().toCompletableFuture();

        int clen0;
        try {
            clen0 = headers.getContentLength();
        } catch (IOException ex) {
            cf.completeExceptionally(ex);
            return cf;
        }
        final int clen = fixupContentLen(clen0);

        executor.execute(() -> {
            try {
                content = new ResponseContent(
                        connection, clen, headers, pusher,
                        publisher.asDataConsumer(),
                        (t -> {
                            publisher.acceptError(t);
                            connection.close();
                            cf.completeExceptionally(t);
                        }),
                        () -> onFinished()
                );
                publisher.subscribe(p);
                if (cf.isCompletedExceptionally()) {
                    // if an error occurs during subscription
                    connection.close();
                    return;
                }
                content.pushBody(buffer);
            } catch (Throwable t) {
                cf.completeExceptionally(t);
            }
        });
        return cf;
    }

    private void onFinished() {
        if (return2Cache) {
            Log.logTrace("Returning connection to the pool: {0}", connection);
            connection.returnToCache(headers);
        }
    }

    private void logHeaders(ResponseHeaders headers) {
        StringBuilder sb = new StringBuilder("RESPONSE HEADERS:\n");
        Log.dumpHeaders(sb, "    ", headers);
        Log.logHeaders(sb.toString());
    }

    Response response() {
        return response;
    }

    boolean redirecting() {
        return redirecting;
    }

    HttpHeaders responseHeaders() {
        return headers;
    }

    int responseCode() {
        return responseCode;
    }

    static final char CR = '\r';
    static final char LF = '\n';

    private int obtainBuffer() throws IOException {
        int n = buffer.remaining();

        if (n == 0) {
            buffer = connection.read();
            if (buffer == null) {
                return -1;
            }
            n = buffer.remaining();
        }
        return n;
    }

    String readStatusLine() throws IOException {
        boolean cr = false;
        StringBuilder statusLine = new StringBuilder(128);
        while ((obtainBuffer()) != -1) {
            byte[] buf = buffer.array();
            int offset = buffer.position();
            int len = buffer.limit() - offset;

            for (int i = 0; i < len; i++) {
                char c = (char) buf[i+offset];

                if (cr) {
                    if (c == LF) {
                        buffer.position(i + 1 + offset);
                        return statusLine.toString();
                    } else {
                        throw new IOException("invalid status line");
                    }
                }
                if (c == CR) {
                    cr = true;
                } else {
                    statusLine.append(c);
                }
            }
            // unlikely, but possible, that multiple reads required
            buffer.position(buffer.limit());
        }
        return null;
    }
}
