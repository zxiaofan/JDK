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
import java.io.UncheckedIOException;
import java.net.URI;
import jdk.incubator.http.internal.common.Utils;

class RedirectFilter implements HeaderFilter {

    HttpRequestImpl request;
    HttpClientImpl client;
    HttpClient.Redirect policy;
    String method;
    MultiExchange<?,?> exchange;
    static final int DEFAULT_MAX_REDIRECTS = 5;
    URI uri;

    static final int max_redirects = Utils.getIntegerNetProperty(
            "jdk.httpclient.redirects.retrylimit", DEFAULT_MAX_REDIRECTS
    );

    @Override
    public synchronized void request(HttpRequestImpl r, MultiExchange<?,?> e) throws IOException {
        this.request = r;
        this.client = e.client();
        this.policy = client.followRedirects();

        this.method = r.method();
        this.uri = r.uri();
        this.exchange = e;
    }

    @Override
    public synchronized HttpRequestImpl response(Response r) throws IOException {
        return handleResponse(r);
    }

    /**
     * checks to see if new request needed and returns it.
     * Null means response is ok to return to user.
     */
    private HttpRequestImpl handleResponse(Response r) {
        int rcode = r.statusCode();
        if (rcode == 200 || policy == HttpClient.Redirect.NEVER) {
            return null;
        }
        if (rcode >= 300 && rcode <= 399) {
            URI redir = getRedirectedURI(r.headers());
            if (canRedirect(redir) && ++exchange.numberOfRedirects < max_redirects) {
                //System.out.println("Redirecting to: " + redir);
                return new HttpRequestImpl(redir, method, request);
            } else {
                //System.out.println("Redirect: giving up");
                return null;
            }
        }
        return null;
    }

    private URI getRedirectedURI(HttpHeaders headers) {
        URI redirectedURI;
        String ss = headers.firstValue("Location").orElse("Not present");
        redirectedURI = headers.firstValue("Location")
                .map((s) -> URI.create(s))
                .orElseThrow(() -> new UncheckedIOException(
                        new IOException("Invalid redirection")));

        // redirect could be relative to original URL, but if not
        // then redirect is used.
        redirectedURI = uri.resolve(redirectedURI);
        return redirectedURI;
    }

    private boolean canRedirect(URI redir) {
        String newScheme = redir.getScheme();
        String oldScheme = uri.getScheme();
        switch (policy) {
            case ALWAYS:
                return true;
            case NEVER:
                return false;
            case SECURE:
                return newScheme.equalsIgnoreCase("https");
            case SAME_PROTOCOL:
                return newScheme.equalsIgnoreCase(oldScheme);
            default:
                throw new InternalError();
        }
    }
}
