/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.api;


/**
 * Signals an error in {@link RawAccessor}.
 *
 * <p>
 * This error is not reported to the user handler. Once reported
 * the error should be wrapped into another exception.
 *
 * <p>
 * This exception happens primarily when JAXB accesses the getter/setter
 * method and it throws a checked exception.
 *
 * <p>
 * <b>Subject to change without notice</b>.
 *
 * @author Kohsuke Kawaguchi
 *
 * @since 2.0 EA1
 */
public final class AccessorException extends Exception {
    public AccessorException() {
    }

    public AccessorException(String message) {
        super(message);
    }

    public AccessorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessorException(Throwable cause) {
        super(cause);
    }
}
