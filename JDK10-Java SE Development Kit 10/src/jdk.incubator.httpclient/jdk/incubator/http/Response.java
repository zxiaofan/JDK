/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.net.URI;

/**
 * Response headers and status code.
 */
class Response {
    final HttpHeaders headers;
    final int statusCode;
    final HttpRequestImpl request;
    final Exchange<?> exchange;
    final HttpClient.Version version;

    Response(HttpRequestImpl req,
             Exchange<?> exchange,
             HttpHeaders headers,
             int statusCode,
             HttpClient.Version version) {
        this.headers = headers;
        this.request = req;
        this.version = version;
        this.exchange = exchange;
        this.statusCode = statusCode;
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

//    Exchange<?> exchange() {
//        return exchange;
//    }

    int statusCode() {
        return statusCode;
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
        return sb.toString();
    }
}
