/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http.websocket;

/*
 * Used as a context-neutral exception which can be wrapped into (for example)
 * a `ProtocolException` or an `IllegalArgumentException` depending on who's
 * doing the check.
 */
final class CheckFailedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    CheckFailedException(String message) {
        super(message);
    }
}
