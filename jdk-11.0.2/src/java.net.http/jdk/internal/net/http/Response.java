/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http;

import java.net.URI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.InetSocketAddress;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;
import jdk.internal.net.http.common.Utils;

/**
 * Response headers and status code.
 */
class Response {
    final HttpHeaders headers;
    final int statusCode;
    final HttpRequestImpl request;
    final Exchange<?> exchange;
    final HttpClient.Version version;
    final boolean isConnectResponse;
    final SSLSession sslSession;
    final InetSocketAddress localAddress;

    Response(HttpRequestImpl req,
             Exchange<?> exchange,
             HttpHeaders headers,
             HttpConnection connection,
             int statusCode,
             HttpClient.Version version) {
        this(req, exchange, headers, connection, statusCode, version,
                "CONNECT".equalsIgnoreCase(req.method()));
    }

    Response(HttpRequestImpl req,
             Exchange<?> exchange,
             HttpHeaders headers,
             HttpConnection connection,
             int statusCode,
             HttpClient.Version version,
             boolean isConnectResponse) {
        this.headers = headers;
        this.request = req;
        this.version = version;
        this.exchange = exchange;
        this.statusCode = statusCode;
        this.isConnectResponse = isConnectResponse;
        if (connection != null) {
            InetSocketAddress a;
            try {
                a = (InetSocketAddress)connection.channel().getLocalAddress();
            } catch (IOException e) {
                a = null;
            }
            this.localAddress = a;
            if (connection instanceof AbstractAsyncSSLConnection) {
                AbstractAsyncSSLConnection cc = (AbstractAsyncSSLConnection)connection;
                SSLEngine engine = cc.getEngine();
                sslSession = Utils.immutableSession(engine.getSession());
            } else {
                sslSession = null;
            }
        } else {
            sslSession = null;
            localAddress = null;
        }
    }

    HttpRequestImpl request() {
        return request;
    }

    HttpClient.Version version() {
        return version;
    }

    HttpHeaders headers() {
        return headers;
    }

    int statusCode() {
        return statusCode;
    }

    SSLSession getSSLSession() {
        return sslSession;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String method = request().method();
        URI uri = request().uri();
        String uristring = uri == null ? "" : uri.toString();
        sb.append('(')
          .append(method)
          .append(" ")
          .append(uristring)
          .append(") ")
          .append(statusCode());
        sb.append(" ").append(version);
        if (localAddress != null)
            sb.append(" Local port:  ").append(localAddress.getPort());
        return sb.toString();
    }
}
