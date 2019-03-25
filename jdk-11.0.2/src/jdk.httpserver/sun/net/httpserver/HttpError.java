/*
 * Copyright (c) 2005, 2008, Oracle and/or its affiliates. All rights reserved.
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

/**
 * A Http error
 */
class HttpError extends RuntimeException {
    private static final long serialVersionUID = 8769596371344178179L;

    public HttpError (String msg) {
        super (msg);
    }
}
