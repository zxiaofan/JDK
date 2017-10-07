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

import java.util.Base64;

/**
 * BasicAuthenticator provides an implementation of HTTP Basic
 * authentication. It is an abstract class and must be extended
 * to provide an implementation of {@link #checkCredentials(String,String)}
 * which is called to verify each incoming request.
 */
public abstract class BasicAuthenticator extends Authenticator {

    protected String realm;

    /**
     * Creates a BasicAuthenticator for the given HTTP realm
     * @param realm The HTTP Basic authentication realm
     * @throws NullPointerException if the realm is an empty string
     */
    public BasicAuthenticator (String realm) {
        this.realm = realm;
    }

    /**
     * returns the realm this BasicAuthenticator was created with
     * @return the authenticator's realm string.
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
            Headers map = t.getResponseHeaders();
            map.set ("WWW-Authenticate", "Basic realm=" + "\""+realm+"\"");
            return new Authenticator.Retry (401);
        }
        int sp = auth.indexOf (' ');
        if (sp == -1 || !auth.substring(0, sp).equals ("Basic")) {
            return new Authenticator.Failure (401);
        }
        byte[] b = Base64.getDecoder().decode(auth.substring(sp+1));
        String userpass = new String (b);
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

            Headers map = t.getResponseHeaders();
            map.set ("WWW-Authenticate", "Basic realm=" + "\""+realm+"\"");
            return new Authenticator.Failure(401);
        }
    }

    /**
     * called for each incoming request to verify the
     * given name and password in the context of this
     * Authenticator's realm. Any caching of credentials
     * must be done by the implementation of this method
     * @param username the username from the request
     * @param password the password from the request
     * @return <code>true</code> if the credentials are valid,
     *    <code>false</code> otherwise.
     */
    public abstract boolean checkCredentials (String username, String password);
}

