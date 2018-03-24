/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.geom.transform;

/**
 * Indicates that inverse of a matrix can not be computed.
 *
 */
public class SingularMatrixException extends RuntimeException {

    public SingularMatrixException() {
    }

    public SingularMatrixException(String string) {
        super(string);
    }
}
