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

package com.sun.xml.internal.ws.client;

/**
 * Receives {@link ResponseContext} at the end of
 * the message invocation.
 *
 * @author Kohsuke Kawaguchi
 */
public interface ResponseContextReceiver {
    /**
     * Called upon the completion of the invocation
     * to set a {@link ResponseContext}.
     *
     * <p>
     * This method is invoked even when the invocation fails.
     */
    void setResponseContext(ResponseContext rc);
}
