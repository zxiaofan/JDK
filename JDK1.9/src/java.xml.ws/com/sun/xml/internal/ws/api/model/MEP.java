/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.model;

/**
 * Constants that represents four message exchange patterns.
 *
 * @author Kohsuke Kawaguchi
 */
public enum MEP {
    REQUEST_RESPONSE(false),
    ONE_WAY(false),
    ASYNC_POLL(true),
    ASYNC_CALLBACK(true);

    /**
     * True for {@link #ASYNC_CALLBACK} and {@link #ASYNC_POLL}.
     */
    public final boolean isAsync;

    MEP(boolean async) {
        isAsync = async;
    }

    public final boolean isOneWay() {
        return this==ONE_WAY;
    }
}
