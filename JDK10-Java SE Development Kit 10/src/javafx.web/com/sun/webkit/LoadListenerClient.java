/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit;

import java.lang.annotation.Native;

public interface LoadListenerClient {
    @Native public final static int PAGE_STARTED = 0;
    @Native public final static int PAGE_FINISHED = 1;
    @Native public final static int PAGE_REDIRECTED = 2;
    @Native public final static int PAGE_REPLACED = 3;
    @Native public final static int LOAD_FAILED = 5;
    @Native public final static int LOAD_STOPPED = 6;
    @Native public final static int CONTENT_RECEIVED = 10;
    @Native public final static int TITLE_RECEIVED = 11;
    @Native public final static int ICON_RECEIVED = 12;
    @Native public final static int CONTENTTYPE_RECEIVED = 13;
    @Native public final static int DOCUMENT_AVAILABLE = 14;
    @Native public final static int RESOURCE_STARTED = 20;
    @Native public final static int RESOURCE_REDIRECTED = 21;
    @Native public final static int RESOURCE_FINISHED = 22;
    @Native public final static int RESOURCE_FAILED = 23;
    @Native public final static int PROGRESS_CHANGED = 30;


    // -- Error Code values
    /**
     * An error code indicating that the host name couldn't be resolved.
     */
    @Native public final static int UNKNOWN_HOST = 1;
    /**
     * An error code indicating that the URL was malformed or illegal.
     */
    @Native public final static int MALFORMED_URL = 2;
    /**
     * An error code indicating that the SSL handshake failed.
     */
    @Native public final static int SSL_HANDSHAKE = 3;
    /**
     * An error code indicating that the connection was refused by the server.
     */
    @Native public final static int CONNECTION_REFUSED = 4;
    /**
     * An error code indicating that the connection was reset by the server.
     */
    @Native public final static int CONNECTION_RESET = 5;
    /**
     * An error code indicating that there was no route to the host.
     */
    @Native public final static int NO_ROUTE_TO_HOST = 6;
    /**
     * An error code indicating that the connection timed out.
     */
    @Native public final static int CONNECTION_TIMED_OUT = 7;
    /**
     * An error code indicating that the client was denied permission
     * to initiate connection to the server.
     */
    @Native public final static int PERMISSION_DENIED = 8;
    /**
     * An error code indicating that the server response was invalid.
     */
    @Native public final static int INVALID_RESPONSE = 9;
    /**
     * An error code indicating that too many redirects were encountered
     * while processing the request.
     */
    @Native public final static int TOO_MANY_REDIRECTS = 10;
    /**
     * An error code indicating that the requested local file was not found.
     */
    @Native public final static int FILE_NOT_FOUND = 11;
    /**
     * An error code indicating that an unknown error occurred.
     */
    @Native public final static int UNKNOWN_ERROR = 99;


    public void dispatchLoadEvent(long frame, int state,
                                  String url, String contentType,
                                  double progress, int errorCode);

    public void dispatchResourceLoadEvent(long frame, int state,
                                          String url, String contentType,
                                          double progress, int errorCode);
}
