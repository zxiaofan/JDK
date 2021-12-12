/*
 * Copyright (c) 2006, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.net.httpserver;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * BasicAuthenticator provides an implementation of HTTP Basic
 * authentication. It is an abstract class and must be extended
 * to provide an implementation of {@link #checkCredentials(String,String)}
 * which is called to verify each incoming request.
 */
public abstract class BasicAuthenticator extends Authenticator {

    /** The HTTP Basic authentication realm. */
    protected final String realm;
    private final Charset charset;
    private final boolean isUTF8;

    /**
     * Creates a {@code BasicAuthenticator} for the given HTTP realm.
     * The Basic authentication credentials (username and password) are decoded
     * using the platform's {@link Charset#defaultCharset() default character set}.
     *
     * @param realm the HTTP Basic authentication realm
     * @throws NullPointerException if realm is {@code null}
     * @throws IllegalArgumentException if realm is an empty string
     */
    public BasicAuthenticator (String realm) {
        this(realm, Charset.defaultCharset());
    }

    /**
     * Creates a {@code BasicAuthenticator} for the given HTTP realm and using the
     * given {@link Charset} to decode the Basic authentication credentials
     * (username and password).
     *
     * @apiNote {@code UTF-8} is the recommended charset because its usage is
     * communicated to the client, and therefore more likely to be used also
     * by the client.
     *
     * @param realm the HTTP Basic authentication realm
     * @param charset the {@code Charset} to decode incoming credentials from the client
     * @throws NullPointerException if realm or charset are {@code null}
     * @throws IllegalArgumentException if realm is an empty string
     */
    public BasicAuthenticator (String realm, Charset charset) {
        Objects.requireNonNull(charset);
        if (realm.isEmpty()) // implicit NPE check
            throw new IllegalArgumentException("realm must not be empty");
        this.realm = realm;
        this.charset = charset;
        this.isUTF8 = charset.equals(UTF_8);
    }

    /**
     * Returns the realm this {@code BasicAuthenticator} was created with.
     *
     * @return the authenticator's realm string
     */
    public String getRealm () {
        return realm;
    }

    public Result authenticate (HttpExchange t)
    {
        Headers rmap = t.getRequestHeaders();
        /*
         * look for auth token
         */
        String auth = rmap.getFirst ("Authorization");
        if (auth == null) {
            setAuthHeader(t);
            return new Authenticator.Retry (401);
        }
        int sp = auth.indexOf (' ');
        if (sp == -1 || !auth.substring(0, sp).equals ("Basic")) {
            return new Authenticator.Failure (401);
        }
        byte[] b = Base64.getDecoder().decode(auth.substring(sp+1));
        String userpass = new String (b, charset);
        int colon = userpass.indexOf (':');
        String uname = userpass.substring (0, colon);
        String pass = userpass.substring (colon+1);

        if (checkCredentials (uname, pass)) {
            return new Authenticator.Success (
                new HttpPrincipal (
                    uname, realm
                )
            );
        } else {
            /* reject the request again with 401 */
            setAuthHeader(t);
            return new Authenticator.Failure(401);
        }
    }

    private void setAuthHeader(HttpExchange t) {
        Headers map = t.getResponseHeaders();
        var authString = "Basic realm=" + "\"" + realm + "\"" +
            (isUTF8 ? ", charset=\"UTF-8\"" : "");
        map.set ("WWW-Authenticate", authString);
    }

    /**
     * Called for each incoming request to verify the
     * given name and password in the context of this
     * authenticator's realm. Any caching of credentials
     * must be done by the implementation of this method.
     *
     * @param username the username from the request
     * @param password the password from the request
     * @return {@code true} if the credentials are valid, {@code false} otherwise
     */
    public abstract boolean checkCredentials (String username, String password);
}

