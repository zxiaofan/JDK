/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.http;

import java.io.IOException;

/**
 * Thrown when a response is not received within a specified time period.
 * {@Incubating}
 */
public class HttpTimeoutException extends IOException {

    private static final long serialVersionUID = 981344271622632951L;

    public HttpTimeoutException(String message) {
        super(message);
    }
}
