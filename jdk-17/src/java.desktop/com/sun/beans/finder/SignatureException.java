/*
 * Copyright (c) 2013, 2021, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.beans.finder;

import java.io.Serial;

final class SignatureException extends RuntimeException {

    /**
     * Use serialVersionUID from JDK 9 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 4536098341586118473L;

    SignatureException(Throwable cause) {
        super(cause);
    }

    NoSuchMethodException toNoSuchMethodException(String message) {
        Throwable throwable = getCause();
        if (throwable instanceof NoSuchMethodException) {
            return (NoSuchMethodException) throwable;
        }
        NoSuchMethodException exception = new NoSuchMethodException(message);
        exception.initCause(throwable);
        return exception;
    }
}
