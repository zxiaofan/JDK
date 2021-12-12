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
package jdk.internal.net.http.common;

import java.net.http.HttpClient;

/**
 * A small class allowing to track how many operations are
 * left outstanding on an instance of HttpClient.
 */
public final class OperationTrackers {
    private OperationTrackers() {
        throw new InternalError("not instantiable");
    }

    /**
     * A tracker can return the current value of
     * operation counters maintained by an instance
     * of {@link Trackable}, such as an HttpClientImpl.
     */
    public interface Tracker {
        // The total number of outstanding operations
        long getOutstandingOperations();
        // The number of outstanding HTTP/1.1 operations.
        // A single HTTP/1.1 request may increment this counter
        // multiple times, so the value returned will be >= to
        // the number of active HTTP/1.1 connections, but will
        // still be 0 if there are no active connections.
        long getOutstandingHttpOperations();
        // The number of active HTTP/2 streams
        long getOutstandingHttp2Streams();
        // The number of active WebSockets
        long getOutstandingWebSocketOperations();
        // Whether the facade returned to the
        // user is still referenced
        boolean isFacadeReferenced();
        // The name of the object being tracked.
        String getName();
    }

    /**
     * Implemented by objects that maintain operation counters.
     */
    public interface Trackable {
        Tracker getOperationsTracker();
    }

    /**
     * Returns a tracker to track pending operations started on
     * an HttpClient instance. May return null if this isn't
     * an HttpClientImpl or HttpClientFacade.
     * @param client the HttpClient instance to track.
     * @return A tracker or null.
     */
    public static Tracker getTracker(HttpClient client) {
        if (client instanceof Trackable) {
            return ((Trackable)client).getOperationsTracker();
        } else {
            return null;
        }
    }

}
