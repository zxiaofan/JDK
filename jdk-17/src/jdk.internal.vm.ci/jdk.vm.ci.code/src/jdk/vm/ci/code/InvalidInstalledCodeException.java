/*
 * Copyright (c) 2013, 2019, Oracle and/or its affiliates. All rights reserved.
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
 */
package jdk.vm.ci.code;

/**
 * Exception thrown by the runtime in case an invalidated machine code is called.
 */
public final class InvalidInstalledCodeException extends Exception {

    public InvalidInstalledCodeException() {
    }

    public InvalidInstalledCodeException(String message) {
        super(message);
    }

    private static final long serialVersionUID = -3540232440794244844L;
}
