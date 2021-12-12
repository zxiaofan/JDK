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

import java.net.URI;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.net.http.HttpClient.Version;
import static jdk.internal.net.http.common.Utils.ALLOWED_HEADERS;

final class ImmutableHttpRequest extends HttpRequest {

    private final String method;
    private final URI uri;
    private final HttpHeaders headers;
    private final Optional<BodyPublisher> requestPublisher;
    private final boolean expectContinue;
    private final Optional<Duration> timeout;
    private final Optional<Version> version;

    /** Creates an ImmutableHttpRequest from the given builder. */
    ImmutableHttpRequest(HttpRequestBuilderImpl builder) {
        this.method = Objects.requireNonNull(builder.method());
        this.uri = Objects.requireNonNull(builder.uri());
        this.headers = HttpHeaders.of(builder.headersBuilder().map(), ALLOWED_HEADERS);
        this.requestPublisher = Optional.ofNullable(builder.bodyPublisher());
        this.expectContinue = builder.expectContinue();
        this.timeout = Optional.ofNullable(builder.timeout());
        this.version = Objects.requireNonNull(builder.version());
    }

    @Override
    public String method() { return method; }

    @Override
    public URI uri() { return uri; }

    @Override
    public HttpHeaders headers() {
        return headers;
    }

    @Override
    public Optional<BodyPublisher> bodyPublisher() { return requestPublisher; }

    @Override
    public boolean expectContinue() { return expectContinue; }

    @Override
    public Optional<Duration> timeout() { return timeout; }

    @Override
    public Optional<Version> version() { return version; }

    @Override
    public String toString() {
        return uri.toString() + " " + method;
    }
}
