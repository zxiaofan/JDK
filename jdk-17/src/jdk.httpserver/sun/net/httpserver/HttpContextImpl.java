/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.httpserver;
import java.util.*;
import java.lang.System.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import com.sun.net.httpserver.*;

/**
 * HttpContext represents a mapping between a protocol (http or https) together with a root URI path
 * to a {@link HttpHandler} which is invoked to handle requests destined
 * for the protocol/path on the associated HttpServer.
 * <p>
 * HttpContext instances are created by {@link HttpServer#createContext(String,String,HttpHandler,Object)}
 * <p>
 */
class HttpContextImpl extends HttpContext {

    private final String path;
    private final String protocol;
    private final ServerImpl server;
    private final AuthFilter authfilter;
    private final Map<String,Object> attributes = new ConcurrentHashMap<>();
    /* system filters, not visible to applications */
    private final List<Filter> sfilters = new CopyOnWriteArrayList<>();
    /* user filters, set by applications */
    private final List<Filter> ufilters = new CopyOnWriteArrayList<>();
    private Authenticator authenticator;
    private HttpHandler handler;

    /**
     * constructor is package private.
     */
    HttpContextImpl (String protocol, String path, HttpHandler cb, ServerImpl server) {
        if (path == null || protocol == null || path.length() < 1 || path.charAt(0) != '/') {
            throw new IllegalArgumentException ("Illegal value for path or protocol");
        }
        this.protocol = protocol.toLowerCase();
        this.path = path;
        if (!this.protocol.equals ("http") && !this.protocol.equals ("https")) {
            throw new IllegalArgumentException ("Illegal value for protocol");
        }
        this.handler = cb;
        this.server = server;
        authfilter = new AuthFilter(null);
        sfilters.add (authfilter);
    }

    /**
     * returns the handler for this context
     * @return the HttpHandler for this context
     */
    public HttpHandler getHandler () {
        return handler;
    }

    public void setHandler (HttpHandler h) {
        if (h == null) {
            throw new NullPointerException ("Null handler parameter");
        }
        if (handler != null) {
            throw new IllegalArgumentException ("handler already set");
        }
        handler = h;
    }

    /**
     * returns the path this context was created with
     * @return this context's path
     */
    public String getPath() {
        return path;
    }

    /**
     * returns the server this context was created with
     * @return this context's server
     */
    public HttpServer getServer () {
        return server.getWrapper();
    }

    ServerImpl getServerImpl () {
        return server;
    }

    /**
     * returns the protocol this context was created with
     * @return this context's path
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * returns a mutable Map, which can be used to pass
     * configuration and other data to Filter modules
     * and to the context's exchange handler.
     * <p>
     * Every attribute stored in this Map will be visible to
     * every HttpExchange processed by this context
     */
    public Map<String,Object> getAttributes() {
        return attributes;
    }

    public List<Filter> getFilters () {
        return ufilters;
    }

    List<Filter> getSystemFilters () {
        return sfilters;
    }

    public Authenticator setAuthenticator (Authenticator auth) {
        Authenticator old = authenticator;
        authenticator = auth;
        authfilter.setAuthenticator (auth);
        return old;
    }

    public Authenticator getAuthenticator () {
        return authenticator;
    }
    Logger getLogger () {
        return server.getLogger();
    }
}
