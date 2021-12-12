/*
 * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www.protocol.http;

import java.io.Serializable;
import java.net.PasswordAuthentication;

/**
 * AuthCacheValue: interface to minimize exposure to authentication cache
 * for external users (i.e. plugin)
 *
 * @author Michael McMahon
 */

public abstract class AuthCacheValue implements Serializable {

    @java.io.Serial
    static final long serialVersionUID = 735249334068211611L;

    public enum Type {
        Proxy,
        Server
    };

    /**
     * Caches authentication info entered by user.  See cacheKey()
     */
    protected static AuthCache cache = new AuthCacheImpl();

    public static void setAuthCache (AuthCache map) {
        cache = map;
    }

    /* Package private ctor to prevent extension outside package */

    AuthCacheValue() {}

    /**
     * Proxy or Server
     */
    abstract Type getAuthType ();

    /**
     * Authentication scheme
     */
    abstract AuthScheme getAuthScheme();

   /**
    * name of server/proxy
    */
    abstract String getHost ();

   /**
    * portnumber of server/proxy
    */
    abstract int getPort();

   /**
    * realm of authentication if known
    */
    abstract String getRealm();

    /**
     * root path of realm or the request path if the root
     * is not known yet.
     */
    abstract String getPath();

    /**
     * returns http or https
     */
    abstract String getProtocolScheme();

    /**
     * the credentials associated with this authentication
     */
    abstract PasswordAuthentication credentials();
}
