/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * Thrown to indicate that the requested operation cannot be
 * completed because the specified code index is not valid.
 *
 * @deprecated This exception is no longer thrown
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
@Deprecated
public class InvalidCodeIndexException extends RuntimeException {

    private static final long serialVersionUID = 7416010225133747805L;

    public InvalidCodeIndexException() {
        super();
    }

    public InvalidCodeIndexException(String s) {
        super(s);
    }
}
