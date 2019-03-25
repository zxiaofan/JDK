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
 * completed because the specified line number is not valid.
 *
 * @deprecated This exception is no longer thrown
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
@Deprecated
public class InvalidLineNumberException extends RuntimeException {

    private static final long serialVersionUID = 4048709912372692875L;

    public InvalidLineNumberException() {
        super();
    }

    public InvalidLineNumberException(String s) {
        super(s);
    }
}
