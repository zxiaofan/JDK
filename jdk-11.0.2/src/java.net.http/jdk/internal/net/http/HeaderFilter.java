/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http;

import java.io.IOException;

/**
 * A header filter that can examine or modify, typically system headers for
 * requests before they are sent, and responses before they are returned to the
 * user. Some ability to resend requests is provided.
 */
interface HeaderFilter {

    void request(HttpRequestImpl r, MultiExchange<?> e) throws IOException;

    /**
     * Returns null if response ok to be given to user.  Non null is a request
     * that must be resent and its response given to user. If impl throws an
     * exception that is returned to user instead.
     */
    HttpRequestImpl response(Response r) throws IOException;
}
