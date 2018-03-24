/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.transport.http.server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import com.sun.xml.internal.ws.server.ServerRtException;

import java.net.InetSocketAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Manages all the WebService HTTP servers created by JAXWS runtime.
 *
 * @author Jitendra Kotamraju
 */
final class ServerMgr {

    private static final ServerMgr serverMgr = new ServerMgr();
    private static final Logger LOGGER =
        Logger.getLogger(
            com.sun.xml.internal.ws.util.Constants.LoggingDomain + ".server.http");
    private final Map<InetSocketAddress,ServerState> servers = new HashMap<>();

    private ServerMgr() {}

    /**
     * Gets the singleton instance.
     * @return manager instance
     */
    static ServerMgr getInstance() {
        return serverMgr;
    }

    /*
     * Creates a HttpContext at the given address. If there is already a server
     * it uses that server to create a context. Otherwise, it creates a new
     * HTTP server. This sever is added to servers Map.
     */
    /*package*/ HttpContext createContext(String address) {
        try {
            HttpServer server;
            ServerState state;
            URL url = new URL(address);
            int port = url.getPort();
            if (port == -1) {
                port = url.getDefaultPort();
            }
            InetSocketAddress inetAddress = new InetSocketAddress(url.getHost(),
                port);
            synchronized(servers) {
                state = servers.get(inetAddress);
                if (state == null) {
                    ServerState free = null;
                    for (ServerState ss : servers.values()) {
                        if (port == ss.getServer().getAddress().getPort()) {
                            free = ss;
                            break;
                        }
                    }
                    if (inetAddress.getAddress().isAnyLocalAddress() && free != null) {
                        state = free;
                    } else {
                        if (LOGGER.isLoggable(Level.FINE)) {
                            LOGGER.fine("Creating new HTTP Server at "+inetAddress);
                        }
                        // Creates server with default socket backlog
                        server = HttpServer.create(inetAddress, 0);
                        server.setExecutor(Executors.newCachedThreadPool());
                        String path = url.toURI().getPath();
                        if (LOGGER.isLoggable(Level.FINE)) {
                            LOGGER.fine("Creating HTTP Context at = "+path);
                        }
                        HttpContext context = server.createContext(path);
                        server.start();

                        // we have to get actual inetAddress from server, which can differ from the original in some cases.
                        // e.g. A port number of zero will let the system pick up an ephemeral port in a bind operation,
                        // or IP: 0.0.0.0 - which is used to monitor network traffic from any valid IP address
                        inetAddress = server.getAddress();

                        if (LOGGER.isLoggable(Level.FINE)) {
                            LOGGER.fine("HTTP server started = "+inetAddress);
                        }
                        state = new ServerState(server, path);
                        servers.put(inetAddress, state);
                        return context;
                    }
                }
            }
            server = state.getServer();

            if (state.getPaths().contains(url.getPath())) {
              String err = "Context with URL path "+url.getPath()+ " already exists on the server "+server.getAddress();
              if (LOGGER.isLoggable(Level.FINE)) {
                LOGGER.fine(err);
              }
              throw new IllegalArgumentException(err);
            }

            if (LOGGER.isLoggable(Level.FINE)) {
                LOGGER.fine("Creating HTTP Context at = "+url.getPath());
            }
            HttpContext context = server.createContext(url.getPath());
            state.oneMoreContext(url.getPath());
            return context;
        } catch(Exception e) {
            throw new ServerRtException("server.rt.err",e );
        }
    }

    /*
     * Removes a context. If the server doesn't have anymore contexts, it
     * would stop the server and server is removed from servers Map.
     */
    /*package*/ void removeContext(HttpContext context) {
        InetSocketAddress inetAddress = context.getServer().getAddress();
        synchronized(servers) {
            ServerState state = servers.get(inetAddress);
            int instances = state.noOfContexts();
            if (instances < 2) {
                ((ExecutorService)state.getServer().getExecutor()).shutdown();
                state.getServer().stop(0);
                servers.remove(inetAddress);
            } else {
                state.getServer().removeContext(context);
                state.oneLessContext(context.getPath());
            }
        }
    }

    private static final class ServerState {
        private final HttpServer server;
        private int instances;
        private final Set<String> paths = new HashSet<>();

        ServerState(HttpServer server, String path) {
            this.server = server;
            this.instances = 1;
            paths.add(path);
        }

        public HttpServer getServer() {
            return server;
        }

        public void oneMoreContext(String path) {
            ++instances;
            paths.add(path);
        }

        public void oneLessContext(String path) {
            --instances;
            paths.remove(path);
        }

        public int noOfContexts() {
            return instances;
        }

        public Set<String> getPaths() {
          return paths;
        }
    }
}
