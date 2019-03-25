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
 * Thrown to indicate line number or variable information is not available.
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
public class AbsentInformationException extends Exception {

    private static final long serialVersionUID = 4988939309582416373L;

    public AbsentInformationException() {
        super();
    }

    public AbsentInformationException(String s) {
        super(s);
    }
}
