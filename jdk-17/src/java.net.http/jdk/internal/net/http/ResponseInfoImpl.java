/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.net.http.HttpResponse.ResponseInfo;
import java.net.http.HttpHeaders;
import java.net.http.HttpClient;

class ResponseInfoImpl implements ResponseInfo {
    private final int statusCode;
    private final HttpHeaders headers;
    private final HttpClient.Version version;

    ResponseInfoImpl(Response response) {
        this.statusCode = response.statusCode();
        this.headers = response.headers();
        this.version = response.version();
    }

    ResponseInfoImpl(int statusCode, HttpHeaders headers, HttpClient.Version version) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.version = version;
    }

    /**
     * Provides the response status code
     * @return the response status code
     */
    public int statusCode() {
        return statusCode;
    }

    /**
     * Provides the response headers
     * @return the response headers
     */
    public HttpHeaders headers() {
        return headers;
    }

    /**
     * provides the response protocol version
     * @return the response protocol version
     */
    public HttpClient.Version version() {
        return version;
    }
}
